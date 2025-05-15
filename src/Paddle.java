import java.awt.event.KeyEvent;
import java.util.Set;

import static utils.Constants.*;

public class Paddle extends Sprite {
    private static final String imagePath = PADDLE_IMAGE_PATH;
    private int dy;
    private int upKey;
    private int downKey;
    private int score;

   public Paddle(int upKey, int downKey, int xPos) {
       super(imagePath, xPos,0,PADDLE_WIDTH, PADDLE_HEIGHT);
       this.upKey = upKey;
       this.downKey = downKey;
   }


    @Override
    public void tick() {
        pos.translate(0, dy);

        pos.y = Math.clamp(pos.y, 0, BOARD_HEIGHT - PADDLE_HEIGHT);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void handleActiveKeys(Set<Integer> activeKeyCodes) {

        dy = 0;

        if (activeKeyCodes.contains(upKey)) {
            dy -= PADDLE_SPEED;
        }
        if (activeKeyCodes.contains(downKey)) {
            dy += PADDLE_SPEED;
        }




    }
}