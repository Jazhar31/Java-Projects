public class Room{
	
	//room description
	private String desc;

	//reference room exits
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    //constructor
    //setting the description instance variable
    public Room(String desc){
    	this.desc = desc;
    }
    
    //setting the value of variables
    public void setNorth(Room north){

        this.north = north;
    }

    public void setEast(Room east){
        this.east = east;
    }

    public void setWest(Room west){
        this.west = west;
    }

    public void setSouth(Room south){
        this.south = south;
    }

    public void setExits(Room n, Room e, Room w, Room s){
        this.north = n;
        this.east = e;
        this.west = w;
        this.south = s;
    }
    //getters
    public Room getNorth(){
        return this.north; 
    }

    public Room getEast(){
        return this.east;
    }

    public Room getWest(){
        return this.west;
    }

    public Room getSouth(){
        return this.south;
    }

    public String getDescription(){
        return this.desc;
    }
    
    //get the exits
    public String getExits(){
        String exits = "";
        if(this.north != null){
            exits += "\nYou can go north\n"; 
        }
        if(this.east != null){
            exits += "You can go east\n";
        }
        if(this.west != null){
            exits += "You can go west\n";
        }
        if(this.south != null){
            exits += "You can go south\n";
        }
        return exits;
    }
    //print room desc with the exits
    public String toString(){
        return this.desc + " " + getExits();
    }


}