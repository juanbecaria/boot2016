package negocio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import soporte.LocalidadBuilder;

/**
 * Created by juanb on 10/6/2016.
 */
public class LocalidadTest {
private Localidad l;




@Before
public void setup(){
    l = (new LocalidadBuilder()).createLocalidad();

}
    @Test
    public void testGetCiudad() {
        Assert.assertEquals(0,l.getCiudad().compareTo("Pilar"));

    }
    @Test
    public void testGetRegion() {
        Assert.assertEquals(0,l.getRegion().compareTo("Buenos Aires"));

    }
    @Test
    public void testGetPais() {
        Assert.assertEquals(0,l.getPais().compareTo("Argentina"));
    }

    @Test
    public void testCompareTo(){
        Assert.assertEquals(0, l.compareTo(l));
    }
}
