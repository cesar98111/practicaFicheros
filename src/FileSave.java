import java.io.*;

public  class  FileSave  {
    public static void writeFile(String fichero, Plane F18) throws IOException {

            File directorio = new File("data" );
            directorio.mkdir();
            String fileNamee = "data/"+fichero+".dat";


            FileOutputStream outputFile = new FileOutputStream(fileNamee);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(outputFile);

            ObjectOutputStream objectOutput = new ObjectOutputStream(bufferedOutput);


            objectOutput.writeObject(F18);
            objectOutput.close();
            bufferedOutput.close();
            outputFile.close();
    }
    public static Plane readFile(String name) throws IOException, ClassNotFoundException {
            Plane a=null;
            try{
                    String fileName = "data/"+name+".dat";
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
