package com.indy.testcalc;

/**
 * This forms the basis of all Math operations.
 * Many types of Math operations(Addition, multiplication etc.), would simply extend this class.
 * 
 * 
 */
public abstract class MathOperation implements Operation {
    protected final int val;

    public MathOperation(int val) {
        this.val = val;
    }

    @Override
    public abstract int doOperation(int operand);

    /**
     * Returns the value this class was initialise with.
     * @return
     */
    public int getVal() {
        return val;
    }
}
