package negocio;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import soporte.DiaActualBuilder;

import java.util.Date;

/**
 * Created by juanb on 10/6/2016.
 */
public class DiaActualTest {
    DiaActual da;



    @Before
    public void setup(){

        da = (new DiaActualBuilder()).createDiaActual();
    }

    @Test
    public void testGetTemp() {
        Assert.assertEquals(30f,da.getTemperatura());
    }
    @Test
    public void testGetDescripcion() {
        Assert.assertEquals(0,da.getDescripcion().compareTo("Nublado"));
    }
    @Test
    public void testGetFecha() {

        Assert.assertEquals(0,da.getFecha().compareTo(new Date(1942,5,2)));
    }
    @Test
    public void testCompareTo(){
        Assert.assertEquals(0, da.compareTo(da));
    }
}
