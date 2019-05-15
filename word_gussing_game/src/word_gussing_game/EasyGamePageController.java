package word_gussing_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    Button answer_button;

    int count=10;

    // temporary word
    String word = "word";
    int point = count;
    char[] array = new char[10];

    @FXML
    //------------------------ getData from datebase & show first word for hint ------------
    public void getHintFromDatabase(){

        String firstWord = word.substring(0,1);
        hint_label.setText("Start with "+firstWord);


    }

    @FXML
    //------------------------ 10times and then decreasing ------------
    public void getLeftCount(){

        count_label.setText(String.valueOf(count));
    }

    @FXML
    public void correctWordChecker(ActionEvent ae){

        // get the word randomly from database
        //
        //
        //
        //
        //


        String getText = getWord_text.getText();

        if(getText.length() == 4) {
            if (getText.equals(word)) {
                System.out.println("Answer is Correct!");
                point = count;


            } else {

                for (int i = 0; i < word.length(); i++) {
                    if (getText.charAt(i) == word.charAt(i)) {
                        System.out.print(getText.charAt(i) + " ");
                    } else {
                        System.out.print("- ");


                    }


                }
                count--;
                System.out.println(count);
                point=count;
                System.out.println("Point: " + point);
                refresh();

            }
        }else
        {
            System.out.println("Too long word or short");
        }
        }




        @FXML
        public void refresh(){
            getLeftCount();
        }


    // --------------------------- initialize ---------------------------------
    @FXML
    public void initialize(URL location, ResourceBundle resources ) {

        getHintFromDatabase();
        getLeftCount();

    }
}
