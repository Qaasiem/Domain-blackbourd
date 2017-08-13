package factories;

import Domain.Hardware;
import Factory.HardwareFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class HardwareFactoryTest
{
    Hardware hardware;

    Map<String, String> hardwareValues;

    @BeforeMethod
    public void setUp() throws Exception {
        long hardwareId = 30;
        hardwareValues = new HashMap<String, String>();
        hardwareValues.put("manufacturer", "Asus");
        hardwareValues.put("name", "Q Samaai");
        hardwareValues.put("category", "Laptop");
        hardwareValues.put("price", "12000");
        hardware = HardwareFactory.getHardware(hardwareId, hardwareValues);
    }

    @Test
    public void testGetCategory() throws Exception {
        assertEquals(true, hardware.equals(hardware));
    }
}
