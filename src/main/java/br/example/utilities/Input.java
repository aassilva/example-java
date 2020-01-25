/*
 * Copyright (c) 2020.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package main.java.br.example.utilities;

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

}
