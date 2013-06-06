package com.indy.testcalc;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Implements the calculation as directed by the instructions submitted.
 * The operations are performed in the order they are read from the file.
 * It can be refactored to change the order here by employing a helper class.
 * 
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
        List<MathOperation> operations = initialiseOperations(instructions);

        // find the apply value and remove the apply operation, it is assumed apply is always the last instruction submitted.
        int applyValue = ((MathOperation)operations.remove(operations.size()-1)).getVal();

        result = doCalculation(operations, applyValue);

        return result;
    }

    /**
     * Convert the instructions into operations
     * @param instructions the submitted instructions
     * @return the list of operations, a linked list is used to preserve the order.
     */
    private List<MathOperation>  initialiseOperations(List<String> instructions) {
        List<MathOperation> operations = new LinkedList<>();
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

    private int doCalculation(List<MathOperation> operations, int initial) {
        int result = initial;
        try {
            for (Operation operation : operations) {
                result = operation.doOperation(result);
            }
        }
        catch (ArithmeticException ae) {
            System.out.println("Unable to perform arithmetic : "+ ae.getMessage());
            throw new IllegalArgumentException(ae);
        }
        return result;
    }

}
