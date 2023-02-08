import pieces.*;

public class Map{
    private Spot[][] map;

    public Map(){
        this.map = new Spot[3][3];
    }

    public void set_piece(Piece p, int x, int y){
        check_if_occupied(x, y);
        map[x][y] = new Spot(x,y,p);
    }

    private void check_if_occupied(int x, int y){
        if (map[x][y].getIsOccupied()) throw new IllegalStateException("Spot is Occupied");
    }

    // Split into multiple functions, map[][].getX and if all same 
    private boolean check_winner(){
        for(int i = 0; i < 3; i++){
            if(map[i][0].getPiece() && map[i][1].getPiece() && map[i][2].getPiece()) return true; //Check Horizontal
            if(map[0][i].getPiece() && map[1][0].getPiece() && map[2][i].getPiece()) return true; //Check Vertical
        }

        if(map[0][0].getPiece() && map[1][1].getPiece() && map[2][2].getPiece()) return true; //Check Diagonal        
        if(map[2][0].getPiece() && map[1][1].getPiece() && map[0][2].getPiece()) return true; //Check Diagonal
        return false;
    }

    



}