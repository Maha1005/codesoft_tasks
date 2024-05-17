import java.util.Scanner;
import java.util.Random;
public class task1{
    public static int getnum() {
        Scanner sc = new Scanner(System.in);
        int guessnum = sc.nextInt();
        return guessnum;
    }

    public static int diff(int gn, int on) {
        int dn;
        if (gn > on) {
            dn = gn - on;
            return dn;
        } else {
            dn = on - gn;
            return dn;
        }
    }
    public static void status(int diffnum) {
        if (diffnum <= 10) {
            System.out.println("You are nearly close to the number");
        } else if (diffnum <= 30) {
            System.out.println("You are somewhat away from the number");
        } else if (diffnum <= 50) {
            System.out.println("You are away from the number");
        } else {
            System.out.println("You are very far away from the number");
        }
    }

    public static void main(String[] args) {
                 //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
            // to see how IntelliJ IDEA suggests fixing it.
            Random random = new Random();
            int guessnum;
            int count = 0;
            int orinum = random.nextInt(1, 100);
            System.out.println("There are three chances.Guess a number between 1 to 100:");
            for (int i = 3; i > 0; i--) {
                System.out.println("chance left :" + i);
                guessnum = getnum();
                if (guessnum > 100 || guessnum < 0) {
                    System.out.println("The entered number is incorrect");
                    break;
                } else {
                    if (guessnum == orinum) {
                        System.out.println("Congrats !Your guess is correct");
                        count++;
                        break;
                    } else {
                        int difnum = diff(guessnum, orinum);
                        status(difnum);
                    }

                }
                if (count == 0 && i == 1) {
                    System.out.println("Oops ! You lost your chance.");
                    System.out.println("The original number is :" + orinum);
                }
            }

        }
    }

   