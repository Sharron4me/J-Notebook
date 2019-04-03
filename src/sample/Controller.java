package sample;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Controller {
    @FXML
    public ListView filelist;
    public TextField file_pro_name;
    public Label error_message;

    public void createnew() {

        //dATABASE BLOCK

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sherrinford\\Documents\\Github\\testjava.db");
            try {
                Statement statement = conn.createStatement();
                statement.execute("Create Table file_Name (Address VARCHAR(100),Parent_file VARCHAR(20))");
                statement.close();

            }
            catch(Exception e){
                System.out.println("Table already exits "+e);
            }

            String Check="SELECT COUNT(*) FROM  file_Name WHERE Parent_file=?";
            PreparedStatement chk_statement = null;
            chk_statement=conn.prepareStatement(Check);
            chk_statement.setString(1,file_pro_name.getText());
            ResultSet rs=chk_statement.executeQuery();
            int counter =rs.getInt("COUNT(*)");
            chk_statement.close();
            if(counter>0 || (file_pro_name.getText() == "")){
                error_message.setVisible(true);
                error_message.setText("File Name Already Exists!! Please Choose another one");
            }
            else {
                if (file_pro_name.getText().isEmpty())
                {
                    System.out.println("File name field cannot be left empty !");
                    error_message.setVisible(true);
                    error_message.setText("File name field cannot be left empty !");
                }
                else
                {
                    error_message.setVisible(false);
                    String sql_insert = "Insert INTO file_Name (Address,Parent_file) values (?,?)";
                    PreparedStatement ps = null;
                    ps = conn.prepareStatement(sql_insert);
                    ps.setString(1, "C:\\"+file_pro_name.getText()+".java");
                    ps.setString(2, file_pro_name.getText());
                    ps.execute();
                    ps.close();
                    try

                    {
                        FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("open.fxml"));
                        System.out.println("Correct Here");
                        Parent root1 =  FXMLLoader.load(Controller.class.getResource("open.fxml"));
                        openController openController = fxmlLoad.getController();
                        openController.setFile_name(file_pro_name.getText());
                        Stage stage = new Stage();
                        stage.setTitle(String.valueOf(file_pro_name.getText())+".java");
                        stage.setScene(new Scene(root1,900,1000));
                        stage.show();

                    }
                    catch (Exception e)
                    {
                        System.out.println("Something Went Wrong:"+e);
                        e.printStackTrace();
                    }
                }

            }
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Something Went Wrong!  "+e);


            e.printStackTrace();
        }

    }

    public void refresh() {
        //clearing listView

        filelist.getItems().clear();

        //dATABASE BLOCK
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sherrinford\\Documents\\Github\\testjava.db");
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

            e.printStackTrace();
        }
    }

}

