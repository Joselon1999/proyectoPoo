package view;

import dao.ConexionConBaseDatos;
import dao.Generador;
import util.SimpleFrame;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import controller.ClientController;
import controller.Control_Cliente;
import controller.Control_Consultas;
import controller.Control_Productos;
import controller.Control_Vendedor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;

public class SalidaProductos extends javax.swing.JDialog {

    public static String[][] arrayDatosTransportistas = new String[10][4];//filas - columnas
    int c = 0;
    int n = 0;
    int totals = 0;
    DefaultTableModel modelo;
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    String ClienteExistente = "no";
    Control_Consultas cc = new Control_Consultas();

    public SalidaProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        JTableProduct.setModel(modelo);
        setLocationRelativeTo(null);
        int[] anchos = {500, 150};
        for (int i = 0; i < JTableProduct.getColumnCount(); i++) {
            JTableProduct.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        fecha_actual();
        cc.listarTodosFacturas(SalidaProductos.jTableListarFacturas);
        cc.listarTodosGuia(SalidaProductos.jTable3);
        Control_Vendedor loads = new Control_Vendedor();
        loads.CargarListaVendedor();
        cc.CargarListaTransportista();
        cc.CargarListaProductos();
        jTextField1.setEditable(false);
        jTextField8.setEditable(false);
        jTextField1.setText(String.valueOf(id_guia_auto()));
        cc.formateaTabla(JTableProduct);
    }

    public void fecha_actual() {
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formateador.format(fechaActual);
    }

    public String buscaDato(String cadena, int posicion) {
        int pos = 0;
        String cad1, cad2;
        cad1 = cadena;
        if (posicion == 0) {
            cad2 = cadena.substring(0, cad1.indexOf('[')).trim();
        } else {
            for (int i = 1; i <= posicion; i++) {
                pos = +cad1.indexOf('[') + 1;
                cad1 = cad1.substring(pos);
            }
            cad2 = cad1.substring(0, cad1.indexOf(']')).trim();
        }
        return cad2;
    }

