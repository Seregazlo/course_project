import javax.swing.*;
import java.awt.*;

public class CellRenderPanel extends JPanel {

    private int[][] cellArray;

    public CellRenderPanel (int[][] aRandomArray) {cellArray = aRandomArray;}

    public void setGrid(int[][] gameArray) {
        cellArray = gameArray;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        double boxWidth = (double)(this.getWidth()) / cellArray.length;
        double boxHeight = (double)(this.getHeight()) / cellArray.length;

        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray.length; j++) {

                if (cellArray[i][j] == 0) {

                    g.setColor(Color.GRAY);
                    g.fillRect((int)(i*boxWidth), (int)(j*boxHeight), (int)(boxWidth), (int)(boxWidth));
                }

                if (cellArray[i][j] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect((int)(i*boxWidth), (int)(j*boxHeight), (int)(boxWidth), (int)(boxWidth));
                }

                if (cellArray[i][j] == 2) {
                    g.setColor(Color.BLACK);
                    g.fillRect((int)(i*boxWidth), (int)(j*boxHeight), (int)(boxWidth), (int)(boxWidth));
                }
            }
        }
        for (int i = 0; i < cellArray.length; i++) {
            g.setColor(new Color(0,0,0));
            g.drawLine((int)(i*boxWidth), 0, (int)(i*boxWidth), this.getHeight());
            g.drawLine(0, (int)(i*boxHeight), this.getWidth(), (int)(i*boxHeight));
        }
    }
}
