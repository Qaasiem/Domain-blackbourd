package Service;

import Domain.Branch;

/**
 * Created by qaasiem on 2017-08-13.
 */
public interface BranchServices
{
    Branch create(Branch branch);

    Branch read(long id);

    Branch update(Branch branch);

    void delete(long id);
}
