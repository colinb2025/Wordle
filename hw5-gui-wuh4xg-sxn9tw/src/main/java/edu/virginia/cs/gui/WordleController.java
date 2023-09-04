package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.LetterResult;
import edu.virginia.cs.wordle.*;
import edu.virginia.cs.wordle.WordleDictionary;
import edu.virginia.cs.wordle.WordleImplementation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WordleController {

    @FXML
    HBox word1;

    @FXML
    HBox word2;

    @FXML
    HBox word3;

    @FXML
    HBox word4;

    @FXML
    HBox word5;

    @FXML
    HBox word6;

    @FXML
    TextField textField1;

    @FXML
    TextField textField2;

    @FXML
    TextField textField3;

    @FXML
    TextField textField4;

    @FXML
    TextField textField5;

    @FXML
    TextField textField6;

    @FXML
    TextField textField7;

    @FXML
    TextField textField8;

    @FXML
    TextField textField9;

    @FXML
    TextField textField10;

    @FXML
    TextField textField11;

    @FXML
    TextField textField12;

    @FXML
    TextField textField13;

    @FXML
    TextField textField14;

    @FXML
    TextField textField15;

    @FXML
    TextField textField16;

    @FXML
    TextField textField17;

    @FXML
    TextField textField18;

    @FXML
    TextField textField19;

    @FXML
    TextField textField20;

    @FXML
    TextField textField21;

    @FXML
    TextField textField22;

    @FXML
    TextField textField23;

    @FXML
    TextField textField24;

    @FXML
    TextField textField25;

    @FXML
    TextField textField26;

    @FXML
    TextField textField27;

    @FXML
    TextField textField28;

    @FXML
    TextField textField29;

    @FXML
    TextField textField30;

    public void initialize() {
        textField6.setEditable(false);
        textField7.setEditable(false);
        textField8.setEditable(false);
        textField9.setEditable(false);
        textField10.setEditable(false);
        textField11.setEditable(false);
        textField12.setEditable(false);
        textField13.setEditable(false);
        textField14.setEditable(false);
        textField15.setEditable(false);
        textField16.setEditable(false);
        textField17.setEditable(false);
        textField18.setEditable(false);
        textField19.setEditable(false);
        textField20.setEditable(false);
        textField21.setEditable(false);
        textField22.setEditable(false);
        textField23.setEditable(false);
        textField24.setEditable(false);
        textField25.setEditable(false);
        textField26.setEditable(false);
        textField27.setEditable(false);
        textField28.setEditable(false);
        textField29.setEditable(false);
        textField30.setEditable(false);
    }



    @FXML
    private void handleTextField1KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField2.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField2KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField3.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField3KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField4.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField4KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField5.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField2KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField1.clear();
            textField1.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField3KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField2.clear();
            textField2.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField4KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField3.clear();
            textField3.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField5KeyPressed(KeyEvent event) {
        if (textField5.getLength() > 1 && event.getCode() != KeyCode.BACK_SPACE || event.getCode() != KeyCode.ENTER) {
            textField5.setText(textField5.getText(0, 0));
        }

        String guess1 = textField1.getText() + textField2.getText() + textField3.getText() + textField4.getText() + textField5.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField5.clear();
            textField4.requestFocus();
        }

        if (event.getCode() == KeyCode.ENTER) {
            if (legalGuesses.containsWord(guess1) == false) {
                error.setText("This word is not contained in the dictionary");
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-text-fill: red;");

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), disappear -> {
                    error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");
                }));
                timeline.play();
            }

            else if (textField5.getLength() == 1) {
            error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");

            textField1.setEditable(false);
            textField1.setDisable(true);

            textField2.setEditable(false);
            textField2.setDisable(true);

            textField3.setEditable(false);
            textField3.setDisable(true);

            textField4.setEditable(false);
            textField4.setDisable(true);

            textField5.setEditable(false);
            textField5.setDisable(true);

            guess1 = guess1.toUpperCase();
            System.out.println("guess: " + guess1);
            System.out.println("in dictionary: " + legalGuesses.containsWord(guess1));
            System.out.println("answer: " + wordle.getAnswer());
            LetterResult[] result = wordle.submitGuess(guess1);

            int right = 0;
            for (int letter = 0; letter < guess1.length(); letter++) {
                if (result[letter] == LetterResult.GREEN) {
                    right++;
                    word1.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                }
            }

            if (right == 5) {
                textField6.setEditable(false);
                textField7.setEditable(false);
                textField8.setEditable(false);
                textField9.setEditable(false);
                textField10.setEditable(false);
                playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: green;");
                winlossmessage.setText("You won!");
            }

            if (right != 5) {
                for (int letter = 0; letter < guess1.length(); letter++) {
                    if (result[letter] == LetterResult.GREEN) {
                        word1.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                    }

                    if (result[letter] == LetterResult.YELLOW) {
                        word1.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: gold; -fx-text-fill: white");
                    }

                    if (result[letter] == LetterResult.GRAY) {
                        word1.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");
                    }

                    textField6.setEditable(true);
                    textField6.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField7.setEditable(true);
                    textField7.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField8.setEditable(true);
                    textField8.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField9.setEditable(true);
                    textField9.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField10.setEditable(true);
                    textField10.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField6.requestFocus();
                    }
                }
            }
        }
        event.consume();
    }

    @FXML
    private void handleTextField6KeyTyped(KeyEvent event) {
        if (textField6.getLength() == 1) {
            textField7.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField7KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField8.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField8KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField9.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField9KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField10.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField7KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField6.clear();
            textField6.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField8KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField7.clear();
            textField7.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField9KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField8.clear();
            textField8.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField10KeyPressed(KeyEvent event) {
        if (textField10.getLength() > 1 && event.getCode() != KeyCode.BACK_SPACE || event.getCode() != KeyCode.ENTER) {
            textField10.setText(textField10.getText(0, 0));
        }

        String guess2 = textField6.getText() + textField7.getText() + textField8.getText() + textField9.getText() + textField10.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField10.clear();
            textField9.requestFocus();
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (legalGuesses.containsWord(guess2) == false) {
                error.setText("This word is not contained in the dictionary");
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-text-fill: red;");

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), disappear -> {
                    error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");
                }));
                timeline.play();
            }

            else if (textField10.getLength() == 1) {
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");

                textField6.setEditable(false);
                textField6.setDisable(true);

                textField7.setEditable(false);
                textField7.setDisable(true);

                textField8.setEditable(false);
                textField8.setDisable(true);

                textField9.setEditable(false);
                textField9.setDisable(true);

                textField10.setEditable(false);
                textField10.setDisable(true);

                guess2 = guess2.toUpperCase();
                System.out.println("guess: " + guess2);
                System.out.println("in dictionary: " + legalGuesses.containsWord(guess2));
                System.out.println("answer: " + wordle.getAnswer());
                LetterResult[] result = wordle.submitGuess(guess2);

                int right = 0;
                for (int letter = 0; letter < guess2.length(); letter++) {
                    if (result[letter] == LetterResult.GREEN) {
                        right++;
                        word2.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                    }
                }

                if (right == 5) {
                    textField11.setEditable(false);
                    textField12.setEditable(false);
                    textField13.setEditable(false);
                    textField14.setEditable(false);
                    textField15.setEditable(false);
                    playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                    yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: green;");
                    winlossmessage.setText("You won!");
                }

                if (right != 5) {
                    for (int letter = 0; letter < guess2.length(); letter++) {
                        if (result[letter] == LetterResult.GREEN) {
                            word2.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                        }

                        if (result[letter] == LetterResult.YELLOW) {
                            word2.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: gold; -fx-text-fill: white");
                        }

                        if (result[letter] == LetterResult.GRAY) {
                            word2.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");
                        }

                        textField11.setEditable(true);
                        textField11.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField12.setEditable(true);
                        textField12.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField13.setEditable(true);
                        textField13.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField14.setEditable(true);
                        textField14.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField15.setEditable(true);
                        textField15.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField11.requestFocus();
                    }
                }
            }
        }
        event.consume();
    }
















    @FXML
    private void handleTextField11KeyTyped(KeyEvent event) {
        if (textField11.getLength() == 1) {
            textField12.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField12KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField13.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField13KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField14.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField14KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField15.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField12KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField11.clear();
            textField11.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField13KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField12.clear();
            textField12.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField14KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField13.clear();
            textField13.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField15KeyPressed(KeyEvent event) {
        if (textField15.getLength() > 1 && event.getCode() != KeyCode.BACK_SPACE || event.getCode() != KeyCode.ENTER) {
            textField15.setText(textField15.getText(0, 0));
        }

        String guess3 = textField11.getText() + textField12.getText() + textField13.getText() + textField14.getText() + textField15.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField15.clear();
            textField14.requestFocus();
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (legalGuesses.containsWord(guess3) == false) {
                error.setText("This word is not contained in the dictionary");
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-text-fill: red;");

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), disappear -> {
                    error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");
                }));
                timeline.play();
            }

            else if (textField5.getLength() == 1) {
            error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");

            textField11.setEditable(false);
            textField11.setDisable(true);

            textField12.setEditable(false);
            textField12.setDisable(true);

            textField13.setEditable(false);
            textField13.setDisable(true);

            textField14.setEditable(false);
            textField14.setDisable(true);

            textField15.setEditable(false);
            textField15.setDisable(true);

            guess3 = guess3.toUpperCase();
            System.out.println("guess: " + guess3);
            System.out.println("in dictionary: " + legalGuesses.containsWord(guess3));
            System.out.println("answer: " + wordle.getAnswer());
            LetterResult[] result = wordle.submitGuess(guess3);

            int right = 0;
            for (int letter = 0; letter < guess3.length(); letter++) {
                if (result[letter] == LetterResult.GREEN) {
                    right++;
                    word3.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                }
            }

            if (right == 5) {
                textField16.setEditable(false);
                textField17.setEditable(false);
                textField18.setEditable(false);
                textField19.setEditable(false);
                textField20.setEditable(false);
                playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: green;");
                winlossmessage.setText("You won!");
            }

            if (right != 5) {
                for (int letter = 0; letter < guess3.length(); letter++) {
                    if (result[letter] == LetterResult.GREEN) {
                        word3.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                    }

                    if (result[letter] == LetterResult.YELLOW) {
                        word3.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: gold; -fx-text-fill: white");
                    }

                    if (result[letter] == LetterResult.GRAY) {
                        word3.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");
                    }

                    textField16.setEditable(true);
                    textField16.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField17.setEditable(true);
                    textField17.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField18.setEditable(true);
                    textField18.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField19.setEditable(true);
                    textField19.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField20.setEditable(true);
                    textField20.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField11.requestFocus();
                    }
                }
            }
        }
        event.consume();
    }

    @FXML
    private void handleTextField16KeyTyped(KeyEvent event) {
        if (textField16.getLength() == 1) {
            textField17.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField17KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField18.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField18KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField19.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField19KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField20.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField17KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField16.clear();
            textField16.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField18KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField17.clear();
            textField17.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField19KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField18.clear();
            textField18.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField20KeyPressed(KeyEvent event) {
        if (textField20.getLength() > 1 && event.getCode() != KeyCode.BACK_SPACE || event.getCode() != KeyCode.ENTER) {
            textField20.setText(textField20.getText(0, 0));
        }

        String guess4 = textField16.getText() + textField17.getText() + textField18.getText() + textField19.getText() + textField20.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField20.clear();
            textField19.requestFocus();
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (legalGuesses.containsWord(guess4) == false) {
                error.setText("This word is not contained in the dictionary");
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-text-fill: red;");

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), disappear -> {
                    error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");
                }));
                timeline.play();
            }

            else if (textField20.getLength() == 1) {
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");

                textField16.setEditable(false);
                textField16.setDisable(true);

                textField17.setEditable(false);
                textField17.setDisable(true);

                textField18.setEditable(false);
                textField18.setDisable(true);

                textField19.setEditable(false);
                textField19.setDisable(true);

                textField20.setEditable(false);
                textField20.setDisable(true);

                guess4 = guess4.toUpperCase();
                System.out.println("guess: " + guess4);
                System.out.println("in dictionary: " + legalGuesses.containsWord(guess4));
                System.out.println("answer: " + wordle.getAnswer());
                LetterResult[] result = wordle.submitGuess(guess4);

                int right = 0;
                for (int letter = 0; letter < guess4.length(); letter++) {
                    if (result[letter] == LetterResult.GREEN) {
                        right++;
                        word4.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                    }
                }

                if (right == 5) {
                    textField21.setEditable(false);
                    textField22.setEditable(false);
                    textField23.setEditable(false);
                    textField24.setEditable(false);
                    textField25.setEditable(false);
                    playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                    yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: green;");
                    winlossmessage.setText("You won!");
                }

                if (right != 5) {
                    for (int letter = 0; letter < guess4.length(); letter++) {
                        if (result[letter] == LetterResult.GREEN) {
                            word4.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                        }

                        if (result[letter] == LetterResult.YELLOW) {
                            word4.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: gold; -fx-text-fill: white");
                        }

                        if (result[letter] == LetterResult.GRAY) {
                            word4.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");
                        }

                        textField21.setEditable(true);
                        textField21.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField22.setEditable(true);
                        textField22.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField23.setEditable(true);
                        textField23.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField24.setEditable(true);
                        textField24.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField25.setEditable(true);
                        textField25.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                        textField16.requestFocus();
                    }
                }
            }
        }
        event.consume();
    }



















    @FXML
    private void handleTextField21KeyTyped(KeyEvent event) {
        if (textField21.getLength() == 1) {
            textField22.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField22KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField23.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField23KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField24.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField24KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField25.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField22KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField21.clear();
            textField21.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField23KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField22.clear();
            textField22.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField24KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField23.clear();
            textField23.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField25KeyPressed(KeyEvent event) {
        if (textField25.getLength() > 1 && event.getCode() != KeyCode.BACK_SPACE || event.getCode() != KeyCode.ENTER) {
            textField25.setText(textField25.getText(0, 0));
        }

        String guess5 = textField21.getText() + textField22.getText() + textField23.getText() + textField24.getText() + textField25.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField25.clear();
            textField24.requestFocus();
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (legalGuesses.containsWord(guess5) == false) {
                error.setText("This word is not contained in the dictionary");
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-text-fill: red;");

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), disappear -> {
                    error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");
                }));
                timeline.play();
            }

            else if (textField5.getLength() == 1) {
            error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");

            textField21.setEditable(false);
            textField21.setDisable(true);

            textField22.setEditable(false);
            textField22.setDisable(true);

            textField23.setEditable(false);
            textField23.setDisable(true);

            textField24.setEditable(false);
            textField24.setDisable(true);

            textField25.setEditable(false);
            textField25.setDisable(true);

            guess5 = guess5.toUpperCase();
            System.out.println("guess: " + guess5);
            System.out.println("in dictionary: " + legalGuesses.containsWord(guess5));
            System.out.println("answer: " + wordle.getAnswer());
            LetterResult[] result = wordle.submitGuess(guess5);

            int right = 0;
            for (int letter = 0; letter < guess5.length(); letter++) {
                if (result[letter] == LetterResult.GREEN) {
                    right++;
                    word5.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                }
            }

            if (right == 5) {
                textField26.setEditable(false);
                textField27.setEditable(false);
                textField28.setEditable(false);
                textField29.setEditable(false);
                textField30.setEditable(false);
                playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: green;");
                winlossmessage.setText("You won!");
            }

            if (right != 5) {
                for (int letter = 0; letter < guess5.length(); letter++) {
                    if (result[letter] == LetterResult.GREEN) {
                        word5.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                    }

                    if (result[letter] == LetterResult.YELLOW) {
                        word5.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: gold; -fx-text-fill: white");
                    }

                    if (result[letter] == LetterResult.GRAY) {
                        word5.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");
                    }

                    textField26.setEditable(true);
                    textField26.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField27.setEditable(true);
                    textField27.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField28.setEditable(true);
                    textField28.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField29.setEditable(true);
                    textField29.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField30.setEditable(true);
                    textField30.setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");

                    textField26.requestFocus();
                    }
                }
            }
        }
        event.consume();
    }

    @FXML
    private void handleTextField26KeyTyped(KeyEvent event) {
        if (textField26.getLength() == 1) {
            textField27.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField27KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField28.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField28KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField29.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField29KeyTyped(KeyEvent event) {
        String input = event.getCharacter();
        if (input != null && input.length() > 0) {
            textField30.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField27KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField26.clear();
            textField26.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField28KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField27.clear();
            textField27.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField29KeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField28.clear();
            textField28.requestFocus();
        }
        event.consume();
    }

    @FXML
    private void handleTextField30KeyPressed(KeyEvent event) {
        if (textField5.getLength() > 1 && event.getCode() != KeyCode.BACK_SPACE || event.getCode() != KeyCode.ENTER) {
            textField30.setText(textField30.getText(0, 0));
        }

        String guess6 = textField26.getText() + textField27.getText() + textField28.getText() + textField29.getText() + textField30.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            textField30.clear();
            textField29.requestFocus();
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (legalGuesses.containsWord(guess6) == false) {
                error.setText("This word is not contained in the dictionary");
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center; -fx-text-fill: red;");

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), disappear -> {
                    error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");
                }));
                timeline.play();
            }

            else if (textField30.getLength() == 1) {
                error.setStyle("-fx-font-size: 18px; -fx-alignment: center;-fx-text-fill: transparent;");

                textField26.setEditable(false);
                textField26.setDisable(true);

                textField27.setEditable(false);
                textField27.setDisable(true);

                textField28.setEditable(false);
                textField28.setDisable(true);

                textField29.setEditable(false);
                textField29.setDisable(true);

                textField30.setEditable(false);
                textField30.setDisable(true);

                guess6 = guess6.toUpperCase();
                System.out.println("guess: " + guess6);
                System.out.println("in dictionary: " + legalGuesses.containsWord(guess6));
                System.out.println("answer: " + wordle.getAnswer());
                LetterResult[] result = wordle.submitGuess(guess6);

                int right = 0;
                for (int letter = 0; letter < guess6.length(); letter++) {
                    if (result[letter] == LetterResult.GREEN) {
                        right++;
                        word6.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                    }
                }

                if (right == 5) {
                    playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                    yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: green;");
                    winlossmessage.setText("You won!");
                }

                if (right != 5) {
                    for (int letter = 0; letter < guess6.length(); letter++) {
                        if (result[letter] == LetterResult.GREEN) {
                            word6.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: green; -fx-text-fill: white");
                        }

                        if (result[letter] == LetterResult.YELLOW) {
                            word6.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: gold; -fx-text-fill: white");
                        }

                        if (result[letter] == LetterResult.GRAY) {
                            word6.getChildren().get(letter).setStyle("-fx-font-size: 50px; -fx-alignment: center; -fx-padding: 0 -15 0 -15; -fx-background-color: grey; -fx-text-fill: white");
                        }
                    }
                    winlossmessage.setStyle("-fx-font-size: 20px; -fx-alignment: center; -fx-text-fill: red;");
                    winlossmessage.setText("You lost! The answer was " + wordle.getAnswer());
                    playAgainQuestion.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-text-fill: black;");
                    yes.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                    no.setStyle("-fx-font-size: 15px; -fx-alignment: center;-fx-background-color: black; -fx-text-fill: white;");
                }
            }
        }
        event.consume();
    }

    // FXML variables
    @FXML
    private Label WordleLogo;

    @FXML
    private Button yes;

    @FXML
    private Button no;

    @FXML
    private void handleNoClick(MouseEvent event) {
        System.exit(0);
    }

    public Stage stage = new Stage();

    @FXML
    private void handleYesClick(MouseEvent event) {
        stage.close();
        Stage newStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(WordleApplication.class.getResource("wordle-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.setWidth(450);
        newStage.setHeight(800);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    private Label playAgainQuestion = new Label("PLAY AGAIN?");

    @FXML
    private VBox playagain = new VBox(10);

    @FXML
    private HBox yesno = new HBox(10);

    @FXML
    private Label winlossmessage = new Label();

    @FXML
    private Label error = new Label();

    public static VBox words;

    private GuessResult guess;

    private Wordle wordle = new WordleImplementation();

    DefaultDictionaryFactory factory = new DefaultDictionaryFactory();

    private WordleDictionary legalGuesses = factory.getDefaultGuessesDictionary();
}
