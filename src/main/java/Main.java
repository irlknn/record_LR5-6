import menu.StartMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StartMenu mainMenu = new StartMenu();

        Scanner input = new Scanner(System.in);

        while (true){
            mainMenu.menuText();
            System.out.println("Write your command: ");
            mainMenu.executeCommand(input.nextLine());
        }
    }
}
