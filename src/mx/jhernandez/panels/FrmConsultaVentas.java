package mx.jhernandez.panels;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import mx.jhernandez.views.FrmMenuPrincipal;
import mx.jhernandez.dao.BDVenta;
import mx.jhernandez.panels.dialogs.JDDetalleVenta;
import mx.jhernandez.vo.Venta;
import mx.jhernandez.reports.*;

/**
 *
 * @author Viruz
 */
public class FrmConsultaVentas extends javax.swing.JFrame {

    private final FrmMenuPrincipal principal;
    private JDDetalleVenta jdventa;
    private ReporteVentaConsulta rVentaC;
    private ReporteVentaConsultaDocumento rVentaCDocumento;
    private ReporteVentaConsultaCliente rVentaCCliente;
    private ReporteVentaConsultaFecha rVentaCFecha;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form FrmConsultaVentas
     *
     * @param menuPrincipal
     */
    public FrmConsultaVentas(FrmMenuPrincipal menuPrincipal) {
        this.principal = menuPrincipal;
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        initComponents();
        actualizarBusqueda();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Privados">
    private void actualizarBusqueda() {
        ArrayList<Venta> result;

        if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Codigo")) {
            result = BDVenta.listarVentaPorCodigo(txtBuscarV.getText());
        } else if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Cliente")) {
            result = BDVenta.listarVentaPorCliente(txtBuscarV.getText());
        } else if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Empleado")) {
            result = BDVenta.listarVentaPorEmpleado(txtBuscarV.getText());
        } else {
            result = BDVenta.listarVentaPorTipoDocumento(txtBuscarV.getText());
        }

        recargarTable(result);
        obtenerMontoTotal();
    }

    private void recargarTable(ArrayList<Venta> list) {
        Object[][] datos = new Object[list.size()][7];
        int i = 0;

        for (Venta v : list) {
            datos[i][0] = v.getnVenCodigo();
            datos[i][1] = v.getPersonal().getcPerNombre();
            datos[i][2] = v.getCliente().getcCliNombre();
            datos[i][3] = v.getcVenFecha();
            datos[i][4] = v.getTipoDocumento().getcTipoDocDescripcion();
            datos[i][5] = v.getnVenMontoTotal();
            datos[i][6] = v.getcVenEstado();
            i++;
        }
        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "CODIGO", "EMPLEADO", "CLIENTE", "FECHA", "DOCUMENTO", "MONTO TOTAL", "ESTADO"
                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
    }

    private void obtenerMontoTotal() {
        int fila;
        double montoTotal = 0.0;
        fila = jtVentas.getRowCount();

        for (int i = 0; i < fila; i++) {
            montoTotal += Double.parseDouble(String.valueOf(jtVentas.getModel().getValueAt(i, 5)));
        }
        txtMontoTotal.setText("" + montoTotal);
    }
    // </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarV = new javax.swing.JTextField();
        cboParametroV = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaB = new javax.swing.JTextField();
        btnFiltrarFecha = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE VENTAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Garamond", 1, 20))); // NOI18N

        jLabel1.setText("BUSCAR VENTA :");

        txtBuscarV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarVKeyReleased(evt);
            }
        });

        cboParametroV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Empleado", "TipoDocumento", "Codigo" }));
        cboParametroV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroVActionPerformed(evt);
            }
        });

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtVentas);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Exit.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Filtrar Por Fecha :");

        txtFechaA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("al ");

        txtFechaB.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnFiltrarFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Zoom.png"))); // NOI18N
        btnFiltrarFecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFiltrarFecha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFiltrarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaA, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFechaA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtFechaB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFiltrarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(247, 254, 255));

        jLabel4.setText("Monto Total :");

        txtMontoTotal.setEditable(false);
        txtMontoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(487, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Print.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarV, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroV, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarVKeyReleased
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarVKeyReleased

    private void cboParametroVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroVActionPerformed
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroVActionPerformed

    private void jtVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentasMouseClicked
        try {
            Venta v = BDVenta.buscarVenta(Integer.parseInt(String.valueOf(jtVentas.getModel().getValueAt(jtVentas.getSelectedRow(), 0))));
            jdventa = new JDDetalleVenta(this, true, v.getnVenCodigo(), String.valueOf(v.getTipoDocumento().getcTipoDocDescripcion()),
                    String.valueOf(v.getTipoDocumento().getcTipDocSerie() + "-" + v.getTipoDocumento().getcTipDocCodigo()), String.valueOf(v.getcVenFecha()),
                    String.valueOf(v.getnVenMontoTotal()), String.valueOf(v.getCliente().getcCliNombre()), v.getcFormapago());
            jdventa.setVisible(true);
        } catch (SQLException ex) {
            // System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error Al Seleccionar Elemento:" + ex.getMessage());
        }
    }//GEN-LAST:event_jtVentasMouseClicked

    private void btnFiltrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarFechaActionPerformed
        ArrayList<Venta> result;
        result = BDVenta.listarVentaPorRangoFecha(txtFechaA.getText(), txtFechaB.getText());
        recargarTable(result);
        obtenerMontoTotal();
    }//GEN-LAST:event_btnFiltrarFechaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
        dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (txtBuscarV.getText().compareTo("") == 0 && txtFechaA.getText().compareTo("") == 0 && txtFechaB.getText().compareTo("") == 0) {
            if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Codigo")) {
                rVentaC = new ReporteVentaConsulta();
                rVentaC.runReporteVentaConsulta(txtBuscarV.getText());
            } else if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Cliente")) {
                //ReporteVentaConsulta
                rVentaCCliente = new ReporteVentaConsultaCliente();
                rVentaCCliente.runReporteVentaConsultaCliente(txtBuscarV.getText());
            } else {
                rVentaCDocumento = new ReporteVentaConsultaDocumento();
                rVentaCDocumento.runReporteVentaConsultaDocumento(txtBuscarV.getText());
            }
        } else if (txtBuscarV.getText().compareTo("") != 0) {
            if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Codigo")) {
                rVentaC = new ReporteVentaConsulta();
                rVentaC.runReporteVentaConsulta(txtBuscarV.getText());
            } else if (String.valueOf(cboParametroV.getSelectedItem()).equalsIgnoreCase("Cliente")) {
                rVentaCCliente = new ReporteVentaConsultaCliente();
                rVentaCCliente.runReporteVentaConsultaCliente(txtBuscarV.getText());
            } else {
                rVentaCDocumento = new ReporteVentaConsultaDocumento();
                rVentaCDocumento.runReporteVentaConsultaDocumento(txtBuscarV.getText());
            }
        } else if (txtFechaA.getText().compareTo("") != 0 && txtFechaB.getText().compareTo("") != 0) {
            rVentaCFecha = new ReporteVentaConsultaFecha();
            rVentaCFecha.runReporteVentaConsultaFecha(txtFechaA.getText(), txtFechaB.getText());
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrarFecha;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboParametroV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtVentas;
    private javax.swing.JTextField txtBuscarV;
    private javax.swing.JTextField txtFechaA;
    private javax.swing.JTextField txtFechaB;
    private javax.swing.JTextField txtMontoTotal;
    // End of variables declaration//GEN-END:variables
}
