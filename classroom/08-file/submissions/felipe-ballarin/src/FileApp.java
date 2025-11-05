import java.util.Date;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import static java.lang.System.out;


public class FileApp {
    
    public static void main(String[] args){

        out.println("________________________________________________");
        out.println("1. List Files in Directory: ");

        File file = new File("../../data");
        for(String nomes:file.list()){
            out.println(nomes);
        }


        out.println("________________________________________________");
        out.println("2. Check Path Exists: ");

        out.println("testando com um diretorio nada a ver '/home/students/xyz.txt' ");
        File my_file_dir = new File("/home/students/xyz.txt");
         if (my_file_dir.exists()) 
           {
            out.println("O diretorio ou arquivo existe.\n");
           } 
         else
          {
            out.println("O diretorio ou arquivo nao existe.\n");
          }

        out.println("testando com clients.txt");
        File clients_dir = new File("../../data/clients.txt");
         if (clients_dir.exists()) 
           {
            out.println("O arquivo existe.");
           } 
         else
          {
            out.println("O arquivo nao existe.");
          }


        out.println("________________________________________________");
        out.println("3. Read File Line by Line: ");

        BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader( new FileReader("../../data/clients.txt"));
            while( (strLine = br.readLine()) != null){
                out.println(strLine);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }


        out.println("________________________________________________");
        out.println("4. Append Text to File: ");

        StringBuilder sb = new StringBuilder();
        String strLine = "";
        try{
            String filename= "/home/students/myfile.txt";
            FileWriter fw = new FileWriter(filename,false); 
            //appends the string to the file
            fw.write("Python Exercises\n");
            fw.close();
            BufferedReader br = new BufferedReader(new FileReader("/home/students/myfile.txt"));
            //read the file content
            while (strLine != null){
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
                System.out.println(strLine);
            }
            br.close();   

        }catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }


        out.println("________________________________________________");
        out.println("5. Write Text File: ");


        out.println("________________________________________________");
        out.println("6. Copy File: ");


        out.println("________________________________________________");
        out.println("7. Delete: ");


        out.println("________________________________________________");
        out.println("8. Directory Tree Walk: ");


        out.println("________________________________________________");
        out.println("9. File Attributes and Metadata: ");


    }
}
