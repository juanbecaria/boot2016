package negocio;

/**
 * Created by juanb on 9/26/2016.
 */
public class Atmosfera implements Comparable<Atmosfera> {


    private float presion;
    private float visibilidad;
    private float humedad;
    private float ambienteAscendente;

    public Atmosfera(float presion, float visibilidad, float humedad, float ambienteAscendente) {
        this.presion = presion;
        this.visibilidad = visibilidad;
        this.humedad = humedad;
        this.ambienteAscendente = ambienteAscendente;
    }

    public float getPresion() {
        return presion;
    }

    public float getVisibilidad() {
        return visibilidad;
    }

    public float getHumedad() {
        return humedad;
    }

    public float getAmbienteAscendente() {
        return ambienteAscendente;
    }

    @Override
    public String toString() {
        return "Atmosfera{" +
                "presion=" + presion + "in" +
                ", visibilidad=" + visibilidad + "miles" +
                ", humedad=" + humedad + "%" +
                ", ambienteAscendente=" + ambienteAscendente +
                '}';
    }
    public int compareTo(Atmosfera o) {
        float res=0;
        res=humedad-o.getHumedad();
        if (res==0){
            res=visibilidad-o.getVisibilidad();
            if (res==0){
                res=presion-o.getPresion();
                if (res==0)
                {
                    res=ambienteAscendente-o.getAmbienteAscendente();
                    if (res==0)
                    {
                        return 0;

                    }

                }
            }
        }
        return 1;
    }
}
