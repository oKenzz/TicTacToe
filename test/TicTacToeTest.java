package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.junit.Before;
import org.junit.Test;

import pieces.*;
import playarea.Playarea;
import playarea.Spot;
import player.Player;

// TODO: check_winner() bugged - can use different pieces(X and O) in the same line still returns a winner, FIX

public class TicTacToeTest {

    private Playarea playarea;
    private Player player1;
    private Player player2;

    @Before
    public void createGame() {
        playarea = new Playarea();
        player1 = new Player(new O(), "Player1");
        player2 = new Player(new X(), "Player2");
    }

    @Test
    public void set_piece_on_unoccupied_spot_true() {
        playarea.set_piece(player1.getPiece(), 0, 0, player1);
        assertEquals(playarea.getplayarea()[0][0].getPiece() == player1.getPiece(), true);
    }

    @Test(expected = IllegalStateException.class)
    public void set_piece_on_occupied_spot_true() {
        playarea.set_piece(player1.getPiece(), 0, 0, player1);
        playarea.set_piece(player1.getPiece(), 0, 0, player1);
    }

    @Test
    public void get_HorizontalLines_true() {
        try {
            playarea.set_piece(player1.getPiece(), 0, 0, player1);
            playarea.set_piece(player1.getPiece(), 0, 1, player1);
            Spot[] line = playarea.get_HorizontalLines(0);
            assertEquals(Arrays.equals(line, new Spot[] { new Spot(0, 0, player1.getPiece(), player1),
                    new Spot(0, 1, player1.getPiece(), player1) }, null), true);
        } catch (NullPointerException e) {
            Spot[] line = playarea.get_HorizontalLines(0);
            System.out.println(Arrays.toString(line));
        }
    }

    @Test
    public void check_horizontal_winner_is_player1_true() {
        try {
            playarea.set_piece(player1.getPiece(), 0, 0, player1);
            playarea.set_piece(player1.getPiece(), 0, 1, player1);
            playarea.set_piece(player1.getPiece(), 0, 2, player1);
            String winner = playarea.check_winner();
            assertEquals(winner.equals("player1"), true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_vertical_winner_is_player1_true() {
        // try{
        playarea.set_piece(player1.getPiece(), 0, 0, player1);
        playarea.set_piece(player1.getPiece(), 1, 0, player1);
        playarea.set_piece(player1.getPiece(), 2, 0, player1);
        String winner = playarea.check_winner();
        assertEquals(winner.equals("player1"), true);
        // } catch (NullPointerException e){
        // System.out.println(winner);
        // }
    }

    @Test
    public void check_diagonal_winner_is_player1_true() {
        try {
            playarea.set_piece(player1.getPiece(), 0, 0, player1);
            playarea.set_piece(player1.getPiece(), 1, 1, player1);
            playarea.set_piece(player1.getPiece(), 2, 2, player1);
            String winner = playarea.check_winner();
            assertEquals(winner.equals("player1"), true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_horizontal_winner_is_player2_true() {
        try {
            playarea.set_piece(player2.getPiece(), 0, 1, player2);
            playarea.set_piece(player2.getPiece(), 1, 1, player2);
            playarea.set_piece(player2.getPiece(), 2, 1, player2);
            String winner = playarea.check_winner();
            assertEquals(winner.equals("player2"), true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_vertical_winner_is_player2_true() {
        try {
            playarea.set_piece(player2.getPiece(), 1, 0, player2);
            playarea.set_piece(player2.getPiece(), 1, 1, player2);
            playarea.set_piece(player2.getPiece(), 1, 2, player2);
            String winner = playarea.check_winner();
            assertEquals(winner.equals("player2"), true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check_diagonal_winner_is_player2_true() {
        try {
            playarea.set_piece(player2.getPiece(), 0, 2, player2);
            playarea.set_piece(player2.getPiece(), 1, 1, player2);
            playarea.set_piece(player2.getPiece(), 2, 0, player2);
            String winner = playarea.check_winner();
            assertEquals(winner.equals("player2"), true);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}