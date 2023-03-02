package playarea;
import pieces.Piece;
import player.Player;

public class Spot {
    private int x;
    private int y;
    private Piece piece;
    private boolean IsOccupied = false;
    private Player player;

    public Spot(int x, int y, Piece piece, Player player){
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.IsOccupied = true; //Remove instead check null
        this.player = player;
    }
  
    public Piece getPiece() {
        return piece;
    }

    public boolean getIsOccupied() {
        return IsOccupied;
    }

    public Player getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    
}
