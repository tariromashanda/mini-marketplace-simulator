package marketplace;

import java.io.*;
import java.util.*;

public class myFile {
    //writing seller to the file
    public static void writeToFile(String key, List<String> value, String file){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(key + " " + value);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("error writing to file " + e.getMessage());
        }
    }

    public static void writeToInventory(String key, List<List <String>> value, String file){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(key + " " + value);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("error writing to file " + e.getMessage());
        }
    }

    public static void createFile(String filePath){

        try {
            File file = new File(filePath);

            if(file.createNewFile()){
                System.out.printf(" %s file created%n", filePath);
            } else{
                System.out.printf(" %s already exists%n", filePath);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<String>> readInData(String filepath){
        Map <String, List<String>> map = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = null;
            while((line.equals(reader.readLine()))){
                String[] parts = line.split(" ",2);
                    String username = parts[0].trim();
                    String attributes = parts[1].trim();
                    map.put(username, Collections.singletonList(attributes));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

}
