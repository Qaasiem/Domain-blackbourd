package Repository.Impl;

import Domain.Supplier;
import Repository.SupplierRepository;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qaasiem on 2017-08-13.
 */
public class SupplierRepositoryImpl implements SupplierRepository
{
    private static SupplierRepositoryImpl repository = null;

    private Map<Long, Supplier> supplierTable;

    private SupplierRepositoryImpl()
    {
        supplierTable = new HashMap<Long, Supplier>();
    }

    public static SupplierRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new SupplierRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        supplierTable.put(supplier.getID(), supplier);
        Supplier saveSupplier = supplierTable.get(supplier.getID());
        return saveSupplier;
    }

    @Override
    public Supplier read(long id) {
        Supplier supplier = supplierTable.get(id);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        supplierTable.put(supplier.getID(), supplier);
        Supplier updateSupplier = supplierTable.get(supplier.getID());
        return updateSupplier;
    }

    @Override
    public void delete(long id) {
        supplierTable.remove(id);
    }
}
