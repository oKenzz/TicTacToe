package controller;

import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.BoardFrame;
import logic.Game;
import logic.Player;

import java.util.ArrayList;

public class Controller implements ActionListener{
    
    private Game logic;
    private BoardFrame board;
    private JPanel playArea = new JPanel();
    private ArrayList<JButton> buttonList = new ArrayList<JButton>();


    public Controller(){
        //TODO: take input from user to set names
        logic = new Game("Ken", "Phillip");
        Player[] playerList = logic.getPlayerList();
        board = new BoardFrame(playerList[0], playerList[1], logic.getCurrentPlayer().getName());
        generatePlayarea(3);
        board.revalidate();
    }

    private void generatePlayarea(int size){
        playArea.setLayout(new GridLayout(3,3));
        for (int i = 0; i < Math.pow(size,2); i++) {
            JButton button = new JButton();
            buttonList.add(button);   
            button.setFocusPainted(false);
            button.setBackground(Color.WHITE);
            button.addActionListener(this);
            playArea.add(button);
        }
        board.add(playArea, BorderLayout.CENTER);
    }

    private void resetBoard(){
        Timer timer = new Timer(2000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(JButton button : buttonList){
                    button.setText("");
                }
            }
        });
        timer.setRepeats(false);
        timer.start();           
    }

    //TODO: rethink/optimize algortim
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!logic.isWinner()){
            // ArrayList<JButton> buttonList = board.getButtonList();
            for(int i = 0; i < buttonList.size(); i++){
                JButton buttonSource = (JButton) e.getSource();
                JButton button = buttonList.get(i);
                String piece = logic.getPiecePressed(buttonSource, button);
                board.setButtonPiece(button, piece);
                if(logic.checkWin(buttonList)){
                    board.displayWinner(logic.getWinner());
                    logic.restartGame();
                    resetBoard();
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
                    board.displayDraw();
                    logic.restartGame();
                    resetBoard();
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
