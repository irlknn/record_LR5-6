package menu;

import ItemsOfMenu.findItem.FindByDuration;
import ItemsOfMenu.findItem.FindByName;
import ItemsOfMenu.findItem.FindByStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FindMenu implements menu.MenuItem {
    private Map<String, MenuItem> methods = new HashMap<>();

    public FindMenu(){
        methods.put("1", new FindByName());
        methods.put("2", new FindByStyle());
        methods.put("3", new FindByDuration());
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

            methods.getOrDefault(command, ()->{
                System.out.println("Incorrect command. Please try again");
                System.out.println("Available commands: " + getAvailableItems());
            }).execute();
        }
    }

    private void menuText(){
        System.out.println(
                """
                        1. Find by name
                        2. Find by style
                        3. Find by duration
                        0. Return to menu
                        """
        );
    }

    private Set<String> getAvailableItems(){
        return methods.keySet();
    }
}
