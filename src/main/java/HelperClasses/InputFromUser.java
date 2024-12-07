package HelperClasses;

import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;

public class InputFromUser {
    Scanner input = new Scanner(System.in);
    Output output = new Output();

    public String getName() {
        System.out.println("Enter name:");
        return input.nextLine();
    }

    public String getCollectionName(){
        System.out.println("Enter name of collection:");
        return input.nextLine();
    }

    public String  getCollectionNameByIndex(){
        RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
        Map<String, RecordCollection> mapOfCollection = rcm.getMapOfCollection();

        if(mapOfCollection.isEmpty()){
            System.out.println("There is no collection");
            return null;
        }

        output.viewAllCollections();
        System.out.println("Enter index of collection: ");
        int index = input.nextInt();
        while (index > mapOfCollection.size()){
            System.out.println("Index is out of boundaries");
            index = input.nextInt();
        }

        int i = 1;
        String name = "";
        for(String n : mapOfCollection.keySet()){
            if(i == index){
                name = n;
            }
            i++;
        }
        return name;
    }

    public String getStyle(){
        System.out.println("Enter style:");
        return input.nextLine();
    }

    public LocalTime getDuration(){
        System.out.println("Enter duration: (in format h:mm:ss)");
        LocalTime result = null;
        while (result == null) {
            try {
                String time = input.nextLine();
                objectHierarchy.Record r = new Record();
                DateTimeFormatter parseFormat = r.getTimeFormat();
                result = LocalTime.parse(time, parseFormat);
            } catch (DateTimeParseException e) {
                System.out.println("False format enter again");
            }
        }
        return result;
    }

}
