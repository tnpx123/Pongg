import static utils.Constants.*;

public class Ball extends Sprite{
    private double vx;
    private double vy;

    public Ball() {
        super(BALL_IMAGE_PATH,295,215 , BALL_WIDTH, BALL_HEIGHT);
        resetBall();
    }

    public void resetBall(){
        //position ball to centre of screen
        //reset ball velocityy
    }

    @Override
    public void tick() {
        getPos().translate((int) vx,(int) vy);
        vx = BALL_SPEED;
        vy = BALL_SPEED;
        pos.x = Math.clamp(pos.x, 0, BOARD_WIDTH - BALL_WIDTH);
        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - BALL_HEIGHT);
    }
}
