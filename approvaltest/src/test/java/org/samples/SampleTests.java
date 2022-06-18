package org.samples;

import org.approvaltests.Approvals;
import org.approvaltests.JsonApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTests {

    @Test
    public void testNormalJunit() {
        assertEquals(5,5);
    }

    @Test
    public void testWithApprovalTests() {
        Approvals.verify("Hello World");
    }

    @Test
    public void testJson() {
        Person hero = new Person("nayne", "cobb", true, 38);
        JsonApprovals.verifyAsJson(hero);
    }
}
