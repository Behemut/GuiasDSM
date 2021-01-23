import java.util.Scanner;

public class DivisionNumeros {
    public static void main(String[] ar){
       Scanner teclado = new Scanner(System.in);
        int a,b;

        System.out.println("Ingrese el primer valor: ");
        a = teclado.nextInt();
        System.out.println("Ingrese el segundo valor: ");
        b = teclado.nextInt();

if ( (a%b)==0){
    System.out.println("Los numeros no son divisibles");
}
else{System.out.println("Los numeros  son divisibles");}

    }
}
