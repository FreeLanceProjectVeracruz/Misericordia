package mx.jhernandez.reports;

import java.sql.Connection;
import mx.jhernandez.database.ConexionPrincipal;

/**
 *
 * @author Viruz
 */
public class ReporteVentaConsultaCliente {

    private final Connection cnn;

    public ReporteVentaConsultaCliente() {
        cnn = ConexionPrincipal.getConnection();
    }

    public void runReporteVentaConsultaCliente(String busqueda) {

    }
}
