package pieces;

import java.awt.*;

public class O extends Piece{
   
    // g2d.drawArc(148,147,100,100,0,360);

    //Draws a circle
    private static final int CIRCLE_WIDTH = 10;
    private static final int CIRCLE_HEIGHT = 10;
    private static final int CIRCLE_START = 100;
    private static final int CIRCLE_END = 100;
    private static final int CIRCLE_ANGLE_START = 0;
    private static final int CIRCLE_ANGLE_END = 360;

    //Chooses square to draw in

    public O(int x, int y){
        super(x, y, "O");
    }

    //This is used to create a representation of what iece a Player is
    public O(){
        super(null,null,"O");
    }

    @Override
    public void paint(Graphics g) throws NullPointerException{ //Does throws signal that this method might throw a NullPointerException
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawArc(CIRCLE_START + getX() * getOffsetx(), CIRCLE_END + getY() * getOffsety(), WIDTH, HEIGHT, CIRCLE_ANGLE_START, CIRCLE_ANGLE_END);

    }



    
}
