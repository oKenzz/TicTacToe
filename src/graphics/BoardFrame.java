package graphics;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Game;
import Logic.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BoardFrame extends JFrame implements ActionListener{

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    public JFrame frame; 
    private ArrayList<JButton> button_list;
    private Player[] player_list;
    private Game game;


    public BoardFrame(){

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(3,3));
        game = new Game();
        player_list = game.getPlayer_list();
        System.out.println(game.getPlayer_list()[0]);
        System.out.println(game.getPlayer_list()[1]);
        button_list = game.getButton_list();
        for (JButton button : button_list) {
            button.addActionListener(this);
            button.setFocusPainted(false);
            add(button);
        }
        
        
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    

    public void setPiece(JButton button, Player player){
        if (player.getPiece() == "O"){
            button.setText("O");
            button.setFont(new Font("Arial", Font.PLAIN, 120));
        } else {
            button.setText("X");
            button.setFont(new Font("Arial", Font.PLAIN, 120));
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
     
        for(int i = 0; i < button_list.size(); i++){
            JButton button_source = (JButton) e.getSource();
            JButton button = button_list.get(i);
            Player player1 = player_list[0];
            Player player2 = player_list[1];

            if(button_source == button){
                if(player1.isTurn() && button.getText() == ""){
                    setPiece(button, player1);
                    player1.setTurn(false);
                    player2.setTurn(true);
                } else if(player2.isTurn() && button.getText() == "") {
                    setPiece(button, player2);
                    player1.setTurn(true);
                    player2.setTurn(false);
                }
            }
        }
    }
}
