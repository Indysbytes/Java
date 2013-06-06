package com.indy.testcalc;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *
 * @author indy
 */
public class CalculatorServiceImpl implements CalculatorService {
    private final String DELIM = " ";
    private final String SUBTRACT = "Subtract";
    private final String APPLY = "Apply";
    private final String ADD = "Add";
    private final String MULTIPLY = "Multiply";
    private final String DIVIDE = "Divide";

    @Override
    public Integer performInstruction(List<String> instructions) {
        Integer result = null;

        // determine all operations described in instructions
        List<Operation> operations = initialiseOperations(instructions);

        // find and remove the apply operation
        int pos = operations.size()-1;
        Operation applyOperation = operations.get(pos);
        int initial = applyOperation.doOperation(0);
        
        result = doCalculation(operations.subList(0, pos), initial);
        return result;
    }

    private List<Operation>  initialiseOperations(List<String> instructions) {
        List<Operation> operations = new LinkedList<>();
        StringTokenizer st = null;
        String instructionType;
        String valString;

        try {
            for (String instruction : instructions) {
                st = new StringTokenizer(instruction, DELIM);
                instructionType = st.nextToken();
                valString = st.nextToken();

                if (APPLY.equalsIgnoreCase(instructionType)) {
                    operations.add(new ApplyOperation(Integer.parseInt(valString)));
                } else if (ADD.equalsIgnoreCase(instructionType)) {
                    Integer temp = Integer.parseInt(valString);
                    operations.add(new AddOperation(temp.intValue()));

                } else if (SUBTRACT.equalsIgnoreCase(instructionType)) {
                    Integer temp = Integer.parseInt(valString);
                    operations.add(new SubtractOperation(temp.intValue()));
                } else if (MULTIPLY.equalsIgnoreCase(instructionType)) {
                    Integer temp = Integer.parseInt(valString);

                    operations.add(new MultiplyOperation(temp.intValue()));
                } else if (DIVIDE.equalsIgnoreCase(instructionType)) {
                    Integer temp = Integer.parseInt(valString);
                    operations.add(new DivideOperation(temp.intValue()));
                }
            }
        }
        catch (NumberFormatException nfe) {
            System.out.println("Unable to read a number value from instructions : "+ nfe.getMessage());
            throw new IllegalArgumentException(nfe);

        }
        catch (Exception exception) {
            System.out.println("Unable to decifer the instructions : "+ exception.getMessage());
            throw new IllegalArgumentException(exception);
        }

        return operations;
    }

    private int doCalculation(List<Operation> operations, int initial) {
        for (Operation operation : operations) {
            initial = operation.doOperation(initial);
        }
        return initial;
    }

}
