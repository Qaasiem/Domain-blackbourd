package Repository.Impl;

import Domain.Branch;
import Repository.BranchRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qaasiem on 2017-08-12.
 */
public class BranchRepositoryImpl implements BranchRepository
{
    private static BranchRepositoryImpl repository = null;

    private Map<Long, Branch> branchTable;

    private BranchRepositoryImpl()
    {
        branchTable = new HashMap<Long, Branch>();
    }

    public static BranchRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new BranchRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Branch create(Branch branch) {
        branchTable.put(branch.getID(), branch);
        Branch saveBranch = branchTable.get(branch.getID());
        return saveBranch;
    }

    @Override
    public Branch read(long id) {
        Branch branch = branchTable.get(id);
        return branch;
    }

    @Override
    public Branch update(Branch branch) {
        branchTable.put(branch.getID(), branch);
        Branch updateBranch = branchTable.get(branch.getID());
        return updateBranch;
    }

    @Override
    public void delete(long id) {
        branchTable.remove(id);
    }
}
