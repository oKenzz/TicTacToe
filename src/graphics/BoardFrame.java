package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardFrame{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private JFrame frame;
    private JPanel board;

    public BoardFrame(){
        frame = new JFrame();
        board = new Board();
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(board);
        frame.setVisible(true);
    }







}
