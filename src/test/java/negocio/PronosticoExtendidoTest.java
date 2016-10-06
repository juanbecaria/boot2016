package negocio;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import soporte.PronosticoExtendidoBuilder;

import java.time.DayOfWeek;
import java.util.Date;

/**
 * Created by juanb on 10/6/2016.
 */
public class PronosticoExtendidoTest {
    PronosticoExtendido pe;

    @Before
    public void setup(){
        pe = (new PronosticoExtendidoBuilder()).createPronosticoExtendido();
    }

    @Test
    public void testGetFecha() {

        Assert.assertEquals(0,pe.getFecha().compareTo(new Date(1930,03,03)));
    }


    @Test
    public void testGetTempMin() {
         Assert.assertEquals(15f,pe.getTempMin());
    }

    @Test
    public void testGetTempMax() {
        Assert.assertEquals(27f,pe.getTempMax());
    }
    @Test
    public void testGetDescripcion(){
        Assert.assertEquals(0,pe.getDescripcion().compareTo("soleado"));
    }
    @Test
    public void testGetDia() {
        Assert.assertEquals(0,pe.getDia().compareTo(DayOfWeek.MONDAY.toString()));
    }

    @Test
    public void testCompareTo(){
        Assert.assertEquals(0, pe.compareTo(pe));
    }



}
