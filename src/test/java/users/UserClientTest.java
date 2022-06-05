package users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserClientTest {

    private UserClient aUserClient;

    private List<User> aUserList;

    /**
     * Setup UserClient class and obtain list of users before conducting tests.
     */
    @Before
    public void setup() {
        aUserClient = new UserClient();
        aUserList = aUserClient.request();
    }

    /**
     * Tests the number of users returned by the list.
     */
    @Test
    public void testNumberOfUsers() {
        Assert.assertEquals(6, aUserList.size());
    }

    /**
     * Tests whether the first name of the first object in the list is George.
     */
    @Test
    public void testGeorge() {
        Assert.assertEquals(new String("George"), aUserList.get(0).getFirstName());
    }

}
