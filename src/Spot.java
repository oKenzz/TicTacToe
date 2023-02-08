import pieces.Piece;

public class Spot {
    private int x;
    private int y;
    private Piece piece;
    private boolean IsOccupied = false;

    public Spot(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.IsOccupied = true;
    }
  
    public Piece getPiece() {
        return piece;
    }

    public boolean getIsOccupied() {
        return IsOccupied;
    }


    
}
