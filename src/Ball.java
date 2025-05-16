import java.util.Random;

import static utils.Constants.*;

public class Ball extends Sprite {
    private double vx;
    private double vy;
    public int rally = 0;
    Random r = new Random();
    private int x;
    private int y;
    int[] directionChoices = {-1,1};



    public Ball() {
        super(BALL_IMAGE_PATH, 295, 215, BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }


    public void resetBall() {

        vx = 0;
        vy = 0;
        // Move the ball to the center of the screen
        this.pos.x = BOARD_WIDTH / 2 - BALL_WIDTH /2;
        this.pos.y = BOARD_HEIGHT / 2 - BALL_HEIGHT /2;

        // Set random starting direction
        int randomX = directionChoices[r.nextInt(directionChoices.length)];
        int randomY = directionChoices[r.nextInt(directionChoices.length)];

        vx = BALL_SPEED * randomX;
        vy = BALL_SPEED * randomY;
        //position ball to centre of screen
        //reset ball velocity

        rally = 0;
    }

    public int getRally() {
        return rally;
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
        rally++;
    }

    public void bounceLeft() {
        vx = -Math.abs(vx) * 1.05;
        rally++;
    }

    public void flipVx() {
        vx = -vx;
    }

}
