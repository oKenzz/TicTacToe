package playarea;

import java.net.SocketOptions;

import pieces.*;
import player.Player;

public class Playarea {
    private Spot[][] playarea;
    private final static int row = 3;
    private final static int column = 3;
    private boolean full = false; // set true if board is full, indicates that it is a tie

    public Playarea() {
        this.playarea = new Spot[3][3];
    }

    public void set_piece(Piece p, int x, int y, Player player) {
        check_if_occupied(x, y);
        playarea[x][y] = new Spot(x, y, p, player);
    }

    private void check_if_occupied(int x, int y) {
        if (playarea[x][y] != null)
            throw new IllegalStateException("Spot is Occupied");
        // if (playarea[x][y].getIsOccupied()) throw new IllegalStateException("Spot is
        // Occupied");
        // if (playarea[x][y].getIsOccupied() && playarea[x][y] != null) throw new
        // IllegalStateException("Spot is Occupied");
    }

    // Split into multiple functions, playarea[][].getX and if all same
    // Should return String name of winner not boolean
    public String check_winner() {
        String winner = null;
        check_horizontal(winner);
        check_vertical(winner);
        check_diagonal(winner);        
        return winner;
    }

    private void check_horizontal(String winner) throws NullPointerException{
        Spot[] line = new Spot[3];
        try{
        for (int row = 0; row < 3; row++) {
            line = get_HorizontalLines(row);
            System.out.println("Match is " + checktmatching(line));
            if (checktmatching(line)) {
                winner = line[0].getPlayer().getName();
            }
            }
            } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public Spot[] get_HorizontalLines(int row){
        Spot[] line = new Spot[3];
        line[0] = playarea[row][0];
        line[2] = playarea[row][2];
        line[1] = playarea[row][1];
        return line;
    }

    private void check_vertical(String winner) throws NullPointerException{
        Spot[] line = new Spot[3];
        try{
        for (int col = 0; col < 3; col++) {
            line = get_VerticallLines(col);
            if (checktmatching(line)) {
                winner = line[0].getPlayer().getName();
            }
        }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public Spot[] get_VerticallLines(int col){
        Spot[] line = new Spot[3];
        line[0] = playarea[0][col];
        line[1] = playarea[1][col];
        line[2] = playarea[2][col];
        return line;
    }

    private void check_diagonal(String winner) throws NullPointerException{
        Spot[] line = new Spot[3];
        try{
        for (int i = 0; i < 2; i++) {
            line = getDiagonalLines(i);
            if (checktmatching(line)) {
                winner = line[0].getPlayer().getName();
            }
        }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    private Spot[] getDiagonalLines(int i){
        Spot[] line = new Spot[3];
        if (i == 0) {
            line[0] = playarea[0][0];
            line[1] = playarea[1][1];
            line[2] = playarea[2][2];
        } else if (i == 1) {
            line[0] = playarea[0][2];
            line[1] = playarea[1][1];
            line[2] = playarea[2][0];
        }
        return line;
    }

    private boolean checktmatching(Spot[] line) throws NullPointerException{
        try {
            for (Spot p : line) {
                if (!(p.getPiece() instanceof X)) { // Checks if the line consists of all X
                    return false;
                }
            }
            for (Spot p : line) {
                if (!(p.getPiece() instanceof O)) { // Checks if the line consists of all X
                    return false;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Spot[][] getplayarea() {
        return playarea;
    }

}