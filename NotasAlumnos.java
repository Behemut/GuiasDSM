import java.util.Scanner;



public class NotasAlumnos {
    private int[] notas;
    private Scanner teclado;

     public NotasAlumnos(){ 
        teclado = new Scanner(System. in );
        notas = new int[10];
        
        for(int i=0; i <10; i++){
            System.out.println("Ingrese la nota " + (i+1));
            notas[i]= teclado.nextInt();
        }
    }

    public void Ordernar(){
        int mayores=0;
        int menores=0;

        for(int i=0; i <10; i++){
           if (notas[i]>=7){
                mayores = mayores +1;
           }
           else{
               menores = menores +1;
           }
        }

        System.out.println("La cantidad de alumnos con notas mayor a 7 fue: " + mayores);
        System.out.println("La cantidad de alumnos con notas menor a 7 fue: " + menores);

        

    }

    public static void main(String[] ar){
        NotasAlumnos estudiantes = new NotasAlumnos();
        estudiantes.Ordernar();
    }
}
