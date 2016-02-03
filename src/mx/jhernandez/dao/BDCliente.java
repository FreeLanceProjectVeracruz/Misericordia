package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Cliente;

/**
 *
 * @author Viruz
 */
public class BDCliente {

    // <editor-fold defaultstate="collapsed" desc="Listado de Cliente">
    public static ArrayList<Cliente> listarClientePorCodigo(String codigo) {
        return listar("nCliCodigo", codigo + "%", "LIKE");
    }

    public static ArrayList<Cliente> listarClientePorNombre(String nombre) {
        return listar("cCliNombre", nombre + "%", "LIKE");
    }

    private static ArrayList<Cliente> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT nCliCodigo,cCliCi,cCliNit,cCliNombre,cCliDireccion,cCliNumTelefono,cCliTipoTelefono,cCliNroFax,cCliEmail,cCliOtros FROM cliente WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Cliente> consultarSQL(String sql) {
        ArrayList<Cliente> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();
        try {
            Cliente cli;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cli = new Cliente();
                cli.setnCliCodigo(rs.getInt("nCliCodigo"));
                cli.setcCliCi(rs.getString("cCliCi"));
                cli.setcCliNit(rs.getString("cCliNit"));
                cli.setcCliNombre(rs.getString("cCliNombre"));
                cli.setcCliDireccion(rs.getString("cCliDireccion"));
                cli.setcCliNumTelefono(rs.getString("cCliNumTelefono"));
                cli.setcCliTipoTelefono(rs.getString("cCliTipoTelefono"));
                cli.setcCliNroFax(rs.getString("cCliNroFax"));
                cli.setcCliEmail(rs.getString("cCliEmail"));
                cli.setcCliOtros(rs.getString("cCliOtros"));
                list.add(cli);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Búsqueda de Cliente">
    public static Cliente buscarClienteCodigo(int codigo) throws SQLException {
        return buscarClienteCodigo(codigo, null);
    }

    public static Cliente buscarClienteCodigo(int codigo, Cliente c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("SELECT cCliNit,cCliCi,cCliNombre,cCliDireccion,cCliNumTelefono,cCliTipoTelefono,cCliNroFax,cCliEmail,cCliOtros FROM cliente WHERE nCliCodigo=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (c == null) {
                c = new Cliente();
            }
            c.setnCliCodigo(codigo);
            c.setcCliNit(rs.getString("cCliNit"));
            c.setcCliCi(rs.getString("cCliCi"));
            c.setcCliNombre(rs.getString("cCliNombre"));
            c.setcCliDireccion(rs.getString("cCliDireccion"));
            c.setcCliNumTelefono(rs.getString("cCliNumTelefono"));
            c.setcCliTipoTelefono(rs.getString("cCliTipoTelefono"));
            c.setcCliNroFax(rs.getString("cCliNroFax"));
            c.setcCliEmail(rs.getString("cCliEmail"));
            c.setcCliOtros(rs.getString("cCliOtros"));
        }
        return c;
    }

    public static Cliente buscarClienteNit(String nit) throws SQLException {
        return buscarClienteNit(nit, null);
    }

    public static Cliente buscarClienteNit(String nit, Cliente c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("SELECT nCliCodigo,cCliCi,cCliNombre,cCliDireccion,cCliNumTelefono,cCliTipoTelefono,cCliNroFax,cCliEmail,cCliOtros FROM cliente WHERE cCliNit=?");
        ps.setString(1, nit);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (c == null) {
                c = new Cliente();
            }
            c.setcCliNit(nit);
            c.setnCliCodigo(rs.getInt("nCliCodigo"));
            c.setcCliCi(rs.getString("cCliCi"));
            c.setcCliNombre(rs.getString("cCliNombre"));
            c.setcCliDireccion(rs.getString("cCliDireccion"));
            c.setcCliNumTelefono(rs.getString("cCliNumTelefono"));
            c.setcCliTipoTelefono(rs.getString("cCliTipoTelefono"));
            c.setcCliNroFax(rs.getString("cCliNroFax"));
            c.setcCliEmail(rs.getString("cCliEmail"));
            c.setcCliOtros(rs.getString("cCliOtros"));
        }
        return c;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Cliente">
    public static void insertarCliente(Cliente c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("INSERT INTO cliente (nCliCodigo,cCliNit,cCliCi,cCliNombre,cCliDireccion,cCliNumTelefono,cCliTipoTelefono,cCliNroFax,cCliEmail,cCliOtros) VALUES (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, c.getnCliCodigo());
        ps.setString(2, c.getcCliNit());
        ps.setString(3, c.getcCliCi());
        ps.setString(4, c.getcCliNombre());
        ps.setString(5, c.getcCliDireccion());
        ps.setString(6, c.getcCliNumTelefono());
        ps.setString(7, c.getcCliTipoTelefono());
        ps.setString(8, c.getcCliNroFax());
        ps.setString(9, c.getcCliEmail());
        ps.setString(10, c.getcCliOtros());
        ps.executeUpdate();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualización de Cliente">
    public static boolean actualizarCliente(Cliente c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("UPDATE cliente SET cCliNombre=?,cCliCi=?, cCliNit=?, cCliDireccion=?, cCliNumTelefono=?, cCliTipoTelefono=?, cCliNroFax=?, cCliEmail=?, cCliOtros=? WHERE nCliCodigo=" + c.getnCliCodigo());
        ps.setString(1, c.getcCliNombre());
        ps.setString(2, c.getcCliCi());
        ps.setString(3, c.getcCliNit());
        ps.setString(4, c.getcCliDireccion());
        ps.setString(5, c.getcCliNumTelefono());
        ps.setString(6, c.getcCliTipoTelefono());
        ps.setString(7, c.getcCliNroFax());
        ps.setString(8, c.getcCliEmail());
        ps.setString(9, c.getcCliOtros());

        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mostrar Clientes">
    public static ArrayList<Cliente> mostrarCliente() throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ArrayList<Cliente> lista = new ArrayList<>();

        ps = cnn.prepareStatement("SELECT nCliCodigo,cCliCi,cCliNit,cCliNombre,cCliDireccion,cCliNumTelefono,cCliTipoTelefono,cCliNroFax,cCliEmail,cCliOtros FROM cliente");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();

            c.setnCliCodigo(rs.getInt("nCliCodigo"));
            c.setcCliCi(rs.getString("cCliCi"));
            c.setcCliNit(rs.getString("cCliNit"));
            c.setcCliNombre(rs.getString("cCliNombre"));
            c.setcCliDireccion(rs.getString("cCliDireccion"));
            c.setcCliNumTelefono(rs.getString("cCliNumTelefono"));
            c.setcCliTipoTelefono(rs.getString("cCliTipoTelefono"));
            c.setcCliNroFax(rs.getString("cCliNroFax"));
            c.setcCliEmail(rs.getString("cCliEmail"));
            c.setcCliOtros(rs.getString("cCliOtros"));
            lista.add(c);
        }
        return lista;
    }
    // </editor-fold>
}
