package services;

import Domain.Supplier;
import Factory.SupplierFactory;
import Service.Impl.SupplierServiceImpl;
import Service.SupplierServices;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class SupplierServiceTest
{
    Supplier supplier;
    Map<String, String> supplierValues;
    SupplierServices supplierService;
    long supplierId;

    @BeforeMethod
    public void setUp() throws Exception {
        supplierId = 100;
        supplierValues = new HashMap<String, String>();
        supplierValues.put("name", "Qaasiem Samaai");
        supplierValues.put("address", "164 Wellintongton street Goodwood");
        supplierValues.put("contactNumber", "0714840789");
        supplier = SupplierFactory.getSupplier(supplierId, supplierValues);
        supplierService = new SupplierServiceImpl();
    }

    @Test
    public void testCreate() throws Exception {
        supplierService.create(supplier);
        assertEquals("Qaasiem Samaai", supplier.getName());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        supplierService.read(100);
        assertEquals("0714840789", supplier.getContactNumber());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        supplierService.read(100);
        Supplier updateEmployee = new Supplier.Builder()
                .id(supplierId)
                .name(supplierValues.get("name"))
                .address(supplierValues.get("address"))
                .contactNumber(supplierValues.get("contactNumber"))
                .build();
        supplierService.update(updateEmployee);
        supplier = supplierService.read(100);
        assertEquals("164 Wellintongton street Goodwood", supplier.getAddress());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        supplierService.delete(100);
        supplier = supplierService.read(100);
        assertNull(supplier);
    }
}
