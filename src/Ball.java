import java.util.Random;

import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;
    Random r = new Random();
    private int x;
    private int y;


    public Ball() {
        super(BALL_IMAGE_PATH, 295, 215, BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }


    public void resetBall() {
        int r1 = r.nextInt(4);
        if (r1 == 0) {
            vx = -BALL_SPEED;
            vy = -BALL_SPEED;
        } else if (r1 == 1) {
            vx = BALL_SPEED;
            vy = BALL_SPEED;
        } else if (r1 == 2) {
            vx = BALL_SPEED;
            vy = -BALL_SPEED;
        } else {
            vx = -BALL_SPEED;
            vy = BALL_SPEED;
        }
        //position ball to centre of screen
        //reset ball velocity
    }



    @Override
    public void tick() {
        getPos().translate((int) vx, (int) vy);

        if (pos.y <= 0 || pos.y >= BOARD_HEIGHT - BALL_HEIGHT) {
            vy *= -1;
        }
    }

    public void bounceRight() {
        vx = Math.abs(vx) * 1.05;
    }

    public void bounceLeft() {
        vx = -Math.abs(vx) * 1.05;
    }

    public void flipVx() {
        vx = -vx;
    }

}
