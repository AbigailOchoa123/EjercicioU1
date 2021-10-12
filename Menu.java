
package programa1_programacionlogica;

/**
 *
 * @author Abigail
 */
import java.util.Scanner;
public class Menu {

    public static void main(String[] args) {
      Scanner entrada=new Scanner(System.in);
      ExpresionLogicaV2 V2  = new ExpresionLogicaV2();
      ExpresionLogica V  = new ExpresionLogica();
      ExpresionAritmetica A  = new ExpresionAritmetica();
         int opc;
         boolean salir= false;
         do{
         
        System.out.println("1. Expresion Aritmetica Notaciones");
        System.out.println("2. Expresion Logica Tabla de verdad");
        System.out.println("3. Expresion Logica Contador de N,C,C");
        System.out.println("4. Salir");
        System.out.println("Ingrese una de las opciones");
        opc=entrada.nextInt();
        
         switch(opc){
             case 1:
                 
                 A.Aritmetica();
                 break;
             case 2:
                 V.Logica();
             break;
             case 3:
                     V2.Nelementos();
                 break;
             case 4:
                 salir=true;
                 break;
    }
    }
    while(!salir);
}
    
}
