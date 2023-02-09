package Playarea;
import pieces.*;
import player.Player;

public class Playarea{
    private Spot[][] playarea;

    public Playarea(){
        this.playarea = new Spot[3][3];
    }

    public void set_piece(Piece p, int x, int y, Player player){
        check_if_occupied(x, y);
        playarea[x][y] = new Spot(x, y, p, player);
    }

    private void check_if_occupied(int x, int y){
        if (playarea[x][y].getIsOccupied()) throw new IllegalStateException("Spot is Occupied");
    }

    // Split into multiple functions, playarea[][].getX and if all same 
    //Should return String name of winner not boolean
    public boolean check_winner(){
        boolean winner;
        winner = check_horizontal();
        winner = check_vertical();
        winner = check_diagonal();
        return winner;
    }

    private boolean check_horizontal(){
        Piece[] line = new Piece[3];
        boolean matching = false;
        for(int row = 0; row < 3; row++){
            line = get_HorizontalLines(row);
            matching = checktmatching(line);
            if (matching) return matching;
        }
        return matching;
    }

    private Piece[] get_HorizontalLines(int row){
        Piece[] line = new Piece[3];
        line[0] = playarea[row][0].getPiece();
        line[2] = playarea[row][2].getPiece();
        line[1] = playarea[row][1].getPiece();
        return line;
    }

    
    private boolean check_vertical(){
        Piece[] line = new Piece[3];
        boolean matching = false;
        for(int col = 0; col < 3; col++){
            line = get_VerticallLines(col);
            matching = checktmatching(line);
            if (matching) return matching;
        }
        return matching;
    }
    
    private Piece[] get_VerticallLines(int col){
        Piece[] line = new Piece[3];
        line[0] = playarea[0][col].getPiece();
        line[1] = playarea[1][col].getPiece();
        line[2] = playarea[2][col].getPiece();
        return line;
    }

    private boolean check_diagonal(){
        Piece[] line = new Piece[3];
        boolean matching = false;
        for (int i = 0; i < 2 ; i++){
            line = getDiagonalLines(i);
            matching = checktmatching(line);
            if (matching) return matching;
        }
        return matching;
    }

    private Piece[] getDiagonalLines(int i){
        Piece[] line = new Piece[3];
        if (i == 0){
            line[0] = playarea[0][0].getPiece();
            line[1] = playarea[1][1].getPiece();
            line[2] = playarea[2][2].getPiece();
        } else if (i == 1){
            line[0] = playarea[0][2].getPiece();
            line[1] = playarea[1][1].getPiece();
            line[2] = playarea[2][0].getPiece();
        }
        return line;
    }

    private boolean checktmatching(Piece[] line){
        for(Piece p : line){
            if(!(p instanceof X)){ // Checks if the line consists of all X
                return false;
            }
        }
        for(Piece p : line){
            if(!(p instanceof O)){ // Checks if the line consists of all X
                return false;
            }
        }
        return true;
    }

    public Spot[][] getplayarea() {
        return playarea;
    }

}