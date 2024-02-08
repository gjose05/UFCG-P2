import java.util.Scanner;

public class AcimaDaMedia{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();
        int contadornumeros = 0;
        int contadortotal = 0 ;
        for(String x : linha.split(" ")){
          contadornumeros++;
          int numero = Integer.parseInt(x);
          contadortotal += numero;
        }
        int media = contadortotal / contadornumeros;
        String resultado = "";
        for (String x : linha.split(" ")){
          int numero = Integer.parseInt(x);
          if (numero > media){
            String strnumero = String.valueOf(numero);
            resultado += (strnumero + " ");
            }
        }
        System.out.println(resultado);
    }
}
