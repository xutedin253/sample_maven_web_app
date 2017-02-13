/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * Parameterized Test Example
 * 
 * @author wlloyd
 */
@RunWith(Parameterized.class)
public class UserTestParam {
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { {"Fred","Fred"}, {"Joe","Joe"}, {"Susan","Susan"}, {"Mary","Mary"},
                                              {"Sarah","Sarah"}, {"Sally","Sally"},{"Andrew","Andrew"},{"David","David"}});
    }
    
    @Before
    public void init() {
        fUser = new User();
    }
    
    private String fInput;
    private String fExpected;
    private User fUser;
    public UserTestParam(String input, String expected) {
        fInput = input;
        fExpected = expected;
    }
    
    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        fUser.setName(fInput);
        assertEquals(fExpected, fUser.getName());
    }

    
}
