package mx.jhernandez.views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import mx.jhernandez.panels.*;

/**
 *
 * @author Viruz
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    private FrmMantenimientoCategoria frmMCat;
    private FrmMantenimientoProducto frmMP;
    private FrmMantenimientoVenta frmMV;
    private FrmMantenimientoCliente frmMCli;
    private FrmMantenimientoPersonal frmMPer;
    private FrmMantenimientoProveedor frmMProv;
    private FrmMantenimientoUsuario frmMU;

    private FrmConsultaVentas frmConV;
    private FrmConsultaCompra frmCC;
    private FrmConsultaProducto frmCP;

    private FrmMantenimientoCompra frmMC;

    private FrmLogin login;
    private FrmCancelarVenta frmCV;

    /**
     * Creates new form FrmMenuPrincipal
     */
    public FrmMenuPrincipal() {
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        initComponents();
        setExtendedState(6);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNombreVendedor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mOpciones = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        miGenerarVenta = new javax.swing.JMenuItem();
        miCancelarVenta = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        miRegistrarCompra = new javax.swing.JMenuItem();
        jMenuMantenimiento = new javax.swing.JMenu();
        miCategoria = new javax.swing.JMenuItem();
        miCliente = new javax.swing.JMenuItem();
        miPersonal = new javax.swing.JMenuItem();
        miProducto = new javax.swing.JMenuItem();
        miProveedor = new javax.swing.JMenuItem();
        miUsuario = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        miConsultaV = new javax.swing.JMenuItem();
        mConsultaC = new javax.swing.JMenuItem();
        miConsultaPro = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miConsultaV1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(835, 688));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENDEDOR :");

        lblNombreVendedor.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        lblNombreVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVendedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreVendedor.setText("NOMBRE DE VENDEDOR");

        jLabel3.setBackground(new java.awt.Color(247, 254, 255));
        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 3, 54)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(247, 254, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LA MISERICORDIA");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FECHA ACTUAL :");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/AVE.PNG"))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(247, 254, 255));
        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 1, 54)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(247, 254, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FERREMATERIALES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreVendedor)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        mOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mOpciones.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        mOpciones.setPreferredSize(new java.awt.Dimension(0, 90));
        mOpciones.setRequestFocusEnabled(false);

        jMenu11.setText("               ");
        jMenu11.setEnabled(false);
        mOpciones.add(jMenu11);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/1291627904_home.png"))); // NOI18N
        jMenu3.setText("INICIO");
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Exit.png"))); // NOI18N
        miSalir.setText("SALIR");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jMenu3.add(miSalir);

        mOpciones.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/compra1.png"))); // NOI18N
        jMenu1.setText("VENTA");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Buy.png"))); // NOI18N
        miGenerarVenta.setText("Generar Venta");
        miGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGenerarVentaActionPerformed(evt);
            }
        });
        jMenu1.add(miGenerarVenta);

        miCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Cancel.png"))); // NOI18N
        miCancelarVenta.setText("Cancelar Venta");
        miCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCancelarVentaActionPerformed(evt);
            }
        });
        jMenu1.add(miCancelarVenta);

        mOpciones.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/compra3.png"))); // NOI18N
        jMenu4.setText("COMPRA");
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miRegistrarCompra.setText("Registrar Compras");
        miRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarCompraActionPerformed(evt);
            }
        });
        jMenu4.add(miRegistrarCompra);

        mOpciones.add(jMenu4);

        jMenuMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/mantenimiento1.png"))); // NOI18N
        jMenuMantenimiento.setText("MANTENIMIENTO");
        jMenuMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuMantenimiento.setPreferredSize(new java.awt.Dimension(110, 31));
        jMenuMantenimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/List.png"))); // NOI18N
        miCategoria.setText("Categoria");
        miCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriaActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(miCategoria);

        miCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/User group.png"))); // NOI18N
        miCliente.setText("Cliente");
        miCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClienteActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(miCliente);

        miPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/People.png"))); // NOI18N
        miPersonal.setText("Personal");
        miPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPersonalActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(miPersonal);

        miProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/producto.png"))); // NOI18N
        miProducto.setText("Producto");
        miProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProductoActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(miProducto);

        miProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Delivery.png"))); // NOI18N
        miProveedor.setText("Proveedor");
        miProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProveedorActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(miProveedor);

        miUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Person.png"))); // NOI18N
        miUsuario.setText("Usuario");
        miUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuarioActionPerformed(evt);
            }
        });
        jMenuMantenimiento.add(miUsuario);

        mOpciones.add(jMenuMantenimiento);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/buscar.png"))); // NOI18N
        jMenu5.setText("CONSULTAS");
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setPreferredSize(new java.awt.Dimension(100, 30));
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miConsultaV.setText("Consulta de Ventas");
        miConsultaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaVActionPerformed(evt);
            }
        });
        jMenu5.add(miConsultaV);

        mConsultaC.setText("Consulta de Compras");
        mConsultaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultaCActionPerformed(evt);
            }
        });
        jMenu5.add(mConsultaC);

        miConsultaPro.setText("Consulta de Producto");
        miConsultaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaProActionPerformed(evt);
            }
        });
        jMenu5.add(miConsultaPro);

        mOpciones.add(jMenu5);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/1291628569_system-help.png"))); // NOI18N
        jMenu8.setText("AYUDA");
        jMenu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miConsultaV1.setText("Acerca de...");
        miConsultaV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaV1ActionPerformed(evt);
            }
        });
        jMenu8.add(miConsultaV1);

        mOpciones.add(jMenu8);

        setJMenuBar(mOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriaActionPerformed
        frmMCat = new FrmMantenimientoCategoria(this);
        frmMCat.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miCategoriaActionPerformed

    private void miProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProductoActionPerformed
        frmMP = new FrmMantenimientoProducto(this);
        frmMP.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miProductoActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        login = new FrmLogin();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miSalirActionPerformed

    private void miGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGenerarVentaActionPerformed
        frmMV = new FrmMantenimientoVenta(this);
        frmMV.txtVendedorV.setText(lblNombreVendedor.getText().trim());
        frmMV.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miGenerarVentaActionPerformed

    private void miCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCancelarVentaActionPerformed
        frmCV = new FrmCancelarVenta(this);
        frmCV.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miCancelarVentaActionPerformed

    private void miClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClienteActionPerformed
        frmMCli = new FrmMantenimientoCliente(this);
        frmMCli.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miClienteActionPerformed

    private void miPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPersonalActionPerformed
        frmMPer = new FrmMantenimientoPersonal(this);
        frmMPer.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miPersonalActionPerformed

    private void miProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProveedorActionPerformed
        frmMProv = new FrmMantenimientoProveedor(this);
        frmMProv.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miProveedorActionPerformed

    private void miUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuarioActionPerformed
        frmMU = new FrmMantenimientoUsuario(this);
        frmMU.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miUsuarioActionPerformed

    private void miConsultaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaVActionPerformed
        frmConV = new FrmConsultaVentas(this);
        frmConV.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miConsultaVActionPerformed

    private void mConsultaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultaCActionPerformed
        frmCC = new FrmConsultaCompra(this);
        frmCC.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_mConsultaCActionPerformed

    private void miConsultaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaProActionPerformed
        frmCP = new FrmConsultaProducto(this);
        frmCP.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miConsultaProActionPerformed

    private void miRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarCompraActionPerformed
        frmMC = new FrmMantenimientoCompra(this);
        frmMC.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_miRegistrarCompraActionPerformed

    private void miConsultaV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaV1ActionPerformed
        JOptionPane.showMessageDialog(null, "Desarrollado por: \nJesus I. Hernandez R.\nMartin M. Hernandez Z.\n\n\t\tContacto:\n\tmartin_txs@hotmail.com\n\tCel: 2291299047\nV 1.0", "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_miConsultaV1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenuMantenimiento;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblNombreVendedor;
    private javax.swing.JMenuItem mConsultaC;
    private javax.swing.JMenuBar mOpciones;
    private javax.swing.JMenuItem miCancelarVenta;
    private javax.swing.JMenuItem miCategoria;
    private javax.swing.JMenuItem miCliente;
    private javax.swing.JMenuItem miConsultaPro;
    private javax.swing.JMenuItem miConsultaV;
    private javax.swing.JMenuItem miConsultaV1;
    private javax.swing.JMenuItem miGenerarVenta;
    private javax.swing.JMenuItem miPersonal;
    private javax.swing.JMenuItem miProducto;
    private javax.swing.JMenuItem miProveedor;
    private javax.swing.JMenuItem miRegistrarCompra;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JMenuItem miUsuario;
    // End of variables declaration//GEN-END:variables
}
