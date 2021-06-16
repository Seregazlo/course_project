import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {



        EventQueue.invokeLater(

                new Runnable() {

                    public void run() {

                        new GamePane();

                    }
                });
    }
}