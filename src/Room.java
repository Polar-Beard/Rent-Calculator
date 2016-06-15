public class Room{
  private int sqFeet;
  private int numResidents;
  private double rent;

  public Room(int sqFeet, int numResidents){
    this.sqFeet = sqFeet;
    this.numResidents = numResidents;
    rent = 0.00;
  }

  public int getSqFeet(){
    return sqFeet;
  }

  public int getNumResidents(){
    return numResidents;
  }

  public void setRent(double rent){
    this.rent = rent;
  }

  public double getRent(){
    return rent;
  }
}
