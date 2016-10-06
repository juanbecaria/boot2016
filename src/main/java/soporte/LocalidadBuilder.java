package soporte;

import negocio.Localidad;

/**
 * Created by juanb on 10/6/2016.
 */
public class LocalidadBuilder {
    private String ciudad;
    private String region;
    private String pais;

    public LocalidadBuilder(){
        ciudad="Pilar";
        region="Buenos Aires";
        pais="Argentina";

    }

    public LocalidadBuilder setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public LocalidadBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public LocalidadBuilder setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public Localidad createLocalidad(){
        return new Localidad(ciudad,region,pais);
    }
}
