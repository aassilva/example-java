/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example.processing;

import main.java.br.example.data_structure.Data;
import main.java.br.example.data_structure.Sales;
import main.java.br.example.data_structure.SalesMan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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

        Map<SalesMan, Double> priceSale = new HashMap<SalesMan, Double>();
        double price = Double.POSITIVE_INFINITY ;
        SalesMan name = new SalesMan();
        SalesMan salesMan = new SalesMan();

        for (Data data : dataList) {
            if (data.typeData() == 3) {

                salesMan = ((Sales) data).getSalesMan();

                if (priceSale.containsKey(salesMan)){
                    double temporary = priceSale.get(salesMan);
                    temporary = temporary + ((Sales) data).totalSales();
                    priceSale.put(salesMan, temporary);
                } else {
                    double temporary = ((Sales) data).totalSales();
                    priceSale.put(salesMan, temporary);
                }
            }
        }

        Set<Entry<SalesMan, Double>> set = priceSale.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Entry<SalesMan, Double> entry = (Entry)it.next();
            double temporary = entry.getValue();

            if (temporary < price) {
                name = entry.getKey();
                price = temporary;
            }
        }


        return name.getName();
    }
}
