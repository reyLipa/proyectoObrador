
package proyectoobrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProyectoObrador {

    public static void main(String[] args) {
        
        try {
            //cargar driver
            Class.forName("org.mariadb.jdbc.Driver");
           
                //conexion a la bd
            Connection conexion=DriverManager.getConnection("jdbc:mariadb://localhost:3306/obrador2023", "root", "");
           
            //AGREGAR UN EMPLEADO
            /*String sql="INSERT INTO empleado (`dni`, `apellido`, `nombre`, `acceso`, `estado`)"
                    + " VALUES (254039,'Molina','karina',1,true)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int registros=ps.executeUpdate();
            System.out.println(registros);*/
            
            //ACTUALIZAR DATO
            
            /*String sql="UPDATE empleado SET nombre='Roxana' where dni=254039";
            PreparedStatement ps=conexion.prepareStatement(sql);
            int registros=ps.executeUpdate();
            System.out.println(registros);*/
            
            //BORRAR UN REGISTRO
            /*String sql="DELETE FROM empleado WHERE dni=254039";
            PreparedStatement ps=conexion.prepareStatement(sql);
            int registros=ps.executeUpdate();
            System.out.println(registros); */
            
            //SELECT
            String sql="SELECT * FROM empleado";
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet resultado=ps.executeQuery();
            while(resultado.next()){
                System.out.println("Ide "+resultado.getInt("idEmpleado"));
                System.out.println("Apellido "+resultado.getString("apellido"));
                System.out.println("Nombre "+resultado.getString("nombre"));
                System.out.println("Dni "+resultado.getInt("dni"));
                System.out.println("Acceso "+resultado.getInt("acceso"));
                System.out.println("Estado "+resultado.getBoolean("estado"));
            }
            
        } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "error al cargar driver  "+ ex.getMessage());
        
        }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error conexion a la bd "+ ex.getMessage());
        }
    }
    
}
