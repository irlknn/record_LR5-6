package objectHierarchy;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RecordCollection {
    private String name;
    private List<objectHierarchy.Record> collectionList; //= new ArrayList<>();
    private LocalTime collectionDuration;

    public RecordCollection(String name, List<objectHierarchy.Record> collection) {
        this.name = name;
        this.collectionList = collection;
        this.collectionDuration = countCollectionDuration();
    }

    public LocalTime getCollectionDuration() {return collectionDuration;}

    public List<objectHierarchy.Record> getCollectionList(){return collectionList;}

    public objectHierarchy.Record getRecord(int index){return collectionList.get(index);}

    public String getName() {return name;}

    public void setCollectionList(objectHierarchy.Record newRecord){
        this.collectionList.add(newRecord);
        this.collectionDuration = countCollectionDuration();
    }

    public void resetCollectionList(List<objectHierarchy.Record> list){
        this.collectionList = list;
    }

    private LocalTime countCollectionDuration() {
        LocalTime total = LocalTime.parse("00:00:00");

        for (Record r : collectionList) {
            LocalTime d = r.getDuration();
            total = total.plusHours(d.getHour())
                    .plusMinutes(d.getMinute())
                    .plusSeconds(d.getSecond());
        }
        return total;
    }

    public void removeRecord(int index) {
        collectionList.remove(index);
    }

}
