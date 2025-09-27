import java.util.Scanner;
public class SongGuessingGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int points = 0;
        System.out.println("Welcome to the song guessing game");
        System.out.println("Guess the song");
        SongPlayer.playSegment("TrapQueen.wav", 15, 41);
        String guess = sc.nextLine();
        if(guess.equals("Trap Queen") || guess.equals("trap queen")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect");
        }
        System.out.println("Guess this next song");
        SongPlayer.playSegment("GoodLife.wav", 22, 46);
        String guess2 = sc.nextLine();
        if(guess2.equals("Good Life") || guess2.equals("good life")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect");
        }
        System.out.println("Guess this next song");
        SongPlayer.playSegment("Ballin.wav",30,60);
        if(guess2.equals("Ballin") || guess2.equals("ballin")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect");
        }
        System.out.println("Guess this next song");
        SongPlayer.playSegment("TouchtheSky.wav",18,54);
        if(guess2.equals("Touch the Sky") || guess2.equals("touch the sky")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect");
        }
        System.out.println("Guess this final song");
        SongPlayer.playSegment("IWonder.wav",155,42);
        if(guess2.equals("I Wonder") || guess2.equals("i wonder")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect");
        }
        System.out.println("Your total points are " + points);

    }
}
