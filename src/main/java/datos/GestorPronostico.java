package datos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import negocio.Pronostico;

import java.sql.*;

/**
 * Created by juanb on 9/28/2016.
 */
public class GestorPronostico {
    Connection con;


    private void openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");
            con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLServerException e){

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void closeConnection(){
        try {
            con.close();
        }
        catch (SQLServerException e){

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void guardarPronostico(Pronostico pro){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String declaracion = "INSERT INTO Pronostico (fecha, ciudad, pais, region) VALUES (?,?,?,?)";

        try {

            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OBB6MVN;databaseName=Bootcamp;integratedSecurity=true;");

            java.util.Date utilDate = pro.getDiaActual().getFecha();
            Date sqlDate = new Date(utilDate.getTime());

            GestorLocalidad gl = new GestorLocalidad();
            gl.guardar(pro.getLocalidad());

            PreparedStatement pst = con.prepareStatement(declaracion);
            pst.setDate(1,sqlDate);
            pst.setString(2,pro.getLocalidad().getCiudad());
            pst.setString(3,pro.getLocalidad().getPais());
            pst.setString(4,pro.getLocalidad().getRegion());
            pst.execute();
            pst.close();


            GestorAtmosfera ga = new GestorAtmosfera();
            ga.guardar( pro.getLocalidad(),sqlDate, pro.getAtmosfera());

            GestorDiaActual gda= new GestorDiaActual();
            gda.guardar( pro.getLocalidad(),sqlDate,pro.getDiaActual());



            GestorPronosticoExtendido gpe = new GestorPronosticoExtendido();
            gpe.guardar(pro.getLocalidad(),sqlDate,pro.getPronosticoExtendido());

            GestorViento gv = new GestorViento();
            gv.guardar(pro.getLocalidad(),sqlDate,pro.getViento());


            pst.execute();
            pst.close();
            con.close();


        }
        catch (SQLServerException e)
        {System.out.println(e.getMessage());

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }



}
