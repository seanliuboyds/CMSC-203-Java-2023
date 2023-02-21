import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String args[]) {
		int num = RNG.rand(), guessMode = 1, nextGuess, lowGuess = 0, highGuess = 0, bufferNum = 0;
		char yesNo = 'u';
		boolean buffer = false;
		
		Scanner input = new Scanner(System.in);
		

		System.out.println("Enter your first guess");
		nextGuess = input.nextInt();
		RNG.inputValidation(nextGuess, (lowGuess > 0? lowGuess:0), (highGuess > 0? highGuess:101));
		
		
		while (guessMode == 1) {
			
			if (buffer == true) {
			System.out.println("Enter your guess between " + (lowGuess > 0? lowGuess:0) + " and " + (highGuess > 0? highGuess:100));
			nextGuess = input.nextInt();
			
			
			while (!RNG.inputValidation(nextGuess, (lowGuess > 0? lowGuess:0), (highGuess > 0? highGuess:101))) {
				nextGuess = input.nextInt();
				bufferNum++;
			}
			
			}
			
			if (buffer == false) {
				while (nextGuess > 100 || nextGuess < 0) {
					nextGuess = input.nextInt();
					RNG.inputValidation(nextGuess, (lowGuess > 0? lowGuess:0), (highGuess > 0? highGuess:101));
					bufferNum++;
				}
			}
			System.out.println("Number of guesses is " + (RNG.getCount()-bufferNum));
			
			yesNo = 'u'; 
			
		
			
			if(nextGuess > num) {
				System.out.println("Guess is too high");
				highGuess = nextGuess;
				buffer = true;
			} else if (nextGuess < num) {
				System.out.println("Guess is too low");
				lowGuess = nextGuess;
				buffer = true;
			} else {
				System.out.println("Congratulations, you guessed correctly\nTry again?");
				do {
				yesNo = input.next().charAt(0);
				} while (!(yesNo == 'y' || yesNo == 'n'));
				guessMode = (yesNo == 'y'? 1:0);
				 
				if (yesNo == 'y') {
				System.out.println("Enter your first guess");
				nextGuess = input.nextInt();
				
				yesNo = 'u';
				RNG.resetCount();
				num = RNG.rand();
				lowGuess = 0;
				highGuess = 100;
				buffer = false;
				bufferNum = 0;
				RNG.inputValidation(nextGuess, (lowGuess > 0? lowGuess:0), (highGuess > 0? highGuess:101));
				} else {
					input.close();
					return;
				}
			}
			
			
			
		}
		
	}
}
