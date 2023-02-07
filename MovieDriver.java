import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String answer = "y";
		Movie movie1 = new Movie();
		do {
		
			System.out.println("Enter the name of a movie");
			movie1.setTitle(scan.nextLine());
			System.out.println("Enter the rating of a movie");
			movie1.setRating(scan.nextLine());
			System.out.println("Enter the number of tickets sold for this movie");
			movie1.setSoldTickets(scan.nextInt());
			System.out.println(movie1.toString());
			System.out.println("Do you want to enter another? (y or n)");
			scan.nextLine();
			do {
				answer = scan.nextLine();
			} while (!(answer.equalsIgnoreCase("y")|| answer.equalsIgnoreCase("n")));
		} while (answer.equalsIgnoreCase("y"));
		scan.close();
	}

}
