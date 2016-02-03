package mx.jhernandez.reports;

import java.sql.Connection;
import mx.jhernandez.database.ConexionPrincipal;

/**
 *
 * @author TCSCON
 */
public class ReporteVentaConsultaFecha {

    private final Connection cnn;

    public ReporteVentaConsultaFecha() {
        cnn = ConexionPrincipal.getConnection();
    }

    public void runReporteVentaConsultaFecha(String fechaA, String fechaB) {

    }
}
