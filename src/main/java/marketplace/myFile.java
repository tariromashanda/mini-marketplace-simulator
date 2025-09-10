package marketplace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.StandardCopyOption;

public class myFile {

    public static void writeToFile(String key, List<String> value, String file){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(key + ","+ " " + value);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("error writing to file " + e.getMessage());
        }
    }


    public static void overwriteInventory(String key, List<List<String>> value, String file) {
            Map<String, List<List<String>>> allData = new LinkedHashMap<>();

            File f = new File(file);

            if (f.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(" ", 2);
                        if (parts.length == 2) {
                            String seller = parts[0];
                            String itemsRaw = parts[1];

                            List<List<String>> items = new ArrayList<>();
                            items.add(List.of(itemsRaw));
                            allData.put(seller, items);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
            }

            allData.put(key, value);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(f, false))) {
                for (Map.Entry<String, List<List<String>>> entry : allData.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Error writing file: " + e.getMessage());
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

    public static Map<String, Seller> readInSeller(String file) {
        Map<String, Seller> sellerMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[\\[\\],]", "");
                String[] parts = line.split(" ");
                Seller seller = new Seller(parts[0], parts[2], parts[0], parts[3], parts[4]);
                sellerMap.put(seller.getUsername(), seller);

            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }

        return sellerMap;

    }

    public static Map<String, Buyer> readInBuyer(String file) {
        Map<String, Buyer> buyerMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[\\[\\],]", "");
                String[] parts = line.split(" ");
                Buyer buyer = new Buyer(parts[0], parts[2], parts[0], parts[3], parts[4]);
                buyerMap.put(buyer.getUsername(), buyer);

            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }

        return buyerMap;

    }

    //reads in inventory of a single seller
    public static Map<String, Inventory>  readInInventory(String file) throws FileNotFoundException {
        Map<String, Inventory> sellerInventory = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                line = line.replaceAll("[\\[\\]]", "");
                String[] parts = line.split(",");
                Inventory inventory = new Inventory();

                for(int i = 0; i < parts.length/3; i++){
                   Item item = new Item(parts[1], parts[2], parts[3]);
                   inventory.add(item);
                }

                sellerInventory.put(parts[0], inventory);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sellerInventory;

    }

    public static void updateFile(String file, String oldValue, String newValue) throws IOException {
        Path filePath = Paths.get(file);
        List<String> lines = Files.readAllLines(filePath);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains(oldValue)) {
                lines.set(i, line.replace(oldValue, newValue));
            }
        }

        Path parent = filePath.getParent() != null ? filePath.getParent() : Paths.get("");
        Path tempFilePath = Files.createTempFile(parent, "temp_", ".txt");

        Files.write(tempFilePath, lines);
        Files.move(tempFilePath, filePath, StandardCopyOption.REPLACE_EXISTING);
    }


}
