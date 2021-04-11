import java.util.Scanner;

public class Test {
	public static void main(String []argh) {
			while(true) {
				System.out.println("								      Press 1 or 2");
				System.out.println("								  1.Single Player vs Bot");
				System.out.println("								  2. Multiplayer vs Bot");
			Scanner play = new Scanner(System.in);
			int SingleOrMultiplayer=play.nextInt();
			if(SingleOrMultiplayer==1) {
				SinglePlayer a = new SinglePlayer();
			}
			else if(SingleOrMultiplayer==2){
				Multiplayer b= new Multiplayer();
			}
			else{
				System.out.println("								  Enter 1 or 2");
			}
			}
	}
	
	
}
