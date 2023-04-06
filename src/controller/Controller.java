package controller;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.BoardFrame;
import logic.Game;

import java.util.ArrayList;

public class Controller implements ActionListener{
    
    private Game logic;
    private BoardFrame board;

    public Controller(){
        logic = new Game();
        board = new BoardFrame();
        setupButtons();
    }

    public void setupButtons(){
        for(JButton button : board.getButtonList()){
            button.addActionListener(this);
        }
    }

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
                };
                if(logic.checkDraw(buttonList) && !logic.isWinner()){
                    board.drawHandler();
                    logic.restartGame();
                }
            }
        }
    }
}
