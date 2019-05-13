package game_mode;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EasyGamePageController implements Initializable {


    @FXML
    Label hint_label;

    @FXML
    Label count_label;

    @FXML
    Label correct_label;

    @FXML
    TextField getWord_text;

    int count=10;
    String word = "word";


    //------------------------ getData from datebase & show first word for hint ------------
    public void getHintFromDatabase(){

        String firstWord = word.substring(0,1);
        hint_label.setText("Start with "+firstWord);


    }

    //------------------------ 10times and then decreasing ------------
    public void getLeftCount(){

        count_label.setText(String.valueOf(count));
    }

    public void correctWordChecker(){

        String getText = getWord_text.getText();

        if(getText == word){

        }else{

            }
        }





    // --------------------------- initialize ---------------------------------
    @FXML
    public void initialize(URL location, ResourceBundle resources ) {

        getHintFromDatabase();
        getLeftCount();

    }
}
