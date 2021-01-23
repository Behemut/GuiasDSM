import java.util.Scanner;

import javax.swing.text.Position;

import java.util.LinkedList;
import java.util.Queue;

public class PlanoCartesiano {
    private int[] x;
    private int[] y;
    private Queue<String> resultado = new LinkedList<>();
    private Scanner teclado;
    private int cantidad=0;
   
    public PlanoCartesiano() {
        teclado = new Scanner(System. in );
      
        System.out.print("¿Cuantos puntos seran ingresados?");
        cantidad = teclado.nextInt();

        x = new int [cantidad];
        y = new int [cantidad];

 for (int i=0; i<cantidad; i++){
    System.out.println("Ingrese la coordenada N°" + (i+1) );
    System.out.print("X: ");
    x[i] = teclado.nextInt();
    System.out.print("Y: ");
    y[i] = teclado.nextInt();
   
               if ( x[i] >=0  && y[i] >=0){
                resultado.add("El punto " + x[i] + "," + y[i]+ " esta en el primer cuadrante");
                }
               if ( x[i]<0  && y[i] >=0){
                resultado.add("El punto " + x[i] + "," + y[i] + " esta en el segundo cuadrante");
                }
               if (x[i] >=0  && y[i] <0){
                resultado.add("El punto " + x[i] + "," + y[i] + " esta en el cuarto cuadrante");
                }
                if ( x[i] <0  && y[i] <0){
                resultado.add("El punto " + x[i]+ "," + y[i] + " esta en el tercer cuadrante");
                }
        }
        System.out.println(resultado + "\n");
    }
    public static void main(String[] ar){
      PlanoCartesiano plano = new PlanoCartesiano();
    }
}
