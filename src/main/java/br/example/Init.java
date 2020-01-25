/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example;

import main.java.br.example.data_structure.Data;
import main.java.br.example.processing.Processing;
import main.java.br.example.utilities.Input;
import main.java.br.example.utilities.Output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Init {

    private static List<Data> dataList = new ArrayList<Data>();
    private static List<String> paths = new ArrayList<String>();
    private static final String SEPARATOR = "ç";
    private static  final String BASE = "%HOMEPATH%/data/in/";
    private static final String ARCHIVE = "report";

    public static void main(String[] args) throws IOException {

        Input input = new Input();
        Processing processing = new Processing();
        Output output = new Output();

        try {
            paths = input.paths(BASE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (String path : paths) {

            try {
                List<String> readerArchive = input.recoverArchives(path);

                for (String line : readerArchive) {
                    Data data = input.convertToObject(line);
                    dataList.add(data);
                }
            }  catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            String out = process(processing);
            String path = BASE.replaceAll("/in/","/out/");
            path = path + ARCHIVE + ".done.dat";
            output.persistsData(path, out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static String process(Processing processing) {

        int quantityOfClient = processing.quantityOfClient(dataList);
        int quantityOfSalesMan = processing.quantityOfSalesMan(dataList);
        int expensiveIdSales = processing.expensiveIdSales(dataList);
        String worseSalesMan = processing.worseSalesMan(dataList);

        String out = Integer.toString(quantityOfClient) +
                SEPARATOR + Integer.toString(quantityOfSalesMan) +
                SEPARATOR + Integer.toString(expensiveIdSales) +
                SEPARATOR + worseSalesMan;

        return out;
    }

}
