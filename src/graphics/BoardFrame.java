package graphics;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import logic.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardFrame extends JFrame{

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    JLabel winnerLabel = new JLabel();
    JPanel infoPanel = new JPanel();
    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();
    JPanel currentTurn = new JPanel();
    JLabel currentPlayer = new JLabel();
    JLabel currentTurnText = new JLabel();
    JLabel player1Name = new JLabel();
    JLabel player2Name = new JLabel();
    JLabel player1Piece = new JLabel();
    JLabel player2Piece = new JLabel();

    public BoardFrame(Player player1, Player player2, String currentPlayer){
        setTitle("Tic Tac Toe");
        setIconImage(new ImageIcon("tictactoeIcon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        generateInfoPanel(player1, player2);
        generateCurrentTurnPanel(currentPlayer);
        createWinnerLabel();  
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateInfoPanel(Player player1, Player player2){
        generatePlayerPanels(player1, player2);
        infoPanel.setPreferredSize(new Dimension(600,100));
        
        infoPanel.setBackground(Color.GRAY);
        infoPanel.setLayout(new BorderLayout());
    
        add(infoPanel, BorderLayout.SOUTH);
        infoPanel.add(player1Panel, BorderLayout.WEST);
        infoPanel.add(player2Panel, BorderLayout.EAST);
        infoPanel.add(currentTurn, BorderLayout.CENTER);
    }

    private void generateCurrentTurnPanel(String player){
        currentTurn.setLayout(new BoxLayout(currentTurn, BoxLayout.Y_AXIS));
        currentTurnText.setText("Turn");
        currentTurnText.setFont(new Font("Arial", Font.BOLD, 20));

        currentPlayer.setText(player);
        currentPlayer.setFont(new Font("Arial", Font.BOLD, 35));
        
        currentTurnText.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentTurn.add(currentTurnText);

        currentTurn.add(currentPlayer);
    }

    private void generatePlayerPanels(Player player1, Player player2){
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));
        player1Name.setText(player1.getName());
        player2Name.setText(player2.getName());
        player1Name.setFont(new Font("Arial", Font.BOLD, 45));
        player2Name.setFont(new Font("Arial", Font.BOLD, 45));
        player1Piece.setText(player1.getPiece());
        player2Piece.setText(player2.getPiece());
        player1Piece.setFont(new Font("Arial", Font.BOLD, 20));
        player2Piece.setFont(new Font("Arial", Font.BOLD, 20));

        player1Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        player1Piece.setAlignmentX(Component.CENTER_ALIGNMENT);

        player2Name.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2Piece.setAlignmentX(Component.CENTER_ALIGNMENT);

        player1Panel.add(player1Piece);
        player1Panel.add(player1Name);
        player2Panel.add(player2Piece);
        player2Panel.add(player2Name);
    }

    private void createWinnerLabel(){
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVerticalAlignment(JLabel.CENTER);
        winnerLabel.setOpaque(false); 
        winnerLabel.setVisible(false);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 60));
        winnerLabel.setForeground(Color.RED);
        JLayeredPane layeredPane = getLayeredPane();
        //TODO: fix alignment when JFrame is resized
        layeredPane.add(winnerLabel, JLayeredPane.POPUP_LAYER);
        winnerLabel.setBounds(0, 0, WIDTH, HEIGHT);
    }

    public void displayWinner(String winner){
        winnerLabel.setText(winner + " wins!");
        winnerLabel.setVisible(true);
        Timer timer = new Timer(2000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                winnerLabel.setVisible(false);
            }
        });
        timer.setRepeats(false);
        timer.start();  
    }

    public void displayDraw(){
        winnerLabel.setText("Draw");
        winnerLabel.setVisible(true);
        Timer timer = new Timer(2000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                winnerLabel.setVisible(false);
            }
        });
        timer.setRepeats(false);
        timer.start();  
    }
    
    public void setButtonPiece(JButton button, String piece){
        if (piece != ""){
            button.setText(piece);
            button.setFont(new Font("Arial", Font.PLAIN, 120));
        }
        if (piece == "X"){
            button.setForeground(Color.RED);
        } else if (piece == "O"){
            button.setForeground(Color.BLUE);
        }
    }

    public void setCurrentPlayer(String player){
        currentPlayer.setText(player);
    }
}
 
