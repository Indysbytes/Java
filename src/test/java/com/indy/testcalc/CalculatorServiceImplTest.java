package com.indy.testcalc;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorService;

    @Before
    public void setUp(){
        calculatorService = new CalculatorServiceImpl();

    }

    @Test
    public void simpleApplyOnly() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("apply 7");
        Integer expected = new Integer(7);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 7", actual.equals(expected));
    }

    @Test
    public void simpleAdd() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("add 5");
        instructions.add("apply 3");
        Integer expected = new Integer(8);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 8 (3+5)", actual.equals(expected));

    }

    @Test
    public void simpleSubtract() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("subtract 5");
        instructions.add("apply 8");
        Integer expected = new Integer(3);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 3 (8-5)", actual.equals(expected));
    }

    @Test
    public void simpleMultiply() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("multiply 3");
        instructions.add("apply 5");
        Integer expected = new Integer(15);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 15 (5*3)", actual.equals(expected));
    }

    @Test
    public void simpleDivision() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("divide 3");
        instructions.add("apply 24");
        Integer expected = new Integer(8);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 8 (24/3)", actual.equals(expected));
    }

    @Test
    public void compoundAddSub() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("add 3");
        instructions.add("subtract 5");
        instructions.add("apply 7");
        Integer expected = new Integer(5);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 5 (7+3-5)", actual.equals(expected));
    }

    @Test
    public void compoundAddSubMultiply() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("add 3");
        instructions.add("subtract 5");
        instructions.add("multiply 2");
        instructions.add("apply 7");
        Integer expected = new Integer(10);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 10 (7+3-5*2)", actual.equals(expected));
    }

    @Test
    public void compoundAddSubMultiplyDivide() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("add 3");
        instructions.add("subtract 5");
        instructions.add("multiply 2");
        instructions.add("divide 10");
        instructions.add("apply 7");
        Integer expected = new Integer(1);

        // when
        Integer actual = calculatorService.performInstruction(instructions);

        //then
        assertTrue("Should produce 1 (7+3-5*2/10)", actual.equals(expected));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyInstruction() {
        // given
        List<String> instructions = new ArrayList<>();
        instructions.add("");

        // when
        Integer actual = calculatorService.performInstruction(instructions);

    }

}
