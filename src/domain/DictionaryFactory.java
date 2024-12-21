package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DictionaryFactory {


    public static void main(String[] args) throws IOException {
        File from = new File("C:\\Users\\favya\\Princeton\\DsII\\boggle\\common.txt");
        File to = new File("src\\dict.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;


        try {
            br = Files.newBufferedReader(Paths.get("C:\\Users\\favya\\Princeton\\DsII\\boggle\\dictionary-common.txt"));
            bw = Files.newBufferedWriter(Paths.get("src\\dict.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.length() == 5) bw.write(line + '\n');
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            assert br != null;
            assert bw != null;
            br.close();
            bw.flush();
        }


        System.out.println("read from " + from.getName() + " to " + to.getName());
    }
}
