package Logic;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;


public class Game{
    private Player player1 = new Player("Player1");  
    private Player player2 = new Player("Player2");
    private Player[] player_list = {player1, player2};
    private Player currentPlayer;
    private boolean winner = false;


    public Game(){
        generateRandomPieceandTurn(player_list);
        System.out.println("Player1: " + player1.getPiece());
        System.out.println("Player2: " + player2.getPiece());
        System.out.println("Turn: " + currentPlayer.getName());
    }

    public void generateRandomPieceandTurn(Player[] player_list){
        Random random = new Random();
        int randomPlayer = random.nextInt(2);
        //TODO: randomize pieces
        player_list[randomPlayer].setPiece("X");
        player_list[randomPlayer].setTurn(true);
        currentPlayer = player_list[randomPlayer];
        player_list[(randomPlayer + 1) % 2].setPiece("O");
        player_list[(randomPlayer + 1) % 2].setTurn(false);
    }

    public String buttonPressed(JButton button_source, JButton button){
        if(!winner){
        Player player1 = player_list[0];
        Player player2 = player_list[1];
                if(button_source == button){
                    if(player1.isTurn() && button.getText() == ""){
                        player1.setTurn(false);
                        player2.setTurn(true);
                        currentPlayer = player2;
                        return player1.getPiece();
                    }
                    if (player2.isTurn() && button.getText() == "") {
                        player1.setTurn(true);
                        player2.setTurn(false);
                        currentPlayer = player1;
                        return player2.getPiece();
                    }
                }
            }
        return "";
    }

    public void check_win(ArrayList<JButton> button_list){
        if (!winner){
            checkHorizontal(button_list);
            checkVertical(button_list);
            checkDiagonal(button_list);
            if(winner){
                if (player1.isWinner()){
                    System.out.println("Winner: Player1");
                } else {
                    System.out.println("Winner: Player2");
                }
            }
        }
    }

    private void checkHorizontal(ArrayList<JButton> button_list){
        for (int i = 0; i < 9; i+=3){
            JButton button1 = button_list.get(i);
            JButton button2 = button_list.get(i+1);
            JButton button3 = button_list.get(i+2);
            checkWinner(button1, button2, button3);
        }
    };
    
    private void checkVertical(ArrayList<JButton> button_list){
        for (int i = 0; i < 3; i++){
            JButton button1 = button_list.get(i);
            JButton button2 = button_list.get(i+3);
            JButton button3 = button_list.get(i+6);
            checkWinner(button1, button2, button3);
        }
    };

    private void checkDiagonal(ArrayList<JButton> button_list){
            JButton button1 = button_list.get(0);
            JButton button2 = button_list.get(4);
            JButton button3 = button_list.get(8);
            checkWinner(button1, button2, button3);
            button1 = button_list.get(2);
            button2 = button_list.get(4);
            button3 = button_list.get(6);
            checkWinner(button1, button2, button3);
        };

    private void checkWinner(JButton button1, JButton button2, JButton button3){
        if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button3.getText() == "O"){
            if (player1.getPiece() == "O"){
                player1.setWinner(true);
            } else {
                player2.setWinner(true);
            }
            winner = true;
        }

        if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button3.getText() == "X"){
            if (player1.getPiece() == "X"){
                player1.setWinner(true);
            } else {
                player2.setWinner(true);
            }
            winner = true;
        }
     
    };
}
