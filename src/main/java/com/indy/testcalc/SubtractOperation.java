package com.indy.testcalc;

/**
 * Provides the subtraction operation.
 * Here I have omitted the check to see that the operand should be more than val.
 * There are no rules for exception handling so let the exception bubble up.
 *
 */
class SubtractOperation extends MathOperation{

    public SubtractOperation(int val) {
        super(val);
    }

    @Override
    /**
     * Performs operand - val submitted during instantiation.
     * Does not check to see if operand is larger.
     */
    public int doOperation(int operand) {
        return operand - val;
    }

}
