package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;

public class openController {
    public TextArea modules_import;
    public TextArea main_code;
    public TextArea Output;
    public TextArea classes;

    public void compile_file(ActionEvent actionEvent) {
        try
        {
            System.out.println(modules_import.getText()+"\n"+main_code.getText()+"\n"+classes.getText());
            String final_string = modules_import.getText()+ "\n public class abc{ \n \t" + classes.getText()+"\n \t  public static void main(String argv[]) { \n \t"+main_code.getText()+" \n \t } \n }";
            try{
                FileWriter fw=new FileWriter("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\programs\\abc.java");
                fw.write(final_string);
                fw.close();
            }
            catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Success...");

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c","Start", "Main.bat",modules_import.getText(),main_code.getText(),classes.getText());
            File dir = new File("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch");
            pb.directory(dir);
            Process p = pb.start();
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\output_abc.txt"))) {

            String sCurrentLine;
            String output_string="";
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                output_string+=sCurrentLine+"\n";
            }
            Output.setText(output_string);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run_code(ActionEvent actionEvent) {

        try
        {
            System.out.println(modules_import.getText()+"\n"+main_code.getText()+"\n"+classes.getText());
            String final_string = modules_import.getText()+ "\n public class abc{ \n \t" + classes.getText()+"\n \t  public static void main(String argv[]) { \n \t"+main_code.getText()+" \n \t } \n }";
            try{
                FileWriter fw=new FileWriter("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\programs\\abc.java");
                fw.write(final_string);
                fw.close();
            }
            catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Success...");

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c","Start", "Run_program.bat",modules_import.getText(),main_code.getText(),classes.getText());
            File dir = new File("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch");
            pb.directory(dir);
            Process p = pb.start();
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\output_abc.txt"))) {

            String sCurrentLine;
            String output_string="";
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                output_string+=sCurrentLine+"\n";
            }
            Output.setText(output_string);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
