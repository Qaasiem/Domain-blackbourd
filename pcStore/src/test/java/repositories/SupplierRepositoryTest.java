package repositories;

import Domain.Supplier;
import Factory.SupplierFactory;
import Repository.Impl.SupplierRepositoryImpl;
import Repository.SupplierRepository;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class SupplierRepositoryTest
{
    Supplier supplier;
    Map<String, String> supplierValues;
    SupplierRepository supplierRepository;
    long supplierId;

    @BeforeMethod
    public void setUp() throws Exception {
        supplierId = 84;
        supplierValues = new HashMap<String, String>();
        supplierValues.put("name", "Qaasiem Samaai");
        supplierValues.put("address", "164 Wellintongton street Goodwood");
        supplierValues.put("contactNumber", "0714840789");
        supplier = SupplierFactory.getSupplier(supplierId, supplierValues);
        supplierRepository = SupplierRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        supplier = supplierRepository.create(supplier);
        assertEquals("Qaasiem Samaai", supplier.getName());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        supplier = supplierRepository.read(84);
        assertEquals(84,84, supplier.getID());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        supplier = supplierRepository.read(84);
        Supplier updateSupplier = new Supplier.Builder()
                .id(supplierId)
                .name(supplierValues.get("name"))
                .address(supplierValues.get("address"))
                .contactNumber(supplierValues.get("contactNumber"))
                .build();
        supplierRepository.update(updateSupplier);
        supplier = supplierRepository.read(84);
        assertEquals("164 Wellintongton street Goodwood", supplier.getAddress());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        supplierRepository.delete(84);
        supplier = supplierRepository.read(84);
        assertNull(supplier);
    }
}
