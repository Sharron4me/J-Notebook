package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.io.FileWriter;

import java.io.File;

public class openController {
    public TextArea modules_import;
    public TextArea main_code;
    public TextArea Output;
    public TextArea classes;

    public void compile_file(ActionEvent actionEvent) {
        try
        {
            System.out.println(modules_import.getText()+"\n"+main_code.getText()+"\n"+classes.getText());
            String final_string = modules_import.getText()+ "\n public class abc{ \n" + classes.getText()+"\n public static void main(String argv[]) { \n"+main_code.getText()+"\n } \n }";
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
    }
}
