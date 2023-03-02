package pieces;

import java.awt.*;

public class X extends Piece{
    private static final int CROSS_START = 10;
    private static final int CROSS_END = 120;

    public X(int x, int y){
        super(x, y, "X");
    }

    public X(){
        super(null,null,"X");
    }

    @Override
    public void paint(Graphics g) throws NullPointerException{
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(CROSS_START + getX() * getOffsetx(), CROSS_START + getY() * getOffsety(),CROSS_END + getX() * getOffsetx(),CROSS_END + getY() * getOffsety());
        g2d.drawLine(CROSS_END + getX() * getOffsetx(), CROSS_START + getY() * getOffsety(), CROSS_START + getX() * getOffsetx(), CROSS_END + getY() * getOffsety());        
    }
}
