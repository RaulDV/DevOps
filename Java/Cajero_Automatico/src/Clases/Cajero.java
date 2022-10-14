package Clases;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Cajero {
    SimpleDateFormat standar;
    String standarFormat;
    float Saldo=1000;
    float ret;



    private static ArrayList<ArrayList> Movimiento=new ArrayList<>();
    private static ArrayList<String> Mov;

    public static void main (String[] args){
        SimpleDateFormat standar;
        String standarFormat;

        standar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Cajero Despliegue=new Cajero();

    if(Despliegue.pin()) {
        while (true) {
            try {
                Scanner entrada = new Scanner(System.in);
                int op = 0;
                ArrayList<String> tacos = new ArrayList<>();

                System.out.println("Menu: ");
                System.out.println("Consulta de saldo: 1");
                System.out.println("Retiro de saldo: 2");
                System.out.println("Historico de movimientos: 3");
                System.out.println("Salir: 4");
                op = entrada.nextInt();


                if (op == 1) {
                    Despliegue.consulta();
                    if (Despliegue.subMenu()) {
                        break;
                    }
                } else if (op == 2) {
                    Mov = new ArrayList<>();
                    Despliegue.retiro();
                    Despliegue.gethora();
                    Movimiento.add(Mov);
                    if (Despliegue.subMenu()) {
                        break;
                    }
                } else if (op == 3) {
                    Despliegue.Historic();
                    if (Despliegue.subMenu()) {
                        break;
                    }
                } else if (op == 4) {

                    break;
                } else {
                    System.out.println("No introdujiste un numero entre las opciones");
                }
            } catch (Exception e) {
                System.out.println("Error");
                System.out.println("No introdujiste un caracter numerico o un numero entero");
            }
        }
    }else{
        System.out.println("Sobre pasaste los tres intentos permisibles");
        System.out.println("Su tarjeta ha sido bloqueada, presentese a sucursal o llame al numero del banco para desbloquearla");
    }
        System.out.println("Terminando operaciones del cajero");
        System.out.println("Gracias por usar nuestro cajero");
        System.out.println("Hasta pronto");
    }
    public void consulta(){
        System.out.println("Tu saldo actual es: "+ Saldo);
    }
    public void retiro(){
        while (true) {
            try {
                Scanner entrada = new Scanner(System.in);
                System.out.println("Digita la cantidad a retirar: ");
                ret = entrada.nextFloat();
                if (ret <= 0) {
                    System.out.println("No puedes introducir cantidades negativas o 0");
                } else if (ret>Saldo) {
                    System.out.println("No cuentas con saldo suficiente");
                    break;
                }else {
                    String sret = Float.toString(ret);
                    String ssaldo = Float.toString(Saldo);
                    Mov.add(sret);
                    Mov.add(ssaldo);
                    Saldo -= ret;
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error");
                System.out.println("Solo puedes introducir caracteres numericos");
            }


        }

    }
    public  void gethora() {
        Calendar now = new GregorianCalendar();
        Date nowDate=now.getTime();
        standar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        standarFormat=standar.format(nowDate);
        Mov.add(standarFormat);

    }
    public void Historic(){

        System.out.println("Lista de Movimientos");
        if (Movimiento.isEmpty()) {
            System.out.println("Aun no ha hecho movimientos");
        }else {
            for (ArrayList i : Movimiento) {
                System.out.println("Retiro: " + i.get(0) + " Saldo anterior: " + i.get(1) + " Fecha: " + i.get(2));
            }
        }

    }

    public boolean subMenu() {
        boolean d=false;
        while (true) {
            Scanner entrada = new Scanner(System.in);
            int op;

            try {

                System.out.println("Regresar al menu: 1");
                System.out.println("Salir: 2");
                System.out.println("Digite una opcion: ");
                op = entrada.nextInt();
                if (op == 1) {
                    System.out.println("Regresando al menu");
                    d=false;
                    break;
                } else if (op == 2) {

                    d=true;

                    break;

                } else {
                    System.out.println("Digite el numero de una de las opciones");
                }
            }catch (Exception e){
                System.out.println("Error");
                System.out.println("Introduzca un  caracter numerico entero");
            }

        }
        return d;
    }
    public boolean pin(){
        boolean d=false;
        int pin=1235;
        int nip;
        int c=0;
        while (c<3){
            Scanner entrada = new Scanner(System.in);

            try{
                System.out.println("Introduzca su pin: ");
                nip= entrada.nextInt();
                if (nip==pin){
                    System.out.println("Bienvenido Raul");
                    d=true;
                    break;
                }else{
                    System.out.println("pin incorrecto");
                    c+=1;
                    d=false;
                }
            }catch (Exception e){
                System.out.println("Porfavor introduzca numeros enteros y ningun otro tipo de caracter");
            }
        }
        return d;
    }

}
