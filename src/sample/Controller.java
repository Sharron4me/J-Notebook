package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.sql.*;

public class Controller {
    @FXML
    public ListView filelist;

    public void createnew() {
        //System.out.println("Hi");
        try

        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("open.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("second page");
            stage.setScene(new Scene(root1));
            stage.show();

        }
        catch (Exception e)
        {
            System.out.println("Something Went Wrong");
        }
    }

    public void refresh() {
        //dATABASE BLOCK
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sherrinford\\Documents\\Jnotebook\\testjava.db");
            try {
                Statement statement = conn.createStatement();
                statement.execute("Create Table file_Name (Address VARCHAR(100),Parent_file VARCHAR(20))");
                statement.close();

            }
            catch(Exception e){
                System.out.println("Table already exits "+e);
            }
            String s ="Select * from file_name";
            Statement ps = conn.createStatement();
            try {
                ResultSet rs = ps.executeQuery(s);
                while(rs.next()){
                    String file_name =  rs.getString("Parent_file");
                    System.out.println(file_name);
                    filelist.getItems().add(file_name+".Java");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Something Went Wrong!  "+e);
        }
    }
}

