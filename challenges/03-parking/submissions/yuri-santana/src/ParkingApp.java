import java.util.ArrayList;
import java.util.List;

public class ParkingApp {
  public static void main(String[] args) {
      List<Vehicle> listaVeiculos = new ArrayList<>();
      Car car = new Car("111", "Porsche", "911 Turbo S");
      Truck truck = new Truck("222", "Ford", "sei la");
      Motorcycle motorcycle = new Motorcycle("333", "Honda", "ninja");
      listaVeiculos.add(car);
      listaVeiculos.add(truck);
      listaVeiculos.add(motorcycle);
      System.out.println(car);
      System.out.println("o valor a pagar por 4h: R$ " + car.calculateParkingFee(4) + "\n");
      
      System.out.println(motorcycle);
      System.out.println("o valor a pagar por 4h: R$ " + motorcycle.calculateParkingFee(4) + "\n");

      System.out.println(truck);
      System.out.println("o valor a pagar por 4h: R$ " + truck.calculateParkingFee(4) + "\n");

  }
}
