package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionConBaseDatos {
    public static Connection conexion = null;
    public static Connection getConexion() {
        try {
           conexion = null;
           Class.forName("org.h2.Driver");
           conexion =DriverManager.getConnection("jdbc:h2:./BD/ventas","sa","");
           System.out.println("conexión establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("error de conexión");
           JOptionPane.showMessageDialog(null, "error de conexión "+e);
       }
        return conexion;
    }    
}