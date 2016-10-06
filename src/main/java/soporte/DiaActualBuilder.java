package soporte;

import negocio.DiaActual;

import java.util.Date;

/**
 * Created by juanb on 10/6/2016.
 */
public class DiaActualBuilder {

    private Date fecha;
    private float temp;
    private String descripcion;

    public DiaActualBuilder(){
        fecha = new Date(1942,5,2) ;
        temp=30;
        descripcion="Nublado";

    }

    public DiaActualBuilder setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }

    public DiaActualBuilder setTemp(float temp) {
        this.temp = temp;
        return this;
    }

    public DiaActualBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public DiaActual createDiaActual(){
        return new DiaActual(fecha,temp,descripcion);
    }
}
