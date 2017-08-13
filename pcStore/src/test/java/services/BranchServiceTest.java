package services;

import Domain.Branch;
import Domain.Customer;
import Factory.BranchFactory;
import Repository.BranchRepository;
import Repository.Impl.BranchRepositoryImpl;
import Service.BranchServices;
import Service.Impl.BranchServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class BranchServiceTest
{
    Branch branch;
    Map<String, String> branchValues;
    BranchServices branchService;
    long branchId;

    @BeforeMethod
    public void setUp() throws Exception {
        branchId = 20;
        branchValues = new HashMap<String, String>();
        branchValues.put("address", "166 Wellington Street Goodwood");
        branchValues.put("phoneNumber", "0714840789");
        branch = BranchFactory.getBranch(branchId, branchValues);
        branchService = new BranchServiceImpl();
    }
    @Test
    public void testCreate() throws Exception {
        branchService.create(branch);
        assertEquals("0714840789", branch.getPhoneNumber());
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testRead() throws Exception {
        branchService.read(20);
        assertEquals("166 Wellington Street Goodwood", branch.getAddress());

    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testUpdate() throws Exception {
        branchService.read(20);
        Branch updateCustomer = new Branch.Builder()
                .id(branchId)
                .address(branchValues.get("address"))
                .phoneNumber(branchValues.get("phoneNumber"))
                .build();
        branchService.update(updateCustomer);
        branch = branchService.read(20);
        assertEquals("0714840789", branch.getPhoneNumber());
    }

    @Test(dependsOnMethods = {"testCreate", "testRead"})
    public void testDelete() throws Exception {
        branchService.delete(20);
        branch = branchService.read(20);
        assertNull(branch);
    }
}
