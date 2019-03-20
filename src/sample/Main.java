package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //dATABASE BLOCK
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sherrinford\\Documents\\Jnotebook\\testjava.db");
            Statement statement = conn.createStatement();
            try {
                statement.execute("Create Table file_Name (Address VARCHAR(100),Parent_file VARCHAR)");
            }
            catch(Exception e){
                System.out.println("Table already exits "+e);
            }
            statement.close();
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Something Went Wrong!  "+e);
        }

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



    public static void main(String[] args) {

        launch(args);
    }
}
