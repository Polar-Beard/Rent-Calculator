import java.util.Scanner;
import java.util.ArrayList;

public class RentCalculator
{
  private static double totalRent;
  private static int numRooms;
  private static ArrayList<Room> rooms;
  private static int totalResidents;
  private static int totalSqFeetOfRooms;
  private static int totalSqFeetOfProperty;

  public static void main(String[] args)
  {
    rooms = new ArrayList<Room>();
    totalResidents = 0;
    totalSqFeetOfRooms = 0;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter the total cost of rent: ");
    totalRent = in.nextDouble();

    System.out.println("Enter total square feet of property: ");
    in.nextLine();
    totalSqFeetOfProperty = in.nextInt();

    System.out.println("Enter total number of rooms: ");
    in.nextLine();
    numRooms = in.nextInt();

    for(int i = 1; i <= numRooms; i++)
    {
      System.out.println("Enter sq footage for Room " + i);
      in.nextLine();
      int roomSqFeet = in.nextInt();
      System.out.println("Enter the number of residents living in Room " + i);
      in.nextLine();
      int roomNumResidents = in.nextInt();
      rooms.add(new Room(roomSqFeet, roomNumResidents));
    }

    addTotals();

    for(Room r: rooms)
    {
      calculateRent(r);
    }

    printRooms();
}

    private static void printRooms()
    {
      for(int i = 1; i <= rooms.size(); i++)
      {
        System.out.println("Room " + i + ": "
                          + rooms.get(i-1).getSqFeet() + " square feet, "
                          + rooms.get(i-1).getNumResidents() + " residents, "
                          + "$" + rooms.get(i-1).getRent() + " rent."
                          );
      }
    }

    private static void addTotals()
    {
      for(Room r: rooms)
      {
        totalResidents += r.getNumResidents();
        totalSqFeetOfRooms += r.getSqFeet();
      }
    }

    private static void calculateRent(Room currentRoom)
    {
      double r = totalRent;
      int x = currentRoom.getSqFeet();
      int n = totalResidents;
      int nX = currentRoom.getNumResidents();
      int f = totalSqFeetOfProperty;
      int fS = totalSqFeetOfRooms - currentRoom.getSqFeet();

      double result = (r * (x * (n - nX) + nX * (f - fS))) / (f*n*nX);
      currentRoom.setRent(result);
    }
}
