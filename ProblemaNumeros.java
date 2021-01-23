import java.util.Scanner;

public class ProblemaNumeros {
    private int[] numero;
    private int cantidad=0;
    private Scanner teclado;

    public ProblemaNumeros(){
        teclado = new Scanner(System. in );
        System.out.print("Ingrese la cantidad de numeros a contar: ");
        cantidad = teclado.nextInt();
        numero= new int[cantidad];
            //Llenado de los campos
        for(int i=0; i<cantidad; i++){
            System.out.print("Ingrese un numero ");
            numero[i] = teclado.nextInt();
            System.out.print("**quedan " + (cantidad-i) + " restantes \n" );
        }
    }

    public void Ordenar(){
        int totalPar=0;
        int totalImpar=0;
        for(int i=0; i< numero.length; i++){
            if (numero[i]%2==0){
              
                totalPar= totalPar+1;
            }
            else{
           
                totalImpar= totalImpar +1;
            }
        }
        
        System.out.println("Numero total ingresados: " + cantidad);
        System.out.println("Total de numeros pares: " + totalPar);
        System.out.println("Total de numeros impares: " + totalImpar);

    }

    public static void main(String[] ar){
        ProblemaNumeros arreglo = new  ProblemaNumeros();
        arreglo.Ordenar();
    }
}
