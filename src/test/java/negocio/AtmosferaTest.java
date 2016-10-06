package negocio;

import static org.junit.Assert.assertEquals;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import soporte.AtmosferaBuilder;

/**
 * Created by juanb on 10/6/2016.
 */
public class AtmosferaTest {
    private Atmosfera at;

    @Before
    public void setup(){
        AtmosferaBuilder ab = new AtmosferaBuilder();
        at = ab.createAtmosfera();
    }
    @Test
    public  void testgetPresion() {


        Assert.assertEquals(3f,at.getPresion());


    }
    @Test
    public void testgetVisibilidad() {


        Assert.assertEquals(15f, at.getVisibilidad());

    }
    @Test
    public void testgetHumedad() {


        Assert.assertEquals(40f, at.getHumedad());
    }

    @Test
    public void testCompareTo(){
        Assert.assertEquals(0, at.compareTo(at));
    }
}
