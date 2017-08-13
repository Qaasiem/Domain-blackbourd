package factories;

import Domain.Branch;

import Factory.BranchFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class BranchFactoryTest
{
    Branch branch;

    Map<String, String> branchValues;

    @BeforeMethod
    public void setUp() throws Exception {
        long branchId = 12;
        branchValues = new HashMap<String, String>();
        branchValues.put("address", "166 Wellington Street Goodwood");
        branchValues.put("phoneNumber", "0714840789");
        branch = BranchFactory.getBranch(branchId, branchValues);
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals(true, branch.equals(branch));
    }

}
