package main;

// Liskov: Replace rallycar superclass
public class AsphaltCar extends RallyCar {

    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;
    }
    
    public double getDownForce(){
        return downforce;
    }

    @Override
    public double calculatePerformance(){
        return getHorsepower() + 0.9+ downforce*2.0;
    }
}
