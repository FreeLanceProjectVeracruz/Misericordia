package mx.jhernandez.reports;

import java.sql.Connection;
import mx.jhernandez.database.ConexionPrincipal;

/**
 *
 * @author Viruz
 */
public class ReporteVentaConsulta {

    private final Connection cnn;

    public ReporteVentaConsulta() {
        cnn = ConexionPrincipal.getConnection();
    }

    public void runReporteVentaConsulta(String busqueda) {
//        try 
//        {
//            String master = System.getProperty("user.dir") + "/src/ComponenteReportes/ReporteVentaConsulta.jasper";
//            if (master == null) 
//            {
//                System.out.println("no encuentro el archivo de reporte maestro");
//                System.exit(2);
//            }
//            
//            JasperReport masterReport = null;
//            
//            try {
//                masterReport = (JasperReport) JRLoader.loadObject(master);
//            } catch (JRException e) {
//                System.out.println("error cargando el reporte maestro:" + e.getMessage());
//                System.exit(3);
//            }
//            
//            Map parametro = new HashMap();
//            parametro.put("busqueda",busqueda);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, cnn);
//            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
//            jviewer.setTitle("REPORTE VENTAS");
//            jviewer.setVisible(true);
//        } catch (Exception j) {
//            System.out.println("mensaje de error:" + j.getMessage());
//        }
    }
}
