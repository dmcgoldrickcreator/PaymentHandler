import java.util.*;

public class PaymentHandler {

  public static void balance(double s, double d, double p, double m) {

    double avg = ((s + d + p + m) / 4);
    System.out.println("Average: " + avg);

    double[] distance = new double[4];
    distance[0] = s - avg;
    distance[1] = d - avg;
    distance[2] = p - avg;
    distance[3] = m - avg;

    for (int k = 0; k < distance.length; k++) {
      while (distance[k] < 0) {
        String name = "";
        String name1 = "";
        int highest = 0;
        Double max = 0.0;
        for (int i = 0; i < distance.length; i++) {
          if (distance[i] > max) {
            max = distance[i];
            highest = i;

          }
        }
        if (k == 0) {
          name = "Spencer";
        }
        if (k == 1) {
          name = "Dylan";
        }
        if (k == 2) {
          name = "Phillip";
        }
        if (k == 3) {
          name = "Myles";
        }
        if (highest == 0) {
          name1 = "Spencer";
        }
        if (highest == 1) {
          name1 = "Dylan";
        }
        if (highest == 2) {
          name1 = "Phillip";
        }
        if (highest == 3) {
          name1 = "Myles";
        }
        if (distance[highest] > distance[k] && distance[highest] + distance[k] > 0.0) {

          distance[highest] += distance[k];

          System.out.println(name + " paid " + name1 + " $" + Math.abs(distance[k]));
          distance[k] = 0.0;

        } else {
          double paid = distance[k];
          distance[k] += distance[highest];
          distance[highest] = 0.0;
          paid -= distance[k];
          k--;
          System.out.println(name + " paid " + name1 + " $" + Math.abs(paid));

        }
      }
    }

  }

  public static void main(String[] args) {
    System.out.println(
        "Enter the price of payment separated by spaces in respective order. \n {Spencer, Dylan, Phillip, Myles}");
    Scanner sb = new Scanner(System.in);
    String scan = sb.nextLine();
    String[] split = scan.split(" ");
    double[] amounts = new double[split.length];
    for (int i = 0; i < split.length; i++) {
      amounts[i] = Double.parseDouble(split[i]);
    }
    balance(amounts[0], amounts[1], amounts[2], amounts[3]);
  }

}
