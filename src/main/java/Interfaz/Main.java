package Interfaz;

import datos.GestorPronostico;
import negocio.*;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanb on 9/26/2016.
 */
public class Main {
    public static void main(String[] args) {





        Atmosfera at = new Atmosfera(10, 20, 30, 0);
        Viento v = new Viento(180, 20);
        Localidad l = new Localidad("rio cuarto", "Cordoba", "Argentina");
        DiaActual da = new DiaActual(new Date(1993, 3, 30), 40, "nublado");
        List<PronosticoExtendido> pE = new ArrayList<PronosticoExtendido>();
        pE.add(new PronosticoExtendido(new Date(1993, 9, 30), 20, 60, DayOfWeek.MONDAY,"soleado"));
        pE.add(new PronosticoExtendido(new Date(1993, 3, 31), 20, 60, DayOfWeek.FRIDAY,"soleado"));
        pE.add(new PronosticoExtendido(new Date(1993, 4, 1), 20, 60, DayOfWeek.SUNDAY,"soleado"));
        pE.add(new PronosticoExtendido(new Date(1993, 4, 2), 20, 60, DayOfWeek.SATURDAY,"soleado"));

        Pronostico pronostico = new Pronostico(v, at, da, pE, l);
        GestorPronostico gp= new GestorPronostico();


        gp.guardarPronostico(pronostico);






        System.out.println(pronostico);
    }
}
