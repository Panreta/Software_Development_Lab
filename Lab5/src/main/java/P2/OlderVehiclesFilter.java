package P2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Color;

public class OlderVehiclesFilter {
    private List<Vehicle> vehicles = new ArrayList<>();

    public OlderVehiclesFilter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
        this.vehicles.add(vehicle1);
        this.vehicles.add(vehicle2);
        this.vehicles.add(vehicle3);
    }

    /**
     * Filters and returns information about vehicles manufactured after 1999.
     * Uses functional programming with Streams to filter vehicles by year,
     * and returns a list of formatted strings containing make, model, and year.
     *
     * @return List of Strings, where each string contains the make, model, and year
     *         of vehicles manufactured after 1999, formatted as "make model (year)"
     */
    public List<String> filterOlderVehicles() {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getYear() > 1999)
                .map(this::formatVehicleInfo)
                .collect(Collectors.toList());
    }

//    Without map, you'd have:
//
//    Stream<Vehicle> → List<Vehicle>

    //With map, you get:

    //Stream<Vehicle> → Stream<String> → List<String>

    /**
     * Helper method to format vehicle information into a readable string.
     *
     * @param vehicle The vehicle to format
     * @return A formatted string containing make, model, and year
     */
    private String formatVehicleInfo(Vehicle vehicle) {
        return vehicle.getMake() + " " +
                vehicle.getModel() + " (" +
                vehicle.getYear() + ")";
    }

    /**
     * Prints all vehicles manufactured after 1999 to the console.
     * Uses the filterOlderVehicles method and prints each result.
     */
    public void printOlderVehicles() {
        filterOlderVehicles().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Toyota", "Camry", 1998, Color.RED));
        vehicles.add(new Vehicle("Honda", "Accord", 2015, Color.BLUE));
        vehicles.add(new Vehicle("Tesla", "Model 3", 2020, Color.WHITE));

        OlderVehiclesFilter filter = new OlderVehiclesFilter(vehicles);
        System.out.println("Vehicles manufactured after 1999:");
        filter.printOlderVehicles();
    }
}