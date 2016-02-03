package mx.jhernandez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.Credito;

/**
 *
 * @author Viruz
 */
public class BDCredito {

    // <editor-fold defaultstate="collapsed" desc="Inserción de Credito">
    public static void insertarPagoCredito(Credito c) throws SQLException {
        Connection cnn = ConexionPrincipal.getConnection();
        PreparedStatement ps;
        ps = cnn.prepareStatement("INSERT INTO credito (nVenCodigo,nCreNroCuotas,nCreMontoPorCuota,cCreEstado,nCreMontoDebito) VALUES (?,?,?,?,?)");
        ps.setInt(1, c.getVenta().getnVenCodigo());
        ps.setInt(2, c.getnCreNroCuotas());
        ps.setDouble(3, c.getNcreMontoPorCuota());
        ps.setString(4, c.getcCreEstado());
        ps.setDouble(5, c.getnCreMontoDebito());
        ps.executeUpdate();
    }
    // </editor-fold>
}
