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
public class DivideOperationBuilderTest {

    private DivideOperationBuilder divideOperationBuilder;

    @Before
    public void setUp(){
        divideOperationBuilder = new DivideOperationBuilder();

    }

    @Test
    public void shouldBuildDivideOperationClass(){
        // given
        int val = 3;

        // when
        Object actual = divideOperationBuilder.getInstance(val);

        // then
        assertTrue(actual instanceof DivideOperation);
        assertEquals(((DivideOperation)actual).getVal(), val);

    }

}