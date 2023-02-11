package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import graphics.Board;
import graphics.BoardFrame;
import pieces.Piece;
import player.Player;

public class Controller {
    
    BoardFrame view;
    Model model;
    Player[] player_list;

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    public Controller(){
        // view = new BoardFrame();
        model = new Model();
        player_list = model.getPlayer_list();
    }

    private class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Player current_player;
            String winner = check_winner();
            Piece p;
            if (player_list[0].isTurn() == true){
                current_player = player_list[0];
            } else {
                current_player = player_list[1];
            }
            do {
                view.frame.repaint();
            } while (current_player.isTurn() && winner != "No winner");
        }
    }
    
    public void set_piece(Piece p, int[] coordinates, Player player){
        model.set_piece(p, coordinates, player);
    }


    //Improve algortim
    public String check_winner(){
        String winner = model.check_winner();
        return winner;
    }

    public void setCoordinates(int[] coordinates){
        model.setCoordinates(coordinates);

    }


}
