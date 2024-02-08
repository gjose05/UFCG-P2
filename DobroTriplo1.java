import java.util.Scanner;

public class DobroTriplo1 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int numero = sc.nextInt();
    int dobro = (numero * 2);
    int triplo = (numero * 3);
    System.out.println("dobro: " + dobro + ", triplo: " + triplo);
    }
}