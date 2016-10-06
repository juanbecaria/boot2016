package soporte;

import negocio.PronosticoExtendido;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * Created by juanb on 10/6/2016.
 */
public class PronosticoExtendidoBuilder {

    private Date fecha;
    private float tempMin;
    private float tempMax;
    private String descripcion;
    private DayOfWeek dia;

    public PronosticoExtendidoBuilder(){
        fecha= new Date(1930,03,03);
        tempMin=15;
        tempMax=27;
        descripcion="soleado";
        dia = DayOfWeek.MONDAY;

    }

    public PronosticoExtendidoBuilder setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public PronosticoExtendidoBuilder setTempMin(float tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    public PronosticoExtendidoBuilder setTempMax(float tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    public PronosticoExtendidoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public PronosticoExtendidoBuilder setDia(DayOfWeek dia) {
        this.dia = dia;
        return this;
    }

    public PronosticoExtendido createPronosticoExtendido(){
        return new PronosticoExtendido(fecha,tempMin,tempMax,dia,descripcion);
    }


}