    public int id_guia_auto() {
        Generador ge = new Generador();
        int id_max2 = 1;
        try {
            id_max2 = ge.auto_increm("SELECT MAX(no_guia) FROM table_guia;");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id_max2;
    }

    public int id_cliente_auto() {

        Generador ge = new Generador();
        int id_max2 = 1;
        try {
            id_max2 = ge.auto_increm("SELECT MAX(idCliente) FROM table_cliente;");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id_max2;
    }

    public int id_venta_auto() {
        Generador ge = new Generador();
        int id_max2 = 1;
        try {
            id_max2 = ge.auto_increm("SELECT MAX(idVentas) FROM table_ventas;");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id_max2;
    }

    public int id_factura_auto() {
        Generador ge = new Generador();
        int id_max2 = 1;
        try {
            id_max2 = ge.auto_increm("SELECT MAX(No_Facturas) FROM table_facturas;");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return id_max2;
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogVendedor = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        SeleccionarVendedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jDialogProductos = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SeleccionarProductos = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldParametroBusqueda = new javax.swing.JTextField();
        jDialogCliente = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        SeleccionarCliente = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        xcant = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableListarFacturas = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();

        jDialogVendedor.setResizable(false);
        jDialogVendedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SeleccionarVendedor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        SeleccionarVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(SeleccionarVendedor);

        jDialogVendedor.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 120));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDialogVendedor.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jDialogProductos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Productos y Articulos de Ferreteria");
        jDialogProductos.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SeleccionarProductos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        SeleccionarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(SeleccionarProductos);

        jDialogProductos.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 610, 230));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 102));
        jButton7.setText("Seleccionar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDialogProductos.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Buscar ");

        jTextFieldParametroBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldParametroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldParametroBusquedaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(12, 12, 12)
                    .addComponent(jTextFieldParametroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(jTextFieldParametroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialogProductos.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 250, 40));

        SeleccionarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(SeleccionarCliente);

        jLabel20.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel20.setText("Lista de Clientes");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 51, 51));
        jButton10.setText("Seleccionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogClienteLayout = new javax.swing.GroupLayout(jDialogCliente.getContentPane());
        jDialogCliente.getContentPane().setLayout(jDialogClienteLayout);
        jDialogClienteLayout.setHorizontalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogClienteLayout.createSequentialGroup()
                .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogClienteLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jButton10))
                    .addGroup(jDialogClienteLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel20)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogClienteLayout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );
        jDialogClienteLayout.setVerticalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addContainerGap())
            .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogClienteLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salida de Productos");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTableProduct.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(JTableProduct);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 1000, 180));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Salida de Productos de Almacen");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1190, 40));

        jButton4.setText("D");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 40, 50));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 640, 140, 30));

        jButton8.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jButton8.setText("Guardar Guia");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 520, 140, -1));

        jButton6.setText("Agregar Producto");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 130, 60));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Codigo de producto");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 130, 30));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Descripcion de Producto");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 670, 30));

        xcant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xcant.setModel(new javax.swing.SpinnerNumberModel(1, 0, 30, 1));
        xcant.setToolTipText("");
        jPanel1.add(xcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 80, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cantidad");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 80, 30));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable3);

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Guias de remisión", jPanel5);

        jTableListarFacturas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableListarFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTableListarFacturas);

        jButton9.setText("Seleccionar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Facturas", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1190, 170));

        jLabel2.setText("Numero de Guia:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 30));

        jLabel24.setText("Fecha:");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 130, 30));

        jLabel25.setText("Responsable:");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 30));

        jLabel26.setText("Transportista:");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 130, 30));

        jLabel27.setText("Placa vehiculo:");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 130, 30));

        jTextField1.setText("4");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 160, 30));

        jTextField2.setText("2021-01-01");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 160, 30));

        jTextField5.setText("LIC001");
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 160, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 400, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 400, 30));

        jLabel3.setText("Licencia:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 30));

        jTextField3.setText("PL-1123");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 160, 30));

        jLabel4.setText("Punto de Partida:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 130, 30));

        jLabel5.setText("Punto de Llegada:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 130, 30));

        jTextField4.setText(" Av. Garcilazo de la Vega 1348");
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 470, 30));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 470, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 670, 30));

        jTextField7.setText("jTextField7");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 130, 30));

        jLabel6.setText("N. Factura:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 80, 30));

        jTextField8.setToolTipText("");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 110, 30));

        jButton12.setText("Eliminar Guia");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 600, 140, 30));

        jButton13.setText("Nueva Guia");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 480, 140, 30));

        jButton11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton11.setText("A");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 40, 50));

        jButton14.setText("Imrpimir Guia");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jTextField7.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Caja vacia");
        } else {
            int cant = (Integer) xcant.getValue();
            String[] datos = new String[3];
            datos[0] = buscaDato(jComboBox3.getSelectedItem().toString(), 1);
            datos[1] = jComboBox3.getSelectedItem().toString();//jComboBox3.getItemAt(jComboBox3.getSelectedItem()); //"producto";
            datos[2] = String.valueOf(cant);
            cc.agregarItemProducto(datos);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int i = JTableProduct.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else {
            cc.eliminaItemProducto(i);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Connection reg = conectar.getConexion();
        String sql_Facturas = "INSERT INTO table_GUIA (NO_GUIA, NO_FACTURA, FECHA , ID_RESPONSABLE, ID_TRANSPORTISTA,LICENCIA,PLACA_VEHICULO,PUNTO_PARTIDA,PUNTO_LLEGADA)VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql_Facturas);
            pst.setString(1, jTextField1.getText());//NO_GUIA
            String no_fact;
            if (jTextField8.getText().compareTo("") == 0) {
                no_fact = null;
            } else {
                no_fact = jTextField8.getText();
            }
            pst.setString(2, no_fact);//NO_FACTURA
            pst.setString(3, jTextField2.getText());//FECHA
            pst.setInt(4, Integer.parseInt(buscaDato(jComboBox1.getSelectedItem().toString(), 1)));//ID_RESPONSABLE
            pst.setInt(5, Integer.parseInt(SalidaProductos.arrayDatosTransportistas[2][jComboBox2.getSelectedIndex()]));//ID_TRANSPORTISTA
            pst.setString(6, jTextField5.getText());//LICENCIA
            pst.setString(7, jTextField3.getText());//PLACA_VEHICULO
            pst.setString(8, jTextField4.getText());//PUNTO_PARTIDA
            pst.setString(9, jTextField6.getText());//PUNTO_LLEGADA
            int ns = pst.executeUpdate();
            if (ns > 0) {
                JOptionPane.showMessageDialog(null, "GUIA - Registado Exitosamente");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - FACTURAS: " + ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (int w = 0; w < JTableProduct.getRowCount(); w = w + 1) {
            String col1 = (String) JTableProduct.getValueAt(w, 0);// valor de codigo ventas
            String col2 = (String) JTableProduct.getValueAt(w, 1);// NOMBRE DEL productos
            String col3 = (String) JTableProduct.getValueAt(w, 2);// cantidad productos
            String sql_Ventas = "INSERT INTO TABLE_GUIA_DETALLE (NO_GUIA, IDPRODUCTOS, NOMBREPRODUCTOS, CANTIDAD)VALUES (?,?,?,?)";
            try {
                PreparedStatement pst = reg.prepareStatement(sql_Ventas);
                pst.setString(1, jTextField1.getText());
                pst.setString(2, col1);
                pst.setString(3, col2);
                pst.setString(4, col3);
                int ns = pst.executeUpdate();
                if (ns > 0) {
                    JOptionPane.showMessageDialog(null, "DETALLE DE GUIA - Registado Exitosamente" + jTextField1.getText());
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error: " + ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextFieldParametroBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldParametroBusquedaKeyPressed
        Control_Productos cc = new Control_Productos();
        String parametroBusqueda = jTextFieldParametroBusqueda.getText();
        cc.buscarProductosparaVentas(parametroBusqueda);


    }//GEN-LAST:event_jTextFieldParametroBusquedaKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int i = jTableListarFacturas.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else//de lo contrario si se selecciono la fila 
        {
            int numero = Integer.parseInt(jTableListarFacturas.getValueAt(i, 0).toString());//obtener valor para la consulta de lista de compras
            int codClient = Integer.parseInt(jTableListarFacturas.getValueAt(i, 1).toString());// cojer codigo de cliente en la tabla
            int codVendedor = Integer.parseInt(jTableListarFacturas.getValueAt(i, 3).toString());
            String enteroString = Integer.toString(numero);
            jTextField8.setText(String.valueOf(jTableListarFacturas.getValueAt(i, 0)));
            try {
                Connection conexion = ConexionConBaseDatos.getConexion();
                Statement comando = conexion.createStatement();
                ResultSet registro = comando.executeQuery("select idCliente,Nombre_Cliente,Apellido_Cliente,Cedula_Cliente from table_Cliente where idCliente =" + codClient);
                if (registro.next() == true) {

                    String nameClient = registro.getString(2);
                    String apellidoClient = registro.getString(3);
                }
            } catch (SQLException ex) {
            }
            try {
                Connection conexion = ConexionConBaseDatos.getConexion();
                Statement comando = conexion.createStatement();
                ResultSet registroVendedor = comando.executeQuery("select idVendedor,nombreVendedor from table_vendedor where idVendedor=" + codVendedor);

                if (registroVendedor.next() == true) {
                }
                conexion.close();
            } catch (SQLException ex) {
            }
            DetailsFacturas(enteroString);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i = jTable3.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else {
            int numero = Integer.parseInt(jTable3.getValueAt(i, 0).toString());
            jTextField1.setText(String.valueOf(jTable3.getValueAt(i, 0)));//numero de guia
            jTextField8.setText(String.valueOf(jTable3.getValueAt(i, 1)));//numero de factura
            jTextField2.setText(String.valueOf(jTable3.getValueAt(i, 2)));//FECHA

            jComboBox1.setSelectedItem(jTable3.getValueAt(i, 4) + " [" + jTable3.getValueAt(i, 3) + "]");

            jComboBox2.setSelectedItem(jTable3.getValueAt(i, 6));
            System.out.println(jTable3.getValueAt(i, 6) + " [" + jTable3.getValueAt(i, 5) + "]" + " [" + jTable3.getValueAt(i, 7) + "]" + " [" + jTable3.getValueAt(i, 8) + "]");
            jTextField5.setText(String.valueOf(jTable3.getValueAt(i, 7)));//licencia
            jTextField3.setText(String.valueOf(jTable3.getValueAt(i, 8)));//PLACA
            jTextField4.setText(String.valueOf(jTable3.getValueAt(i, 9)));//PARTIDA
            jTextField6.setText(String.valueOf(jTable3.getValueAt(i, 10)));//LLEGADA
            String enteroString = Integer.toString(numero);
            DetailsGuia(enteroString);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cc.listarTodosGuia(SalidaProductos.jTable3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedIndex() >= 0) {
            jTextField5.setText(SalidaProductos.arrayDatosTransportistas[2][jComboBox2.getSelectedIndex()]);
            jTextField3.setText(SalidaProductos.arrayDatosTransportistas[3][jComboBox2.getSelectedIndex()]);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked

    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Connection reg = conectar.getConexion();
        String sql_Facturas = "DELETE FROM table_GUIA WHERE NO_GUIA = ?";
        String sql_Guia_Detalle = "DELETE FROM table_GUIA_detalle WHERE NO_GUIA = ?";
        try {
            PreparedStatement pst = reg.prepareStatement(sql_Facturas);
            pst.setInt(1, Integer.parseInt(jTextField1.getText()));
            int ns = pst.executeUpdate();
            if (ns > 0) {
                JOptionPane.showMessageDialog(null, "GUIA - Eliminado Exitosamente");
            }
            PreparedStatement pst2 = reg.prepareStatement(sql_Guia_Detalle);
            pst2.setInt(1, Integer.parseInt(jTextField1.getText()));
            int ns2 = pst2.executeUpdate();
            if (ns2 > 0) {
                JOptionPane.showMessageDialog(null, "GUIA DETALLE- Eliminado Exitosamente");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - GUIA: " + ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jTextField1.setText(String.valueOf(id_guia_auto()));
        jTextField8.setText("");
        Date objDate = new Date();
        String strDateFormat = "YYYY-MM-dd";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        jTextField2.setText(objSDF.format(objDate));
        jTextField5.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField6.setText("");
        cc.formateaTabla(JTableProduct);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if (jComboBox3.getSelectedIndex() >= 0) {
            jTextField7.setText(buscaDato(jComboBox3.getSelectedItem().toString(), 1));
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (jTextField7.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Caja vacia");
        } else {
            int cant = (Integer) xcant.getValue();
            String[] datos = new String[3];
            datos[0] = buscaDato(jComboBox3.getSelectedItem().toString(), 1);
            datos[1] = jComboBox3.getSelectedItem().toString();
            datos[2] = String.valueOf(cant);
            cc.agregarItemProducto(datos);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Image portada;
        Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("guias/" + jTextField1.getText() + ".pdf"));
            document.open();

            portada = Image.getInstance("portadapcya.png");
            portada.setAlignment(Element.ALIGN_CENTER);
            portada.scalePercent(45f);// tamaño de imagen

            document.add(portada);
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("|    GUIA     |"));
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("Numero Fact. : " + jTextField1.getText()));
            //document.add(new Paragraph("Cliente : " + jTextFieldNombreCliente.getText() + " " + jTextFieldApellido.getText() + " - ID : " + jTextFieldCedula.getText()));
            //document.add(new Paragraph("Atendio por : " + jLabel9.getText()));
            //document.add(new Paragraph("Fecha   : [ " + jTextField2.getText() + " ] - Total a Pagar : $ " + totals + "  pesos"));
            document.add(new Paragraph("Fecha   : [ " + jTextField2.getText() + " ]"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("| No. |  Id-Ventas   |  COD.  |          PRODUCTOS             |CANT.| VALOR UNIT "
                    + "|  IMPORTE  |"));
            document.add(new Paragraph("----------------------------------------------------------------------"
                    + "--------------------------------------------------------"));

            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(500, 500);
            Graphics2D g2;
            g2 = tp.createGraphicsShapes(100, 500);
            JTableProduct.print(g2);
            g2.dispose();
            cb.addTemplate(tp, 50, -25);
            document.close();
            SimpleFrame sf = new SimpleFrame(jTextField1.getText(), 1);//1=guias  2=facturas
            sf.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
            sf.setAlwaysOnTop(true);
            sf.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton14ActionPerformed

    private void DetailsFacturas(String number) {

        cc.buscarFacturas(number, JTableProduct, 2);

    }

    private void DetailsGuia(String number) {

        cc.buscarGuias(number, JTableProduct);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalidaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalidaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalidaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalidaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalidaProductos dialog = new SalidaProductos(new javax.swing.JFrame(), false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTableProduct;
    public static javax.swing.JTable SeleccionarCliente;
    public static javax.swing.JTable SeleccionarProductos;
    public static javax.swing.JTable SeleccionarVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox2;
    public static javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JDialog jDialogCliente;
    private javax.swing.JDialog jDialogProductos;
    private javax.swing.JDialog jDialogVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public static javax.swing.JTable jTable3;
    public static javax.swing.JTable jTableListarFacturas;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextFieldParametroBusqueda;
    private javax.swing.JSpinner xcant;
    // End of variables declaration//GEN-END:variables
}
