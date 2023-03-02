package mvc;

import java.util.Map;
import java.util.Random;

import pieces.O;
import pieces.Piece;
import pieces.X;
import playarea.Playarea;
import player.Player;

public class Model {
    
    private Player player1;
    private Player player2;

    private Player[] player_list = new Player[2];
    private Playarea playarea;
    private int[] coordinates;
    private Random random = new Random();

    public Model(){
        this.playarea = new Playarea();
        //Namn input från användare
        //Random piece
        this.player1 = new Player(new X(), "BB");
        this.player2 = new Player(new O(), "AA");
    
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

    public void set_piece(Piece p, int[] coordinates, Player player){
        int x = coordinates[0];
        int y = coordinates[1];
       playarea.set_piece(p, x, y, player);
       changeturn();
    }


    //Improve algortim
    public String check_winner(){
        String winner = playarea.check_winner();
        return winner;
        // if (winner){
        //     for (Player p : player_list){
        //         if (p.isTurn()) return p.getName();
        //     }
        // }
        // return "No winner";
    }

    public Player[] getPlayer_list() {
        return player_list;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    
    
}
