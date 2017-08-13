package repositories;

import Domain.Branch;
import Factory.BranchFactory;
import Repository.BranchRepository;
import Repository.Impl.BranchRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;


/**
 * Created by qaasiem on 2017-08-13.
 */
public class BranchRepositoryTest
{
    Branch branch;
    Map<String, String> branchValues;
    BranchRepository branchRepository;
    long branchId;

    @BeforeMethod
    public void setUp() throws Exception {
        branchId = 19;
        branchValues = new HashMap<String, String>();
        branchValues.put("address", "166 Wellington Street Goodwood");
        branchValues.put("phoneNumber", "0714840789");
        branch = BranchFactory.getBranch(branchId, branchValues);
        branchRepository = BranchRepositoryImpl.getRepository();
    }

    @Test
    public void testCreate() throws Exception {
        branch = branchRepository.create(branch);
        assertEquals("0714840789", branch.getPhoneNumber());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        branch = branchRepository.read(19);
        assertEquals(19,19, branch.getID());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        branch = branchRepository.read(19);
        Branch updateBranch = new Branch.Builder()
                .id(branchId)
                .address(branchValues.get("address"))
                .phoneNumber(branchValues.get("phoneNumber"))
                .build();
        branchRepository.update(updateBranch);
        branch = branchRepository.read(19);
        assertEquals("0714840789", branch.getPhoneNumber());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        branchRepository.delete(19);
        branch = branchRepository.read(19);
        assertNull(branch);
    }
}
