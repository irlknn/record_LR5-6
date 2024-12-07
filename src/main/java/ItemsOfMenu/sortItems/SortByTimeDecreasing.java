package ItemsOfMenu.sortItems;

import HelperClasses.Output;
import menu.MenuItem;
import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.util.Comparator;
import java.util.List;

public class SortByTimeDecreasing implements MenuItem {
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
    Output output = new Output();

    @Override
    public void execute(){
        RecordCollection collection = rcm.getCollection();

        List<Record> list = collection.getCollectionList();
        list.sort(Comparator.comparing(objectHierarchy.Record::getDuration).reversed());
        collection.resetCollectionList(list);
        output.viewRecordsInCollectionWithName(collection.getName());
    }
}
