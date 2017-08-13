package factories;

import Domain.Supplier;
import Factory.SupplierFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class SupplierFactoryTest
{
    Supplier supplier;

    Map<String, String> supplierValues;

    @BeforeMethod
    public void setUp() throws Exception {
        long supplierId = 3;
        supplierValues = new HashMap<String, String>();
        supplierValues.put("name", "Qaasiem Samaai");
        supplierValues.put("address", "164 Wellintongton street Goodwood");
        supplierValues.put("contactNumber", "0714840789");
        supplier = SupplierFactory.getSupplier(supplierId, supplierValues);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(true, supplier.equals(supplier));
    }
}
