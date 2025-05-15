import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.Constants.*;

public class Board extends JPanel implements ActionListener, KeyListener {

    private final Paddle leftPaddle;
    private final Paddle rightPaddle;
    private final Ball ball;
    private final List<Sprite> sprites;
    private final Set<Integer> activeKeyCodes;

    public Board() {
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setBackground(Color.GRAY);

        ball = new Ball();
        //passed args for x pos to add padding to paddles
        leftPaddle = new Paddle(KeyEvent.VK_W, KeyEvent.VK_S, 10);
        rightPaddle = new Paddle(KeyEvent.VK_UP, KeyEvent.VK_DOWN, BOARD_WIDTH - PADDLE_WIDTH -10);
        sprites = new ArrayList<>(List.of(ball, leftPaddle, rightPaddle));

        activeKeyCodes = new HashSet<>();

        new Timer(TICK_DELAY, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftPaddle.handleActiveKeys(activeKeyCodes);
        rightPaddle.handleActiveKeys(activeKeyCodes);

        for(Sprite sprite : sprites) {
            sprite.tick();
        }

        if (ball.isColliding(leftPaddle)){
            ball.bounceRight();
        } else if (ball.isColliding(rightPaddle)) {
            ball.bounceLeft();
        }

        if (ball.getPos().x <= 0 || ball.getPos().x >= BOARD_WIDTH - BALL_WIDTH){
            ball.flipVx();
        }


        if (ball.getPos().x <= BOARD_WIDTH - BALL_WIDTH){
            //player winning point
        } else if (ball.getPos().x >= BOARD_WIDTH - BALL_WIDTH){

        }
        //implemented check for touching left side
        if (ball.pos.x >= BOARD_WIDTH - BALL_WIDTH){
            rightPaddle.setScore(1);
            ball.resetBall();

            //implemented check for touching right side
        } else if (ball.pos.x <= 0) {
            leftPaddle.setScore(1);
            ball.resetBall();
        }

        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for(Sprite sprite : sprites) {
            sprite.draw(graphics, this);
        }

        graphics.setFont(new Font("Arial", Font.BOLD, 42));
        graphics.drawString(("Hello World"), 20, 20);

        //drawing basic scoring system to screen
        graphics.drawString("left paddle score: " + leftPaddle.getScore(), 20, 90);
        graphics.drawString("right paddle score: " + rightPaddle.getScore(), 20, 140);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        activeKeyCodes.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        activeKeyCodes.remove(keyEvent.getKeyCode());
    }
}
