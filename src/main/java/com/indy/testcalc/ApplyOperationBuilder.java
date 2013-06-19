/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indy.testcalc;


public class ApplyOperationBuilder implements OperationBuilder {

    @Override
    public MathOperation getInstance(int val) {
        return new ApplyOperation(val);
    }

}
