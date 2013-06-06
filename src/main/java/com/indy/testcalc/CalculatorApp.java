package com.indy.testcalc;

import com.indy.testcalc.utils.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main entry point for the calculation service.
 *
 * I did this with limited time please ask for details if not sure about anything.
 *
 * This is done using Netbeans 7.2 on an Ubuntu 12.04 LTS OS with JDK 1.7. and Maven 3.
 *
 * Assumptions:
 * - The input validation is deferred for later.
 * - The values would be small so I used Integers and int, instead of BigDecimal, Double, Float etc.
 * - I have ignored MATH precedence like BODMAS in the view that the order of the instructions was important as per brief.
 * - I have shown little Exception handling but the principle is demonstrated.
 * - I have ignored validation of operations like division by zero, smaller number should be subtracted from larger as the are no
 *   rules for exception handling I thought it better to leave it to bubble to the top. There are  catch all handlers.
 *   These type of errors should be trapped during data input/capture not late in the operations.
 * - I have only implemented the basic add, subtract, Multiply and Divide, but the solution provides to scalability so
 *   one can continue to add operations like, power, square root etc.
 *
 *
 * It should be pointed out that this app does not guarantee thread safety, this was not in the brief.
 * I did not use DI or use third party software like Spring I did not think it was warranted however I am happy
 * use it to demonstrate it if required.
 * I wanted to use as little code/third party software as possible.
 * The tests are in the src/test/java directory.
 *
 * How to run the app.
 * I have used the assembly pluggin so you can run this from the cmd line with Maven.
 * After extracting to a directory you should see:
 *       src
 *       simpleAdd.txt
 *       pom.xml
 *
 * run Maven
 * $ maven clean install
 * then you should see the target directory.
 * make sure the TestCalc-1.0-RELEASE.jar file in the target directory has run permissions. (sudo chmod +x target/TestCalc-1.0-RELEASE.jar)
 * then run the app supplying the file with instructions [I have supplied simpleAdd.txt].
 *
 * $ java -jar target/TestCalc-1.0-RELEASE.jar CalculatorApp "simpleAdd.txt"
 * 
 *
 */
public class CalculatorApp{
    
    public static void main( String[] args )   {
        System.out.println( "----------------------------------------------------------" );
        try {
            System.out.println( "Reading file" );
            List<String> instructions = FileReader.readInstructionsFromFile(args[1]);

            CalculatorService calculatorService = new CalculatorServiceImpl();
            System.out.println( "Performing calculation..." );
            Integer calResult = calculatorService.performInstruction(instructions);

            System.out.println( "Result :" + calResult);

            
        }
        catch (IOException ex) {
            System.out.println("Unable to read the sumbited file. :" + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Unable to perform the calculation. :" + ex.getMessage());
        }
        System.out.println( "----------------------------------------------------------" );
    }
}
