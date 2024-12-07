package ItemsOfMenu.fileWork;

import menu.MenuItem;
import objectHierarchy.Record;
import ItemsOfMenu.RecordCollectionManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileRead implements MenuItem {
    int NUM_OF_PARAMETERS_IN_ONE_RECORD = 3;
    File folder = new File("D:\\file\\record application");
    File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
    DateTimeFormatter parseFormat = new Record().getTimeFormat();

    @Override
    public void execute() {
        System.out.println("Read date from file");
        if (files == null || files.length == 0){
            System.out.println("There is no saved files");
            return;
        }

        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }
        System.out.println("Choose file(enter the number of file): ");

        Scanner input = new Scanner(System.in);
        int index = input.nextInt();

        while (index < 1 || index > files.length){
            System.out.println("There is no such file, try once more: ");
            index = input.nextInt();
        }

        File file = files[index - 1];
        readDateFromFile(file);
    }

    private void readDateFromFile(File file){
        try(BufferedReader buffer = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = buffer.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == NUM_OF_PARAMETERS_IN_ONE_RECORD){
                    String name = parts[0].trim();
                    String style = parts[1].trim();
                    String time = parts[2].trim();
                    LocalTime duration = LocalTime.parse(time, parseFormat);
                    Record r = new Record(name, style, duration);
                    rcm.addRecordsFromFile(r);
                }
            }
        }catch (IOException e){
            System.err.println("Exception in reading file: " + e.getMessage());
        } catch (NumberFormatException e){
            System.err.println("Exception " + e.getMessage());
        }
        System.out.println("Records have been added to the program");
    }

}
