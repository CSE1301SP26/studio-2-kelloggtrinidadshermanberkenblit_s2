import java.util.Scanner;

public class Ruin {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("What is the starting amount?: ");
        int startAmount = in.nextInt();
        System.out.println("What is the win probability?: ");
        double winChance = in.nextDouble();
        System.out.println("What is the winning limit?: ");
        int winLimit = in.nextInt();

        int currentAmount=startAmount;
        int numRuin=0;
        double alpha = (1 - winChance/100) / (winChance/100);
        double expectedRuin;

        if (winChance == 50){
            expectedRuin = (1-((double)startAmount/winLimit));
        } else{
            expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow (alpha, winLimit));
        }
        System.out.println("How many days would you like to simulate?: ");
        int totalSimulations=in.nextInt();
        for (int i=0; i<totalSimulations; i++){
            int count=0;
            currentAmount=startAmount;
        while (currentAmount>0 && currentAmount<winLimit){
            double randomValue = 100*Math.random();
            count++;
          //  System.out.println("Round #"+count);
            if (randomValue<winChance){
                currentAmount++;
                //System.out.println("You won, your new amount is: $" + currentAmount + ".");
            } else {
                currentAmount--;
               // System.out.println("You lost, your new amount is: $" + currentAmount + ".");
            }
        }
        System.out.println("day #"+ (i+1));
        System.out.println("number of rounds played: " + count);
        if (currentAmount==0){
            System.out.println("The day was a ruin!");
            numRuin++;
        } else {
            System.out.println("It was a successful day!");
        }
    }
    double ruinPercent = 100.0*numRuin/totalSimulations;
    System.out.println("The percentage of ruin over " + totalSimulations + " days is: " + ruinPercent + "%");
    System.out.println("The expected percentage of ruin is: " + 100.0*expectedRuin + "%");

    }
}
