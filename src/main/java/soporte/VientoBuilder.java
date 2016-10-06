package soporte;

import negocio.Viento;

/**
 * Created by juanb on 10/6/2016.
 */
public class VientoBuilder {
    private float direccion;
    private float velocidad;

    public VientoBuilder(){
        direccion=45;
        velocidad=20;

    }

    public VientoBuilder setDireccion(float direccion) {
        this.direccion = direccion;
        return this;
    }

    public VientoBuilder setVelocidad(float velocidad) {
        this.velocidad = velocidad;
        return this;
    }

    public Viento createViento(){
        return new Viento(direccion,velocidad);
    }


}
