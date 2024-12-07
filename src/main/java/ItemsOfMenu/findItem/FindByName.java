package ItemsOfMenu.findItem;

import HelperClasses.InputFromUser;
import menu.MenuItem;
import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.RecordCollection;

public class FindByName implements MenuItem {
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
    InputFromUser inputFromUser = new InputFromUser();

    @Override
    public void execute() {
        RecordCollection collection = rcm.getCollection();
        String name = inputFromUser.getName();

        boolean noRecord = true;
        System.out.println("Find record by name");
        for(objectHierarchy.Record r : collection.getCollectionList()){
            if(r.getName().equals(name) || r.getName().contains(name)){
                System.out.println(r);
                noRecord = false;
            }
        }
        if (noRecord) {
            System.out.println("There is no records with this name");
        }
    }
}
