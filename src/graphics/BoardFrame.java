package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mvc.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardFrame extends JFrame{

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public JFrame frame;
    private JPanel board;
    private Controller controller = new Controller();

    public BoardFrame(Controller controller){
        this.controller = controller;

        board = new Board();
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        add(board);
        setVisible(true);

    board.addMouseListener(new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e){
            int[] coordinates = new int[2];
            coordinates[0] = e.getX();
            coordinates[1] = e.getY();
            System.out.println("X: " + e.getX() + "Y: " + e.getY());
            controller.setCoordinates(coordinates);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    });
    }
}

