import java.io.*;

public  class  FileSave  {
    public static void writeFile( Plane F18) throws IOException {

            File directorio = new File("data" );
            directorio.mkdir();
            String fileNamee = "data/plane.dat";


            FileOutputStream outputFile = new FileOutputStream(fileNamee);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(outputFile);

            ObjectOutputStream objectOutput = new ObjectOutputStream(bufferedOutput);


            objectOutput.writeObject(F18);
            objectOutput.close();
            bufferedOutput.close();
            outputFile.close();
    }

    public static Plane readFile() throws IOException, ClassNotFoundException {

            Plane a=null;
            try{
                    String fileName = "data/plane.dat";
                    FileInputStream inputFile = new FileInputStream(fileName);

                    BufferedInputStream bufferedInput = new BufferedInputStream(inputFile);
                    ObjectInputStream objectInput = new ObjectInputStream(bufferedInput);

                     a =(Plane) objectInput.readObject();
                    while(true){
                            System.out.println(a);
                            a = (Plane) objectInput.readObject();
                    }


            }catch (EOFException e){
                    System.out.println("terminado de leer fichero");
                    return a;

            }


    }
}
