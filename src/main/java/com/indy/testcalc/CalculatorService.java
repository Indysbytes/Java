package com.indy.testcalc;

import java.util.List;

/**
 * The definition of the calculator service.
 * 
 */
public interface CalculatorService {

    /**
     * Executes the instructions as per instructions.
     * @param instructions, the list is computations to perform.
     * @return the result of performing the instructions.
     */
    Integer performInstruction(List<String> instructions);

}
