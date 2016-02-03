package mx.jhernandez.panels;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;
import mx.jhernandez.views.FrmMenuPrincipal;
import mx.jhernandez.dao.*;
import mx.jhernandez.vo.*;

/**
 *
 * @author Viruz
 */
public class FrmMantenimientoCompra extends javax.swing.JFrame {

    DefaultTableModel ListaCompra = new DefaultTableModel();
    private final FrmMenuPrincipal principal;
    private String accion = "";
    private double monto = 0.0;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form FrmMantenimientoCompra
     *
     * @param menuPrincipal
     */
    public FrmMantenimientoCompra(FrmMenuPrincipal menuPrincipal) {
        principal = menuPrincipal;
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setExtendedState(6);

        initComponents();

        String titulos[] = {"CODIGO", "CODPROD-PROVEEDOR", "NOMBRE", "DESCRIPCION", "PRECIO COMPRA", "CANT. INGRESADA", "PRECIO TOTAL"};
        ListaCompra.setColumnIdentifiers(titulos);
        actualizarBusquedaProveedor();
        actualizarBusquedaProducto();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos privados">
    private void actualizarBusquedaProveedor() {
        ArrayList<Proveedor> resultado = null;
        if (String.valueOf(cboParametroProv.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            resultado = BDProveedor.listarProveedorPorNombre(txtBuscarProv.getText());
        } else if (String.valueOf(cboParametroProv.getSelectedItem()).equalsIgnoreCase("Codigo")) {
            resultado = BDProveedor.listarProveedorPorCodigo(txtBuscarProv.getText());
        }
        recargarTableProveedor(resultado);
    }

    // Cargar Lista Producto
    private void actualizarBusquedaProducto() {
        ArrayList<Producto> result;
        if (String.valueOf(cboParametroPro.getSelectedItem()).equalsIgnoreCase("Codigo")) {
            result = BDProducto.listarProductoPorCodigo(txtBuscarPro.getText());

        } else if (String.valueOf(cboParametroPro.getSelectedItem()).equalsIgnoreCase("Nombre")) {
            result = BDProducto.listarProductoPorNombre(txtBuscarPro.getText());
        } else {
            result = BDProducto.listarProductoPorCodProveedor(txtBuscarPro.getText());
        }
        recargarTableProducto(result);
    }

    private void recargarTableProducto(ArrayList<Producto> list) {
        Object[][] datos = new Object[list.size()][3];
        int i = 0;

        for (Producto p : list) {
            datos[i][0] = p.getnProCodigo();
            datos[i][1] = p.getcProNombre();
            datos[i][2] = p.getcCodProProv();
            i++;
        }
        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "CODIGO", "NOMBRE", "CODPROVEEDOR"
                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
    }

    private void recargarTableProveedor(ArrayList<Proveedor> lista) {
        Object[][] datop = new Object[lista.size()][2];
        int i = 0;

        for (Proveedor pv : lista) {
            datop[i][0] = pv.getnProvCodigo();
            datop[i][1] = pv.getcProvNombre();
            i++;
        }
        jtProveedor.setModel(new javax.swing.table.DefaultTableModel(
                datop,
                new String[]{
                    "CODIGO", "NOMBRE"
                }) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
    }

    private void limpiarCajaTexto() {
        txtSerieCom.setText("");
        txtCodigoCom.setText("");
        txtCodigoProv.setText("");
        txtNombreProv.setText("");
        txtCodigoPro.setText("");
        txtNombrePro.setText("");
        txtPrecioActual.setText("");
        txtCantidadActual.setText("");
        txtNuevoPCompra.setText("");
        txtCantidadNuevaCom.setText("");
    }

    private void activarCajaTexto(boolean b) {
        txtSerieCom.setEditable(b);
        txtCodigoCom.setEditable(!b);
        txtFecha.setEnabled(b);
        txtPrecioActual.setEditable(b);
        txtCantidadActual.setEditable(b);
        txtNuevoPCompra.setEditable(b);
        txtCantidadNuevaCom.setEditable(b);
        txtCodigoProv.setEditable(b);
        txtNombreProv.setEditable(b);
        txtCodigoPro.setEditable(b);
        txtNombrePro.setEditable(b);
    }

    private void activarBotones(boolean b) {
        btnNuevoCom.setEnabled(b);
        btnGuardarCom.setEnabled(!b);
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
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoProv = new javax.swing.JTextField();
        txtNombreProv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSerieCom = new javax.swing.JTextField();
        txtCodigoCom = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPrecioActual = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCantidadActual = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNuevoPCompra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        txtNombrePro = new javax.swing.JTextField();
        txtCantidadNuevaCom = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        btnGuardarCom = new javax.swing.JButton();
        btnSalirCompra = new javax.swing.JButton();
        btnNuevoCom = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTipoDocumento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarProv = new javax.swing.JTextField();
        cboParametroProv = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProveedor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarPro = new javax.swing.JTextField();
        cboParametroPro = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENTRADA / COMPRAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Garamond", 1, 24))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(247, 254, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Codigo :");

        jLabel4.setText("Proveedor :");

        txtCodigoProv.setEditable(false);
        txtCodigoProv.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombreProv.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(txtCodigoProv, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel7.setText("Serie :");

        jLabel8.setText("Codigo :");

        txtSerieCom.setEditable(false);
        txtSerieCom.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodigoCom.setEditable(false);
        txtCodigoCom.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel6.setBackground(new java.awt.Color(247, 254, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Codigo :");

        jLabel11.setText("Nombre :");

        jLabel13.setText("Precio Compra Actual :");

        txtPrecioActual.setEditable(false);
        txtPrecioActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setText("Cantidad Actual :");

        txtCantidadActual.setEditable(false);
        txtCantidadActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setText("Nuevo Precio Compra :");

        txtNuevoPCompra.setEditable(false);
        txtNuevoPCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNuevoPCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoPCompraKeyTyped(evt);
            }
        });

        jLabel17.setText("Cantidad Nueva:");

        txtCodigoPro.setEditable(false);
        txtCodigoPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombrePro.setEditable(false);

        txtCantidadNuevaCom.setEditable(false);
        txtCantidadNuevaCom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadNuevaCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadNuevaComKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNuevoPCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidadNuevaCom, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidadActual, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(197, 197, 197))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtCantidadActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNuevoPCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtCantidadNuevaCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel18.setText("Fecha :");

        btnGuardarCom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Save.png"))); // NOI18N
        btnGuardarCom.setText("GUARDAR");
        btnGuardarCom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarCom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComActionPerformed(evt);
            }
        });

        btnSalirCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/Exit.png"))); // NOI18N
        btnSalirCompra.setText("SALIR");
        btnSalirCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalirCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCompraActionPerformed(evt);
            }
        });

        btnNuevoCom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/oracle/ferretera/images/New document.png"))); // NOI18N
        btnNuevoCom.setText("NUEVO");
        btnNuevoCom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoComActionPerformed(evt);
            }
        });

        jTable1.setModel(ListaCompra);
        jScrollPane3.setViewportView(jTable1);

        jLabel5.setText("TIPO DOCUMENTO :");

        txtTipoDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("Monto Total :");

        txtMontoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(60, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnNuevoCom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarCom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalirCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSerieCom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCodigoCom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(544, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerieCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel5))
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalirCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel4.setBackground(new java.awt.Color(247, 254, 255));

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        jLabel1.setText("BUSCAR PROVEEDOR");

        txtBuscarProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProvKeyReleased(evt);
            }
        });

        cboParametroProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Codigo" }));
        cboParametroProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroProvActionPerformed(evt);
            }
        });

        jtProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "CODIGO", "NOMBRE"
            }
        ));
        jtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProveedor);

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUSCAR PRODUCTO");

        txtBuscarPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProKeyReleased(evt);
            }
        });

        cboParametroPro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Codigo", "CodProveedor" }));
        cboParametroPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroProActionPerformed(evt);
            }
        });

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
                {null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE"
            }
        ));
        jtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtProducto);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroProv, 0, 75, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroPro, 0, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboParametroPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProvKeyReleased
        actualizarBusquedaProveedor();
    }//GEN-LAST:event_txtBuscarProvKeyReleased

    private void cboParametroProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroProvActionPerformed
        actualizarBusquedaProveedor();
    }//GEN-LAST:event_cboParametroProvActionPerformed

    private void jtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProveedorMouseClicked
        try {
            Proveedor prov = BDProveedor.buscarProveedor(Integer.parseInt(String.valueOf(jtProveedor.getModel().getValueAt(jtProveedor.getSelectedRow(), 0))));
            txtCodigoProv.setText(String.valueOf(prov.getnProvCodigo()));
            txtNombreProv.setText(prov.getcProvNombre());
        } catch (SQLException ex) {
            //       System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error Al Seleccionar Elemento:" + ex.getMessage());
        }
    }//GEN-LAST:event_jtProveedorMouseClicked

    private void txtBuscarProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProKeyReleased
        actualizarBusquedaProducto();
    }//GEN-LAST:event_txtBuscarProKeyReleased

    private void cboParametroProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroProActionPerformed
        actualizarBusquedaProducto();
    }//GEN-LAST:event_cboParametroProActionPerformed

    private void jtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductoMouseClicked
        try {
            Producto pro = BDProducto.buscarProducto(Integer.parseInt(String.valueOf(jtProducto.getModel().getValueAt(jtProducto.getSelectedRow(), 0))));
            txtCodigoPro.setText(String.valueOf(pro.getnProCodigo()));
            txtNombrePro.setText(pro.getcProNombre());
            txtPrecioActual.setText(String.valueOf(pro.getnPropRecioCompra()));
            txtCantidadActual.setText(String.valueOf(pro.getnProCantidad()));
        } catch (SQLException ex) {
            //  System.out.println("Error Al Seleccionar Elemento:" + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error Al Seleccionar Elemento:" + ex.getMessage());
        }
    }//GEN-LAST:event_jtProductoMouseClicked

    private void txtNuevoPCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoPCompraKeyTyped
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNuevoPCompraKeyTyped

    private void txtCantidadNuevaComKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadNuevaComKeyTyped
        if (String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadNuevaComKeyTyped

    private void btnNuevoComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoComActionPerformed
        limpiarCajaTexto();
        activarCajaTexto(true);
        activarBotones(false);
        accion = "Guardar";

        while (ListaCompra.getRowCount() > 0) {
            ListaCompra.removeRow(0);
        }
    }//GEN-LAST:event_btnNuevoComActionPerformed

    private void btnSalirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCompraActionPerformed
        setVisible(false);
        dispose();
        principal.setVisible(true);
    }//GEN-LAST:event_btnSalirCompraActionPerformed

    private void btnGuardarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComActionPerformed
        int cantidad;
        if (accion.equalsIgnoreCase("Guardar")) {
            if (txtSerieCom.getText().compareTo("") != 0 && txtNuevoPCompra.getText().compareTo("") != 0
                    && txtCantidadNuevaCom.getText().compareTo("") != 0 && txtCodigoProv.getText().compareTo("") != 0 && txtCodigoPro.getText().compareTo("") != 0) {
                try {
                    //registrar compra
                    Compra c = new Compra();
                    c.setcComCodigo(txtCodigoCom.getText());
                    c.setcComSerie(txtSerieCom.getText());
                    c.setcComFecha(txtFecha.getDate());
                    c.setProveedor(BDProveedor.buscarProveedor(Integer.parseInt(txtCodigoProv.getText().trim())));
                    c.setProducto(BDProducto.buscarProducto(Integer.parseInt(txtCodigoPro.getText().trim())));
                    c.setnComPrecio(Double.parseDouble(txtNuevoPCompra.getText()));
                    c.setnComCantidad(Integer.parseInt(txtCantidadNuevaCom.getText()));
                    c.setnComPrecioTotal(Double.parseDouble(txtNuevoPCompra.getText()) * Integer.parseInt(txtCantidadNuevaCom.getText()));
                    BDCompra.insertarCompra(c);

                    //actualizar Producto
                    Producto p = BDProducto.buscarProducto(Integer.parseInt(txtCodigoPro.getText().trim()));
                    p.setnPropRecioCompra(Double.parseDouble(txtNuevoPCompra.getText()));
                    cantidad = Integer.parseInt(txtCantidadNuevaCom.getText()) + p.getnProCantidad();
                    p.setnProCantidad(cantidad);
                    BDProducto.actualizarProducto(p);

                    //String titulos[] = {"CODIGO","CODPROD-PROVEEDOR","NOMBRE","DESCRIPCION", "PRECIO COMPRA", "STOCK", "PRECIO TOTAL"};
                    String Datos[] = {txtCodigoPro.getText(), p.getcCodProProv(), p.getcProNombre(), p.getcProDescripcion(), String.valueOf(txtNuevoPCompra.getText()), String.valueOf(Integer.parseInt(txtCantidadNuevaCom.getText())),
                        String.valueOf(Math.round(Integer.parseInt(txtCantidadNuevaCom.getText()) * Double.parseDouble(txtNuevoPCompra.getText())))};
                    ListaCompra.addRow(Datos);
                    monto += Math.round(Integer.parseInt(txtCantidadNuevaCom.getText()) * Double.parseDouble(txtNuevoPCompra.getText()));
                    txtMontoTotal.setText(String.valueOf(monto));
                } catch (SQLException e) {
                    //  System.out.println(e);
                    JOptionPane.showMessageDialog(this, e);
                }
            }
            txtCodigoPro.setText("");
            txtNombrePro.setText("");
            txtPrecioActual.setText("");
            txtCantidadActual.setText("");
            txtNuevoPCompra.setText("");
            txtCantidadNuevaCom.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos Requeridos..!!");
        }
    }//GEN-LAST:event_btnGuardarComActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCom;
    private javax.swing.JButton btnNuevoCom;
    private javax.swing.JButton btnSalirCompra;
    private javax.swing.JComboBox cboParametroPro;
    private javax.swing.JComboBox cboParametroProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTable jtProveedor;
    private javax.swing.JTextField txtBuscarPro;
    private javax.swing.JTextField txtBuscarProv;
    private javax.swing.JTextField txtCantidadActual;
    private javax.swing.JTextField txtCantidadNuevaCom;
    private javax.swing.JTextField txtCodigoCom;
    private javax.swing.JTextField txtCodigoPro;
    private javax.swing.JTextField txtCodigoProv;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtNombrePro;
    private javax.swing.JTextField txtNombreProv;
    private javax.swing.JTextField txtNuevoPCompra;
    private javax.swing.JTextField txtPrecioActual;
    private javax.swing.JTextField txtSerieCom;
    private javax.swing.JTextField txtTipoDocumento;
    // End of variables declaration//GEN-END:variables
}
