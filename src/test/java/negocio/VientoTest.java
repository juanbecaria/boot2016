package negocio;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import soporte.VientoBuilder;

/**
 * Created by juanb on 10/6/2016.
 */
public class VientoTest {
 private Viento  v;


    @Before
    public void setup(){

        v= (new VientoBuilder()).createViento();
    }

    @Test
    public void testGetDireccion() {
        Assert.assertEquals(45f,v.getDireccion());
    }
    @Test
    public void testGetVelocidad() {
        Assert.assertEquals(20f,v.getVelocidad());
    }
    @Test
    public void testCompareTo(){
        Assert.assertEquals(0, v.compareTo(v));
    }
}
