package marketplace;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class myFile {
    //writing seller to the file
    public static void writeToFile(String key, List<String> value, String file){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(key + " " + value);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to file " + e.getMessage());
        }
    }

    public static void createFile(String filePath){

        try {
            File file = new File(filePath);

            if(file.createNewFile()){
                System.out.println("File created");
            } else{
                System.out.println("File already exists");
            };

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
