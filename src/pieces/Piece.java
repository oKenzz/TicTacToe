package pieces;

import javax.swing.JLabel;
import java.awt.Graphics;

public abstract class Piece extends JLabel{
    // private int x;
    // private int y;
    private String pieceSymbol;

     //Chooses square to draw in
     private Integer offsetX;
     private Integer offsetY;

    public Piece(Integer offsetX, Integer offsetY, String pieceSymbol){
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.pieceSymbol = pieceSymbol;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public String getPieceSymbol(){
        return pieceSymbol;
    }

    @Override
    public abstract void paint(Graphics g);

}
