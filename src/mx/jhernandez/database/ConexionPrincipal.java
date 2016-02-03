package mx.jhernandez.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class ConexionPrincipal {

    private static Connection cn;

    public static Connection getConnection() {
        try {
            if (cn == null) {
                String user = "pruebas";
                String password = "pruebas";

//                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                cn = DriverManager.getConnection("jdbc:oracle:thin:@187.141.82.89:1521:oracleg", user, password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPrincipal.class.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error BD: " + ex.getMessage());
        }
        return cn;
    }
}
