import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the Canvas
 * class.
 *
 * @author Jennifer Moran
 * @version 2015.11.02
 */
public class BallDemo {

	private static final int OFFSET = 10;
	private final Canvas canvas;

	/**
	 * Create a BallDemo object. Creates a fresh canvas and makes it visible.
	 */
	public BallDemo() {
		canvas = new Canvas("Ball Demo", 600, 500);
	}

	private void drawCanvas(Canvas canvas) {

		// get the height and width of the canvas
		Double height = canvas.getSize().getHeight();
		Double width = canvas.getSize().getWidth();
		canvas.setVisible(true);
		// draw the rectangle using four lines and using the size of the canvas and the offset to figure out where to draw the lines
		canvas.drawLine(OFFSET, height.intValue() - OFFSET, width.intValue() - OFFSET, height.intValue() - OFFSET);
		canvas.drawLine(OFFSET, OFFSET, width.intValue() - OFFSET, OFFSET);
		canvas.drawLine(OFFSET, OFFSET, OFFSET, height.intValue() - OFFSET);
		canvas.drawLine(width.intValue() - OFFSET, OFFSET, width.intValue() - OFFSET, height.intValue() - OFFSET);
	}

	/**
	 * Draw a rectangle on the canvas and bounce balls inside of it
	 *
	 * @param numberOfBalls parameter used to determine number of balls
	 * @param numberOfBounces parameter used to determine number of bounces
	 *
	 */
	public void boxBounce(int numberOfBalls, int numberOfBounces) {
		// Verify number of balls is between 5 and 50 per requirements
		if (numberOfBalls < 5 || numberOfBalls > 50) {
			System.out.println("Number of Balls must be between 5 and 50");
			return;
		}
		int x = 0;
		ArrayList<BoxBall> balls = new ArrayList<>();
		drawCanvas(canvas);

		// Add balls to an ArrayList based on numberOfBalls parameter
		for (int i = 0; i <= numberOfBalls; i++) {
			balls.add(new BoxBall(canvas, OFFSET));
		}

		// Draw balls in ArrayList
		for (BoxBall ball : balls) {
			ball.draw();
		}

		// make them bounce
		while (x <= numberOfBounces) {
			canvas.wait(50); // small delay
			for (BoxBall ball : balls) {
				ball.move();
			}
			x++;
		}
	}
}