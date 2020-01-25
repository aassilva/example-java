/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example.data_structure;

import java.util.ArrayList;
import java.util.List;

public class Sales implements Data {

    private final int TYPE_DATA = 003;
    private int salesId;
    private List<Item> itens = new ArrayList<Item>();
    private SalesMan salesMan;

    @Override
    public int typeData() {
        return TYPE_DATA;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public SalesMan getSalesMan() {
        return salesMan;
    }

    public void setSalesManName(SalesMan salesMan) {
        this.salesMan = salesMan;
    }

    public double totalSales() {

        double sales = 0;
        for (Item item : itens) {
            sales += item.totalPrice();
        }
        return sales;
    }
}
