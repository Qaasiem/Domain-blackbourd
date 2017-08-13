package Service;

import Domain.Supplier;

/**
 * Created by qaasiem on 2017-08-13.
 */
public interface SupplierServices
{
    Supplier create(Supplier supplier);

    Supplier read(long id);

    Supplier update(Supplier supplier);

    void delete(long id);
}
