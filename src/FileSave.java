import java.io.*;

public  class  FileSave  {
    public static void writeFile(String fichero, Plane F18) throws IOException {
            File directorio = new File("data");
            directorio.mkdir();
            String fileName = "data/"+fichero+".dat";

            FileOutputStream outputFile = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(outputFile);
            ObjectOutputStream objectOutput = new ObjectOutputStream(bufferedOutput);
            objectOutput.writeObject(F18);

            outputFile.close();
            bufferedOutput.close();
            objectOutput.close();
    }
}
