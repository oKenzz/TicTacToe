package controller;

import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.BoardFrame;
import logic.Game;
import logic.Player;

import java.util.ArrayList;

public class Controller implements ActionListener{
    
    private Game logic;
    private BoardFrame board;

    public Controller(){
        //TODO: take input from user to set names
        logic = new Game("Player1", "Player2");
        Player[] playerList = logic.getPlayerList();
        board = new BoardFrame(playerList[0], playerList[1], logic.getCurrentPlayer().getName());
        setupButtons();
    }

    public void setupButtons(){
        for(JButton button : board.getButtonList()){
            button.addActionListener(this);
        }
    }

    //TODO: rethink/optimize algortim
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!logic.isWinner()){
            ArrayList<JButton> buttonList = board.getButtonList();
            for(int i = 0; i < buttonList.size(); i++){
                JButton buttonSource = (JButton) e.getSource();
                JButton button = buttonList.get(i);
                String piece = logic.getPiecePressed(buttonSource, button);
                board.setButtonPiece(button, piece);
                if(logic.checkWin(buttonList)){
                    board.winnerHandler(logic.getWinner());
                    logic.restartGame();
                    Timer timer = new Timer(2000, new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            board.setCurrentPlayer(logic.getCurrentPlayer().getName());
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                    board.setCurrentPlayer(logic.getCurrentPlayer().getName());
                } 
                if(logic.checkDraw(buttonList) && !logic.isWinner()){
                    board.drawHandler();
                    logic.restartGame();
                    Timer timer = new Timer(2000, new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            board.setCurrentPlayer(logic.getCurrentPlayer().getName());
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } 
                //TODO: Don't set to next player when won/draw
                board.setCurrentPlayer(logic.getCurrentPlayer().getName());
            }
        }
    }
}
