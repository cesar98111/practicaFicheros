import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);

        Plane F18 = null;
        File fileName = new File("data/plane.dat");
        if(fileName.exists()){
           F18=FileSave.readFile();
        }


        String opcion = "";


        while(!opcion.equals("q")){
            System.out.println("introduce una opcion");
            System.out.println("1. para mostrar datos del avion o para rellenar formulario de piloto");
            System.out.println("2. para cambiar estado de los flags");
            System.out.println("3. para subir o bajar el tred de aterrizaje");
            System.out.println("4. para activar los sistemas de eyeccion");
            System.out.println("5. para meter un piloto en la cabina");
            opcion = sc.nextLine();
            switch (opcion){
                case "1":

                    if(!fileName.exists()){

                        System.out.println("------------------------------- cuestionario para piloto -------------------------------");
                        System.out.println("");
                        System.out.println("introduzca el numero de litros de combustible");
                        int conbustible = sc.nextInt();
                        sc.nextLine();
                        System.out.println("introduzca apodo del piloto");
                        System.out.println("");
                        String apodo = sc.nextLine();
                        System.out.println("introduzca el numero de escuadron");
                        System.out.println("");
                        String escuadron = sc.nextLine();

                        F18 = new Plane(conbustible,apodo,escuadron);

                        System.out.println(F18);
                        FileSave.writeFile(F18);

                    }else{
                        F18 = FileSave.readFile();
                    }
                    break;

                case "2":

                    if(fileName.exists()){
                        F18.toggleFlaps();
                        System.out.println(F18);
                    }else{
                        System.out.println("no exixte ningun avion registrado por favor registrese");
                    }
                    break;

                case "3":

                    if(fileName.exists()){
                        F18.toggleLandingGear();
                        System.out.println(F18);
                    }else{
                        System.out.println("no existe ningun avion registrado por favor registrese");
                    }


                    break;

                case "4":

                    if(fileName.exists()){
                        F18.tejectionSystem();
                        System.out.println(F18);
                    }else{
                        System.out.println("no existe ningun avion registrado por favor registrese");
                    }


                    break;
                case "5":
                    if(fileName.exists()){
                        F18.setSeatOccupation(true);
                        System.out.println(F18);
                    }else{
                        System.out.println("no existe ningun avion registrado por favor registrese");
                    }


                    break;
                case "q":


                    FileSave.writeFile(F18);

                    System.out.println("cambios guardados\n" +
                            "saliendo...");

                    break;
                default:
                    System.out.println("opcion incorrecta");




            }


        }
    }
}