package menu;
import HelperClasses.Output;
import ItemsOfMenu.fileWork.LoadToFile;
import ItemsOfMenu.RecordCollectionManager;

import java.util.*;

public class OperationMenu implements MenuItem{
    private Map<String, MenuItem> menuItems;

    public OperationMenu(){
        menuItems = new HashMap<>();
        Output output = new Output();
        RecordCollectionManager rcm = RecordCollectionManager.getRecordManager();
        menuItems.put("1", rcm::createRecord);
        menuItems.put("2", rcm::createCollection);
        menuItems.put("3", rcm::addRecordsToCollection);
        menuItems.put("4", new FindMenu());
        menuItems.put("5", new SortMenu());
        menuItems.put("6", new LoadToFile());
        menuItems.put("7", output::viewAllCollections);
        menuItems.put("8", output::viewRecordsInCollection);
        menuItems.put("9", rcm::deleteRecordFromCollection);
    }

    @Override
    public void execute(){
        Scanner input = new Scanner(System.in);

        while (true){
            menuText();
            String command = input.nextLine();
            if(command.equals("0")) {
                break;
            }
            menuItems.getOrDefault(command, ()->{
                System.out.println("Incorrect command. Please try again");
                System.out.println("Available commands: " + getAvailableItems());
            }).execute();
        }
    }

    private void menuText(){
        System.out.println(
                """
                        1. Create record
                        2. Create collection
                        3. Add record to collection
                        4. Find record by ...
                        5. Sort by ...
                        6. Save collection to file
                        7. View all created collection
                        8. View records in collection
                        9. Delete record from collection
                        0. Return to main menu
                        Write your command:
                        """);
    }

    private Set<String> getAvailableItems(){
        return menuItems.keySet();
    }
}

//    private Set<String> getAvailableItems(){
//        return commands.keySet();
//    }
