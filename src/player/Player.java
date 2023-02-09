package player;
import pieces.Piece;

public class Player {
    private String piece;
    private String name;
    private boolean turn;
   
    public Player(String piece, String name){
        this.piece = piece;
        this.name = name;
        this.turn = false;
    }

    public String getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    


}   
