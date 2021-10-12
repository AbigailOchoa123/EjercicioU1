package programa1_programacionlogica;

import java.util.ArrayList;
import java.util.Scanner;
public class ExpresionAritmetica {
     Scanner leer = new Scanner(System.in);
       public void Aritmetica (){ 
       //(.9+8)*1/5^2-76)
   
       
        //Declaracion de variables
        String expresion;
        System.out.println("Ingrese la expresion aritmetica");
        expresion=leer.nextLine();
        ArrayList<String> Infija = new ArrayList<String>();
        System.out.println("Expresion: " + expresion);
        String numero = "";
         //Divide la cadena
        for (int i = 0; i < expresion.length(); i++) {
            if (Character.isDigit(expresion.charAt(i))) {
                numero += expresion.charAt(i);
            } else {
                if (!numero.equals("")) {
                    Infija.add(numero);
                }
                Infija.add(String.valueOf(expresion.charAt(i)));
                numero = "";
            }
        }
        if (!numero.equals("")) {
            Infija.add(numero);
        }
        //Llamar metodo 
        convertir(Infija);
    }
       //Metodo Convertir
     public void convertir(ArrayList<String> operacion) {
        ArrayList<String> Posfija = new ArrayList<String>();
        ArrayList<String> pila = new ArrayList<String>();
        while (operacion.size() > 0) {
            String elemento = operacion.remove(0);
            if (Character.isDigit(elemento.charAt(0))) {
                Posfija.add(elemento);
            } else if (elemento.equals("(")) {
                pila.add(elemento);
            } else if (elemento.equals(")")) {
                while (pila.size() > 0 && !pila.get(pila.size() - 1).equals("(")) {
                    Posfija.add(pila.remove(pila.size() - 1));
                }
                if (pila.size() > 0) {
                    if (pila.get(pila.size() - 1).equals("(")) {
                        pila.remove(pila.size() - 1);
                    }
                }
            } else if (existeOperador(elemento)) {
                while (pila.size() > 0 && ((precedencia(pila.get(pila.size() - 1)) >= precedencia(elemento)) && !pila.get(pila.size() - 1).equals("("))) {
                    Posfija.add(pila.remove(pila.size() - 1));
                }
                pila.add(elemento);
            }
        }
        while (pila.size() > 0) {
            Posfija.add(pila.remove(pila.size() - 1));
        }
        //Llamar metodo 
        operaciones(Posfija);
    }
      //Jerarquia de operadores
    public int precedencia(String op) {
        if (op.equals("(") || op.equals(")")) {return 4;
        } else if (op.equals("^")) {return 3;
        } else if (op.equals("*") || op.equals("/")) {return 2;
        } else if (op.equals("+") || op.equals("-")) {return 1;
        }
        return 0;
    }
        //Metodo Resultados
    public float resultados(float x, float y, String op) {
        if (op.equals("+")) {return x + y;
        } else if (op.equals("-")) {return x - y;
        } else if (op.equals("*")) {return x * y;
        } else if (op.equals("/")) {return x / y;
        } else if (op.equals("^")) {return (float) Math.pow((int) x, (int) y);
        }
        return 0;
    }
    //existeOperador
    public boolean existeOperador(String operador) {
        String[] operadores = {"+", "-", "*", "/", "^"};
        for (String elemento : operadores) {
            if (elemento.equals(operador)) {
                return true;
            }
        }
        return false;
    }
     //Metodo de operaciones
    public void operaciones(ArrayList<String> operacion) {
        ArrayList<String> pila = new ArrayList<String>();
        String x, y;
        System.out.println("Posfijo: " + operacion);
        for (String valor : operacion) {
            if (Character.isDigit(valor.charAt(0))) {
                pila.add(valor);
            } else {
                 y = pila.remove(pila.size() - 1);
                 x = pila.remove(pila.size() - 1);
                String resultado = String.valueOf(resultados(Float.parseFloat(x), Float.parseFloat(y), valor));
                pila.add(resultado);
            }
        }
        System.out.println("Resultado: " + pila.get(0));
    }
}
