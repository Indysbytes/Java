package com.indy.testcalc;

/**
 * Provides the division function.
 * I have not implemented the check for division by zero.
 * It would bubble up as a RuntimeException.
 * There are various ways to trap and secure this e.g. by validating the constructor.
 * 
 */
class DivideOperation extends MathOperation{

    public DivideOperation(int val) {
        super(val);
    }

    @Override
    public int doOperation(int operand) {
        return operand / val;
    }

}
