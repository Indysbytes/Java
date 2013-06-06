package com.indy.testcalc;

/**
 * Provides the addition operation.
 * 
 */
public class AddOperation extends MathOperation {

    public AddOperation(int val) {
        super(val);
    }

    @Override
    public int doOperation(int operand) {
        return operand + val;
    }
}
