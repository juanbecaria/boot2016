package negocio;

/**
 * Created by juanb on 9/26/2016.
 */
public class Viento implements Comparable<Viento>{
    private float direccion;
    private float velocidad;

    public Viento(float direccion, float velocidad) {
        this.direccion = direccion;
        this.velocidad = velocidad;
    }

    public float getDireccion() {
        return direccion;
    }

    public float getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return "Viento{" +
                "direccion=" + direccion + "grados" +
                ", velocidad=" + velocidad + "mi/h" +
                '}';
    }

    public int compareTo(Viento o) {
        float res=0;
        res= direccion-o.getDireccion();
        if(res==0){
            res=velocidad-o.getVelocidad();
            if(res==0){
                return 0 ;

            }
        }
        return 1;
    }
}
