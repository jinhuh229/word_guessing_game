package word_gussing_game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainGameScreenController {

    @FXML
    Label display_id;

    @FXML
    Button easy_mode_button;
    Button hard_mode_button;



    public void showLabel(String name){
        display_id.setText("Welcome " + name);
    }

    public void easy_button(){
        try {


            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("easy_game_page.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            //get the username for getting from database
            //EasyGamePageController easy = fxmlLoader.getController();
            //easy.showLabel(login.getUserName());

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void hard_button(){
        try {


            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("hard_game_page.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            //get the password for getting from database
            //HardGamePageController hard = fxmlLoader.getController();
            //hard.showLabel(login.getUserName());


            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void initialize() {

        // display the account userID
        //login log = new login();


    }

    }




