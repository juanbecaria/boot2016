package negocio;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import soporte.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanb on 10/6/2016.
 */
public class PronosticoTest {
    private Pronostico p;

    @Before
    public void setup(){
        p= (new PronosticoBuilder()).createPronostico();
    }

    @Test
    public void testGetViento() {
        Viento v = (new VientoBuilder()).createViento();
        Assert.assertEquals(0,p.getViento().compareTo((v)));
    }
    @Test
    public void testGetAtmosfera() {
        Atmosfera a = (new AtmosferaBuilder()).createAtmosfera();
        Assert.assertEquals(0,p.getAtmosfera().compareTo((a)));
    }
    @Test
    public void testGetDiaActual() {
        DiaActual da= (new DiaActualBuilder()).createDiaActual();
        Assert.assertEquals(0,p.getDiaActual().compareTo(da));
    }
    @Test
    public void testGetPronosticoExtendido() {

        PronosticoExtendido pronEx = p.getPronosticoExtendido().get(0);
        Assert.assertEquals(0, pronEx.compareTo((new PronosticoExtendidoBuilder()).createPronosticoExtendido()));

    }
    @Test
    public void testGetLocalidad() {
        Localidad l = (new LocalidadBuilder()).createLocalidad();
        Assert.assertEquals(0,p.getLocalidad().compareTo(l));
    }


}
