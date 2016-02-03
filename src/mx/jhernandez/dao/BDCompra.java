package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Compra;

/**
 *
 * @author Viruz
 */
public class BDCompra {

    // <editor-fold defaultstate="collapsed" desc="Listado de Compras">
    public static ArrayList<Compra> listarCompraPorCodigo(String codigo) {
        return consultarSQL("SELECT c.nComCodigo,c.nProvCodigo,c.cComFecha FROM compra c INNER JOIN proveedor p ON p.nProvCodigo = c.nProvcodigo WHERE c.nComCodigo LIKE '%" + codigo + "%' GROUP BY nProvCodigo,c.cComFecha ORDER BY c.cComFecha");
    }

    public static ArrayList<Compra> listarCompraPorProveedor(String prov) {
        return consultarSQL("SELECT c.nComCodigo,c.nProvCodigo,c.cComFecha FROM compra c INNER JOIN proveedor p ON p.nProvCodigo = c.nProvcodigo WHERE p.cProvNombre LIKE '%" + prov + "%' GROUP BY nProvCodigo,c.cComFecha ORDER BY c.cComFecha");
    }

    public static ArrayList<Compra> listarCompraProProveedor(int codprov, String fecha) {
        return consultarSQLProv("SELECT nProCodigo,nComPrecio,nComPrecioTotal,nComCantidad FROM compra WHERE nProvCodigo=" + codprov + " AND DATE_FORMAT(cComFecha, '%Y-%m-%d')='" + fecha + "'");
    }

    private static ArrayList<Compra> consultarSQL(String sql) {
        ArrayList<Compra> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();

        try {
            Compra c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                c = new Compra();
                c.setnComCodigo(rs.getInt("nComCodigo"));
                c.setProveedor(BDProveedor.buscarProveedor(rs.getInt("nProvCodigo")));
                c.setcComFecha((java.util.Date) rs.getDate("cComFecha"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }

    private static ArrayList<Compra> consultarSQLProv(String sql) {
        ArrayList<Compra> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();
        try {
            Compra c;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c = new Compra();
                c.setProducto(BDProducto.buscarProducto(rs.getInt("nProCodigo")));
                c.setnComCantidad(rs.getInt("nComCantidad"));
                c.setnComPrecio(rs.getDouble("nComPrecio"));
                c.setnComPrecioTotal(rs.getDouble("nComPrecioTotal"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Compras">
    public static void insertarCompra(Compra c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("INSERT INTO compra (nProvCodigo,nProCodigo,cComFecha,nComCantidad,nComPrecio,cComSerie,nComCodigo) VALUES (?,?,?,?,?,?,NCOMCODIGO.NEXTVAL)");
        ps.setInt(1, c.getProveedor().getnProvCodigo());
        ps.setInt(2, c.getProducto().getnProCodigo());
        ps.setDate(3, new java.sql.Date(c.getcComFecha().getTime()));
        ps.setInt(4, c.getnComCantidad());
        ps.setDouble(5, c.getnComPrecio());
//      ps.setDouble(6, c.getnComPrecioTotal());
        ps.setString(6, c.getcComSerie());
        // ps.setString(7, c.getcComCodigo());
        ps.executeUpdate();
    }
    // </editor-fold>
}
