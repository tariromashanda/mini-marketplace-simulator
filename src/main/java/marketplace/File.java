package marketplace;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class File {
    //writing seller to the file
    public static void writeToFile(String content, String filename){
        HashMap<String, List<String>> sellers = new HashMap<>();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file " + e.getMessage());
        }
    }
}
