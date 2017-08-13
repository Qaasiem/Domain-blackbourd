package Factory;

import Domain.Branch;

import java.util.Map;

/**
 * Created by qaasiem on 2017-08-12.
 */
public class BranchFactory
{
    public static Branch getBranch(Long id, Map<String, String> branchValues)
    {
        Branch branch = new Branch.Builder()
                .id(id)
                .address(branchValues.get("address"))
                .phoneNumber(branchValues.get("phoneNumber"))
                .build();
        return branch;
    }
}
