package datos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import negocio.Localidad;
import negocio.PronosticoExtendido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by juanb on 9/28/2016.
 */
public class GestorPronosticoExtendido {



    public void guardar(Localidad loca, java.sql.Date sqlDate, List<PronosticoExtendido> pe){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String insert= "INSERT INTO PronosticoExtendido (fechadia, ciudad, pais, region, fechaPronostico, minima, maxima, descripcion, nombre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try {

            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");
            for(int i = 0; i < pe.size();i++) {


                 java.util.Date utilDate = pe.get(i).getFecha();
                 java.sql.Date fechaProno = new java.sql.Date(utilDate.getTime());

                 PreparedStatement st = con.prepareStatement(insert);

                 st.setDate(1, sqlDate);
                 st.setString(2, loca.getCiudad());
                 st.setString(3, loca.getPais());
                 st.setString(4, loca.getRegion());
                 st.setDate(5, fechaProno);
                 st.setFloat(6, pe.get(i).getTempMin());
                 st.setFloat(7, pe.get(i).getTempMax());
                 st.setString(8, pe.get(i).getDescripcion());
                 st.setString(9, pe.get(i).getDia());
                 st.execute();
                 st.close();

             }

             con.close();




        }catch (SQLServerException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
