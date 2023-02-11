import graphics.BoardFrame;
import mvc.Controller;

public class app {

    public static void main(String[] args) {
        Controller c = new Controller();
        new BoardFrame(c);
    }


    
}
