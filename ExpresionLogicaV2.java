
package programa1_programacionlogica;

import java.util.ArrayList;

public class ExpresionLogicaV2 {
    
   
    public void Nelementos (){  
         
         //ATRIBUTOS
          String Elemento = "( 9 + 8.6 ) * .1 / .5^2 - 76";
          int  Letras = 0, Numero = 0, cadena=0;
          String[] cadenaS= Elemento.split(" ");
          
          //Creacion de ArrayList
          ArrayList <String> numeros= new ArrayList();
          ArrayList <String> cadenaa= new ArrayList();
          ArrayList <String> caracteres= new ArrayList();
          
         for(int i = 0; i <cadenaS.length; i++) {
          if(esNumero(cadenaS[i])){
              numeros.add(cadenaS[i]);
              Numero++;
          
          }else if(esCadena(cadenaS[i])){
              cadenaa.add(cadenaS[i]);
              cadena++;
              
          }else{
              caracteres.add(cadenaS[i]);
              Letras++;
          }
        }
         
         //Mostrar resultados 
        System.out.println("\nLa cadena original es:"  +  Elemento);
        
        System.out.println("\nLos numeros de la cadena son: " + numeros.toString());
        System.out.println("La cantidad de numeros son: " + Numero);
        System.out.println("\nLos elementos de la cadena son: " + cadenaa.toString());
        System.out.println("La cantidad de cadenas son: " + cadena);
        System.out.println("\nLos elementos de las letras  son: " + caracteres.toString());
        System.out.println("La cantidad de letras son: " + Letras);
        
        
    }
    //Metodo para los numeros
    private  static boolean esNumero(String dato){
        try{
            Integer.parseInt(dato);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //Metodo 
    private static  boolean esCadena(String dato){
        return (dato.length() > 1) ? true : false;
    }
    
}
