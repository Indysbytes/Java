package com.indy.testcalc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddOperationBuilderTest {

    private AddOperationBuilder addOperationBuilder;

    @Before
    public void setUp(){
        addOperationBuilder = new AddOperationBuilder();

    }

    @Test
    public void shouldBuildAddOperationClass(){
        // given
        int val = 5;

        // when
        Object actual = addOperationBuilder.getInstance(val);

        // then
        assertTrue(actual instanceof AddOperation);
        assertEquals(((AddOperation)actual).getVal(), val);

    }

}
