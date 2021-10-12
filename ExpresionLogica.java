package programa1_programacionlogica;
import java.util.Scanner;
public class ExpresionLogica {
    
   Scanner entrada = new Scanner(System.in);
    
    public void Logica(){
     
  
    
     System.out.println("La expresion a realizar es [(p->q)^p]->q\n");  
    
     
    String p[]={"V","V","F","F"};
    String q[]={"V","F","V","F"};
    String [] aux= new String[4];
    String [] aux1= new String[4];
    String [] aux2= new String[4];
    
    
    //Condicional
    for(int i=0; i<p.length; i++){
        if(p[i].equals("V") && q[i].equals("F")){
         aux[i]="F";
         
         }else{
             aux[i]="V";
         }
     }  
    //Conjucional
          for(int i=0; i<p.length; i++){
         if(aux[i].equals("V") && p[i].equals("V")){
           aux1[i]="V";
         
         }else{
             aux1[i]="F";
         }
          }
        System.out.println("p"+"  "+"q"+"   "+"(p->q)"+" "+"p"+"   "+"[(p->q)^p]"+"  "+"q"+"  "+"[(p->q)^p]->q");
        //Condicionl
        for(int i=0; i<q.length; i++){
         if(aux1[i].equals("V") && q[i].equals("F")){
           aux2[i]="F";
         }else{
             aux2[i]="V";
             
         }
            System.out.println(p[i]+"  "+q[i]+"    "+aux[i]+"     "+p[i]+"        "+aux1[i]+"      "+q[i]+"      "+aux2[i] );   
          }
    }}
   
      

       
