package datos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import negocio.Localidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by juanb on 9/28/2016.
 */
public  class GestorLocalidad {

    public void guardar(Localidad loca){

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String insert= "INSERT INTO Localidad (ciudad, pais, region) VALUES (?, ?, ?) ";

        try {

            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");

            PreparedStatement st = con.prepareStatement(insert);
            st.setString(1,loca.getCiudad());
            st.setString(2,loca.getPais());
            st.setString(3,loca.getRegion());
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
