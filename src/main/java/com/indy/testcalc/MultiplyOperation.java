package com.indy.testcalc;

/**
 * Provides the multiplication operation.
 *
 */
class MultiplyOperation extends MathOperation{

    public MultiplyOperation(int val) {
        super(val);
    }

    @Override
    public int doOperation(int operand) {
        return operand * val;
    }

}
