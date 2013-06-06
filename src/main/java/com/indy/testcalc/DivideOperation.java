/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.testcalc;

/**
 *
 * @author indy
 */
class DivideOperation implements Operation {
    private final int val;

    public DivideOperation(int val) {
        this.val = val;
    }

    @Override
    public int doOperation(int operand) {
        return operand / val;
    }

}
