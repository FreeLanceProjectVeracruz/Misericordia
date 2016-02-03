package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Transaccion;

/**
 *
 * @author Viruz
 */
public class BDTransaccion {

    // <editor-fold defaultstate="collapsed" desc="Inserción de Transacción">
    public static void insertarTransaccion(Transaccion t) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO transaccion (NTRACODIGO,nVenCodigo,nProCodigo,nTraPrecio,nTraCantidad,nTraPrecioTotal) VALUES(NTRACODIGO.NEXTVAL,?,?,?,?,?)");
        ps.setInt(1, t.getVenta().getnVenCodigo());
        ps.setInt(2, t.getProducto().getnProCodigo());
        ps.setDouble(3, t.getnTraPrecio());
        ps.setInt(4, t.getNtraCantidad());
        ps.setDouble(5, t.getnTraPrecioTotal());
        ps.executeUpdate();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Listado de Transacción">
    public static ArrayList<Transaccion> listarTransaccionVenta(int nventa) {
        return consultarSQL("SELECT nTraCodigo,nVenCodigo,nProCodigo,nTraPrecio,nTraCantidad,nTraPrecioTotal FROM transaccion WHERE nVenCodigo=" + nventa);
    }

    private static ArrayList<Transaccion> consultarSQL(String sql) {
        ArrayList<Transaccion> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();

        try {
            Transaccion t;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                t = new Transaccion();
                t.setnTraCodigo(rs.getInt(1));
                t.setVenta(BDVenta.buscarVenta(rs.getInt(2)));
                t.setProducto(BDProducto.buscarProducto(rs.getInt(3)));
                t.setnTraPrecio(rs.getDouble(4));
                t.setNtraCantidad(rs.getInt(5));
                t.setnTraPrecioTotal(rs.getDouble(6));
                list.add(t);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>
}
