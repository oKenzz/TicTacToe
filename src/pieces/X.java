package pieces;

import java.awt.*;

public class X extends Piece{
    private static final int CROSS_START = 10;
    private static final int CROSS_END = 120;

    public X(int offsetX, int offsetY){
        super(offsetX, offsetY, "X");
    }

    public X(){
        super(null,null,"X");
    }

    @Override
    public void paint(Graphics g) throws NullPointerException{
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(CROSS_START + getOffsetX(), CROSS_START + getOffsetX(),CROSS_END + getOffsetX(),CROSS_END + getOffsetY());
        g2d.drawLine(CROSS_END + getOffsetX(), CROSS_START + getOffsetY(), CROSS_START + getOffsetX(), CROSS_END + getOffsetY());        
    }
}
