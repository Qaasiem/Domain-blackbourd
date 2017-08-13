package Service.Impl;

import Domain.Supplier;
import Repository.Impl.SupplierRepositoryImpl;
import Repository.SupplierRepository;
import Service.SupplierServices;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class SupplierServiceImpl implements SupplierServices
{
    SupplierRepository repository = SupplierRepositoryImpl.getRepository();

    @Override
    public Supplier create(Supplier supplier) {
        return repository.create(supplier);
    }

    @Override
    public Supplier read(long id) {
        return repository.read(id);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.update(supplier);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
