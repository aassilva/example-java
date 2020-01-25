/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example.utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Output {

    public void persistsData(String directory, String data) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter pw = new PrintWriter(directory, "UTF-8");
        pw.write(data);
        pw.close();
    }
}
