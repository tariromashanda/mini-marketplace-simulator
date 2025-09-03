package marketplace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.StandardCopyOption;

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

    public static void updateFile(String file, String oldValue, String newValue) throws IOException {
        System.out.println(oldValue+ "old value");
        System.out.println(newValue+ "new value");
        Path filePath = Paths.get(file);
        List<String> lines = Files.readAllLines(filePath);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            System.out.println(lines.get(i)+"i");
            if (line.contains(oldValue)) {
                lines.set(i, line.replace(oldValue, newValue));
            }
        }

        // Fix: handle null parent
        Path parent = filePath.getParent() != null ? filePath.getParent() : Paths.get("");
        Path tempFilePath = Files.createTempFile(parent, "temp_", ".txt");

        Files.write(tempFilePath, lines);
        Files.move(tempFilePath, filePath, StandardCopyOption.REPLACE_EXISTING);
    }


}
