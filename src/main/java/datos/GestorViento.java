package datos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import negocio.Localidad;
import negocio.Viento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by juanb on 9/28/2016.
 */
public class GestorViento {

   public void guardar(Localidad loca, java.sql.Date sqlDate, Viento vien){
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      String insert= "INSERT INTO Viento (fecha, ciudad, pais, region, velocidad, direccion) VALUES (?, ?, ?, ?, ?, ?) ";

      try {

         Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");





         PreparedStatement st = con.prepareStatement(insert);
         st.setDate(1, sqlDate);
         st.setString(2,loca.getCiudad());
         st.setString(3,loca.getPais());
         st.setString(4,loca.getRegion());
         st.setFloat(5,vien.getVelocidad());
         st.setFloat(6,vien.getDireccion());


         st.execute();
         st.close();
         con.close();

      }catch (SQLServerException e){
         System.out.println(e.getMessage());

      }
      catch (SQLException e) {
         e.printStackTrace();
      }


   }



}
