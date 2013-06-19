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
public class SubtractOperationBuilderTest {

    private SubtractOperationBuilder subtractOperationBuilder;

    @Before
    public void setUp(){
        subtractOperationBuilder = new SubtractOperationBuilder();

    }

    @Test
    public void shouldBuildSubtractOperationClass(){
        // given
        int val = 2;

        // when
        Object actual = subtractOperationBuilder.getInstance(val);

        // then
        assertTrue(actual instanceof SubtractOperation);
        assertEquals(((SubtractOperation)actual).getVal(), val);

    }

}