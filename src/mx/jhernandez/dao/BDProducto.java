package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Producto;

/**
 *
 * @author Viruz
 */
public class BDProducto {

    // <editor-fold defaultstate="collapsed" desc="Enlistado de Productos">
    public static ArrayList<Producto> listarProductoPorCodigo(String codigo) {
        return listar("nProCodigo", codigo + "%", "LIKE");
    }

    public static ArrayList<Producto> listarProductoPorNombre(String nombre) {
        return listar("cProNombre", nombre + "%", "LIKE");
    }

    public static ArrayList<Producto> listarProductoPorCodProveedor(String nombre) {
        return listar("cCodProProv", nombre + "%", "LIKE");
    }

    private static ArrayList<Producto> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("SELECT nProCodigo,cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado FROM producto WHERE " + atributo + " " + comparador + " '" + parametro + "' and CPROESTADO='Activo'");
    }

    public static ArrayList<Producto> listarProductoPorCodigoEstado(String codigo) throws SQLException {
        return consultarSQL("SELECT nProCodigo,cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado FROM producto WHERE nProCodigo LIKE '" + codigo + "%' AND cProEstado='Activo'");
    }

    public static ArrayList<Producto> listarProductoPorNombreEstado(String codigo) throws SQLException {
        return consultarSQL("SELECT nProCodigo,cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado FROM producto WHERE cProNombre LIKE '" + codigo + "%' AND cProEstado='Activo'");
    }

    public static ArrayList<Producto> listarProductoPorCodProveedorEstado(String codigo) throws SQLException {
        return consultarSQL("SELECT nProCodigo,cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado FROM producto WHERE cCodProProv LIKE '" + codigo + "%' AND cProEstado='Activo'");
    }

    private static ArrayList<Producto> consultarSQL(String sql) {
        ArrayList<Producto> list = new ArrayList<>();
        Connection cn = ConexionPrincipal.getConnection();
        try {
            Producto p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                p = new Producto();
                p.setnProCodigo(rs.getInt("nProCodigo"));
                p.setcProNombre(rs.getString("cProNombre"));
                p.setnProCantidad(rs.getInt("nProCantidad"));
                p.setnPropRecioCompra(rs.getDouble("nProPrecioCompra"));
                p.setnProPRecioVenta(rs.getDouble("nProPrecioVenta"));
                p.setnProUtilidad(rs.getString("nProUtilidad"));
                p.setcProDescripcion(rs.getString("cProDescripcion"));
                p.setCategoria(BDCategoria.buscarCategoriaCodigo(rs.getInt("nCatCodigo")));
                p.setcProMarca(rs.getString("cProMarca"));
                p.setcCodProProv(rs.getString("cCodProProv"));
                p.setcProEstado(rs.getString("cProEstado"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Productos">
    public static Producto insertarProducto(Producto p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO producto (nProCodigo,cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado) VALUES(nProCodigo.NEXTVAL,?,?,?,?,?,?,?,?,?,?)");

        ps.setString(1, p.getcProNombre());
        ps.setInt(2, p.getnProCantidad());
        ps.setDouble(3, p.getnPropRecioCompra());
        ps.setDouble(4, p.getnProPRecioVenta());
        ps.setString(5, p.getnProUtilidad());
        ps.setString(6, p.getcProDescripcion());
        ps.setInt(7, p.getCategoria().getnCatCodigo());
        ps.setString(8, p.getcProMarca());
        ps.setString(9, p.getcCodProProv());
        ps.setString(10, p.getcProEstado());
        ps.executeUpdate();

        PreparedStatement ps2 = cnn.prepareStatement("SELECT MAX(nProCodigo) FROM producto");
        ResultSet r = ps2.executeQuery();

        if (r.next()) {
            int lastID = r.getInt(1);
            p.setnProCodigo(lastID);
        }
        return p;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Busqueda de Productos">
    public static Producto buscarProducto(int codigo) throws SQLException {
        return buscarProducto(codigo, null);
    }

    public static Producto buscarProducto(int codigo, Producto p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("SELECT cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado FROM producto WHERE nProCodigo=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            if (p == null) {
                p = new Producto();
            }
            p.setnProCodigo(codigo);
            p.setcProNombre(rs.getString("cProNombre"));
            p.setnProCantidad(rs.getInt("nProCantidad"));
            p.setnPropRecioCompra(rs.getDouble("nProPrecioCompra"));
            p.setnProPRecioVenta(rs.getDouble("nProPrecioVenta"));
            p.setnProUtilidad(rs.getString("nProUtilidad"));
            p.setcProDescripcion(rs.getString("cProDescripcion"));
            p.setCategoria(BDCategoria.buscarCategoriaCodigo(rs.getInt("nCatCodigo")));
            p.setcProMarca(rs.getString("cProMarca"));
            p.setcCodProProv(rs.getString("cCodProProv"));
            p.setcProEstado(rs.getString("cProEstado"));
        }
        return p;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualización de Productos">
    public static boolean actualizarProducto(Producto p) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("UPDATE producto SET cProNombre=?,nProCantidad=?,nProPrecioCompra=?,nProPrecioVenta=?,nProUtilidad=?,cProDescripcion=?,nCatCodigo=?,cProMarca=?,cCodProProv=?,cProEstado=? WHERE nProCodigo=" + p.getnProCodigo());
        ps.setString(1, p.getcProNombre());
        ps.setInt(2, p.getnProCantidad());
        ps.setDouble(3, p.getnPropRecioCompra());
        ps.setDouble(4, p.getnProPRecioVenta());
        ps.setString(5, p.getnProUtilidad());
        ps.setString(6, p.getcProDescripcion());
        ps.setInt(7, p.getCategoria().getnCatCodigo());
        ps.setString(8, p.getcProMarca());
        ps.setString(9, p.getcCodProProv());
        ps.setString(10, p.getcProEstado());
        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mostrado de Productos">
    public static ArrayList<Producto> mostrarProducto() throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ArrayList<Producto> lista = new ArrayList<>();

        ps = cnn.prepareStatement("SELECT nProCodigo,cProNombre,nProCantidad,nProPrecioCompra,nProPrecioVenta,nProUtilidad,cProDescripcion,nCatCodigo,cProMarca,cCodProProv,cProEstado FROM producto");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Producto p = new Producto();

            p.setcProNombre(rs.getString("cProNombre"));
            p.setnProCodigo(rs.getInt("nProCodigo"));
            p.setnProCantidad(rs.getInt("nProCantidad"));
            p.setnPropRecioCompra(rs.getDouble("nProPrecioCompra"));
            p.setnProPRecioVenta(rs.getDouble("nProPrecioVenta"));
            p.setnProUtilidad(rs.getString("nProUtilidad"));
            p.setcProDescripcion(rs.getString("cProDescripcion"));
            p.setCategoria(BDCategoria.buscarCategoriaCodigo(rs.getInt("nCatCodigo")));
            p.setcProMarca(rs.getString("cProMarca"));
            p.setcCodProProv(rs.getString("cCodProProv"));
            p.setcProEstado(rs.getString("cProEstado"));
            lista.add(p);
        }
        return lista;
    }
    // </editor-fold>
}
