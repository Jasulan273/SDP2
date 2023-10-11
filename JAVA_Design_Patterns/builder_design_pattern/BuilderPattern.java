package builder_design_pattern;

//Define the Vehicle class which represents a vehicle with various attributes
class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  //Getter methods for retrieving vehicle attributes
  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return this.wheel;
  }

  public int getAirbags() {
    return this.airbags;
  }

  //Private constructor for the Vehicle class that takes a VehicleBuilder
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  //Define the VehicleBuilder as a static inner class for constructing Vehicle objects
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    //Constructor for the VehicleBuilder that requires essential attributes
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    //Method to set optional attribute airbags and return the builder for method chaining
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    //Method to build and return a Vehicle object using the configured builder
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

//Main class to demonstrate the Builder Design Pattern
public class BuilderPattern {
  public static void main(String[] args) {
    //Create a car using the VehicleBuilder with specified attributes and airbags
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

    //Create a bike using the VehicleBuilder with specified attributes no airbags
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    //Display the attributes of the car and bike objects
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
