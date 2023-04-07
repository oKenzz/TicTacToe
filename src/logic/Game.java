package logic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.Timer;

public class Game{
    private String[] pieces = {"X", "O"};
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    Player[] playerList = new Player[2];
    private boolean winner = false;
    private boolean draw = false;

    public Game(String player1Name, String player2Name){
        player1 = new Player(player1Name); 
        player2 = new Player(player2Name);
        playerList[0] = player1;
        playerList[1] = player2;
        generateRandomPieceandTurn(playerList);
    }

    private void generateRandomPieceandTurn(Player[] playerList){
        Random random = new Random();
        int randomPlayer = random.nextInt(2);
        int randomPiece = random.nextInt(2);
        playerList[randomPlayer].setPiece(pieces[randomPiece]);
        currentPlayer = playerList[randomPlayer];
        playerList[(randomPlayer + 1) % 2].setPiece(pieces[(randomPiece + 1) % 2]);
    }

    public String getPiecePressed(JButton buttonSource, JButton button){
        if(!winner){
        Player player1 = playerList[0];
        Player player2 = playerList[1];
                if(buttonSource == button){
                    if(currentPlayer == player1 && button.getText() == ""){;
                        currentPlayer = player2;
                        System.out.println("Current Turn:" + player2.getName());
                        return player1.getPiece();
                    }
                    if (currentPlayer == player2 && button.getText() == "") {
                        currentPlayer = player1;
                        System.out.println("Current Turn:" + player1.getName());
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

    public boolean checkDraw(ArrayList<JButton> buttonList){
        draw = true;
        for(JButton button : buttonList){
            if(button.getText() == ""){
                draw = false;
            }
        }
        return draw;
    }
    
    public void restartGame(){
        Timer timer = new Timer(2000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                winner = false;
                player1.setWinner(false);
                player1.setWinner(false);
                Random random = new Random();
                int randomPlayer = random.nextInt(2);
                System.out.println(randomPlayer);
                currentPlayer = playerList[randomPlayer];
            }
        });
        timer.setRepeats(false);
        timer.start();           
        
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

    public Player[] getPlayerList() {
        return playerList;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    
}
