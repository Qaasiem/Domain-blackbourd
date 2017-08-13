package repositories;

import Domain.Hardware;
import Factory.HardwareFactory;
import Repository.HardwareRepository;
import Repository.Impl.HardwareRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class HardwareRepositoryTest
{
    Hardware hardware;
    Map<String, String> hardwareValues;
    HardwareRepository hardwareRepository;
    long hardwareId;

    @BeforeMethod
    public void setUp() throws Exception {
        hardwareId = 99;
        hardwareValues = new HashMap<String, String>();
        hardwareValues.put("manufacturer", "Asus");
        hardwareValues.put("name", "Q Samaai");
        hardwareValues.put("category", "Laptop");
        hardwareValues.put("price", "12000.0");
        hardware = HardwareFactory.getHardware(hardwareId, hardwareValues);
        hardwareRepository = HardwareRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        hardware = hardwareRepository.create(hardware);
        assertEquals("Laptop", hardware.getCategory());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        hardware = hardwareRepository.read(99);
        assertEquals(99,99, hardware.getID());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        hardware = hardwareRepository.read(99);
        Hardware updateHardware = new Hardware.Builder()
                .id(hardwareId)
                .manufacturer(hardwareValues.get("manufacturer"))
                .name(hardwareValues.get("name"))
                .category(hardwareValues.get("category"))
                .price(Double.parseDouble(hardwareValues.get("price")))
                .build();
        hardwareRepository.update(updateHardware);
        hardware = hardwareRepository.read(99);
        assertEquals("Laptop", hardware.getCategory());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        hardwareRepository.delete(99);
        hardware = hardwareRepository.read(99);
        assertNull(hardware);
    }
}
