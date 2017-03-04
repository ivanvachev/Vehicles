
public class Car extends Vehicles{

    public Car (String typeOfVehicles, Double fuelQuantity, Double litersPerKm) {
        super(typeOfVehicles,fuelQuantity, litersPerKm);
    }

    @Override
    protected void setLitersPerKm(Double litersPerKm) {
        super.litersPerKm = litersPerKm + 0.9;
    }

    @Override
    public void addDistance (Double distance) throws IllegalArgumentException{
        if (distance * super.litersPerKm > super.fuelQuantity) {
            throw new IllegalArgumentException("Car needs refueling");
        }
        else {
            super.fuelQuantity = super.fuelQuantity - distance * super.litersPerKm;
        }
    }

}
