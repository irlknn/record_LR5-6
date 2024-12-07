package ItemsOfMenu.findItem;

import HelperClasses.InputFromUser;
import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.time.LocalTime;

public class FindByDuration implements menu.MenuItem{
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
    InputFromUser inputFromUser = new InputFromUser();

    @Override
    public void execute() {
        RecordCollection collection = rcm.getCollection();

        LocalTime duration = inputFromUser.getDuration();
        boolean noRecord = true;
        System.out.println("Find record by duration");
        for(Record r : collection.getCollectionList()){
            if(r.getDuration().equals(duration)){
                System.out.println(r);
                noRecord = false;
            }
        }
        if (noRecord) {
            System.out.println("There is no records with this duration");
        }
    }
}
