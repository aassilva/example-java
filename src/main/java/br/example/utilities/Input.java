package main.java.br.example.utilities;

import main.java.br.example.data_structure.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<String> recoverArchives(String file) throws IOException {

        Charset utf8 = Charset.forName("UTF-8");
        Path archive = Paths.get(file);
        List<String> files = Files.readAllLines(archive, utf8);

        return files;
    }

    public List<String> paths(String base){

        List<String> paths =  new ArrayList<String>();
        File file = new File(base);
        File[] archives = file.listFiles();

        for (File archive : archives) {
            if (archive.getName().contains(".dat"))
                paths.add(archive.getPath());
        }
        return paths;
    }


    public Data convertToObject(String data) {

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
                ((Sales) object).setSalesManName(listDates[3]);
                break;
        }
        return object;
    }

}
