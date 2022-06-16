import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);

        File fileName = new File("data/plane.dat");
        Plane F18=null;
        String opcion = "";
        String name = "plane";
        while(!opcion.equals("q")){
            System.out.println("introduce una opcion");
            opcion=sc.nextLine();
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

                    }else{
                        F18=FileSave.readFile(name);
                    }
                    break;
                case "2":

                    F18.toggleFlaps();

                    System.out.println(F18);

                    break;
                case "3":

                    F18.toggleLandingGear();

                    break;
                case "4":

                    F18.tejectionSystem();

                    break;
                case "5":

                    F18.setSeatOccupation(true);

                    break;
                case "q":


                    FileSave.writeFile(name,F18);

                    break;
                default:
                    System.out.println("opcion incorrecta");




            }


        }
    }
}