package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Board extends JPanel{
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    
    public Board(){
        // setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.RED);
        setBounds(180, 80, WIDTH, HEIGHT);
    }

  





}
