import java.util.Scanner;
import java.util.Random;

public class HW6{
    
    //methods to handle exits
	static Room handleNorthExits(Room currentRoom){

		//no room set up to the north so user cant go there
		if(currentRoom.getNorth() == null){
			System.out.println("CAN'T GO THAT WAY! Please try again!\n");
		}
		else{
			//IS a room north so user can go
			currentRoom = currentRoom.getNorth();
		}
		return currentRoom;
	}
	static Room handleEastExits(Room currentRoom){
		//no room set to the east, so user cant go there
		if(currentRoom.getEast() == null){
			System.out.println("CAN'T GO THAT WAY! Please try again\n");
		}
		else{
			//IS a room east so user can go
			currentRoom = currentRoom.getEast();
		}
		return currentRoom;
	}
	static Room handleWestExits(Room currentRoom){
		//no room towards west so user cant go there
		if(currentRoom.getWest() == null){
			System.out.println("CAN'T GO THAT WAY!Please try again\n");
		}
		else{
			//there is a room towards the west
			currentRoom = currentRoom.getWest();
		}
		return currentRoom;
	}
	static Room handleSouthExits(Room currentRoom){
		//no exit towards the south so user cant go there
		if(currentRoom.getSouth() == null){
			System.out.println("CAN'T GO THAT WAY!Please try again!\n");
		}
		else{
			//there is an exit towards the south
			currentRoom = currentRoom.getSouth();
		}
		return currentRoom;
	}
	static int NUM_ROOMS = 9;
	
	public static void main(String[] args){

		//invoking the Dungeon constructor
		Dungeon myDungeon = new Dungeon();

		//new room reference to the starting room
	    Room currentRoom = myDungeon.getRoom0();

		Scanner input = new Scanner(System.in);

		//initializng loop variable 
		boolean userPlayingTheGame = true;
		
		System.out.println("********************WARNING********************");
		System.out.println("YOU MIGHT ENCOUNTER MONSTERS OR FIND TREASURES!\n");
		System.out.println("Do you wish to continue? yes/no");
		String answer = input.nextLine();
		if(answer.equals("yes")){
			System.out.println("Let the show begin!\n");
		}
		else if(answer.equals("no")){
			System.out.println("Aww! We will see you next time");
			userPlayingTheGame = false;
		}
		//game loop
		while(userPlayingTheGame == true){
		    
		    //updating current room
			System.out.println(currentRoom);
			
			//generate treasures
			Random random = new Random();
		    int treasureLocation = random.nextInt(NUM_ROOMS);
            
            //ask direction
			System.out.println("Which direction?");
			System.out.println("\nn:for north\ns:for south\nw:for west\ne:for east\nq:for quit");
            
            //get char input
			char response = input.nextLine().charAt(0);
			switch(response){
				case 'n': 
				     //invoking the handle north exits 
				     currentRoom = handleNorthExits(currentRoom);				    				     				   
				     break;
				case 'e':
				     //invoking handle south exits				     
				     currentRoom = handleEastExits(currentRoom);				    				     
				     break;
				case 'w':	
				     //incoking handle west exits			     				     
				     currentRoom = handleWestExits(currentRoom);				     
				     break;
                case 's':  
                     //invoking handle south exits                                                        
                     currentRoom = handleSouthExits(currentRoom);
                     break;
                case 'q':
                     System.out.println("You left the mansion!\nThanks for playing!");
                     //if user says q, the game will end
                     userPlayingTheGame = false;
                     break;
                default:
                     System.out.println("Invalid direction! Try again!"); 
                     break;                  
			}
			if (treasureLocation % 4 == 0){
            	System.out.println("Congrats! You found the hidden treasure!");
            }
			
		}
	}
}