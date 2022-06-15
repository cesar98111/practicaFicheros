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
}
