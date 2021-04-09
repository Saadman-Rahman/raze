import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class gameHead {
	static ArrayList<Integer>playerMoves = new ArrayList<Integer>();
	static ArrayList<Integer>botMoves = new ArrayList<Integer>();
	
	gameHead(){
while(true) {	
	try {
		/*  Gameboard should be looking like this. And the indexes for the players will be like this as well
		    
		  		   1|2|3
		  		   -+-+-
		  		   4|5|6
		  		   -+-+-
				   7|8|9
		  
		  
		  //37(Index is 36) of row 1 is 1(row Index is 0)
		  //39 of row 1 is 2
		  //41 of row 1is 3
		  //Same for row 2 and 3
		  //there are 36 spaces of char type for alignment purposes.
		 */
		char [][] gameBoard = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ','|',' '},
					  		   {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-','+','-','+','-'},
					  		   {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ','|',' '},
					  		   {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','-','+','-','+','-'},
					  		   {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|',' ','|',' '}};

		
		while(true) {
		System.out.println("								  Press 1 to Start Game");
		System.out.println("								    Press 2 to  Exit");
		System.out.println("");
		
		Scanner gameS = new Scanner(System.in);
		int gameStart = gameS.nextInt();
		
		
			if(gameStart==1) {
		
		printGameBoard(gameBoard);
		
		while(true) {
			Scanner playerInput = new Scanner(System.in);
			System.out.println("\r\n 							  	    Place your move(1-9)");
			 int playerMove = playerInput.nextInt();
			 
				 
				while(playerMoves.contains(playerMove) || botMoves.contains(playerMove)) {
					System.out.println("							    Already Taken. Try a new move again! ");
					 playerMove = playerInput.nextInt();
				}
				while(playerMove>9) {
					System.out.println("							    Wrong Move.Try a valid move(1-9)");
					playerMove=playerInput.nextInt();
				}
			
			
			
			placeMove(gameBoard,playerMove, "player"); 
			String result = checkWinner();
			
			if (result.length()>0) {
				printGameBoard(gameBoard);
				System.out.println(result);
				System.out.println("								   Thank you for playing.\r\n");
				System.exit(0);
				
		
				
			}
			
			Random botTurn = new Random();
			int botMove = botTurn.nextInt(9)+1 ;
			while(playerMoves.contains(botMove) || botMoves.contains(botMove)) {
			
				 botMove = botTurn.nextInt(9)+1 ;
			}
			
			placeMove(gameBoard,botMove,  "bot");
			printGameBoard(gameBoard);
			
			
			result = checkWinner();
			if (result.length()>0) {
				
				System.out.println(result);
				System.out.println("								     Thank you for playing.\r\n");
				System.exit(0);
				
				
		
				
			}
		
		}
			}
		
		
		
		else if(gameStart==2) {
			System.out.println("							   Exiting game. Thank you for playing.");
			System.exit(0);
			
		}
		
		else{
			System.out.println("								  Please, Either enter 1 or 2! \r\n \r\n \r\n");
			
			
		}
		}
		
		
		
		}
		catch(Exception e) {
			System.out.println("								  An error occured. Play again! ");
			System.out.println("							    Error : "+e+"\r\n");
		}
}
		
	}
	public static void placeMove(char [][] gameBoard, int move, String user) { 
		char symbol = ' ';
		
		if (user.equals("player")) {
			symbol= 'X';
			if(move<10){
			playerMoves.add(move);
			}
		}else if(user.equals("bot")) {
			symbol = 'O';
			botMoves.add(move);
		}
		switch(move) {
		case 1: 
			gameBoard [0][36] = symbol;
			break;
		case 2: 
			gameBoard [0][38] =symbol;
			break;
		case 3: 
			gameBoard [0][40] =symbol;
			break;
		case 4: 
			gameBoard [2][36] =symbol;
			break;
		case 5: 
			gameBoard [2][38] =symbol;
			break;
		case 6: 
			gameBoard [2][40] =symbol;
			break;
		case 7: 
			gameBoard [4][36] =symbol;
			break;
		case 8: 
			gameBoard [4][38] =symbol;
			break;
		case 9: 
			gameBoard [4][40] =symbol;
			break;
			default:
				System.out.println("								  	Wrong Move\r\n");
				break;
	}
		
	}
		
	
	//To print the gameboard. Wheneve I need to print the gameboard I can just call this method.
	
	public static void printGameBoard(char [][] gameBoard){
		
		
		
		for (char [] row: gameBoard) {
				for(char sym: row) {
					
					System.out.print(" "+sym);
				}
					System.out.println("");
				
			}
		}
	
	// This method check winner after every move player makes. 
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List leftcol = Arrays.asList(1,4,7);
		List midcol = Arrays.asList(2,5,8);
		List rightcol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List>winning = new ArrayList<List>();// List of lists from above.
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);
		
		for (List rowof : winning )
			{
				if(playerMoves.containsAll(rowof)) {
												return "\r\n								  Congratulations! You Win!";
												}
				else if(botMoves.containsAll(rowof)) {
												return "\r\n								  BOT Wins. Better luck next time";
												}
				else if (playerMoves.size() + botMoves.size() == 9) {
												return "\r\n								  Match Drawn";
												}
		}
		
		return ""; 
	
		
	}
	
}
