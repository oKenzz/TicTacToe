package Controller;

import javax.swing.JButton;

import Logic.Game;
import java.util.ArrayList;

public class Controller {
    
    private Game logic;

    public Controller(){
        logic = new Game();
    }

    public String buttonPressed(JButton buttonSource, JButton button){
        return logic.buttonPressed(buttonSource, button);
    }

    public boolean checkWin(ArrayList<JButton> buttonList){
        return logic.checkWin(buttonList);
    }

    public void restartGame(){
        logic.restartGame();
    }

    public String getWinner(){
        return logic.getWinner();
    }

    public boolean isWinner(){
        return logic.isWinner();
    }

    public boolean checkDraw(ArrayList<JButton> buttonList){
        logic.checkDraw(buttonList);
        return logic.isDraw();
    }
}
