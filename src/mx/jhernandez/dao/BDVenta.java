package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Venta;

/**
 *
 * @author Viruz
 */
public class BDVenta {

    // <editor-fold defaultstate="collapsed" desc="Inserción de Venta">
    public static void insertarVenta(Venta v) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("INSERT INTO venta (NVENCODIGO,nCliCodigo,nPerCodigo,cVenFecha,nVenMontoTotal,nTipDocumento,cVenEstado,cFormapago) VALUES (NVENCODIGO.NEXTVAL,?,?,?,?,?,?,?)");
        ps.setInt(1, v.getCliente().getnCliCodigo());
        ps.setInt(2, v.getPersonal().getnPerCodigo());
        ps.setDate(3, new java.sql.Date(v.getcVenFecha().getTime()));
        ps.setDouble(4, v.getnVenMontoTotal());
        ps.setInt(5, v.getTipoDocumento().getnTipDocumento());
        ps.setString(6, v.getcVenEstado());
        ps.setString(7, v.getcFormapago());
        ps.executeUpdate();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Búsqueda de Venta">
    public static Venta buscarVenta(int codigo) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        Venta v = null;

        ps = cnn.prepareStatement("SELECT nCliCodigo,nPerCodigo,cVenFecha,nVenMontoTotal,nTipDocumento,cVenEstado,cFormapago FROM venta WHERE nVenCodigo=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            v = new Venta();
            v.setnVenCodigo(codigo);
            v.setCliente(BDCliente.buscarClienteCodigo(rs.getInt("nCliCodigo")));
            v.setPersonal(BDPersonal.buscarPersonalCodigo(rs.getInt("nPerCodigo")));
            v.setcVenFecha((java.util.Date) rs.getDate("cVenFecha"));
            v.setnVenMontoTotal(rs.getDouble("nVenMontoTotal"));
            v.setTipoDocumento(BDTipoDocumento.buscarTipoDocumento(rs.getInt("nTipDocumento")));
            v.setcVenEstado(rs.getString("cVenEstado"));
            v.setcFormapago(rs.getString("cFormapago"));
        }
        return v;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Listado de Venta">
    public static ArrayList<Venta> listarVentaPorCliente(String cli) {
        return listarCliente("c.cCliNombre", cli + "%", "like");
    }

    public static ArrayList<Venta> listarVentaPorCodigo(String codigo) {
        return listar("nVenCodigo", codigo + "%", "like");
    }

    public static ArrayList<Venta> listarVentaPorTipoDocumento(String td) {
        return listarTipo("tp.cTipDocDescripcion", td + "%", "like");
    }

    public static ArrayList<Venta> listarVentaPorFecha(String fecha) {
        return consultarSQL("SELECT nVenCodigo,nCliCodigo,nPerCodigo,cVenFecha,nVenMontoTotal,nTipDocumento,cVenEstado,cFormapago FROM venta WHERE cVenFecha LIKE '%" + fecha + "%'");
    }

    private static ArrayList<Venta> listarCliente(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT v.nVenCodigo,v.nCliCodigo,v.nPerCodigo,v.cVenFecha,v.nVenMontoTotal,v.nTipDocumento,v.cVenEstado,v.cFormapago FROM venta v INNER JOIN cliente c on v.nCliCodigo=c.nCliCodigo WHERE " + atributo + " " + comparador + " '" + parametro + "' order by cVenFecha asc");
    }

    public static ArrayList<Venta> listarVentaPorEmpleado(String nompersonal) {
        return listarEmpleado("p.cPerNombre", nompersonal + "%", "LIKE");
    }

    private static ArrayList<Venta> listarEmpleado(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT v.nVenCodigo,v.nCliCodigo,v.nPerCodigo,v.cVenFecha,v.nVenMontoTotal,v.nTipDocumento,v.cVenEstado,v.cFormapago FROM venta v inner join personal p on v.nPerCodigo=p.nPerCodigo WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Venta> listarTipo(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT v.nVenCodigo,v.nCliCodigo,v.nPerCodigo,v.cVenFecha,v.nVenMontoTotal,v.nTipDocumento,v.cVenEstado,v.cFormapago FROM venta v INNER JOIN TipoDocumento tp ON v.nTipDocumento=tp.nTipDocumento WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Venta> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT nVenCodigo,nCliCodigo,nPerCodigo,cVenFecha,nVenMontoTotal,nTipDocumento,cVenEstado,cFormapago FROM venta WHERE " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Venta> consultarSQL(String sql) {
        ArrayList<Venta> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();
        try {
            Venta v;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                v = new Venta();
                v.setnVenCodigo(rs.getInt("nVenCodigo"));
                v.setCliente(BDCliente.buscarClienteCodigo(rs.getInt("nCliCodigo")));
                v.setPersonal(BDPersonal.buscarPersonalCodigo(rs.getInt("nPerCodigo")));
                v.setcVenFecha((java.util.Date) rs.getDate("cVenFecha"));
                v.setnVenMontoTotal(rs.getDouble("nVenMontoTotal"));
                v.setTipoDocumento(BDTipoDocumento.buscarTipoDocumento(rs.getInt("nTipDocumento")));
                v.setcVenEstado(rs.getString("cVenEstado"));
                v.setcFormapago(rs.getString("cFormapago"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }

    public static ArrayList<Venta> listarVentaPorRangoFecha(String fechaA, String fechaB) {
        return consultarSQL("SELECT v.nVenCodigo,v.nCliCodigo,v.nPerCodigo,v.cVenFecha,v.nVenMontoTotal,v.nTipDocumento,v.cVenEstado,v.cFormapago FROM venta v WHERE DATE_FORMAT(v.cVenFecha, '%Y-%m-%d') BETWEEN '" + fechaA + "' AND '" + fechaB + "'");
    }
    // </editor-fold>

    public static void actualizarVenta(String estado, int codventa) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("UPDATE VENTA SET CVENESTADO='" + estado + "' WHERE NVENCODIGO=" + codventa);
        ps.executeUpdate();
    }

}
