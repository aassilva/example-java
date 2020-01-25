/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example.processing;

import main.java.br.example.data_structure.Data;
import main.java.br.example.data_structure.Sales;

import java.util.List;

public class Processing {

    public int quantityOfClient(List<Data> dataList){

        int quantityOfClient = 0;
        for (Data data : dataList) {
            if (data.typeData() == 2) {
                quantityOfClient++;
            }
        }

        return quantityOfClient;
    }

    public int quantityOfSalesMan(List<Data> dataList) {

        int quantityOfSalesMan = 0;
        for (Data data : dataList) {
            if (data.typeData() == 1) {
                quantityOfSalesMan++;
            }
        }

        return quantityOfSalesMan;
    }

    public int expensiveIdSales(List<Data> dataList) {

        int IdSale = -1;
        double priceSale = Double.NEGATIVE_INFINITY ;

        for (Data data : dataList) {
            if (data.typeData() == 3) {
                if (((Sales) data).totalSales() > priceSale) {
                    IdSale = ((Sales) data).getSalesId();
                    priceSale = ((Sales) data).totalSales();
                }
            }
        }

        return IdSale;
    }

    public String worseSalesMan(List<Data> dataList) {

        String salesMan = null;
        double priceSale = Double.POSITIVE_INFINITY ;

        for (Data data : dataList) {
            if (data.typeData() == 3) {
                if (((Sales) data).totalSales() < priceSale) {
                    salesMan = ((Sales) data).getSalesManName();
                    priceSale = ((Sales) data).totalSales();
                }
            }
        }

        return salesMan;
    }
}
