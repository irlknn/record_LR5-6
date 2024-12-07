package ItemsOfMenu;

import menu.MenuItem;

public class ExitItem implements MenuItem {
    @Override
    public void execute() {
        System.out.println("Exiting program");
        System.exit(0);
    }
}
