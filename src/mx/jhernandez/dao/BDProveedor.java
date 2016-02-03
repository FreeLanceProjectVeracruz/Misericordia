package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Proveedor;

/**
 *
 * @author Viruz
 */
public class BDProveedor {

    // <editor-fold defaultstate="collapsed" desc="Búsqueda de Proveedores">
    public static Proveedor buscarCodigoProveedor(int codigo) throws SQLException {
        return buscarProveedor2("SELECT nProvCodigo, cProvNombre FROM proveedor WHERE nProvCodigo=" + codigo, null);
    }

    public static Proveedor buscarProveedorNombre(String nombre) throws SQLException {
        return buscarProveedor("SELECT nProvCodigo,nProvNit,cProvNombre,cProvDireccion,cProvNroFax,cProvPaginaWeb,cProvEmail,cProvTipoTelefono,cProvNumTelefono,cProvEstado,cProvObservacion FROM proveedor WHERE cProvNombre='" + nombre + "'", null);
    }

    public static Proveedor buscarProveedor(String sql, Proveedor pv) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (pv == null) {
                pv = new Proveedor();
            }

            pv.setnProvCodigo(rs.getInt("nProvCodigo"));
            pv.setnPRovNit(rs.getInt("nPRovNit"));
            pv.setcProvNombre(rs.getString("cProvNombre"));
            pv.setcProvDireccion(rs.getString("cProvDireccion"));
            pv.setcProvNroFax(rs.getString("cProvNroFax"));
            pv.setcProvPaginaWeb(rs.getString("cProvPaginaWeb"));
            pv.setcProvEmail(rs.getString("cProvEmail"));
            pv.setcProvTipoTelefono(rs.getString("cProvTipoTelefono"));
            pv.setcProvNumTelefono(rs.getString("cProvNumTelefono"));
            pv.setcProvEstado(rs.getString("cProvEstado"));
            pv.setcProvObservacion(rs.getString("cProvObservacion"));
        }
        return pv;
    }

    public static Proveedor buscarProveedor2(String sql, Proveedor pv) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (pv == null) {
                pv = new Proveedor();
            }

            pv.setnProvCodigo(rs.getInt("nProvCodigo"));
            pv.setcProvNombre(rs.getString("cProvNombre"));
        }
        return pv;
    }

    public static Proveedor buscarProveedor(int codigo) throws SQLException {
        return buscarProveedor("SELECT nProvCodigo,nProvNit,cProvNombre,cProvDireccion,cProvNroFax,cProvPaginaWeb,cProvEmail,cProvTipoTelefono,cProvNumTelefono,cProvEstado,cProvObservacion FROM proveedor WHERE nProvCodigo=" + codigo, null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Listado de Proveedores">
    public static ArrayList<Proveedor> listarProveedorPorNombre(String nombre) {
        return listar("cProvNombre", nombre + "%", "LIKE");
    }

    public static ArrayList<Proveedor> listarProveedorPorNit(String nit) {
        return listar("nProvNit", nit + "%", "LIKE");
    }

    public static ArrayList<Proveedor> listarProveedorPorCodigo(String codigo) {
        return listar("nProvCodigo", codigo + "%", "LIKE");
    }

    private static ArrayList<Proveedor> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT nProvCodigo,nProvNit,cProvNombre,cProvDireccion,cProvNroFax,cProvPaginaWeb,cProvEmail,cProvTipoTelefono,cProvNumTelefono,cProvEstado,cProvObservacion FROM proveedor WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Proveedor> consultarSQL(String sql) {
        ArrayList<Proveedor> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();
        try {
            Proveedor p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                p = new Proveedor();
                p.setnProvCodigo(rs.getInt("nProvCodigo"));
                p.setnPRovNit(rs.getInt("nProvNit"));
                p.setcProvNombre(rs.getString("cProvNombre"));
                p.setcProvDireccion(rs.getString("cProvDireccion"));
                p.setcProvNroFax(rs.getString("cProvNroFax"));
                p.setcProvPaginaWeb(rs.getString("cProvPaginaWeb"));
                p.setcProvEmail(rs.getString("cProvEmail"));
                p.setcProvTipoTelefono(rs.getString("cProvTipoTelefono"));
                p.setcProvNumTelefono(rs.getString("cProvNumTelefono"));
                p.setcProvEstado(rs.getString("cProvEstado"));
                p.setcProvObservacion(rs.getString("cProvObservacion"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Proveedores">
    public static Proveedor insertarProveedor(Proveedor pv) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO proveedor (nProvCodigo,nProvNit,cProvNombre,cProvDireccion,cProvNroFax,cProvPaginaWeb,cProvEmail,cProvTipoTelefono,cProvNumTelefono,cProvEstado,cProvObservacion) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, pv.getnProvCodigo());
        ps.setInt(2, pv.getnPRovNit());
        ps.setString(3, pv.getcProvNombre());
        ps.setString(4, pv.getcProvDireccion());
        ps.setString(5, pv.getcProvNroFax());
        ps.setString(6, pv.getcProvPaginaWeb());
        ps.setString(7, pv.getcProvEmail());
        ps.setString(8, pv.getcProvTipoTelefono());
        ps.setString(9, pv.getcProvNumTelefono());
        ps.setString(10, pv.getcProvEstado());
        ps.setString(11, pv.getcProvObservacion());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("SELECT MAX(nProvCodigo) FROM proveedor");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            pv.setnProvCodigo(lastID);
        }
        return pv;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualización de Proveedores">
    public static boolean actualizarProveedor(Proveedor p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("UPDATE proveedor SET nProvNit=?,cProvNombre=?,cProvDireccion=?,cProvNroFax=?,cProvPaginaWeb=?,cProvEmail=?,cProvTipoTelefono=?,cProvNumTelefono=?,cProvEstado=?,cProvObservacion=? WHERE nProvCodigo=" + p.getnProvCodigo());
        ps.setInt(1, p.getnPRovNit());
        ps.setString(2, p.getcProvNombre());
        ps.setString(3, p.getcProvDireccion());
        ps.setString(4, p.getcProvNroFax());
        ps.setString(5, p.getcProvPaginaWeb());
        ps.setString(6, p.getcProvEmail());
        ps.setString(7, p.getcProvTipoTelefono());
        ps.setString(8, p.getcProvNumTelefono());
        ps.setString(9, p.getcProvEstado());
        ps.setString(10, p.getcProvObservacion());
        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Muestreo de Proveedores">
    public static ArrayList<Proveedor> mostrarProveedor() throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ArrayList<Proveedor> lista = new ArrayList<>();

        ps = cnn.prepareStatement("SELECT nProvCodigo,nProvNit,cProvNombre,cProvDireccion,cProvNroFax,cProvPaginaWeb,cProvEmail,cProvTipoTelefono, cProvNumTelefono,cProvEstado,cProvObservacion FROM proveedor");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Proveedor pv = new Proveedor();
            pv.setnProvCodigo(rs.getInt(1));
            pv.setnPRovNit(rs.getInt(2));
            pv.setcProvNombre(rs.getString(3));
            pv.setcProvDireccion(rs.getString(4));
            pv.setcProvNroFax(rs.getString(5));
            pv.setcProvPaginaWeb(rs.getString(6));
            pv.setcProvEmail(rs.getString(7));
            pv.setcProvTipoTelefono(rs.getString(8));
            pv.setcProvNumTelefono(rs.getString(9));
            pv.setcProvEstado(rs.getString(10));
            pv.setcProvObservacion(rs.getString(11));
            lista.add(pv);
        }
        return lista;
    }
    // </editor-fold>
}
