package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Contado;

/**
 *
 * @author Viruz
 */
public class BDContado {

    // <editor-fold defaultstate="collapsed" desc="Inserción de Contado">
    public static void insertarPagoContado(Contado c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO contado (nVenCodigo,cContEstado,nContMontoPagado) VALUES (?,?,?)");
        ps.setInt(1, c.getVenta().getnVenCodigo());
        ps.setString(2, c.getcContEstado());
        ps.setDouble(3, c.getnContMontoPago());
        ps.executeUpdate();
    }
    // </editor-fold>
}
