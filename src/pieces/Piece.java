package pieces;

import javax.swing.JLabel;
import java.awt.Graphics;

public abstract class Piece extends JLabel {
    // private int x;
    // private int y;
    private String pieceSymbol;

    // Chooses square to draw in
    private Integer x;
    private Integer y;
    private final static int offsetX = 100;
    private final static int offsetY = 60;

    public Piece(Integer x, Integer y, String pieceSymbol) {
        this.x = x;
        this.y = y;
        this.pieceSymbol = pieceSymbol;
    }

    public static int getOffsetx() {
        return offsetX;
    }

    public static int getOffsety() {
        return offsetY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPieceSymbol() {
        return pieceSymbol;
    }

    @Override
    public abstract void paint(Graphics g);

}
