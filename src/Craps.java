import java.util.Scanner;
import java.util.Random;
public class Craps {
    static void main() {
        Scanner in = new Scanner(System.in);

        Random rand = new Random();
        int die1 = 0;
        int die2 = 0;
        int die3 = 0;
        int sum;
        int goal;
        int roll = 0;
        boolean done = false;
        boolean end = false;
        String playagain = "";
        boolean running = false;
        do {
            System.out.println("Time to roll the dice. Literally.");
            running = false;
            die1 = rand.nextInt(1, 7);
            die2 = rand.nextInt(1, 7);
            System.out.println("Neato. You rolled a " + die1 + " and a " + die2 + ".");
            sum = die1 + die2;
            done = false;
            if (sum == 2 | sum == 3 | sum == 12) {
                System.out.println("You, uh, crapped out, and rolled a " + sum + ". You lose. Man, that's a dumb thing to say");
            } else if (sum == 7 | sum == 11) {
                System.out.println("You're a natural. You rolled a " + sum + " and won already.");
            } else {
                System.out.println("Ok, you rolled a " + sum + ", now you gotta roll until you get the value you just rolled. Don't get a seven.");
                goal = sum;
                do {
                    die1 = rand.nextInt(1, 7);
                    die2 = rand.nextInt(1, 7);
                    sum = die1 + die2;
                    if (sum == 7) {
                        System.out.println("You rolled a " + sum + ", which means you lose. Nice try buddy.");
                        done = true;
                    } else if (sum == goal) {
                        System.out.println("WOW! YOU WIN! YOU ROLLED " + sum + "!");
                        done = true;
                    } else {
                        System.out.println("Aw craps. Here we go again. You rolled " + sum + ".");

                    }
                } while (!done);
            }
            System.out.println("Wanna play again? (Y/N)");
            do {
                if (in.hasNextLine()) {
                    playagain = in.nextLine();
                    if (playagain.equals("Y")) {
                        System.out.println("Ok. Cool.");
                        running = true;
                    } else if (playagain.equals("N")) {
                        System.out.println("Ok. Seeya.");
                        running = true;
                        end = true;
                    } else {
                        System.out.println("Ok clearly you didn't do something right. Try again");
                    }
                }
            } while (!running);

        } while (!end);
        System.out.print("99 percent of gamblers quit right before they're about to win big... just saying.");
    }
}