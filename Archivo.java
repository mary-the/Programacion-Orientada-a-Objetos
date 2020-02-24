package polinomios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Archivo {

    void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        int snn=1;
        do{
        Polinomios lista1 = new Polinomios();
        Polinomios lista2 = new Polinomios();
       
         String cadena; //String para la cadena que es la linea de mi texto
        //Para leer el archivo
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
       
        //Contadores
        int a=0; // lineas
        int p=0; // numeros
           
            //Para obtener los primeros dos numeros
           
            String[] parts = cadena.split(" ");
            String part1 = parts[0]; // 123
            String part2 = parts[1];
            int num1 = Integer.parseInt(parts[0]); 
            int num2 = Integer.parseInt(parts[1]); 
            int tnum= num1+num2;
            String arreglo[]= new String[tnum];
            int[] numero=new int[(tnum*2)+2]; 
         System.out.println("hola1");
                
        while((cadena = b.readLine())!=null) {          
            arreglo[a]=cadena; 
            System.out.println("hola2");
            //El arreglo[a] igual a la linea que esta recorriendo
            //Obtener los numeros 
            parts = arreglo[a].split(" ");
            part1 = parts[0]; 
            part2 = parts[1];
            p++;
            numero[p]=Integer.parseInt(parts[0]);
                    
            p++;
            numero[p]=Integer.parseInt(parts[1]);
            a++;
        } b.close();
               
        
         for (int i = 1; i <=((num1)*2); i=i+2) {
            // System.out.println(i+" "+(i+1));
             //System.out.println("");
             //System.out.println(numero[i]+" "+numero[i+1]);
             //System.out.println("");
             lista1.insertarFinal(numero[i],numero[i+1]);   
         }
        for (int i = (num1*2)+1; i <=(tnum*2); i=i+2) {
           /*    System.out.println(i+" "+(i+1));
             System.out.println("");
             System.out.println(numero[i]+" "+numero[i+1]);
             System.out.println("");*/
          lista2.insertarFinal(numero[i],numero[i+1]);
         }
       
         System.out.println("-------------------------M E N U---------------------------");
         System.out.println("1. Suma");
         System.out.println("2. Resta");
         System.out.println("3. Multiplicación");
         System.out.println("4. División: Cociente");
         System.out.println("5. División: Residuo.");
         Scanner opc= new Scanner(System.in);
         int op=opc.nextInt();
        switch (op){
             case 1: lista1.suma(lista2);
             lista1.recorrer();
             break;
             case 2: 
             lista2.cambiarSigno();
             lista1.suma(lista2);
             lista1.recorrer();
             break;
             case 3: 
             Polinomios lista3=lista1.multiplicar(lista2);
             lista3.recorrer();
             break;
             case 4: 
              lista1.division(lista2,1);
             break;
             case 5: 
              lista1.division(lista2,2);
             break;
         }
            System.out.println("");
            System.out.println("Si desea realizar otra operacion precione 1 (si no 0)");
            Scanner sn=new Scanner(System.in);
            snn=sn.nextInt();
        }while(snn==1); 
         }
     
	
}
