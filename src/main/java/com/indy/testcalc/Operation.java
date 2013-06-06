package com.indy.testcalc;

/**
 * Describes the common methods for this type.
 * 
 */
public interface Operation {

    /**
     * Perform the operation using the value passed in by operand.
     * @param operand
     * @return the result of the operation.
     */
    int doOperation(int operand);

}
