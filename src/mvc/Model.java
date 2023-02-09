package mvc;

import java.util.Map;
import java.util.Random;

import Playarea.Playarea;
import pieces.Piece;
import player.Player;

public class Model {
    
    private Player player1;
    private Player player2;

    private Player[] player_list = new Player[2];
    private Playarea playarea;
    private Random random = new Random();

    public Model(){
        this.playarea = new Playarea();
        //Namn input från användare
        //Random piece
        this.player1 = new Player("X", "BB");
        this.player2 = new Player("O", "AA");
    
        player_list[0] = player1;
        player_list[1] = player2;

        int i = random.nextInt(0, 2);
        player_list[i].setTurn(true);

    }

    public void changeturn(){
        for (Player p: player_list){
            if(p.isTurn()){
                p.setTurn(false);
            } else {
                p.setTurn(true);
            }
         }
    }

    public void set_piece(Piece p, int x, int y, Player player){
       playarea.set_piece(p, x, y, player);
    }


    //Improve algortim
    public String check_winner(){
        boolean winner = playarea.check_winner();
        if (winner){
            for (Player p : player_list){
                if (p.isTurn()) return p.getName();
            }
        }
        return "No winner";
    }
}
