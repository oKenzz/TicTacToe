package graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    public BoardFrame(){
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(3,3));
        generatePlayarea(3);     
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void generatePlayarea(int size){
        for (int i = 0; i < Math.pow(size,2); i++) {
            JButton button = new JButton();
            button_list.add(button);   
            button.addActionListener(this);
            button.setFocusPainted(false);
            button.setBackground(Color.WHITE);
            add(button);
        }
    }
    

    public void setButton(JButton button, String piece){
        if (piece != ""){
            button.setText(piece);
            button.setFont(new Font("Arial", Font.PLAIN, 120));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < button_list.size(); i++){
            JButton button_source = (JButton) e.getSource();
            JButton button = button_list.get(i);
            String piece = c.buttonPressed(button_source, button);
            setButton(button, piece);
            c.check_win(button_list);
        }
    }
}
 
