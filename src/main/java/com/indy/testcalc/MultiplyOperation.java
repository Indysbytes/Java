/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.testcalc;

/**
 *
 * @author indy
 */
class MultiplyOperation implements Operation {
    private final int val;

    public MultiplyOperation(int val) {
        this.val = val;
    }

    @Override
    public int doOperation(int operand) {
        return operand * val;
    }

}
