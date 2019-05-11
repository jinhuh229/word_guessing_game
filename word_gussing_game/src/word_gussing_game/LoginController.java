package word_gussing_game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    @FXML
    Button login_button;

    @FXML
    TextField username_text;

    @FXML
    PasswordField password_text;

    @FXML
    Label lost_password_text;

    @FXML
    Label no_account_text;

    @FXML
    Label exit_text;


    @FXML
    public void login_clicked() throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM login WHERE userName =? and password =?";


        String userName = username_text.getText();
        String password = password_text.getText();

        try {


            Connection con = DBConnection.getConnection();
            preparedStatement = con.prepareStatement(query);


            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();


            if(!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User Name or Password is incorrect", ButtonType.CLOSE);
                alert.showAndWait();
            }
            else {


                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("main_game_screen.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


                Stage stage = (Stage) login_button.getScene().getWindow();
                stage.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        }


        // ---------------------------------   No Account Mouse Clicked (Label) --------------------------------------------
        @FXML
        public void no_account_clicked(){

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("RegisterScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // ---------------------------------   Close the window when click the X  (Label) --------------------------------------------
        @FXML
        public void close_window(){
            Stage stage = (Stage) exit_text.getScene().getWindow();
            stage.close();
        }


    // ---------------------------------   Pressed the enter to login --------------------------------------------
        @FXML
        public void pressed_enter(ActionEvent ae){
            PreparedStatement preparedStatement = null;
            String query = "SELECT * FROM login WHERE userName =? and password =?";


            String userName = username_text.getText();
            String password = password_text.getText();

            try {


                Connection con = DBConnection.getConnection();
                preparedStatement = con.prepareStatement(query);


                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();


                if(!resultSet.next()) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User Name or Password is incorrect", ButtonType.CLOSE);
                    alert.showAndWait();
                }
                else {


                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("main_game_screen.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Stage stage = (Stage) login_button.getScene().getWindow();
            stage.close();

        }


    // ---------------------------------   get information about account  --------------------------------------------
        @FXML
        public String getInformaiton(){


            String getuserName = username_text.getText();

            System.out.println(getuserName);

            return getuserName;


        }



    }




