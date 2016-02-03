package mx.jhernandez.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Usuario;

/**
 *
 * @author Viruz
 */
public class BDUsuario {

    // <editor-fold defaultstate="collapsed" desc="Login de Usuario">
    public static Usuario login(String usuario, String clave) throws SQLException {
        return realizarbusqueda(null, "SELECT cUsuId,cUsuClave,nPerCodigo FROM usuario WHERE cUsuId='" + usuario + "' AND cUsuClave='" + clave + "'");
    }

    public static Usuario realizarbusqueda(Usuario u, String sql) throws SQLException {
        try {
            Connection cnn = ConexionPrincipal.getConnection();
            PreparedStatement ps;
            ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (u == null) {
                    u = new Usuario();
                }
                u.setcUsuId(rs.getString("cUsuId"));
                u.setcUsuClave(rs.getString("cUsuClave"));
                u.setPersonal(BDPersonal.buscarPersonalCodigo(rs.getInt("nPerCodigo")));
            } else {
                JOptionPane.showMessageDialog(null, "El usuario o Contraseña no es valido");
            }
        } catch (SQLException | HeadlessException ex) {
            System.out.println(ex);
        }
        return u;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Listado de Usuario">
    public static ArrayList<Usuario> listarUsuarioPorId(String nombre) {
        return listar("cUsuId", nombre + "%", "LIKE");
    }

    public static ArrayList<Usuario> listarUsuarioPorCodigo(String codigo) {
        return listar("nUsuCodigo", codigo + "%", "LIKE");
    }

    private static ArrayList<Usuario> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT nUsuCodigo,cUsuId,cUsuClave,nPerCodigo,cUsuEstado FROM usuario WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Usuario> consultarSQL(String sql) {
        ArrayList<Usuario> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();

        try {
            Usuario u;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                u = new Usuario();
                u.setnUsuCodigo(rs.getInt("nUsuCodigo"));
                u.setcUsuId(rs.getString("cUsuId"));
                u.setcUsuClave(rs.getString("cUsuClave"));
                u.setPersonal(BDPersonal.buscarPersonalCodigo(rs.getInt("nPerCodigo")));
                u.setcUsuEstado(rs.getString("cUsuEstado"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Búsqueda de Usuario">
    public static Usuario buscarUsuario(int codigo) throws SQLException {
        return buscarUsuario("SELECT nUsuCodigo,cUsuId,cUsuClave,nPerCodigo,cUsuEstado FROM usuario WHERE nUsuCodigo=" + codigo, null);
    }

    private static Usuario buscarUsuario(String sql, Usuario u) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (u == null) {
                u = new Usuario();
            }
            u.setnUsuCodigo(rs.getInt("nUsuCodigo"));
            u.setcUsuId(rs.getString("cUsuId"));
            u.setcUsuClave(rs.getString("cUsuClave"));
            u.setPersonal(BDPersonal.buscarPersonalCodigo(rs.getInt("nPerCodigo")));
            u.setcUsuEstado(rs.getString("cUsuEstado"));
        }
        return u;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Usuario">
    public static void insertarUsuario(Usuario u) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO usuario (nUsuCodigo,cUsuId,cUsuClave,nPerCodigo,cUsuEstado) VALUES (?,?,?,?,?)");
        ps.setInt(1, u.getnUsuCodigo());
        ps.setString(2, u.getcUsuId());
        ps.setString(3, u.getcUsuClave());
        ps.setInt(4, u.getPersonal().getnPerCodigo());
        ps.setString(5, u.getcUsuEstado());
        ps.executeUpdate();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualización de Usuario">
    public static boolean actualizarUsuario(Usuario u) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("UPDATE usuario SET cUsuId=?,cUsuClave=?,nPerCodigo=?,cUsuEstado=? WHERE nUsuCodigo=" + u.getnUsuCodigo());
        ps.setString(1, u.getcUsuId());
        ps.setString(2, u.getcUsuClave());
        ps.setInt(3, u.getPersonal().getnPerCodigo());
        ps.setString(4, u.getcUsuEstado());
        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Muestreo de Usuario">
    public static ArrayList<Usuario> mostrarUsuario() throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ArrayList<Usuario> lista = new ArrayList<>();

        ps = cnn.prepareStatement("SELECT nUsuCodigo,cUsuId,cUsuClave,nPerCodigo,cUsuEstado FROM usuario");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setnUsuCodigo(rs.getInt("nUsuCodigo"));
            u.setcUsuId(rs.getString("cUsuId"));
            u.setcUsuClave(rs.getString("cUsuClave"));
            u.setPersonal(BDPersonal.buscarPersonalCodigo(rs.getInt("nPerCodigo")));
            u.setcUsuEstado(rs.getString("cUsuEstado"));
            lista.add(u);
        }
        return lista;
    }
    // </editor-fold>
}
