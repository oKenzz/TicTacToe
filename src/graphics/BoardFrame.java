package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardFrame extends JFrame{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private JFrame frame;
    private JPanel board;

    public BoardFrame(){
        board = new Board();
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        add(board);
        setVisible(true);
    }







}
