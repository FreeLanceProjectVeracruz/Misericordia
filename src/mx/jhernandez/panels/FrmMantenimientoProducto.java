package mx.jhernandez.panels;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import mx.jhernandez.views.FrmMenuPrincipal;
import mx.jhernandez.dao.*;
import mx.jhernandez.database.ConexionPrincipal;
import mx.jhernandez.panels.dialogs.JDListaProducto;
import mx.jhernandez.vo.*;

/**
 *
 * @author Viruz
 */
public class FrmMantenimientoProducto extends javax.swing.JFrame {

    private Connection conn;
    private Statement stmt;
    private FrmMenuPrincipal principal;
    private String accion = "";

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form FrmMantenimientoProducto
     *
     * @param menuPrincipal
     */
    public FrmMantenimientoProducto(FrmMenuPrincipal menuPrincipal) {
        this.principal = menuPrincipal;
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setExtendedState(6);

        initComponents();
        initConnection();
        obtenerUltimoId();
        activarCajaTexto(false);
        activarBotones(true);

        try {
            actualizarBusqueda();
            ResultSet rs = stmt.executeQuery("SELECT cCatDescripcion FROM categoria");

            while (rs.next()) {
                cboCategoriaPro.addItem(rs.getObject(1));
            }

            rs = stmt.executeQuery("SELECT NPROVCODIGO FROM proveedor");

            while (rs.next()) {
                cboProdProveedor.addItem(rs.getObject(1));
            }

            rs.close();
        } catch (SQLException error) {
            //System.out.println(error);
            JOptionPane.showMessageDialog(this, error);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Privados">
    private void initConnection() {
        try {
            conn = ConexionPrincipal.getConnection();
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FrmMantenimientoProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void obtenerUltimoId() {
        try {
            try (ResultSet rs = stmt.executeQuery("SELECT MAX(nProCodigo) FROM producto")) {
                while (rs.next()) {
                    int lastID = rs.getInt(1);
                    txtCodigoPro.setText(String.valueOf(lastID + 1));
                }
            }
        } catch (SQLException error) {
            //   System.out.print(error);
            JOptionPane.showMessageDialog(this, error);
        }
    }

    private void actualizarBusqueda() throws SQLException {
        ArrayList<Producto> result;
        if (String.valueOf(cboParametroPro.getSelectedItem()).equalsIgnoreCase("Codigo")) {
            result = BDProducto.listarProductoPorCodigo(txtBuscarPro.getText());

        } else if (String.valueOf(cboParametroPro.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDProducto.listarProductoPorNombre(txtBuscarPro.getText());
        } else {
            result = BDProducto.listarProductoPorCodProveedor(txtBuscarPro.getText());
        }
        recargarTable(result);
    }

    private void recargarTable(ArrayList<Producto> list) {
        Object[][] datos = new Object[list.size()][3];
        int i = 0;

        for (Producto p : list) {
            datos[i][0] = p.getnProCodigo();
            datos[i][1] = p.getcProNombre();
            datos[i][2] = p.getcCodProProv();
            i++;
        }

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(datos, new String[]{
            "CODIGO", "NOMBRE", "CODPROVEEDOR"
        }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    private void activarBotones(boolean b) {
        btnNuevoPro.setEnabled(b);
        btnGuardarPro.setEnabled(!b);
        btnModificarPro.setEnabled(b);
        btnCancelarPro.setEnabled(!b);
        btnMostrarPro.setEnabled(b);
    }

    private void limpiarCajaTexto() {
        txtCodigoPro.setText("");
        txtNombrePro.setText("");
        cboCategoriaPro.setSelectedItem("Seleccionar...");
        txtMarcaPro.setText("");
        txtCantidadPro.setText("");
        txtDescripcionPro.setText("");
        cboEstadoPro.setSelectedItem("Seleccionar...");
        txtPrecioCompraPro.setText("");
        txtPrecioVentaPro.setText("");
        txtUtilidadPro.setText("");
        txtcCodProProv.setText("");
        cboProdProveedor.setSelectedItem("Seleccionar...");
    }

    private void activarCajaTexto(boolean b) {
        txtCodigoPro.setEditable(false);
        txtNombrePro.setEditable(b);
        txtMarcaPro.setEditable(b);
        txtCantidadPro.setEditable(b);
        txtDescripcionPro.setEditable(b);
        txtPrecioCompraPro.setEditable(b);
        txtPrecioVentaPro.setEditable(b);
        txtcCodProProv.setEditable(!b);

        cboCategoriaPro.setEnabled(b);
        cboEstadoPro.setEnabled(b);
        cboProdProveedor.setEnabled(b);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        txtBuscarPro = new javax.swing.JTextField();
        cboParametroPro = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombrePro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMarcaPro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantidadPro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionPro = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        cboEstadoPro = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cboCategoriaPro = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtcCodProProv = new javax.swing.JTextField();
        cboProdProveedor = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioCompraPro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioVentaPro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtUtilidadPro = new javax.swing.JTextField();
        btnNuevoPro = new javax.swing.JButton();
        btnGuardarPro = new javax.swing.JButton();
        btnModificarPro = new javax.swing.JButton();
        btnCancelarPro = new javax.swing.JButton();
        btnMostrarPro = new javax.swing.JButton();
        btnSalirPro = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 800));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR PRODUCTO ");

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProducto);

        txtBuscarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProKeyReleased(evt);
            }
        });

        cboParametroPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "CodProveedor", "Codigo" }));
        cboParametroPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboParametroPro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(47, 47, 47))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel4.setBackground(new java.awt.Color(247, 254, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caracteristicas del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setText("Codigo :");

        txtCodigoPro.setEditable(false);
        txtCodigoPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Nombre :");

        txtNombrePro.setEditable(false);

        jLabel5.setText("Marca :");

        txtMarcaPro.setEditable(false);
        txtMarcaPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("Cantidad :");

        txtCantidadPro.setEditable(false);
        txtCantidadPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProKeyTyped(evt);
            }
        });

        jLabel7.setText("Descripcion del Producto :");

        txtDescripcionPro.setEditable(false);
        txtDescripcionPro.setColumns(15);
        txtDescripcionPro.setRows(5);
        txtDescripcionPro.setTabSize(5);
        jScrollPane2.setViewportView(txtDescripcionPro);

        jLabel12.setText("Estado :");

        cboEstadoPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar...", "Activo", "Inactivo" }));

        jLabel13.setText("Categoria :");

        cboCategoriaPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));

        jLabel4.setText("Codigo Producto Proveedor :");

        txtcCodProProv.setEditable(false);

        cboProdProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar..." }));
        cboProdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProdProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCantidadPro))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(24, 24, 24)
                            .addComponent(txtMarcaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboEstadoPro, 0, 132, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboProdProveedor, 0, 159, Short.MAX_VALUE)
                            .addComponent(txtcCodProProv))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(cboCategoriaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMarcaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(cboEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cboProdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcCodProProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(247, 254, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de Precio y Utilidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel8.setText("Precio de Compra :");

        txtPrecioCompraPro.setEditable(false);
        txtPrecioCompraPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioCompraPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraProKeyTyped(evt);
            }
        });

        jLabel9.setText("Precio de Venta :");

        txtPrecioVentaPro.setEditable(false);
        txtPrecioVentaPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaProKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaProKeyTyped(evt);
            }
        });

        jLabel10.setText("Utilidad % :");

        txtUtilidadPro.setEditable(false);
        txtUtilidadPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioCompraPro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioVentaPro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUtilidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioCompraPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioVentaPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtUtilidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btnNuevoPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/New document.png"))); // NOI18N
        btnNuevoPro.setText("NUEVO");
        btnNuevoPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProActionPerformed(evt);
            }
        });

        btnGuardarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Save.png"))); // NOI18N
        btnGuardarPro.setText("GUARDAR");
        btnGuardarPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProActionPerformed(evt);
            }
        });

        btnModificarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Modify.png"))); // NOI18N
        btnModificarPro.setText("MODIFICAR");
        btnModificarPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProActionPerformed(evt);
            }
        });

        btnCancelarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Erase.png"))); // NOI18N
        btnCancelarPro.setText("CANCELAR");
        btnCancelarPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProActionPerformed(evt);
            }
        });

        btnMostrarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/List.png"))); // NOI18N
        btnMostrarPro.setText("MOSTRAR");
        btnMostrarPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMostrarPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMostrarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProActionPerformed(evt);
            }
        });

        btnSalirPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Exit.png"))); // NOI18N
        btnSalirPro.setText("SALIR");
        btnSalirPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirPro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirProActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel11.setText("REGISTRAR PRODUCTO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnNuevoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalirPro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalirPro, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btnMostrarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoPro, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProKeyReleased
        try {
            actualizarBusqueda();
        } catch (SQLException ex) {
            Logger.getLogger(FrmMantenimientoProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_txtBuscarProKeyReleased

    private void cboParametroProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroProActionPerformed
        try {
            actualizarBusqueda();
        } catch (SQLException ex) {
            Logger.getLogger(FrmMantenimientoProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_cboParametroProActionPerformed

    private void btnSalirProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirProActionPerformed
        setVisible(false);
        dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_btnSalirProActionPerformed

    private void txtCantidadProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProKeyTyped
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProKeyTyped

    private void txtPrecioCompraProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraProKeyTyped
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioCompraProKeyTyped

    private void txtPrecioVentaProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaProKeyTyped
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaProKeyTyped

    private void txtPrecioVentaProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaProKeyReleased
        DecimalFormat formateador = new DecimalFormat("#.#");
        double precioVenta, precioCompra, Utilidad = 0.0;

        if (txtPrecioVentaPro.getText().compareTo("") != 0) {
            precioVenta = Double.parseDouble(txtPrecioVentaPro.getText());
            precioCompra = Double.parseDouble(txtPrecioCompraPro.getText());
            Utilidad = (precioVenta * 100) / precioCompra;
            Utilidad = Utilidad - 100;
        }
        txtUtilidadPro.setText(String.valueOf(formateador.format(Utilidad)));
    }//GEN-LAST:event_txtPrecioVentaProKeyReleased

    private void btnNuevoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProActionPerformed
        limpiarCajaTexto();
        activarCajaTexto(true);
        accion = "Guardar";
        obtenerUltimoId();
        activarBotones(false);
    }//GEN-LAST:event_btnNuevoProActionPerformed

    private void btnGuardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProActionPerformed
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtNombrePro.getText().compareTo("") != 0 && txtCantidadPro.getText().compareTo("") != 0
                    && txtMarcaPro.getText().compareTo("") != 0
                    && txtDescripcionPro.getText().compareTo("") != 0 && txtPrecioCompraPro.getText().compareTo("") != 0 && txtPrecioVentaPro.getText().compareTo("") != 0
                    && txtUtilidadPro.getText().compareTo("") != 0 && !cboCategoriaPro.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
                    && !cboEstadoPro.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
                    && !cboProdProveedor.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")) {
                try {
                    Producto p = new Producto();
                    p.setcProNombre(txtNombrePro.getText());
                    p.setnProCantidad(Integer.parseInt(txtCantidadPro.getText()));
                    p.setcProMarca(txtMarcaPro.getText());
                    Categoria c = BDCategoria.buscarCategoriaDescripcion((String) cboCategoriaPro.getSelectedItem());

                    p.setCategoria(c);
                    p.setcProDescripcion(txtDescripcionPro.getText());
                    p.setnPropRecioCompra(Double.parseDouble(txtPrecioCompraPro.getText()));
                    p.setnProPRecioVenta(Double.parseDouble(txtPrecioVentaPro.getText()));
                    p.setnProUtilidad(txtUtilidadPro.getText());

                    if (txtcCodProProv.getText().compareTo("") != 0) {
                        String proveedor = String.valueOf(cboProdProveedor.getModel().getSelectedItem());
                        p.setcCodProProv(proveedor);
                    } else {
                        p.setcCodProProv("-----");
                    }

                    p.setcProEstado((String) cboEstadoPro.getSelectedItem());
                    BDProducto.insertarProducto(p);
                    JOptionPane.showMessageDialog(null, "[ Datos Agregados ]");

                    actualizarBusqueda();
                    limpiarCajaTexto();
                    activarCajaTexto(false);
                    activarBotones(true);
                } catch (SQLException e) {
                    //  System.out.println();
                    JOptionPane.showMessageDialog(this, e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..!!");
            }
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            if (txtNombrePro.getText().compareTo("") != 0 && txtCantidadPro.getText().compareTo("") != 0
                    && txtMarcaPro.getText().compareTo("") != 0
                    && txtDescripcionPro.getText().compareTo("") != 0 && txtPrecioCompraPro.getText().compareTo("") != 0 && txtPrecioVentaPro.getText().compareTo("") != 0
                    && txtUtilidadPro.getText().compareTo("") != 0 && !cboCategoriaPro.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
                    && !cboEstadoPro.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")
                    && !cboProdProveedor.getSelectedItem().toString().equalsIgnoreCase("Seleccionar...")) {
                Producto p;
                try {
                    p = BDProducto.buscarProducto(Integer.parseInt(txtCodigoPro.getText()));
                    p.setcProNombre(txtNombrePro.getText());
                    p.setnProCantidad(Integer.parseInt(txtCantidadPro.getText()));
                    p.setcProMarca(txtMarcaPro.getText());
                    Categoria c = BDCategoria.buscarCategoriaDescripcion((String) cboCategoriaPro.getSelectedItem());
                    p.setCategoria(c);
                    p.setcProDescripcion(txtDescripcionPro.getText());
                    p.setnPropRecioCompra(Double.parseDouble(txtPrecioCompraPro.getText()));
                    p.setnProPRecioVenta(Double.parseDouble(txtPrecioVentaPro.getText()));
                    p.setnProUtilidad(txtUtilidadPro.getText());

                    if (txtcCodProProv.getText().compareTo("") != 0) {
                        String proveedor = String.valueOf(cboProdProveedor.getModel().getSelectedItem());
                        p.setcCodProProv(proveedor);
                    } else {
                        p.setcCodProProv("-----");
                    }

                    p.setcProEstado((String) cboEstadoPro.getSelectedItem());

                    BDProducto.actualizarProducto(p);
                    JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");

                    actualizarBusqueda();
                    limpiarCajaTexto();
                    activarCajaTexto(false);
                    activarBotones(true);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar.. Datos Invalidos");
            }
        }
        obtenerUltimoId();
        jtProducto.setEnabled(true);
    }//GEN-LAST:event_btnGuardarProActionPerformed

    private void btnCancelarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProActionPerformed
        limpiarCajaTexto();
        activarCajaTexto(false);
        obtenerUltimoId();
        activarBotones(true);
        jtProducto.setEnabled(true);
    }//GEN-LAST:event_btnCancelarProActionPerformed

    private void btnMostrarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProActionPerformed
        JDListaProducto jdListaP = new JDListaProducto(this, true);
        jdListaP.setVisible(true);
    }//GEN-LAST:event_btnMostrarProActionPerformed

    private void btnModificarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProActionPerformed
        accion = "Actualizar";
        activarCajaTexto(true);

        btnNuevoPro.setEnabled(false);
        btnGuardarPro.setEnabled(true);
        btnModificarPro.setEnabled(false);
        btnCancelarPro.setEnabled(true);
        btnMostrarPro.setEnabled(false);
        jtProducto.setEnabled(false);
    }//GEN-LAST:event_btnModificarProActionPerformed

    private void jtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductoMouseClicked
        try {
            Producto pro = BDProducto.buscarProducto(Integer.parseInt(String.valueOf(jtProducto.getModel().getValueAt(jtProducto.getSelectedRow(), 0))));
            txtCodigoPro.setText(String.valueOf(pro.getnProCodigo()));
            txtNombrePro.setText(pro.getcProNombre());
            txtCantidadPro.setText(String.valueOf(pro.getnProCantidad()));
            txtMarcaPro.setText(pro.getcProMarca());
            cboCategoriaPro.setSelectedItem((String) pro.getCategoria().getcCatDescripcion());
            txtDescripcionPro.setText(pro.getcProDescripcion());
            txtPrecioCompraPro.setText(String.valueOf(pro.getnPropRecioCompra()));
            txtPrecioVentaPro.setText(String.valueOf(pro.getnProPRecioVenta()));
            txtUtilidadPro.setText(String.valueOf(pro.getnProUtilidad()));
            Proveedor prove = BDProveedor.buscarCodigoProveedor(Integer.parseInt(pro.getcCodProProv()));
            txtcCodProProv.setText(prove.getcProvNombre());
            cboEstadoPro.setSelectedItem((String) pro.getcProEstado());
        } catch (SQLException ex) {
            // System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error Al Seleccionar Elemento:" + ex.getMessage());
        }
    }//GEN-LAST:event_jtProductoMouseClicked

    private void cboProdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProdProveedorActionPerformed
        try {
            if (cboProdProveedor.getSelectedItem() != "Seleccionar...") {
                Proveedor pro = BDProveedor.buscarCodigoProveedor(Integer.parseInt(String.valueOf(cboProdProveedor.getModel().getSelectedItem())));
                txtcCodProProv.setText(pro.getcProvNombre());
            } else {
                txtcCodProProv.setText("");
            }
        } catch (SQLException ex) {
            //  System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error Al Seleccionar Elemento:" + ex.getMessage());
        }
    }//GEN-LAST:event_cboProdProveedorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPro;
    private javax.swing.JButton btnGuardarPro;
    private javax.swing.JButton btnModificarPro;
    private javax.swing.JButton btnMostrarPro;
    private javax.swing.JButton btnNuevoPro;
    private javax.swing.JButton btnSalirPro;
    private javax.swing.JComboBox cboCategoriaPro;
    private javax.swing.JComboBox cboEstadoPro;
    private javax.swing.JComboBox cboParametroPro;
    private javax.swing.JComboBox cboProdProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTextField txtBuscarPro;
    private javax.swing.JTextField txtCantidadPro;
    private javax.swing.JTextField txtCodigoPro;
    private javax.swing.JTextArea txtDescripcionPro;
    private javax.swing.JTextField txtMarcaPro;
    private javax.swing.JTextField txtNombrePro;
    private javax.swing.JTextField txtPrecioCompraPro;
    private javax.swing.JTextField txtPrecioVentaPro;
    private javax.swing.JTextField txtUtilidadPro;
    private javax.swing.JTextField txtcCodProProv;
    // End of variables declaration//GEN-END:variables
}
