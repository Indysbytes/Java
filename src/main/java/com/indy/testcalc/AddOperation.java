/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.testcalc;

/**
 *
 * @author indy
 */
public class AddOperation implements Operation {

    private final int val;

    public AddOperation(int val) {
        this.val = val;
    }


    @Override
    public int doOperation(int operand){

        return val+operand;
    }
}
