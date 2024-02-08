import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        String simbolos = sc.next();
        if ((! simbolos.equals("+")) && (! simbolos.equals("-")) && (! simbolos.equals("*")) && (! simbolos.equals("/"))){
            System.out.println("ENTRADA INVALIDA");
        }
        else{
            float numero1 = sc.nextFloat();
            float numero2 = sc.nextFloat();
            if (simbolos.equals("+")){
                float resultado = (numero1 + numero2);
                System.out.println("RESULTADO: " + resultado);
            }   
            else if (simbolos.equals("-")){
                float resultado = (numero1 - numero2);
                System.out.println("RESULTADO: " + resultado);
            }
            else if (simbolos.equals("*")){
                float resultado = (numero1 * numero2);
                System.out.println("RESULTADO: " + resultado);
            }
            else if((simbolos.equals("/"))&&(numero2 != 0)){
                float resultado = (numero1 / numero2);
                System.out.println("RESULTADO: " + resultado);
            }
            else if ((simbolos.equals("/"))&&(numero2==0)){
                System.out.println("ERRO");
            }
        }
    }
}