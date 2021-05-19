package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    private Console ConsoleObj;
    private Game Game;

    //set TextField;
    @FXML private TextArea Console;

    //Set buttons
    @FXML private Button Btn1;
    @FXML private Button Btn2;
    @FXML private Button Btn3;
    @FXML private Button Btn4;
    @FXML private Button Btn5;
    @FXML private Button Btn6;
    @FXML private Button Btn7;
    @FXML private Button Btn8;
    @FXML private Button Btn9;

    // constructor
    public Controller() {
        this.ConsoleObj = new Console();
        this.Game = new Game(ConsoleObj);

    }

    // set button Controls
    public void Btn1Control(ActionEvent actionEvent) {handleButtonClick(1);}
    public void Btn2Control(ActionEvent actionEvent) {handleButtonClick(2);}
    public void Btn3Control(ActionEvent actionEvent) {handleButtonClick(3);}
    public void Btn4Control(ActionEvent actionEvent) {handleButtonClick(4);}
    public void Btn5Control(ActionEvent actionEvent) {handleButtonClick(5);}
    public void Btn6Control(ActionEvent actionEvent) {handleButtonClick(6);}
    public void Btn7Control(ActionEvent actionEvent) {handleButtonClick(7);}
    public void Btn8Control(ActionEvent actionEvent) {handleButtonClick(8);}
    public void Btn9Control(ActionEvent actionEvent) {handleButtonClick(9);}

    public void StartVsCpu(ActionEvent actionEvent) {
        gameInit(true);
    }

    public void StartVsPlayer(ActionEvent actionEvent) {
        gameInit(false);
    }

    private void gameInit(Boolean cpu) {
        Game.init(cpu);
        resetButtons();
        printToConsole();
    }

    private void resetButtons() {
        Btn1.setText("");
        Btn2.setText("");
        Btn3.setText("");

        Btn4.setText("");
        Btn5.setText("");
        Btn6.setText("");

        Btn7.setText("");
        Btn8.setText("");
        Btn9.setText("");
    }

    private void printToConsole() {
        String message = ConsoleObj.getMessageLines();
        Console.setText(message);
    }

    private void handleButtonClick(int btnNr) {
        this.handleGame(btnNr);
    }

    private void handleGame(int btnNr) {
        if( this.Game.ValidAction(btnNr) ) {
            String icon = Game.getPlayerIcon();
            this.setBtn(btnNr, icon);
            this.Game.Handle(btnNr);

            if ( Game.activeCpu() ) {
               this.handleCpu();
            }
        }
        this.printToConsole();
    }

    private void handleCpu() {
        String icon = Game.getPlayerIcon();
        int btnNr2 = Game.playCpu();

        this.setBtn(btnNr2, icon);
        if (btnNr2 < 0) {
            this.printToConsole();
        }
    }

    private void setBtn(int btnNr, String a) {
        switch (btnNr) {
            case 1:
                this.Btn1.setText(a);
                break;
            case 2:
                this.Btn2.setText(a);
                break;
            case 3:
                this.Btn3.setText(a);
                break;
            case 4:
                this.Btn4.setText(a);
                break;
            case 5:
                this.Btn5.setText(a);
                break;
            case 6:
                this.Btn6.setText(a);
                break;
            case 7:
                this.Btn7.setText(a);
                break;
            case 8:
                this.Btn8.setText(a);
                break;
            case 9:
                this.Btn9.setText(a);
                break;
        }
    }
}
