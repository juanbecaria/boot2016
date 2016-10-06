package negocio;

import java.util.List;

/**
 * Created by juanb on 9/26/2016.
 */
public class Pronostico implements Comparable<Pronostico> {

    private Viento viento;
    private Atmosfera atmosfera;
    private DiaActual diaActual;
    private List<PronosticoExtendido> pronosticoExtendido;
    private Localidad localidad;

    public Pronostico(Viento viento, Atmosfera atmosfera, DiaActual diaActual, List<PronosticoExtendido> pronosticoExtendido, Localidad localidad) {
        this.viento = viento;
        this.atmosfera = atmosfera;
        this.diaActual = diaActual;
        this.pronosticoExtendido = pronosticoExtendido;
        this.localidad = localidad;
    }

    public Viento getViento() {
        return viento;
    }

    public Atmosfera getAtmosfera() {
        return atmosfera;
    }

    public DiaActual getDiaActual() {
        return diaActual;
    }

    public List<PronosticoExtendido> getPronosticoExtendido() {
        return pronosticoExtendido;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    @Override
    public String toString() {
        return "Pronostico{" +
                "viento=" + viento +
                ", atmosfera=" + atmosfera +
                ", diaActual=" + diaActual +
                ", pronosticoExtendido=" + pronosticoExtendido +
                ", localidad=" + localidad +
                '}';
    }

    public int compareTo(Pronostico o) {

        if(viento.compareTo(o.getViento())==0){
            if(atmosfera.compareTo(o.getAtmosfera())==0){
               if(diaActual.compareTo(o.getDiaActual())==0) {
                   if(localidad.compareTo(o.getLocalidad())==0){
                       int i=0;
                       for (PronosticoExtendido x :pronosticoExtendido) {
                           if(o.getPronosticoExtendido().contains(x)){
                               i++;
                           }


                       }
                       if(i==pronosticoExtendido.size()){
                           return 0;
                       }

                   }


               }
            }

        }
        return 1;

    }
}
