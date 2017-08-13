package Factory;

import Domain.Supplier;
import java.util.Map;
/**
 * Created by qaasiem on 2017-08-13.
 */
public class SupplierFactory
{
    public static Supplier getSupplier(Long id, Map<String, String> supplierValues)
    {
        Supplier supplier = new Supplier.Builder()
                .id(id)
                .name(supplierValues.get("name"))
                .address(supplierValues.get("address"))
                .contactNumber(supplierValues.get("contactNumber"))
                .build();
        return supplier;
    }
}
