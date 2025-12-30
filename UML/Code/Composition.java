package UML;

import java.util.ArrayList;
import java.util.List;


//Compostion is a string "has a relationship" where when the container class is detroyed the containing objects is also destroyed.
// There are no rooms if the house is destroyed
class Room{
    private String name;
    Room(String name)
    {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class House{

    private List<Room> rooms;

    public House()
    {
        rooms = new ArrayList<>();
        rooms.add(new Room("Living room"));
        rooms.add(new Room("Kitchen"));
    }

    public void showRooms(){
        for(Room room : rooms)
        {
            System.out.println(room.getName());
        }
    }



}

public class Composition {

    public static void main(String[] args)
    {
        House house = new House();

        house.showRooms();
    }
}
