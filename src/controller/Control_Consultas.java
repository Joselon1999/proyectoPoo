package controller;

import view.SalidaProductos;

import view.ConsultarFacturas;
import view.ConsultarVentas;
import dao.CerrarConexiones;
import dao.ConexionConBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Jose
 */


public class Control_Consultas {

    DefaultTableModel modelo;
    String[][] info = {};
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();

    public void CargarListaProductos() {
        try{
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT CONCAT( NOMBREPRODUCTOS, ' [' , IDPRODUCTOS , ']' ) AS PRODUCTOS FROM TABLE_PRODUCTOS  ORDER BY NOMBREPRODUCTOS ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            //mientras haya datos en la BD ejecutar eso...
            SalidaProductos.jComboBox3.removeAllItems();
            while (resultado.next()) {
                //int codigo = resultado.getInt("idVendedor");
                String nombre = resultado.getString("PRODUCTOS");
                SalidaProductos.jComboBox3.addItem(nombre);
            }       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:\n" + e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }            
    }    
    
    public void CargarListaTransportista() {
        try{
            int fila=0;
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT CONCAT(NOMBRE_TRANSPORTISTA,' [', CAST(IDTRANSPORTISTA  AS VARCHAR(10)) , '] ','[', LICENCIA, '] ' , '[', PLACA_VEHICULO, ']' ) AS ListaTransportista, NOMBRE_TRANSPORTISTA, IDTRANSPORTISTA, LICENCIA, PLACA_VEHICULO FROM TABLE_TRANSPORTISTA  ORDER BY NOMBRE_TRANSPORTISTA  ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            SalidaProductos.jComboBox2.removeAllItems();
            while (resultado.next()) {
                String nombre = resultado.getString("NOMBRE_TRANSPORTISTA");
                SalidaProductos.jComboBox2.addItem(nombre);
                SalidaProductos.arrayDatosTransportistas[0][fila] =resultado.getString("IDTRANSPORTISTA");
                SalidaProductos.arrayDatosTransportistas[1][fila] =resultado.getString("NOMBRE_TRANSPORTISTA");
                SalidaProductos.arrayDatosTransportistas[2][fila] =resultado.getString("LICENCIA");
                SalidaProductos.arrayDatosTransportistas[3][fila] =resultado.getString("PLACA_VEHICULO");
                fila++;
            }      
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:\n" + e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }            
    }

    
    public void listarTodosGuia(JTable jtable) {
        String[] titulosColumnas = {"No_Guia", "No_Factura", "Fecha", "Cod_Res","Responsable", "Cod_Tra", "Transportista","Licencia","Placa", "partida", "Llegada"  };
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtable.setModel(modelo);
        ejecutarConsultaTodaTabladeGuias();
    }
    
    public void listarTodosFacturas(JTable jtable) {
        String[] titulosColumnas = {"No_Facturas", "CLIENTE", "FECHA", "VENDEDOR","TOTALS"};
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtable.setModel(modelo);
        ejecutarConsultaTodaTabladeFacturas();
    }
    
     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    
    public void ejecutarConsultaTodaTabladeGuias() {
        try {
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT " +
            "G.NO_GUIA ,G.NO_FACTURA, G.FECHA,G.ID_RESPONSABLE, V.NOMBREVENDEDOR, G.ID_TRANSPORTISTA, T.NOMBRE_TRANSPORTISTA, " +
            "G.LICENCIA, G.PLACA_VEHICULO ,G.PUNTO_PARTIDA ,G.PUNTO_LLEGADA " +
            "FROM " +
            "TABLE_GUIA G " +
            "LEFT OUTER JOIN TABLE_VENDEDOR V ON " +
            "G.ID_RESPONSABLE = V.IDVENDEDOR " +
            "LEFT OUTER JOIN TABLE_TRANSPORTISTA T ON " +
            "G.ID_TRANSPORTISTA = T.IDTRANSPORTISTA";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                int guia = resultado.getInt("NO_GUIA");
                int fact = resultado.getInt("NO_FACTURA");
                String fecha = resultado.getString("FECHA").substring(0, 10);
                int id_resp = resultado.getInt("ID_RESPONSABLE");
                String vendedor = resultado.getString("NOMBREVENDEDOR");
                int id_trans = resultado.getInt("ID_TRANSPORTISTA");
                String trans = resultado.getString("NOMBRE_TRANSPORTISTA");
                String licencia = resultado.getString("LICENCIA");
                String placa = resultado.getString("PLACA_VEHICULO");
                String partida = resultado.getString("PUNTO_PARTIDA");
                String llegada = resultado.getString("PUNTO_LLEGADA");
                Object[] info = {guia,fact,fecha,id_resp,vendedor,id_trans, trans, licencia, placa, partida, llegada};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
    
    public void ejecutarConsultaTodaTabladeFacturas() {
        try {
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_Facturas ORDER BY fecha ASC";
            resultado = sentencia.executeQuery(consultaSQL);
            while (resultado.next()) {
                int fact = resultado.getInt("No_Facturas");
                String cliente = resultado.getString("cliente");
                String fecha = resultado.getString("fecha");
                String vendedor = resultado.getString("vendedor");
                String total = resultado.getString("totals");
                Object[] info = {fact,cliente,fecha,vendedor,total};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
  
    public void buscarFacturas(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        String[] titulosColumnas = {"No_Facturas", "CLIENTE", "FECHA", "VENDEDOR","TOTALS"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            ConsultarFacturas.jTableListarFacturas.setModel(modelo);
            buscarFacturasporBusqueda(parametroBusqueda, buscarPorFacturas, buscarPorCliente, buscarPorFecha);
        }
    }
    
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarFacturasporBusqueda(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        try {

            
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
            if (buscarPorFacturas == true) {     
                System.out.print("buscando por facturas");
                selectSQL = "SELECT * FROM table_Facturas WHERE No_Facturas LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            } 
            else if(buscarPorCliente== true){
                System.out.print("buscando por cliente");
                selectSQL = "SELECT * FROM table_Facturas WHERE cliente LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorFecha== true){
                System.out.print("buscando por fecha -->"+parametroBusqueda);
                selectSQL = "SELECT * FROM table_Facturas WHERE fecha LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();
            while (resultado.next()) {
                int fact = resultado.getInt("No_Facturas");
                String cliente = resultado.getString("cliente");
                String fecha = resultado.getString("fecha");
                String vendedor = resultado.getString("vendedor");
                String total = resultado.getString("totals");
                Object[] info = {fact,cliente, fecha, vendedor,total};
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    
    public void formateaTabla(JTable jtable){
    
        int[] anchos = {150, 500, 150};
        String[] titulosColumnas = {"Codigo Producto","Producto", "Cantidad"};

            modelo = new DefaultTableModel(info,titulosColumnas){
                public boolean isCellEditable(int row, int column)
                {
                return false;
                }
            };
       jtable.setModel(modelo);
        for(int i = 0; i < jtable.getColumnCount(); i++) {
        jtable.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public void buscarGuias ( String number, JTable jtable){
        //String titulosColumnas[] = new String[2]; 
        //int anchos[] = new int[4];
        int[] anchos = {150, 500, 150};
        String[] titulosColumnas = {"Codigo Producto","Producto", "Cantidad"};
        if( (number.trim().length()==0)){
            JOptionPane.showMessageDialog(null,"Error, Seleccione la Guia");
        }
        else{
            modelo = new DefaultTableModel(info,titulosColumnas){
                public boolean isCellEditable(int row, int column)
                {
                return false;
                }
            };
       jtable.setModel(modelo);
        for(int i = 0; i < jtable.getColumnCount(); i++) {
        jtable.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        buscarGuiasDetall1(number);
        }
    }

    public void buscarFacturas ( String number, JTable jtable, Integer modeloTabla){
        int cantidadCol=0;
        switch (modeloTabla) 
        {
        case 1:        
            cantidadCol = 4;
            break;
        case 2:
            cantidadCol = 3;
            break;
        default:  break;
        }
        
        String[] titulosColumnas = new String[cantidadCol];
        int[] anchos = new int[4];
            switch (modeloTabla) 
            {
            case 1:
                titulosColumnas[0] = "ID-VENTAS";titulosColumnas[1] = "PRODUCTOS";
                titulosColumnas[2] = "CANTIDAD";titulosColumnas[3] = "IMPORTE";                
                anchos[0] = 80;anchos[1] = 200;anchos[2] = 50;anchos[3] = 145;
                break;
            case 2:    
                titulosColumnas[0] = "Codigo Producto";titulosColumnas[1] = "Producto";titulosColumnas[2] = "Cantidad";
                anchos[0] = 150;anchos[1] = 500;anchos[2] = 150;
                break;
            default:  break;
            }                  
        
        if( (number.trim().length()==0)){
            JOptionPane.showMessageDialog(null,"Error, Seleccione la Facturas");
        }
        else{
            modelo = new DefaultTableModel(info,titulosColumnas){
                public boolean isCellEditable(int row, int column)
                {
                return false;
                }
            };
       jtable.setModel(modelo);
        
        for(int i = 0; i < jtable.getColumnCount(); i++) {
        jtable.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if (modeloTabla == 1)
            buscarFacturasDetall(number);         
        else
            buscarFacturasDetall2(number);         
        }
    }

    public void agregarItemProducto(String[] datos){
            modelo.addRow(datos);
    }

    public void eliminaItemProducto(int i){
            modelo.removeRow(i);
    }

      public void buscarGuiasDetall1(String number) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
           
                selectSQL = "SELECT idproductos, nombreproductos, cantidad FROM table_guia_detalle WHERE No_guia LIKE ? ";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + number + "%");
            
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigoProduct = resultado.getString("idproductos");
                String product = resultado.getString("nombreproductos");
                String cant = resultado.getString("cantidad");
                Object[] info = {codigoProduct,product,cant};
                modelo.addRow(info);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n " + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }     

      public void buscarFacturasDetall2(String number) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
           
                selectSQL = "SELECT productos, cantidad FROM table_ventas WHERE No_Facturas LIKE ? ORDER BY idVentas ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + number + "%");
            
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String product = resultado.getString("productos");
                String cant = resultado.getString("cantidad");
                String name="";
                Statement comando = conexion.createStatement();
                 ResultSet registro = comando.executeQuery("select idProductos,nombreProductos from table_productos where idProductos=" +product);
                 if (registro.next() == true) {
                     name = registro.getString("nombreProductos");
                    }
                Object[] info = {product,name,cant};
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n " + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }

      public void buscarFacturasDetall(String number) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
           
                selectSQL = "SELECT * FROM table_ventas WHERE No_Facturas LIKE ? ORDER BY idVentas ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + number + "%");
            
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String id = resultado.getString("idVentas");
                String product = resultado.getString("productos");
                String cant = resultado.getString("cantidad");
                String imp = resultado.getString("importe");
                String name="";
                Statement comando = conexion.createStatement();
                 ResultSet registro = comando.executeQuery("select idProductos,nombreProductos from table_productos where idProductos=" +product);
            
                 if (registro.next() == true) {
                     name = registro.getString("nombreProductos");
                    }
                Object[] info = {id,name,cant,imp};
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n " + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }
    public void listarTodosVentas() {
        String[] titulosColumnas = {"id-Ventas","No_Facturas", "Cod_Prod", "cantidad", "Importe"};
        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ConsultarVentas.jTableListarVentas.setModel(modelo);
        ejecutarConsultaTodaTabladeVentas();
    }

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */


    public void ejecutarConsultaTodaTabladeVentas() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_ventas ORDER BY idVentas ASC";
            resultado = sentencia.executeQuery(consultaSQL);

            while (resultado.next()) {
                int num = resultado.getInt("idVentas");
                String fact = resultado.getString("No_Facturas");
                String prod = resultado.getString("productos");
                String cant = resultado.getString("cantidad");
                String importe = resultado.getString("importe");

                Object[] info = {num,fact,prod,cant,importe};
                modelo.addRow(info);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }
    
    public void buscarFacturasdeVentas(String parametroBusqueda) {

        String[] titulosColumnas = {"id-Ventas","No_Facturas", "Cod_Prod", "cantidad", "Importe"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            ConsultarVentas.jTableListarVentas.setModel(modelo);
            buscarFacturasporBusquedaenVentas(parametroBusqueda);
        }
    }
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarFacturasporBusquedaenVentas(String parametroBusqueda) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                System.out.print("buscando por facturas en Ventas");
                selectSQL = "SELECT * FROM table_ventas WHERE No_Facturas LIKE ? ORDER BY idVentas ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            resultado = ps.executeQuery();
            while (resultado.next()) {
                int num = resultado.getInt("idVentas");
                String fact = resultado.getString("No_Facturas");
                String prod = resultado.getString("productos");
                String cant = resultado.getString("cantidad");
                String importe = resultado.getString("importe");
                Object[] info = {num,fact,prod,cant,importe};
                modelo.addRow(info);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }
}
