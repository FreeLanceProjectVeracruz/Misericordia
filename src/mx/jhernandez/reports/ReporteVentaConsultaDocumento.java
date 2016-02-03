package mx.jhernandez.reports;

import java.sql.Connection;
import mx.jhernandez.database.ConexionPrincipal;

/**
 *
 * @author Viruz
 */
public class ReporteVentaConsultaDocumento {

    private final Connection cnn;

    public ReporteVentaConsultaDocumento() {
        cnn = ConexionPrincipal.getConnection();
    }

    public void runReporteVentaConsultaDocumento(String busqueda) {

    }
}
