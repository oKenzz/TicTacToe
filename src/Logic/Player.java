package Logic;
public class Player {
    
    private boolean turn;
    private String piece;

    public Player(){
        this.turn = false;
        this.piece = "";
    };
  
    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
