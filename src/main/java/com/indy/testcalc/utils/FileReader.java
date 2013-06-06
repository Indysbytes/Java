package com.indy.testcalc.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * A helper class to read files.
 * Uses ENCODING of UTF_8 this can be made configurable.
 * 
 */
public class FileReader {
    public final static Charset ENCODING = StandardCharsets.UTF_8;
    public static final String EMPTY_LINE = "";

   /**
    * Reads lines from the file pointed to by the fileName value. The list is cleared of any empty lines
    * Note no validation is done here as per brief for the test.
    *
    * @param fileName
    * @return a list of Strings which are text from each line read from the file.
    * @throws IOException
    */
   public static List<String> readInstructionsFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> instructions = Files.readAllLines(path, ENCODING);
        instructions.removeAll(Arrays.asList(EMPTY_LINE, null));

        return instructions;
    }
}
