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

    public void check_win(ArrayList<JButton> button_list){
        logic.check_win(button_list);
    }







}
