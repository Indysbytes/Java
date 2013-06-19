/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.testcalc;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author indy
 */
public class MultiplyOperationBuilderTest {

    public MultiplyOperationBuilderTest() {
    }

    private MultiplyOperationBuilder multiplyOperationBuilder;

    @Before
    public void setUp(){
        multiplyOperationBuilder = new MultiplyOperationBuilder();

    }

    @Test
    public void shouldBuildMultiplyOperationClass(){
        // given
        int val = 1;

        // when
        Object actual = multiplyOperationBuilder.getInstance(val);

        // then
        assertTrue(actual instanceof MultiplyOperation);
        assertEquals(((MultiplyOperation)actual).getVal(), val);

    }

}