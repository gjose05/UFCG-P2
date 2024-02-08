import java.util.Scanner;

public class PontoFlutuante {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    float numero1 = sc.nextFloat();
    float numero2 = sc.nextFloat();
    float media = (numero1 + numero2) / 2;
    if (media >= 7){
      System.out.println("pass: True!");
    }
    else if(media < 7){
      System.out.println("pass: False!");
    }
  }
}
