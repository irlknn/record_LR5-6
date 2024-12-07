package ItemsOfMenu.sortItems;

import HelperClasses.InputFromUser;
import HelperClasses.Output;
import menu.MenuItem;
import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.util.*;
import java.util.stream.Collectors;

public class SortByStyle implements MenuItem {
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
    Output output = new Output();

    @Override
    public void execute() {
        RecordCollection collection = rcm.getCollection();
        InputFromUser inputFromUser = new InputFromUser();

        output.viewAllStyleInCollection();
        String style = inputFromUser.getStyle();

        collection.resetCollectionList(sortingProcessByStyle(collection.getCollectionList(), style));
        System.out.println("Collection was sorted");
        output.viewRecordsInCollectionWithName(collection.getName());
    }

    private List<Record> sortingProcessByStyle(List<objectHierarchy.Record> list, String style){
        return list.stream()
                .sorted(Comparator.comparing(
                        (objectHierarchy.Record r) -> !r.getStyle().equals(style)))
                .collect(Collectors.toList());
    }
}
