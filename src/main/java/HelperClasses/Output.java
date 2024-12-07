package HelperClasses;

import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Output {

    public void viewAllCollections() {
        int i = 1;
        RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
        Map<String, RecordCollection> mapOfCollection = rcm.getMapOfCollection();

        if(mapOfCollection.isEmpty()){
            System.out.println("There is no created collection");
            return;
        }

        for (String name : mapOfCollection.keySet()){
            System.out.println(i + ". " + name);
            i++;
        }
        System.out.println(" ");
    }

    public void viewRecordsInCollectionWithName(String name) {
        RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
        Map<String, RecordCollection> mapOfCollection = rcm.getMapOfCollection();
        int index = 1;
        for(Record r : mapOfCollection.get(name).getCollectionList()){
            System.out.println(index + ". " + r);
            index++;
        }
        System.out.println("Duration of collection: " + mapOfCollection.get(name).getCollectionDuration() + "\n");
    }

    public void viewRecordsInCollection() {
        InputFromUser inputFromUser = new InputFromUser();
        RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
        Map<String, RecordCollection> mapOfCollection = rcm.getMapOfCollection();

        String name = inputFromUser.getCollectionName();
        int index = 1;
        try {
            for(Record r : mapOfCollection.get(name).getCollectionList()){
                System.out.println(index + ". " + r);
                index++;
            }
        }catch (NullPointerException e){
            System.out.println("There is some problem, collection may be null");
            return;
        }
        System.out.println("Duration of collection: " + mapOfCollection.get(name).getCollectionDuration() + "\n");
    }

    public void viewAllStyleInCollection(){
        RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
        RecordCollection collection = rcm.getCollection();

        Set<String> styles = new HashSet<>();
        System.out.println("Available styles:");
        for(Record r : collection.getCollectionList()){
            styles.add(r.getStyle());
        }
        System.out.println(styles);
    }
}
