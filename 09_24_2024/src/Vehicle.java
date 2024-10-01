import java.util.ArrayList;

public class Vehicle {
    public Vehicle(){
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        Truck myTruck = new Truck();

        ArrayList<Vehicle> myGarage = new ArrayList<Vehicle>();
        myGarage.add(myCar);
        myGarage.add(myTruck);

        for(int i = 0; i < myGarage.size(); i++){
            myGarage.get(i).honk();
        }
    }
    public void honk(){
        System.out.println("Beep!!");
    }
}
