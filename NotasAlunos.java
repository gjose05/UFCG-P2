import java.util.Scanner;

public class NotasAlunos {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numerodealunos = 0;
        int totaldepontos = 0;
        int maior = 0;
        int menor = 1000;
        int acimadamedia = 0;
        int abaixodamedia = 0;
        while (true){
            String nome = sc.next();
            if (nome.equals("-")){
                break;
            }
            String x = sc.next();
            int notas = Integer.parseInt(x);
            totaldepontos += notas;
            numerodealunos++;
                if (notas >= 700){
                    acimadamedia++;
                }
                else{
                    abaixodamedia++;
                }
                if (notas > maior){
                    maior = notas;
                }
                if (notas < menor){
                    menor = notas;
                }
            }
        Integer medianotas = (totaldepontos / numerodealunos);
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + medianotas);
        System.out.println("acima: " + acimadamedia);
        System.out.println("abaixo: " + abaixodamedia);
    }
    
}
