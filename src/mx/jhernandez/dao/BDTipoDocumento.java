package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.TipoDocumento;

/**
 *
 * @author Viruz
 */
public class BDTipoDocumento {

    // <editor-fold defaultstate="collapsed" desc="Inserción de Documento">
    public static void insertarTipoDocumento(TipoDocumento t) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO tipodocumento (NTIPDOCUMENTO,cTipDocDescripcion,cTipDocSerie,cTipDocCodigo) VALUES (NTIPODOCUMENTO.NEXTVAL,?,?,?)");
        ps.setString(1, t.getcTipoDocDescripcion());
        ps.setString(2, t.getcTipDocSerie());
        ps.setString(3, t.getcTipDocCodigo());
        ps.executeUpdate();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Búsqueda de Documento">
    public static TipoDocumento buscarTipoDocumento(int codigo) throws SQLException {
        return buscarTipoDocumento("SELECT nTipDocumento,cTipDocDescripcion,cTipDocSerie,cTipDocCodigo FROM tipodocumento WHERE nTipDocumento=" + codigo, null);
    }

    public static TipoDocumento buscarTipoDocumento(String sql, TipoDocumento t) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            t = new TipoDocumento();
            t.setnTipDocumento(rs.getInt("nTipDocumento"));
            t.setcTipoDocDescripcion(rs.getString("cTipDocDescripcion"));
            t.setcTipDocSerie(rs.getString("cTipDocSerie"));
            t.setcTipDocCodigo(rs.getString("cTipDocCodigo"));
        }
        return t;
    }
    // </editor-fold>
}
