package mx.jhernandez.panels;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import mx.jhernandez.views.FrmMenuPrincipal;
import mx.jhernandez.dao.*;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.vo.*;

/**
 *
 * @author Viruz
 */
public class FrmConsultaCompra extends javax.swing.JFrame {

    private final FrmMenuPrincipal principal;
    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form FrmConsultaCompra
     *
     * @param menuPrincipal
     */
    public FrmConsultaCompra(FrmMenuPrincipal menuPrincipal) {
        this.principal = menuPrincipal;
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        initComponents();
        actualizarBusqueda();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Privados">
    private void actualizarBusqueda() {
        ArrayList<Compra> result = null;
        if (String.valueOf(cboParametroCom.getSelectedItem()).equalsIgnoreCase("Codigo")) {
            result = BDCompra.listarCompraPorCodigo(txtBuscarCom.getText());
        } else if (String.valueOf(cboParametroCom.getSelectedItem()).equalsIgnoreCase("Proveedor")) {
            result = BDCompra.listarCompraPorProveedor(txtBuscarCom.getText());
        }
        recargarTable(result);
        actualizarCant();
    }

    private void recargarTable(ArrayList<Compra> list) {
        Object[][] datos = new Object[list.size()][4];
        int i = 0;

        for (Compra c : list) {
            datos[i][0] = c.getnComCodigo();
            datos[i][1] = c.getProveedor().getcProvNombre();
            datos[i][2] = c.getcComFecha();
            datos[i][3] = obtenerCantidad(c.getcComFecha(), c.getProveedor().getnProvCodigo());
            i++;
        }
        jtListaCompra.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "CODIGO", "PROVEEDOR", "FECHA", "CANTIDAD"
                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
    }

    private int obtenerCantidad(Date fecha, int codproveedor) {
        int cantidad = 0;
        try {
            Connection con = ConexionPrincipal.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(nComCantidad)AS Cantidad FROM compra WHERE nProvCodigo=" + codproveedor + " AND DATE_FORMAT(cComFecha,'%Y-%m-%d')='" + formatofecha.format(fecha) + "'");
            while (rs.next()) {
                cantidad = rs.getInt("Cantidad");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error);
            //  System.out.println(error);
        }
        return cantidad;
    }

    private void actualizarCant() {
        int cant = 0;
        int fila;
        fila = jtListaCompra.getRowCount();

        for (int i = 0; i < fila; i++) {
            cant += Integer.parseInt(String.valueOf(jtListaCompra.getModel().getValueAt(i, 3)));
        }
        txtCantTotalCompra.setText(String.valueOf(cant));
    }

    private void actualizarBusquedaProv(int codprov, String fecha) {
        ArrayList<Compra> result;
        result = BDCompra.listarCompraProProveedor(codprov, fecha);
        recargarTableProv(result);
    }

    private void actualizarMonto() {
        double monto = 0.0;
        int fila;
        fila = jtDetalleCompra.getRowCount();
        for (int i = 0; i < fila; i++) {
            monto += Double.parseDouble(String.valueOf(jtDetalleCompra.getModel().getValueAt(i, 4)));
        }
        txtMontoTotal.setText(String.valueOf(monto));
    }

    private void recargarTableProv(ArrayList<Compra> list) {
        Object[][] datos = new Object[list.size()][5];
        int i = 0;

        for (Compra c : list) {
            datos[i][0] = c.getProducto().getcProNombre();
            datos[i][1] = c.getProducto().getcProDescripcion();
            datos[i][2] = c.getnComPrecio();
            datos[i][3] = c.getnComCantidad();
            datos[i][4] = c.getnComPrecioTotal();
            i++;
        }
        jtDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "PRODUCTO", "DESCRIPCION", "PRECIO COMPRA", "CANTIDAD", "IMPORTE"
                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaCompra = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarCom = new javax.swing.JTextField();
        cboParametroCom = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDireccionProv = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDetalleCompra = new javax.swing.JTable();
        txtNombreProv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantTotalCompra = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jtListaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "FECHA", "PROVEEDOR", "CANTIDAD"
            }
        ));
        jtListaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaCompra);

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE COMPRAS");

        jLabel2.setText("BUSCAR :");

        txtBuscarCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarComKeyReleased(evt);
            }
        });

        cboParametroCom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Proveedor", "Codigo" }));
        cboParametroCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroComActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DETALLE DE LA COMPRA");

        jLabel4.setText("DIRECCION :");

        txtDireccionProv.setEditable(false);

        jtDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUCTO", "PRECIO COMPRA", "PRECIO VENTA", "CANTIDAD"
            }
        ));
        jScrollPane2.setViewportView(jtDetalleCompra);

        txtNombreProv.setEditable(false);

        jLabel3.setText("PROVEEDOR :");

        jLabel7.setText("Monto Total :");

        txtMontoTotal.setEditable(false);
        txtMontoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProv)
                            .addComponent(txtDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccionProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)))
        );

        jLabel6.setText("Cantidad Total Productos:");

        txtCantTotalCompra.setEditable(false);
        txtCantTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Exit.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarCom, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboParametroCom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(318, 318, 318))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(19, 19, 19))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscarCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboParametroCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarComKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarComKeyReleased
        actualizarBusqueda();
    }//GEN-LAST:event_txtBuscarComKeyReleased

    private void cboParametroComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroComActionPerformed
        actualizarBusqueda();
    }//GEN-LAST:event_cboParametroComActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
        dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jtListaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaCompraMouseClicked
        try {
            Proveedor prov = BDProveedor.buscarProveedorNombre(String.valueOf(jtListaCompra.getModel().getValueAt(jtListaCompra.getSelectedRow(), 1)));
            txtNombreProv.setText(prov.getcProvNombre());
            txtDireccionProv.setText(prov.getcProvDireccion());

            actualizarBusquedaProv(prov.getnProvCodigo(), String.valueOf(jtListaCompra.getModel().getValueAt(jtListaCompra.getSelectedRow(), 2)));
            actualizarMonto();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            // System.out.println(ex);
        }
    }//GEN-LAST:event_jtListaCompraMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboParametroCom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtDetalleCompra;
    private javax.swing.JTable jtListaCompra;
    private javax.swing.JTextField txtBuscarCom;
    private javax.swing.JTextField txtCantTotalCompra;
    private javax.swing.JTextField txtDireccionProv;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtNombreProv;
    // End of variables declaration//GEN-END:variables
}
