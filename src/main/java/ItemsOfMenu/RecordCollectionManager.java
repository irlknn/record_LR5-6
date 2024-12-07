package ItemsOfMenu;

import HelperClasses.InputFromUser;
import HelperClasses.Output;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.time.LocalTime;
import java.util.*;

public class RecordCollectionManager{
    private static RecordCollectionManager rcm;
    private Map<String, RecordCollection> mapOfCollection;
    RecordCollection defaultCollection = new RecordCollection("default" , new ArrayList<>());

    InputFromUser inputFromUser = new InputFromUser();
    Output output = new Output();
    Scanner input = new Scanner(System.in);

    public RecordCollectionManager(){
        this.mapOfCollection = new HashMap<>();
    }

    public static RecordCollectionManager getRecordManager(){
        if (rcm == null){rcm = new RecordCollectionManager();}
        return rcm;
    }

    public RecordCollection getCollection(String name){
        return mapOfCollection.get(name);
    }

    public Map<String, RecordCollection> getMapOfCollection() {
        return mapOfCollection;
    }

    public RecordCollection getCollection(){

        String name = inputFromUser.getCollectionNameByIndex();
        RecordCollection collection = rcm.getCollection(name);

        while (collection == null){
            System.out.println("There is no collection with this name");
            name = inputFromUser.getCollectionName();
            collection = rcm.getCollection(name);
        }
        return collection;
    }

    public void createRecord(){
        System.out.println("Create new record:");
        String name = inputFromUser.getName();
        String style = inputFromUser.getStyle();
        LocalTime duration = inputFromUser.getDuration();

        defaultCollection.setCollectionList(new Record(name, style, duration));

        mapOfCollection.put("default", defaultCollection);
    }

    public void createCollection(){
        System.out.println("Create collection of records");
        String name = inputFromUser.getCollectionName();

        RecordCollection newCollection = new RecordCollection(name, new ArrayList<>());
        mapOfCollection.put(name, newCollection);
        System.out.println("Collection was created");
    }

    public void addRecordsToCollection(){
        if(defaultCollection.getCollectionList().isEmpty()){
            System.out.println("There is no records at all so you can`t create collection");
            return;
        }

        String name = inputFromUser.getCollectionNameByIndex();
        if(name == null){
            return;
        }
        output.viewRecordsInCollectionWithName("default");

        System.out.println("Choose records to add: (to stop enter '0')");
        int key;
        while (true){
            key = input.nextInt();
            while (key > defaultCollection.getCollectionList().size()){
                System.out.println("Index is out of bounds, try once more:");
                key = input.nextInt();
            }
            if(key == 0){
                break;
            }
            mapOfCollection.get(name).setCollectionList(defaultCollection.getRecord(key - 1));
        }
        output.viewRecordsInCollectionWithName(name);
    }

    public void deleteRecordFromCollection(){
        output.viewAllCollections();
        String name = inputFromUser.getCollectionNameByIndex();
        output.viewRecordsInCollectionWithName(name);
        System.out.println("Enter the record you want to delete");
        int index = input.nextInt() - 1;

        mapOfCollection.get(name).removeRecord(index);

        output.viewRecordsInCollectionWithName(name);
    }

    public void addRecordsFromFile(Record record) {
        defaultCollection.setCollectionList(record);
        mapOfCollection.put("default", defaultCollection);
    }

}
