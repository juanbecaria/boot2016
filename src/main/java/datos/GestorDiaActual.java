package datos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import negocio.DiaActual;
import negocio.Localidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by juanb on 9/28/2016.
 */
public class GestorDiaActual {


    public void guardar(Localidad loca, java.sql.Date sqlDate, DiaActual dia){

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String insert= "INSERT INTO DiaActual (fecha, ciudad, pais, region, temperatura, descripcion) VALUES (?, ?, ?, ?, ?, ?) ";

        try {

            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");

            PreparedStatement st = con.prepareStatement(insert);
            st.setDate(1, sqlDate);
            st.setString(2,loca.getCiudad());
            st.setString(3,loca.getPais());
            st.setString(4,loca.getRegion());
            st.setFloat(5,dia.getTemperatura());
            st.setString(6,dia.getDescripcion());
            st.execute();

            st.close();
            con.close();

        }catch (SQLServerException e){

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
