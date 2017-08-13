package Service.Impl;

import Domain.Branch;
import Repository.BranchRepository;
import Repository.Impl.BranchRepositoryImpl;
import Service.BranchServices;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class BranchServiceImpl implements BranchServices
{
    BranchRepository repository = BranchRepositoryImpl.getRepository();

    @Override
    public Branch create(Branch branch) {
        return repository.create(branch);
    }

    @Override
    public Branch read(long id) {
        return repository.read(id);
    }

    @Override
    public Branch update(Branch branch) {
        return repository.update(branch);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}

