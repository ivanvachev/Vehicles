
public abstract class Vehicles {

    protected String typeOfVehicles;
    protected Double fuelQuantity;
    protected Double litersPerKm;

    protected Vehicles (String typeOfVehicles, Double fuelQuantity, Double litersPerKm)  {
        this.typeOfVehicles = typeOfVehicles;
        this.fuelQuantity = fuelQuantity;
        this.setLitersPerKm(litersPerKm);
    }

    protected abstract void setLitersPerKm (Double litersPerKm);

   public abstract void addDistance (Double distance) throws IllegalArgumentException;

    public void refuel (Double fuel) {
        this.fuelQuantity += fuel;
    }

    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public String getTypeOfVehicles() {
        return this.typeOfVehicles;
    }

}
