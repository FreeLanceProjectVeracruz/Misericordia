package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Categoria;

/**
 *
 * @author Viruz
 */
public class BDCategoria {

    // <editor-fold defaultstate="expanded" desc="Busqueda de Categorias">
    public static Categoria buscarCategoriaCodigo(int codigo) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        Categoria cat = null;
        ps = cnn.prepareStatement("SELECT nCatCodigo,cCatDescripcion FROM categoria WHERE nCatCodigo=?");
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cat = new Categoria();
            cat.setnCatCodigo(codigo);
            cat.setcCatDescripcion(rs.getString("cCatDescripcion"));
        }
        return cat;
    }

    public static Categoria buscarCategoriaDescripcion(String descripcion) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        Categoria cat = null;
        ps = cnn.prepareStatement("SELECT nCatCodigo,cCatDescripcion FROM categoria WHERE cCatDescripcion='" + descripcion + "'");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cat = new Categoria();
            cat.setcCatDescripcion(descripcion);
            cat.setnCatCodigo(rs.getInt("nCatCodigo"));
        }
        return cat;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Inserción de Categorías">
    public static void insertarCategoria(Categoria cat) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO categoria (nCatCodigo,cCatDescripcion) VALUES(?,?)");
        ps.setInt(1, cat.getnCatCodigo());
        ps.setString(2, cat.getcCatDescripcion());
        ps.executeUpdate();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mostrar Clientes">
    public static ArrayList<Categoria> mostrarCategoria() throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ArrayList<Categoria> lista = new ArrayList<>();

        ps = cnn.prepareStatement("SELECT nCatCodigo,cCatDescripcion FROM categoria");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setnCatCodigo(rs.getInt("nCatCodigo"));
            cat.setcCatDescripcion(rs.getString("cCatDescripcion"));
            lista.add(cat);
        }
        return lista;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Actualización de Categorías">
    public static boolean actualizarCategoria(Categoria cat) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;

        ps = cnn.prepareStatement("UPDATE categoria SET cCatDescripcion=? WHERE nCatCodigo=" + cat.getnCatCodigo());
        ps.setString(1, cat.getcCatDescripcion());
        int rowsUpdated = ps.executeUpdate();

        return rowsUpdated > 0;
    }
    // </editor-fold>
}
