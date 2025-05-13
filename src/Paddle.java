public class Paddle extends Sprite {
    private static final String imagePath = ;
    private double dx;
    private double dy;
    private int upKey;
    private int downKey;

   public Paddle(int upKey, int downKey, int xPos) {
       super(imagePath, x, y);
       this.upKey = upKey;
       this.downKey = downKey;
   }


    @Override
    public void tick() {

    }
}

