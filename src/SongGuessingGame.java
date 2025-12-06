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
            System.out.println("Sorry you are incorrect the answer is trap queen");
        }
        System.out.println("Guess this next song");
        SongPlayer.playSegment("GoodLife.wav", 22, 70);
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
        String guess3 = sc.next();
        if(guess3.equals("Ballin") || guess3.equals("ballin")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect the answer is ballin");
        }
        System.out.println("Guess this next song");
        SongPlayer.playSegment("TouchtheSky.wav",18,55);
        String guess4 = sc.nextLine();
        if(guess4.equals("Touch the Sky") || guess4.equals("touch the sky")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect the answer is touch the sky");
        }
        System.out.println("Guess this final song");
        SongPlayer.playSegment("IWonder.wav",155,42);
        String guess5 = sc.nextLine();
        if(guess5.equals("I Wonder") || guess5.equals("i wonder")){
            System.out.println("You are correct");
            points++;
        }
        else{
            System.out.println("Sorry you are incorrect");
        }
        System.out.println("Your total points are " + points);

    }
}
