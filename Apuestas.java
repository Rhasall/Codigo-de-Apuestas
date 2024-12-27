package apuestas;
import java.util.Scanner;
import java.time.*;
import java.util.Random;
public class Apuestas 
{
    // ------------------ VARIABLES GLOBALES ---------------//
    
    static int totalPrecioPrimitiva = 0, precioPrimitiva = 1;
    static double totalPrecioQuiniela = 0, precioQuiniela = 0.50;
    static int totalPrecioLoteria = 0, precioLoteria = 12;
    static boolean sigo = true;
  // -------------------- PRIMITIVA --------------//
    
    public static void SorteoJueves() // ver el dia que toca para jugar la Primitiva
    {
        var hoy = LocalDateTime.now();
        var proxJueves = hoy.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.THURSDAY));
        
        Period hastaProxJueves = Period.between(hoy.toLocalDate(), proxJueves.toLocalDate());
        int dias = hastaProxJueves.getDays(); // que quedan hasta el proximo jueves
        
        System.out.println("Proximo sorteo: jueves " + proxJueves.getDayOfMonth() + " de " + proxJueves.getMonth() + " de " + proxJueves.getYear());
        System.out.println("Tiempo restante: " + dias + " dias");
    }
    
    public static int [] ApuestaPrimitiva(int [] numero) // funcion para no repetir numeros de la primitiva
    {
        int ArrayPrimitiva [] = new int [8];
        for (int x=0; x<=5; x++) 
        {
            int num;// para verificar si lo repito
            boolean repetido;
            do {
                num=(int) Math.floor(Math.random() * 48 + 1); // le doy valor aleatorio a num
                repetido=false; // doy valor al booleano para poder trabajar
                for (int y = 0; y < x;y++)
                {
                if (ArrayPrimitiva[y] == num){repetido = true;break;} // si repito numero empiezo de nuevo el bucle
                }
            }while (repetido ==true); // repetir hasta que no se repita
   
            ArrayPrimitiva[x] = (int) Math.floor(Math.random() * 48 + 1); // doy valor a la posicion y despues empieza el bucle de nuevo
            
        //-------------------------------------------------------------------------------------------------------
        }
        do {            
        ArrayPrimitiva[6] = (int) Math.floor(Math.random() * 9 + 0); // aqui saco el complemento y me aseguro de que no repita con los otros
        } 
        while((ArrayPrimitiva[6]==ArrayPrimitiva[5])||(ArrayPrimitiva[6]==ArrayPrimitiva[4])||(ArrayPrimitiva[6]==ArrayPrimitiva[3])||(ArrayPrimitiva[6]==ArrayPrimitiva[2])||(ArrayPrimitiva[6]==ArrayPrimitiva[1])||(ArrayPrimitiva[6]==ArrayPrimitiva[0]));
        do 
        {                
        ArrayPrimitiva[7] = (int) Math.floor(Math.random() * 9 + 0); // compruebo que reintegro no se repita con el complemento
        } 
        while((ArrayPrimitiva[7]==ArrayPrimitiva[6])||(ArrayPrimitiva[7]==ArrayPrimitiva[5])||(ArrayPrimitiva[7]==ArrayPrimitiva[4])||(ArrayPrimitiva[7]==ArrayPrimitiva[3])||(ArrayPrimitiva[7]==ArrayPrimitiva[2])||(ArrayPrimitiva[7]==ArrayPrimitiva[1])||(ArrayPrimitiva[7]==ArrayPrimitiva[0]));
        return ArrayPrimitiva;
    }
    
    public static void ImprimirArrayPrimitiva(int [] array) // funcion simple para imprimir array de la primitiva
    {
        for (int x=0; x<=5 ;x++)
        {
            System.out.print(array[x] + " ");
        }
        System.out.println("");
        System.out.println("Complementario: " + array[6]);
        System.out.println("Reintegro: " + array[7]);
    }
    // ----------QUINIELA ---------------//
    
    public static void SorteoDomingo() // ver el dia que toca para jugar la quiniela
    {
        var hoy = LocalDateTime.now();
        var proxDomingo = hoy.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.SUNDAY));
        
        Period hastaProxDomingo = Period.between(hoy.toLocalDate(), proxDomingo.toLocalDate());
        int dias = hastaProxDomingo.getDays(); // que quedan hasta el proximo jueves
        
        System.out.println("Proxima jornada" + proxDomingo.getDayOfMonth() + " de " + proxDomingo.getMonth() + " de " + proxDomingo.getYear());
        System.out.println("Tiempo restante: " + dias + " dias");
    }    

    public static String RandomQuiniela() // par generar el 1 X 2 de la quiniela
    {
        Random cadena= new Random();
        int aleatorio = cadena.nextInt(3); // aleatoriamente generare del 1 al 3
        if (aleatorio == 0){ return"X";}
        else if (aleatorio == 1){return "1";}
        else if (aleatorio == 2){return "2";}
        return null;
    }
    public static int ApuestasQuiniela(int opcion) // funcion para rellenar las quinielas
    {
        String cuartilla []  = new String [15];
        System.out.println("¿cuantas apuestas quieres (2-8)?");  
        opcion = Scanner();
        try 
        {
             if (opcion <2 || opcion >8)
             {
             System.out.println("Numero de apuestas incorrecto");
             }
             else {
             
                 for (int i=0;i<opcion;i++)
                 {
                    
                    System.out.print("Apuesta "+(i+1)+": ");  
                    for (int x=0;x<cuartilla.length;x++)
                    {
                    cuartilla [x] = RandomQuiniela();//relleno con datos random de la funcion RandomQuiniela
                        System.out.print(cuartilla[x]+" "); // imprimo el resultado
                    }
                     System.out.println(""); // imprimo salto de linea
                     
                     totalPrecioQuiniela = totalPrecioQuiniela+ precioQuiniela; // actualizo el total que debe pagar en eel bucle
                 }
             }
        } catch (Exception e) {
            System.out.println("eso no es un numero, por favor introduce un numero entero del 2 al 8");
        }
        
        return opcion;
    }
    // ---------- LOTERIA -------------//
    
    public static void SorteoSabado() // ver el dia que toca para jugar la Loteria
    {
        var hoy = LocalDateTime.now();
        var proxSabado = hoy.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.SATURDAY));
        
        Period hastaProxSabado = Period.between(hoy.toLocalDate(), proxSabado.toLocalDate());
        int dias = hastaProxSabado.getDays(); // que quedan hasta el proximo jueves
        
        System.out.println("Proximo sorteo: " + proxSabado.getDayOfMonth() + " de " + proxSabado.getMonth() + " de " + proxSabado.getYear());
        System.out.println("Tiempo restante: " + dias + " dias");
    }  
    public static int RandomLoteria() // para generar numeros aleatorios de Loteria
    {
        Random numeros= new Random();
        int aleatorio = numeros.nextInt(100); // generar numeros aleatorios del 1 al 100
        return aleatorio;
    }
    
    public static int [] BoletoLoteria (int num) //recibo numero para saber cuantos numeros generar y devuelvo array
    {
     int boleto []= new int[5];
     
        for (int x=0;x<boleto.length-num;x++) // relleno el array con numero aleatorios, me da igual si se repiten
        {
         boleto[x]= RandomLoteria();
        }
        
        for (int y=boleto.length-num;y<boleto.length;y++)
        {
        System.out.println("dime el numero a ingresar en "+(y+1)+"º lugar: ");
        
            try 
            {
            boleto [y]= Scanner();
            }
            catch (Exception e) 
            {
                System.out.println("solo numeros enteros please");
                y--; // para repetir si introduje mal el dato
            }
        }
        return boleto;
    
    }
    
     public static void ImprimirArrayLoteria(int [] numero) // funcion simple para imprimir array de la primitiva
    {
        for (int x=0; x<numero.length ;x++)
        {
            System.out.print(numero[x] + " ");
        }
        System.out.println();
     }
    // --------------- OPCIONES BASICAS--------------------//

