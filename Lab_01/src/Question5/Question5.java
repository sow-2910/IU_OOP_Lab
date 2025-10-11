package Question5;


import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

class Player {
    private String choice;
    private int bet;
    private int wallet;

    public Player(int wallet) {
        this.wallet = wallet;
    }

    public int getBet() {
        return this.bet;
    }

    public void setBet() {
        Scanner scanner = new Scanner(System.in);
        this.bet = scanner.nextInt();
    }

    public String getChoice() {
        return this.choice;
    }

    public void setChoice(int choice) {
        switch (choice) {
            case 1 -> this.choice = "big";
            case 2 -> this.choice = "small";
            default -> this.choice = "Invalid input";
        }
    }

    public int getWallet() {
        return this.wallet;
    }

    public void addWallet(int money) {
        this.wallet += money;
    }
}


class Dice {
    private int value;

    public Dice() {
        roll();
    }

    public void roll() {
        Random r = new Random();
        this.value = r.nextInt(1, 6);
    }

    public int getValue() {
        return this.value;
    }
}


class House {
    private static final byte MIN_SMALL = 4;
    private static final byte MAX_SMALL = 10;
    private static final byte MIN_BIG = 11;
    private static final byte MAX_BIG = 17;
    private final Dice[] dices = new Dice[3];
    private int wallet;

    public House(int wallet) {
        this.wallet = wallet;

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }
    }

    public void rollDices() {
        for (Dice dice : dices) {
            dice.roll();
        }
    }

    public void printDices() {
        System.out.printf("The dices are: %d %d %d\n", dices[0].getValue(), dices[1].getValue(), dices[2].getValue());
    }

    public int sumDices() {
        int sum = 0;
        for (Dice dice : dices) {
            sum += dice.getValue();
        }
        return sum;
    }

    public String checkDicesResult() {
        int dice1 = dices[0].getValue();
        int dice2 = dices[1].getValue();
        int dice3 = dices[2].getValue();
        int sum = dice1 + dice2 + dice3;
        if (dice1 == dice2 && dice1 == dice3) {
            return "same";
        }
        if (sum >= MIN_SMALL && sum <= MAX_SMALL) {
            return "small";
        }
        if (sum >= MIN_BIG && sum <= MAX_BIG) {
            return "big";
        } else {
            return "nothing";
        }
    }

    public int getWallet() {
        return wallet;
    }

    public void addWallet(int amount) {
        this.wallet += amount;
    }


}


public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        House house_Wallet_Start = new House(1000000);
        System.out.println("Enter the amount of money you have: ");
        int Player_Wallet_Start = scanner.nextInt();
        scanner.nextLine();
        Player player = new Player(Player_Wallet_Start);
        System.out.printf("The house has %d\n", house_Wallet_Start.getWallet());
        System.out.printf("The player has %d\n", Player_Wallet_Start);


        int counter = 1;
        while (player.getWallet() > 0) {
            System.out.printf("Round %d\n", counter);
            System.out.println("How much do you want to bet?");
            player.setBet();
            if (player.getBet() <= player.getWallet()) {


                System.out.printf("You have bet $%d\n", player.getBet());

                System.out.println("What do you want to bet?(1 for big/ 2 for small)");
                int n = scanner.nextInt();
                player.setChoice(n);
                house_Wallet_Start.rollDices();
                house_Wallet_Start.printDices();
                System.out.printf("The sum of 3 dices is %d!\n", house_Wallet_Start.sumDices());

                String result_home = house_Wallet_Start.checkDicesResult();
                if (result_home.equals("same")) {
                    System.out.printf("You lost %d\n", player.getBet());
                    player.addWallet(-player.getBet());
                    house_Wallet_Start.addWallet(player.getBet());
                } else if (!Objects.equals(result_home, player.getChoice())) {
                    System.out.printf("You lost %d\n", player.getBet());
                    player.addWallet(-player.getBet());
                    house_Wallet_Start.addWallet(player.getBet());
                } else {
                    System.out.printf("You won %d\n", player.getBet());
                    player.addWallet(player.getBet());
                    house_Wallet_Start.addWallet(-player.getBet());
                }

                System.out.printf("The house has %d\n", house_Wallet_Start.getWallet());
                System.out.printf("The player has %d\n", player.getWallet());
                if (player.getWallet() == 0) {
                    System.out.println("You are out of money! Bye!");
                    break;
                }
                scanner.nextLine();
                boolean validAnswer;
                do {
                    System.out.println("Do you still want to continue to play?(Yes/No)");
                    String continue_to_play = scanner.nextLine();
                    String answer = continue_to_play.toLowerCase();
                    validAnswer = true;
                    if (answer.equals("yes")) {
                        System.out.println("\n");
                        counter++;
                    } else if (answer.equals("no")) {
                        break;
                    } else {
                        System.out.println("Your answer must be Yes or No");
                        validAnswer = false;
                    }
                } while (!validAnswer);
            } else {
                System.out.println("You do not have enough money!");
                System.out.println("The amount of money you bet: " + player.getBet());
                System.out.println("The amount of money you have: " + player.getWallet());
            }

        }

        scanner.close();
    }
}

