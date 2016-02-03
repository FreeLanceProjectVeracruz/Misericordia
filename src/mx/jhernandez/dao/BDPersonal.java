package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Personal;

/**
 *
 * @author Viruz
 */
public class BDPersonal {

    // <editor-fold defaultstate="collapsed" desc="Enlistado de Personal">
    public static ArrayList<Personal> listarPersonalPorNombre(String nombre) {
        return listar("cPerNombre", nombre + "%", "LIKE");
    }

    public static ArrayList<Personal> listarPersonalPorCi(String ci) {
        return listar("cPerCi", ci + "%", "LIKE");
    }

    private static ArrayList<Personal> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT nPerCodigo,cPerCi,cPerNombre,cPerDireccion,cPerTipoTelefono,cPerNumTelefono,cPerEstado FROM personal WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Personal> consultarSQL(String sql) {
        ArrayList<Personal> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();
        try {
            Personal p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                p = new Personal();
                p.setnPerCodigo(rs.getInt("nPerCodigo"));
                p.setcPerNombre(rs.getString("cPerNombre"));
                p.setcPerDirceccion(rs.getString("cPerDireccion"));
                p.setcPerCi(rs.getString("cPerCi"));
                p.setcPerTipoTelefono(rs.getString("cPerTipoTelefono"));
                p.setcPerNumTelefono(rs.getString("cPerNumTelefono"));
                p.setcPerEstado(rs.getString("cPerEstado"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Búsqueda de Personal">
    public static Personal buscarPersonalNombre(String nombre) throws SQLException {
        return buscarPersonal("SELECT nPerCodigo,cPerCi,cPerNombre,cPerDireccion,cPerTipoTelefono,cPerNumTelefono,cPerEstado FROM personal WHERE cPerNombre='" + nombre + "'", null);
    }

    public static Personal buscarPersonalCodigo(int codigo) throws SQLException {
        return buscarPersonal("SELECT nPerCodigo,cPerCi,cPerNombre,cPerDireccion,cPerTipoTelefono,cPerNumTelefono,cPerEstado FROM personal WHERE nPerCodigo='" + codigo + "'", null);
    }

    public static Personal buscarPersonal(String sql, Personal p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (p == null) {
                p = new Personal();
            }
            p.setnPerCodigo(rs.getInt("nPerCodigo"));
            p.setcPerNombre(rs.getString("cPerNombre"));
            p.setcPerDirceccion(rs.getString("cPerDireccion"));
            p.setcPerCi(rs.getString("cPerCi"));
            p.setcPerTipoTelefono(rs.getString("cPerTipoTelefono"));
            p.setcPerNumTelefono(rs.getString("cPerNumTelefono"));
            p.setcPerEstado(rs.getString("cPerEstado"));
        }
        return p;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Personal">
    public static Personal insertarPersonal(Personal p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO personal (nPerCodigo,cPerNombre,cPerDireccion,cPerCi,cPerTipoTelefono,cPerNumTelefono,cPerEstado) VALUES (?,?,?,?,?,?,?)");
        ps.setInt(1, p.getnPerCodigo());
        ps.setString(2, p.getcPerNombre());
        ps.setString(3, p.getcPerDirceccion());
        ps.setString(4, p.getcPerCi());
        ps.setString(5, p.getcPerTipoTelefono());
        ps.setString(6, p.getcPerNumTelefono());
        ps.setString(7, p.getcPerEstado());
        ps.executeUpdate();

        PreparedStatement ps2 = cnn.prepareStatement("SELECT MAX(nPerCodigo) FROM personal");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            p.setnPerCodigo(lastID);
        }
        return p;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualización de Personal">
    public static boolean actualizarPersonal(Personal p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("UPDATE personal SET cPerNombre=?,cPerDireccion=?,cPerCi=?,cPerTipoTelefono=?,cPerNumTelefono=?,cPerEstado=?  WHERE nPerCodigo=" + p.getnPerCodigo());
        ps.setString(1, p.getcPerNombre());
        ps.setString(2, p.getcPerDirceccion());
        ps.setString(3, p.getcPerCi());
        ps.setString(4, p.getcPerTipoTelefono());
        ps.setString(5, p.getcPerNumTelefono());
        ps.setString(6, p.getcPerEstado());
        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mostrar Personal">
    public static ArrayList<Personal> mostrarPersonal() throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ArrayList<Personal> lista = new ArrayList<>();
        ps = cnn.prepareStatement("SELECT nPerCodigo,cPerCi,cPerNombre,cPerDireccion,cPerTipoTelefono,cPerNumTelefono,cPerEstado FROM personal");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Personal p = new Personal() {
            };
            p.setnPerCodigo(rs.getInt("nPerCodigo"));
            p.setcPerNombre(rs.getString("cPerNombre"));
            p.setcPerDirceccion(rs.getString("cPerDireccion"));
            p.setcPerCi(rs.getString("cPerCi"));
            p.setcPerTipoTelefono(rs.getString("cPerTipoTelefono"));
            p.setcPerNumTelefono(rs.getString("cPerNumTelefono"));
            p.setcPerEstado(rs.getString("cPerEstado"));
            lista.add(p);
        }
        return lista;
    }
    // </editor-fold>
}
