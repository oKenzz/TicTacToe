package logic;

import javax.swing.JButton;
import java.util.Random;
import java.util.ArrayList;


public class Computer{

    //Run different algoritm depending on the mode seleceted
    private boolean easyMode;
    private boolean standardMode;
    private boolean impossible;
    private Player computer;
    private Random random;
    private ArrayList<JButton> buttonList = new ArrayList<JButton>();

    public Computer(String setMode){
        this.computer = new Player("Computer");
        this.random = new Random();
        setMode(setMode);
    }

    private void setMode(String mode){
        switch (mode){
            case "easy":
            easyMode = true;
            standardMode = false;
            impossible = false;
            break;
            case "standard":
            easyMode = false;
            standardMode = true;
            impossible = false;
            break;
            case "impossible":
            easyMode = false;
            standardMode = false;
            impossible = true;
            break;
        }
    }

    // Diffculty turn algoritms
    public void impossible(){
        //TODO: Logic for minmax, always draw
    }

    public void standard(){
        //TODO: standard mode
    }

    public void easy(){
        //TODO: easy mode
    }

}