//Abstract class for the base type Vehicle
abstract class Vehicle {
	public abstract int getWheel(); //Method to get the number of wheels
	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

//Concrete class Car that extends Vehicle
class Car extends Vehicle {
	int wheel; //Number of wheels for a car

	Car(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

//Concrete class Bike that extends Vehicle
class Bike extends Vehicle {
	int wheel; // Number of wheels for a bike

	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

//Factory class for creating instances of Vehicle
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) {
			return new Car(wheel);
		} else if (type.equals("bike")) {
			return new Bike(wheel);
		}
		return null; //Return null for unsupported types
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		//Use the factory to create instances of vehicles
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
