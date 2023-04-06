package Controller;

import javax.swing.JButton;

import Logic.Game;
import java.util.ArrayList;

public class Controller {
    
    private Game logic;

    public Controller(){
        logic = new Game();
    }

    public String buttonPressed(JButton button_source, JButton button){
        return logic.buttonPressed(button_source, button);
    }

    public boolean check_win(ArrayList<JButton> button_list){
        return logic.check_win(button_list);
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

    public boolean check_draw(ArrayList<JButton> button_list){
        logic.checkDraw(button_list);
        return logic.isDraw();
    }
}
