// Class Vehicle that implements Cloneable to enable cloning.
class Vehicle implements Cloneable {
  private List<String> vehicleList;

  public Vehicle() {
    this.vehicleList = new ArrayList<String>();
  }

  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }

  public void insertData() {
    //Populate the list with some vehicle names.
    vehicleList.add("Honda Amaze");
    vehicleList.add("Audi A4");
    vehicleList add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList() {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();

    for (String s : this.getVehicleList()) {
      tempList.add(s);
    }

    return new Vehicle(tempList); //Create a new instance with a copy of the list.
  }
}

public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle a = new Vehicle();
    a.insertData();

    //Clone A to create a new instance B.
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze");

    //Display the lists from A and B.
    System.out.println("Original List (a): " + a.getVehicleList());
    System.out.println("Cloned List (b): " + list);

    //Modify the cloned list.
    b.getVehicleList().remove("Audi A4");
    System.out.println("Modified Cloned List (b): " + list);
    System.out.println("Original List (a) after modification of (b): " + a.getVehicleList());
  }
}
