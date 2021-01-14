public class Dungeon{
	
	//setting up instance rooms
	private Room basement;
	private Room masterBedroom;
	private Room guestBedroom;
	private Room diningRoom;
	private Room kitchen;
	private Room southHall;
	private Room northHall;
	private Room gamingRoom;
    private Room bathroom;

    public Dungeon(){

        //room descriptions by invoking thr Room constructor
    	basement = new Room("This is the basement! It is very stinky in here!");
    	masterBedroom = new Room("You are in the Master Bedroom! There is a King size bed, a soaking tub and a refrigerator");
    	guestBedroom = new Room("Wow!You are in the Guest Bedroom with the famous Queensize bed!");
    	diningRoom = new Room("You are in the glamorous and modern Dining Room!");
    	kitchen = new Room("You are in the yummiest place of the dungeon: The Kitchen!It smells nice in here!");
    	southHall = new Room("This is the South Hall! Its Decorative Marble Floor will catch your attention for sure!");
    	northHall = new Room("You are in the North Hall, the only place with cute and adorable puppies!");
    	gamingRoom = new Room("Kids and Teenagers love this room!.....The Gaming Room!");
    	bathroom = new Room("This is the bathroom! Don't worry, just breathe!");
        
        //making exits corresponding to the correct room 

        //basement is south of northhall
        basement.setSouth(northHall);
        
        //master bed is north of bathroom
        masterBedroom.setNorth(bathroom);
        masterBedroom.setSouth(kitchen);
        masterBedroom.setWest(northHall);
        
        //guest bed is north of south hall
        guestBedroom.setNorth(southHall);
        guestBedroom.setEast(kitchen);
        
        //dining is east of north hall
        diningRoom.setEast(northHall);
        diningRoom.setSouth(gamingRoom);
        
        //kitchen is north of master bed
        kitchen.setNorth(masterBedroom);
        kitchen.setEast(guestBedroom);
        
        //south hall has exits to all these
        southHall.setExits(northHall, masterBedroom, gamingRoom, guestBedroom);

        northHall.setExits(basement, bathroom, diningRoom, southHall);
        
        //gaming room is east of south hall
        gamingRoom.setEast(southHall);
        gamingRoom.setNorth(diningRoom);
        
        //bathroom is west of north hall
        bathroom.setWest(northHall);
        bathroom.setSouth(masterBedroom);
        
    }
    //method to start from current room
    public Room getRoom0(){
        return basement;
    }
        
}//end of class

