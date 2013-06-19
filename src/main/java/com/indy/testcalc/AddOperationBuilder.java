package com.indy.testcalc;

import com.indy.testcalc.AddOperation;
import com.indy.testcalc.MathOperation;

public class AddOperationBuilder implements OperationBuilder{

    @Override
    public MathOperation getInstance(int val) {
        return new AddOperation(val);
        
    }

}
