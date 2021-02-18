import java.util.Scanner;

public class Menu {

    public String settings;

    public Menu() {
        this.settings = "normal";
    }

    public static void introduction() {
        System.out.println("Until Victory!\n" +
                "1 to start the game\n" +
                "2 exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("Good luck!");
                StartGame game = new StartGame();
                if (game.win)
                    System.out.println("You win this game!");
                else
                    System.out.println("You dead");
                return;
            }
            case 2: {
                System.out.println("Good bye! Have a nice day)");
                return;
            }
        }
        System.out.println("input existing option\n");
        introduction();
    }

    public static void main(String[] args) {
        introduction();
    }

}
