import java.util.Scanner;

public class Wally{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            String nomes = sc.nextLine();
            if (nomes.equals("wally")){
                break;
            }
            else{
                String todosnomes = "";
                for (String x : nomes.split(" ")){
                  if (x.length() == 5){
                    todosnomes = x;
                      }
                  }
                if (todosnomes.length() == 0){
                  System.out.println("?");
                }
                System.out.println(todosnomes);
                }
            }
            
        }
    }
