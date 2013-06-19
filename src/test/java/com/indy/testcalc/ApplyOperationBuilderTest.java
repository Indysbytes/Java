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
public class ApplyOperationBuilderTest {

    private ApplyOperationBuilder applyOperationBuilder;

    @Before
    public void setUp(){
        applyOperationBuilder = new ApplyOperationBuilder();

    }

    @Test
    public void shouldBuildApplyOperationClass(){
        // given
        int val = 4;

        // when
        Object actual = applyOperationBuilder.getInstance(val);

        // then
        assertTrue(actual instanceof ApplyOperation);
        assertEquals(((ApplyOperation)actual).getVal(), val);

    }

}