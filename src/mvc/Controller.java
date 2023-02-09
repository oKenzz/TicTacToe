package mvc;

public class Controller {
    
    View view;
    Model model;

    public Controller(){
        view = new View();
        model = new Model();
    }

}
