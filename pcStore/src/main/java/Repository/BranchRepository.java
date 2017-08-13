package Repository;


import Domain.Branch;

/**
 * Created by qaasiem on 2017-08-12.
 */
public interface BranchRepository
{
    Branch create(Branch branch);

    Branch read(long id);

    Branch update(Branch branch);

    void delete(long id);
}
