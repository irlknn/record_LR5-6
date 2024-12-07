package menu;

import ItemsOfMenu.fileWork.FileRead;
import ItemsOfMenu.ExitItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StartMenu {
    private Map<String, MenuItem> menuItems;

    public StartMenu(){
        menuItems = new HashMap<>();
        menuItems.put("1", new FileRead());
        menuItems.put("2", new OperationMenu());
        menuItems.put("0", new ExitItem());
    }

    public void executeCommand(String command){
        menuItems.getOrDefault(command, ()->{
            System.out.println("Incorrect command. Please try again");
            System.out.println("Available commands: " + getAvailableItems());
        }).execute();
    }

    private Set<String> getAvailableItems(){
        return menuItems.keySet();
    }

    public void menuText(){
        System.out.println("""
                Available commands:\s
                1. Read from file
                2. Operate with records
                0. Exit
                """);
    }

}
