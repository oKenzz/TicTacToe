package graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardFrame extends JFrame implements ActionListener{

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private ArrayList<JButton> button_list = new ArrayList<JButton>();
    private Controller c = new Controller();
    JLabel winnerLabel = new JLabel();

    public BoardFrame(){
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(3,3));
        generatePlayarea(3);
        createWinnerLabel();  
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generatePlayarea(int size){
        for (int i = 0; i < Math.pow(size,2); i++) {
            JButton button = new JButton();
            button_list.add(button);   
            button.addActionListener(this);
            button.setFocusPainted(false);
            button.setBackground(Color.WHITE);
            add(button);
        }
    }

    private void createWinnerLabel(){
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVerticalAlignment(JLabel.CENTER);
        winnerLabel.setOpaque(false); 
        winnerLabel.setVisible(false);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 60));
        winnerLabel.setForeground(Color.RED);
        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(winnerLabel, JLayeredPane.POPUP_LAYER);
        winnerLabel.setBounds(0, 0, WIDTH, HEIGHT);
    }

    private void displayWinner(String winner){
        winnerLabel.setText(winner + " wins!");
        winnerLabel.setVisible(true);
    }

    private void displayDraw(){
        winnerLabel.setText("Draw");
        winnerLabel.setVisible(true);
    }
    
    public void setButton(JButton button, String piece){
        if (piece != ""){
            button.setText(piece);
            button.setFont(new Font("Arial", Font.PLAIN, 120));
        }
    }

    public void restartGame(){
        Timer timer = new Timer(2000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                winnerLabel.setVisible(false);
                for(JButton button : button_list){
                    button.setText("");
                }
                c.restartGame();
            }
        });
        timer.setRepeats(false);
        timer.start();           
    }

    public void winnerHandler(){
        String winner = c.getWinner();
        displayWinner(winner);
        restartGame();     
    }

    private void drawHandler(){
        displayDraw();
        restartGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < button_list.size(); i++){
            JButton button_source = (JButton) e.getSource();
            JButton button = button_list.get(i);
            String piece = c.buttonPressed(button_source, button);
            setButton(button, piece);
            if(c.check_win(button_list)){
                winnerHandler();
            };
            if(c.check_draw(button_list) && !c.isWinner()){
                drawHandler();
            }
        }
    }
}
 
