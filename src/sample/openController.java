package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class openController implements Initializable
 {
     @FXML
    public TextArea modules_import;
    public TextArea main_code;
    public TextArea Output;
    public TextArea classes;
    public Label file_name;
    static String file_name_java;
     static String name;
     @Override
     public void initialize(URL location, ResourceBundle resources)
     {

     }
     public static void setFile_name(String text)
     {
         //file_name.setText(text+".java");
         System.out.println(text);
         name=text;
         file_name_java=name;
     }

     public void compile_file(ActionEvent actionEvent) {
        try
        {
            file_name.setText(name);
            file_name_java=file_name.getText();
            System.out.println(modules_import.getText()+"\n"+main_code.getText()+"\n"+classes.getText());
            String final_string = modules_import.getText()+ "\n public class "+name+"{ \n \t" + classes.getText()+"\n \t  public static void main(String argv[]) { \n \t"+main_code.getText()+" \n \t } \n }";
            try{
                FileWriter fw=new FileWriter("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\programs\\"+file_name_java+".java");
                fw.write(final_string);
                fw.close();
            }
            catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Success...");

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c","Start", "Main.bat",file_name_java);
            File dir = new File("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch");
            pb.directory(dir);
            Process p = pb.start();
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\output_"+file_name_java+".txt"))) {

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
        file_name_java=file_name.getText();
        try
        {
            System.out.println(modules_import.getText()+"\n"+main_code.getText()+"\n"+classes.getText());
            String final_string = modules_import.getText()+ "\n public class "+name+"{ \n \t" + classes.getText()+"\n \t  public static void main(String argv[]) { \n \t"+main_code.getText()+" \n \t } \n }";
            try{
                FileWriter fw=new FileWriter("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\programs\\"+file_name_java+".java");
                fw.write(final_string);
                fw.close();
            }
            catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Success...");

            ProcessBuilder pb = new ProcessBuilder("cmd", "/c","Start", "Run_program.bat",file_name_java);
            File dir = new File("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch");
            pb.directory(dir);
            Process p = pb.start();
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }

        String output_string="";

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\error_"+file_name_java+".txt"))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                output_string+=sCurrentLine+"\n";
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sherrinford\\Documents\\Github\\src\\batch\\output_"+file_name_java+".txt"))) {

            String sCurrentLine;
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
