/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example.utilities;
import main.java.br.example.data_structure.*;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public Data convertToObject(String data, List<Data> dataList) {

        String[] listDates = data.split("ç");
        String key = listDates[0];
        Data object = null;
        switch (key){
            case "001":
                object = new SalesMan();
                ((SalesMan) object).setCpf(listDates[1]);
                ((SalesMan) object).setName(listDates[2]);
                ((SalesMan) object).setSalary(Double.parseDouble(listDates[3]));
                break;
            case "002":
                object = new Client();
                ((Client) object).setCnpj(listDates[1]);
                ((Client) object).setName(listDates[2]);
                ((Client) object).setBusinessArea(listDates[3]);
                break;
            case "003":
                object = new Sales();
                ((Sales) object).setSalesId(Integer.parseInt(listDates[1]));
                String[] temporary = listDates[2].split(",");
                List<Item> itens = new ArrayList<Item>();
                for (String temp : temporary) {
                    temp = temp.replaceAll("]", "").replace("[", "");;
                    String[] listItens = temp.split("-");
                    Item item = new Item();
                    item.setItemId(Integer.parseInt(listItens[0]));
                    item.setQuantityItem(Integer.parseInt(listItens[1]));
                    item.setPrice(Double.parseDouble(listItens[2]));
                    itens.add(item);
                }
                ((Sales) object).setItens(itens);
                SalesMan salesMan = new SalesMan();
                salesMan = searchSalesMan(listDates[3], dataList);
                if (salesMan == null) {
                    salesMan.setName(listDates[3]);
                }
                ((Sales) object).setSalesManName(salesMan);
                break;
        }
        return object;
    }

    private static SalesMan searchSalesMan(String name, List<Data> dataList) {

        for (Data obj : dataList) {

            if (obj.typeData() == 1) {
                if (((SalesMan) obj).getName().equals(name))
                    return (SalesMan) obj;
            }
        }

        return  null;
    }

}
