package ItemsOfMenu.findItem;

import HelperClasses.InputFromUser;
import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.RecordCollection;

import java.util.Scanner;

public class FindByStyle implements menu.MenuItem {
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();

    @Override
    public void execute() {
        RecordCollection collection = rcm.getCollection();
        InputFromUser inputFromUser = new InputFromUser();

        String style = inputFromUser.getStyle();
        boolean noRecord = true;
        System.out.println("Find record by style");
        for(objectHierarchy.Record r : collection.getCollectionList()){
            if(r.getStyle().equals(style) || r.getStyle().contains(style)){
                System.out.println(r);
                noRecord = false;
            }
        }
        if (noRecord) {
            System.out.println("There is no records with this style");
        }
    }
}
