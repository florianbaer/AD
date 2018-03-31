package com.baerdev.ad.sw05.BallGame;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BallGamePanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    // Liste, um sich alle Kreise auf dem Jpanel zu merken
    private final List<BallBehavior> circles;

    public BallGamePanel(final int width, final int height) {
        circles = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(width, height));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                BallBehavior ball = new BallBehavior(new Ball(mouseEvent.getX(), mouseEvent.getY()));
                Thread thread = new Thread(ball);
                thread.start();
                circles.add(ball);
            }
        });

        // Zeichne alle 10ms den Inhalt auf dem JPanel neu
        Timer timer = new Timer(10, this);
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    /**
     * paint-Methode der UI, wird aufgerufen, wenn repaint()-Methode aufgerufen wird
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Update alle Kreise, welche auf dem JPanel sind
        Graphics2D g2 = (Graphics2D) g;
        for (BallBehavior circle : circles) {
            circle.drawCircle(g2);

            // Beende den Thread des Balles, wenn er fertig ist, also unten
            if (circle.isAtTheBottom(circle.getBall(), this.getHeight())) {
                circle.getThreadBehindBall().interrupt();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}