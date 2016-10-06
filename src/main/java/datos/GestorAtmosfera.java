package datos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import negocio.Atmosfera;
import negocio.Localidad;

import java.sql.*;

/**
 * Created by juanb on 9/28/2016.
 */
public class GestorAtmosfera {

    public void guardar(Localidad loca, Date sqlDate, Atmosfera at){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");


            String insert= "INSERT INTO Atmosfera (fecha, ciudad, pais, region, presion, visivilidad, ambienteAscendente, humedad) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";


            PreparedStatement st = con.prepareStatement(insert);
            st.setDate(1, sqlDate);
            st.setString(2,loca.getCiudad());
            st.setString(3,loca.getPais());
            st.setString(4,loca.getRegion());
            st.setFloat(5,at.getPresion());
            st.setFloat(6,at.getVisibilidad());
            st.setFloat(7,at.getAmbienteAscendente());
            st.setFloat(8,at.getHumedad());
            st.execute();

            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLServerException e){
            System.out.println(e.getMessage());

        }

        catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
