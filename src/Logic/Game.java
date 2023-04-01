package Logic;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class Game{
    private Player player1 = new Player();  
    private Player player2 = new Player();
    private Player[] player_list = {player1, player2};
    private ArrayList<JButton> button_list;


    public Game(){
        generateRandomPieceandTurn(player_list);
        this.button_list = GeneratePlayarea(3);
                    
    }

    public void generateRandomPieceandTurn(Player[] player_list){
        Random random = new Random();
        int randomPlayer = random.nextInt(2);
        player_list[randomPlayer].setPiece("X");
        player_list[randomPlayer].setTurn(true);
        player_list[(randomPlayer + 1) % 2].setPiece("O");
        player_list[(randomPlayer + 1) % 2].setTurn(false);
    }

    public ArrayList<JButton> GeneratePlayarea(int size){
        ArrayList<JButton> button_list = new ArrayList<JButton>();

        for (int i = 0; i < Math.pow(size,2); i++) {
            JButton button = new JButton();
            button.setBackground(Color.WHITE);
            button_list.add(button);   
        }
        return button_list;
    }

    public Player[] getPlayer_list() {
        return player_list;
    }

    public ArrayList<JButton> getButton_list() {
        return button_list;
    }

    

}
