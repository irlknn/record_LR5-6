package menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ItemsOfMenu.sortItems.SortByName;
import ItemsOfMenu.sortItems.SortByStyle;
import ItemsOfMenu.sortItems.SortByTimeDecreasing;
import ItemsOfMenu.sortItems.SortByTimeIncreasing;

public class SortMenu implements MenuItem {
    private Map<String, MenuItem> menuItems;

    public SortMenu(){
        menuItems = new HashMap<>();
        menuItems.put("1", new SortByName());
        menuItems.put("2", new SortByStyle());
        menuItems.put("3", new SortByTimeDecreasing());
        menuItems.put("4", new SortByTimeIncreasing());
    }

    @Override
    public void execute() {
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
                        1. By name
                        2. By style
                        4. By author
                        3. By decreasing of time
                        4. By increasing of time
                        0. Return to menu
                        """
        );
    }

    private Set<String> getAvailableItems(){
        return menuItems.keySet();
    }

}
