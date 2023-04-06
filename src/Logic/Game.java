package Logic;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class Game{
    private Player player1 = new Player("Player1");  
    private Player player2 = new Player("Player2");
    //TODO: remove playerList, really only for randomizing, use better randomizing algoritm
    private Player[] playerList = {player1, player2};
    private Player currentPlayer;
    private boolean winner = false;
    private boolean draw = false;

    public Game(){
        generateRandomPieceandTurn(playerList);
        System.out.println("Player1: " + player1.getPiece());
        System.out.println("Player2: " + player2.getPiece());
        System.out.println("Turn: " + currentPlayer.getName());
    }

    private void generateRandomPieceandTurn(Player[] playerList){
        Random random = new Random();
        int randomPlayer = random.nextInt(2);
        //TODO: randomize pieces
        playerList[randomPlayer].setPiece("X");
        playerList[randomPlayer].setTurn(true);
        currentPlayer = playerList[randomPlayer];
        playerList[(randomPlayer + 1) % 2].setPiece("O");
        playerList[(randomPlayer + 1) % 2].setTurn(false);
        System.out.println("Player1: " + player1.getPiece());
        System.out.println("Player2: " + player2.getPiece());
        System.out.println("Turn: " + currentPlayer.getName());
    }

    public String buttonPressed(JButton buttonSource, JButton button){
        if(!winner){
        Player player1 = playerList[0];
        Player player2 = playerList[1];
                if(buttonSource == button){
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

    public boolean checkWin(ArrayList<JButton> buttonList){
        if(!winner){
            checkHorizontal(buttonList);
            checkVertical(buttonList);
            checkDiagonal(buttonList);
            return winner;
        }
        return false;
    }

    private void checkHorizontal(ArrayList<JButton> buttonList){
        for (int i = 0; i < 9; i+=3){
            JButton button1 = buttonList.get(i);
            JButton button2 = buttonList.get(i+1);
            JButton button3 = buttonList.get(i+2);
            checkWinner(button1, button2, button3);
        }
    };
    
    private void checkVertical(ArrayList<JButton> buttonList){
        for (int i = 0; i < 3; i++){
            JButton button1 = buttonList.get(i);
            JButton button2 = buttonList.get(i+3);
            JButton button3 = buttonList.get(i+6);
            checkWinner(button1, button2, button3);
        }
    };

    private void checkDiagonal(ArrayList<JButton> buttonList){
            JButton button1 = buttonList.get(0);
            JButton button2 = buttonList.get(4);
            JButton button3 = buttonList.get(8);
            checkWinner(button1, button2, button3);
            button1 = buttonList.get(2);
            button2 = buttonList.get(4);
            button3 = buttonList.get(6);
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

    public void checkDraw(ArrayList<JButton> buttonList){
        draw = true;
        for(JButton button : buttonList){
            if(button.getText() == ""){
                draw = false;
            }
        }
    }
    
    public void restartGame(){
        winner = false;
        player1.setWinner(false);
        player1.setWinner(false);
        generateRandomPieceandTurn(playerList);
    }

    public String getWinner(){
        if(winner && player1.isWinner()){
            return player1.getName();
        }
        if(winner && player2.isWinner()){
            return player2.getName();
        }
        return "";
    }

    public boolean isDraw(){
        return draw;
    }

    public boolean isWinner(){
        return winner;
    }
}
