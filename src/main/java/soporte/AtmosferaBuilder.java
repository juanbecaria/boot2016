package soporte;

import negocio.Atmosfera;

/**
 * Created by juanb on 10/6/2016.
 */
public class AtmosferaBuilder {

    private float presion;
    private float visibilidad;
    private float humedad;
    private float ambienteAscendente;

    public AtmosferaBuilder() {
        presion=3;
        visibilidad=15;
        humedad=40;
        ambienteAscendente=0;
    }

    public AtmosferaBuilder setPresion(float presion) {
        this.presion = presion;
        return this;
    }

    public AtmosferaBuilder setVisibilidad(float visibilidad) {
        this.visibilidad = visibilidad;
        return this;
    }

    public AtmosferaBuilder setHumedad(float humedad) {
        this.humedad = humedad;
        return this;
    }

    public AtmosferaBuilder setAmbienteAscendente(float ambienteAscendente) {
        this.ambienteAscendente = ambienteAscendente;
        return this;
    }

    public Atmosfera createAtmosfera(){
        return new Atmosfera(presion,visibilidad,humedad,ambienteAscendente);
    }

}
