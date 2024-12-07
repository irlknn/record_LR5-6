package ItemsOfMenu.sortItems;

import HelperClasses.Output;
import menu.MenuItem;
import ItemsOfMenu.RecordCollectionManager;
import objectHierarchy.Record;
import objectHierarchy.RecordCollection;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortByName implements MenuItem {
    RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
    Output output = new Output();
    Scanner input = new Scanner(System.in);

    @Override
    public void execute() {
        RecordCollection collection = rcm.getCollection();

        System.out.println("Enter name to sort by");
        String name = input.nextLine();

        collection.resetCollectionList(sortingProcessByName(collection.getCollectionList(), name));
        System.out.println("Collection was sorted");
        output.viewRecordsInCollectionWithName(collection.getName());
    }

    private List<Record> sortingProcessByName(List<objectHierarchy.Record> list, String name){
        return list.stream()
                .sorted(Comparator.comparing(
                        (objectHierarchy.Record r) -> !r.getName().equals(name) || !r.getName().contains(name)))
                .collect(Collectors.toList());
    }
}
