package EightQueensPuzzle;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author robert
 */
public class QueensGUI extends QueensBoard {

    private JButton[][] myButtons;

    private int myDelay;

    private JFrame f;

    private int SIZE;

    public QueensGUI(int size) {

        super(size);
        SIZE = board.length;
        f = new JFrame();
        f.setSize(60 * SIZE + 50, 60 * SIZE + 80);
        f.setTitle(size + " Queens Animation");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();

        // initialize delay and add slider to control it at bottom
        final int maxPause = 1000; // milliseconds
        final JSlider slider = new JSlider(0, maxPause - 20);
        myDelay = slider.getValue();

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                myDelay = maxPause - slider.getValue();
            }
        });
        JPanel p = new JPanel();
        p.add(new JLabel("slow"));
        p.add(slider);
        p.add(new JLabel("fast"));
        contentPane.add(p, "South");

        // add buttons in the middle for the chess squares
        p = new JPanel(new GridLayout(SIZE, SIZE, 1, 1));
        contentPane.add(p, "Center");

        p.setBackground(Color.black);
        myButtons = new JButton[SIZE][SIZE];

        Font f24 = new Font("Serif", Font.BOLD, 24);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton b = new JButton();

                b.setFont(f24);
                p.add(b);
                myButtons[i][j] = b;

            }
        }

        // bring it on...
        f.setVisible(true);
        f.toFront();

    }

    public void place(int row, int col) {
        super.place(row, col);
        myButtons[row][col].setText("" + board[row][col]);
        pause();

    }

    public boolean isSafe(int row, int col) {
        myButtons[row][col].setText("?");
        pause();
        myButtons[row][col].setText("" + board[row][col]);
        return super.isSafe(row, col);
    }

    public void remove(int row, int col) {
        super.remove(row, col);
        myButtons[row][col].setOpaque(true); // might need this on a mac?
        myButtons[row][col].setBackground(Color.RED);
        myButtons[row][col].setText("No");
        pause();
        pause();
        pause();
        myButtons[row][col].setBackground(new JButton().getBackground());
        myButtons[row][col].setOpaque(false); // might need this on a mac?
        myButtons[row][col].setText("" + board[row][col]);

    }

    // pause using slider setting
    private void pause() {
        pause(myDelay);

    }

    private void pause(int delay) {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            throw new InternalError();
        }

    }
}