public static int Seleccion(int a) // funcion de ejecutar el menu que selecciono
    {
        
        switch (a) {
            case 1:
                
                int [] numeroAleatorio = new int[8];
                SorteoJueves();
                numeroAleatorio = ApuestaPrimitiva(numeroAleatorio);
                ImprimirArrayPrimitiva(numeroAleatorio);
                totalPrecioPrimitiva += precioPrimitiva;
                break;
                
            case 2:
                int cantidad =0;
                SorteoDomingo(); // imprimo cuando toca el sorteo
                ApuestasQuiniela(cantidad); // pido la cantidad de quinielas que quiere hacer
                break;
                
            case 3:
                int boleto [] = new int [5];
                int opcion=-1; //pongo negativo para inicializar sin errores
                boolean testeo=true;
                
                do{
                SorteoSabado();// imprimo cuando es el sorteo
                System.out.println("Elige terminacion hasta 3 cifras (0 si te da igual): "); // con ENTER no me sale
                try
                {
                opcion = Scanner();
                    if (opcion < 0 || opcion > 3) 
                    {
                    System.out.println("Opcion invalida, te lo doy totalmente aleatorio");
                    opcion = 0;
                    }
                    testeo=false; // para salir del bucle
                } 
                catch (Exception e) 
                {
                    System.out.println("introduce un numero entero del 0 al 3");
                    testeo=true;
                }
                }
                while (testeo == true);
                 
                boleto=BoletoLoteria(opcion);// genero el numero
                System.out.print("Numero con el que juegas :"); //imprimo el boleto
                ImprimirArrayLoteria(boleto);
                System.out.println("");
                System.out.println("Serie: " + RandomLoteria());
                System.out.println("Fraccion: "+RandomLoteria());
                totalPrecioLoteria += precioLoteria;
                break;
                
            case 0:
                
                double resultado = (double) totalPrecioPrimitiva + totalPrecioQuiniela + totalPrecioLoteria;
                System.out.println(".........................................................");
                System.out.printf("Total a pagar es: %.2f€\n", resultado);
                System.out.println(".........................................................");
                sigo = false;
                break;
                
            default:
                System.out.println("Opcion no valida, escoge del 0 al 3");
                break;
        }
        return a;
    }

    public static void menu() //imprimir menu inicial
    {
        System.out.println("....................");
        System.out.println("LOTERIAS Y APUESTAS");
        System.out.println("....................");
        System.out.println("");
        System.out.println("1 - Primitiva");
        System.out.println("2 - Quiniela");
        System.out.println("3 - Loteria");
        System.out.println("0 - Salir");
        System.out.println("");
    }

    public static int Scanner() //funcion del scanner
    {     
        Scanner lectura = new Scanner(System.in);
        int opcion = lectura.nextInt();
        return opcion;
    }

    public static void main(String[] args) 
    {
        int opcion = 0;  
        do
        {            
            menu();
            System.out.println("Elige juego: ");
            try // meto try catch para verificar los datos siempre
            {
                opcion = Scanner();  
            } 
            catch (Exception e) 
            {
                System.out.println("Opcion no valida, por favor introduce un numero entero");
            }
            Seleccion(opcion);
        } while (sigo == true);
    }  
}