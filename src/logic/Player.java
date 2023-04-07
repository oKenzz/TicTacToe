package logic;
public class Player {
    
    private String piece;
    private boolean winner;
    private String name;

    public Player(String name){
        this.piece = "";
        this.winner = false;
        this.name = name;
    };

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public void setWinner(boolean winner){
        this.winner = winner;
    }

    public boolean isWinner() {
        return winner;
    }

    public String getName() {
        return name;
    }    
}
