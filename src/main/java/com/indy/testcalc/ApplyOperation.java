package com.indy.testcalc;

/**
 * Provides the apply operation.
 * This is a special case as the implied intention is to keep this
 * as though it is an operation.
 *
 */
public class ApplyOperation extends MathOperation {


    public ApplyOperation(int val) {
        super(val);
    }

    @Override
    public int doOperation(int operand) {
        return val;
    }

}
