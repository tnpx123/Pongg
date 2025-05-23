package utils;

public final class Constants {
    private Constants() {
        // prevents instantiation
    }

    // Board constants
    public static final int BOARD_WIDTH = 640;
    public static final int BOARD_HEIGHT = 480;
    // A delay of 25 milliseconds results in a frame rate of 45 FPS.
    public static final int TICK_DELAY = 25;

    // Player constants
    public static final String PADDLE_IMAGE_PATH = "resources/paddle.jpg";
    public static final int PADDLE_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 80;
    public static final int PADDLE_SPEED = 10;

    public static final String BALL_IMAGE_PATH = "resources/ball.png";
    public static final int BALL_WIDTH = 25;
    public static final int BALL_HEIGHT = 25;
    public static final int BALL_SPEED = 10;
}
