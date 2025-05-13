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
        pos.x = Math.clamp(pos.x, 0, BOARD_WIDTH - BALL_WIDTH);
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - BALL_HEIGHT);



        if (pos.y <= 0){
            vy *= -1;
        } else if (pos.y >= BOARD_HEIGHT - BALL_HEIGHT) {
            vy *= -1;
        }
    }
}
