package services;

import Domain.Hardware;
import Factory.HardwareFactory;
import Service.HardwareServices;
import Service.Impl.HardwareServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class HardwareServiceTest
{
    Hardware hardware;
    Map<String, String> hardwareValues;
    HardwareServices hardwareService;
    long hardwareId;

    @BeforeMethod
    public void setUp() throws Exception {
        hardwareId = 29;
        hardwareValues = new HashMap<String, String>();
        hardwareValues.put("manufacturer", "Asus");
        hardwareValues.put("name", "Q Samaai");
        hardwareValues.put("category", "Laptop");
        hardwareValues.put("price", "12000.0");
        hardware = HardwareFactory.getHardware(hardwareId, hardwareValues);
        hardwareService = new HardwareServiceImpl();
    }

    @Test
    public void testCreate() throws Exception {
        hardwareService.create(hardware);
        assertEquals("Q Samaai", hardware.getName());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        hardwareService.read(29);
        assertEquals("Asus", hardware.getManufacturer());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        hardwareService.read(29);
        Hardware updateBranch = new Hardware.Builder()
                .id(hardwareId)
                .manufacturer(hardwareValues.get("manufacturer"))
                .name(hardwareValues.get("name"))
                .category(hardwareValues.get("category"))
                .price(Double.parseDouble(hardwareValues.get("price")))
                .build();
        hardwareService.update(updateBranch);
        hardware = hardwareService.read(29);
        assertEquals("Laptop", hardware.getCategory());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        hardwareService.delete(29);
        hardware = hardwareService.read(29);
        assertNull(hardware);
    }
}
