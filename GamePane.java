import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePane implements ActionListener, Runnable {

    JFrame frame = new JFrame("Игра \"Инь-Ян\"");
    JPanel buttonPanel  = new JPanel();
    JPanel delayPanel = new JPanel();
    JPanel rowColumnPanel = new JPanel();
    JPanel menuPanel = new JPanel();

    JButton beginGame = new JButton("Начать игру");
    JButton stopGame = new JButton("Остановить игру");
    JSlider delaySlider = new JSlider(JSlider.HORIZONTAL, 0, 500, 100);
    JSlider rowsAndColums = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);
    int aNumberOfRowsAndColumns = rowsAndColums.getValue();


    int[][] aRandomArray = new int[aNumberOfRowsAndColumns][aNumberOfRowsAndColumns];
    CellRenderPanel gamePanel = new CellRenderPanel(aRandomArray);

    boolean ifGameBegin = false;
    int delay = delaySlider.getValue();


    public GamePane(){

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenW = screenSize.width;
        int screenH = screenSize.height;

        frame.setMinimumSize(new Dimension((int)(screenW/1.3), (int) (screenH/1.3)));
        frame.setResizable(true);

        buttonPanel.add(beginGame);
        buttonPanel.add(stopGame);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        delayPanel.add (new JLabel("Быстрее"));

        delaySlider.addChangeListener(new ChangeListener() {
            @Override public void stateChanged(ChangeEvent e) {
                delaySlider = (JSlider) e.getSource();
                delay = delaySlider.getValue();
            }
        });

        delaySlider.setMajorTickSpacing(100);
        delaySlider.setMinorTickSpacing(5);
        delaySlider.setPaintTicks(true);
        delaySlider.setPaintLabels(true);

        delayPanel.add (delaySlider);
        delayPanel.add (new JLabel("Медленнее"));
        delayPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,50));

        rowColumnPanel.add (new JLabel("10"));

        rowsAndColums.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rowsAndColums = (JSlider) e.getSource();
                aNumberOfRowsAndColumns = rowsAndColums.getValue();
                frame.repaint();
            }
        });

        rowsAndColums.setMajorTickSpacing(20);
        rowsAndColums.setMinorTickSpacing(5);
        rowsAndColums.setPaintTicks(true);
        rowsAndColums.setPaintLabels(true);

        rowColumnPanel.add (rowsAndColums);
        rowColumnPanel.add (new JLabel("100"));
        rowColumnPanel.setBorder(BorderFactory.createEmptyBorder(5,50,5,5));

        beginGame.addActionListener(this);
        stopGame.addActionListener(this);


        menuPanel.add(delayPanel, BorderLayout.EAST);
        menuPanel.add(buttonPanel, BorderLayout.CENTER);
        menuPanel.add(rowColumnPanel, BorderLayout.WEST);

        frame.add(menuPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(beginGame) && !ifGameBegin){
            ifGameBegin = true;
            Thread t = new Thread(this);
            t.start();
            rowsAndColums.setEnabled(false);

        }

        if (e.getSource().equals(stopGame)){
            ifGameBegin = false;
            rowsAndColums.setEnabled(true);

        }

    }

    public void run() {

        CreateRandomArrayClass randomArray = new CreateRandomArrayClass();
        aRandomArray = randomArray.setRandomArray(aNumberOfRowsAndColumns, aNumberOfRowsAndColumns);
        OneStepOfGame step = new OneStepOfGame();
        gamePanel.setGrid(aRandomArray);
        frame.repaint();

        try {
            Thread.sleep(delay);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        while (ifGameBegin == true) {
            aRandomArray = step.oneStepOfGame(aRandomArray, aNumberOfRowsAndColumns, aNumberOfRowsAndColumns);
            gamePanel.setGrid(aRandomArray);
            frame.repaint();

            try {
                Thread.sleep(delay);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}