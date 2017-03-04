
public class Truck extends Vehicles{

    public Truck (String typeOfVehicles, Double fuelQuantity, Double litersPerKm) {
        super(typeOfVehicles,fuelQuantity, litersPerKm);
    }

    @Override
    protected void setLitersPerKm(Double litersPerKm) {
        super.litersPerKm = litersPerKm + 1.6;
    }

    @Override
    public void addDistance (Double distance) throws IllegalArgumentException{
        if (distance * super.litersPerKm > super.fuelQuantity) {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        else {
            super.fuelQuantity = super.fuelQuantity - distance * super.litersPerKm;
        }
    }


}
