import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String comand = "";
        String typeOfVehicles = "";
        Double distance = 0.0;
        String[] carInput = br.readLine().trim().split("\\s+");
        String[] truckInput = br.readLine().trim().split("\\s+");

        Vehicles car = new Car("Car", Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        Vehicles Truck = new Truck("Truck", Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        ArrayList<Vehicles> listOfVehicles = new ArrayList<>();
        listOfVehicles.add(car);
        listOfVehicles.add(Truck);

        int n = Integer.parseInt(br.readLine().trim());
        while (n-- > 0){
            String[] comands = br.readLine().trim().split("\\s+");
            comand = comands[0];
            typeOfVehicles = comands[1];
            distance = Double.parseDouble(comands[2]);
            switch (comand) {
                case "Drive":
                    for (Vehicles el : listOfVehicles) {
                        if (typeOfVehicles.equals(el.getTypeOfVehicles())) {
                            try {
                                el.addDistance(distance);
                                DecimalFormat format = new DecimalFormat("0.#");
                                System.out.printf("%1$s travelled %2$s km\n", el.getTypeOfVehicles(), format.format(distance));
                            }
                            catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case "Refuel":
                    for (Vehicles el : listOfVehicles) {
                        if (typeOfVehicles.equals(el.getTypeOfVehicles())) {
                            el.refuel(distance);
                        }
                    }
                    break;
            }
        }

        System.out.printf("%1$s: %2$.2f\n", car.getTypeOfVehicles(), car.getFuelQuantity());
        System.out.printf("%1$s: %2$.2f",Truck.getTypeOfVehicles(), Truck.getFuelQuantity());

    br.close();
    }
}
