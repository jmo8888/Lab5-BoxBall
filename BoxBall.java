import java.awt.Color;
import java.util.Random;

/**
 *
 * @author jennifermoran
 */
/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The
 * ball has the ability to move. Details of movement are determined by the ball
 * itself. It will fall downwards, accelerating with time due to the effect of
 * gravity, and bounce upward again when hitting the walls of the rectangle.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 *
 * @author jennifer moran
 * @version 2015-10-30
 */
public class BoxBall {

	private final Color color;
	private final int diameter;
	private int xPosition;
	private int yPosition;
	private final Canvas canvas;
	private int ySpeed;
	private int xSpeed;
	private final int offset;
	private final Random random = new Random();

	/**
	 * Constructor for objects of class BoxBall
	 *
	 * @param canvas
	 * @param offset
	 */
	public BoxBall(Canvas canvas, int offset) {
		this.canvas = canvas;
		this.offset = offset;
		// generate random color
		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		// generate random diameter with at least 10 px;
		diameter = random.nextInt(50) + 10;
		// generate random position for x and y position based on canvas height and width
		xPosition = random.nextInt(canvas.getSize().height);
		yPosition = random.nextInt(canvas.getSize().width);
		// generate random speed in x and y directions
		xSpeed = random.nextInt(7) + 1;
		ySpeed = random.nextInt(7) + 1;
	}

	/**
	 * Draw this ball at its current position onto the canvas.
	 *
	 */
	public void draw() {
		canvas.setForegroundColor(color);
		canvas.fillCircle(xPosition, yPosition, diameter);
	}

	/**
	 * Erase this ball at its current position.
	 *
	 */
	public void erase() {
		canvas.eraseCircle(xPosition, yPosition, diameter);
	}

	/**
	 * Move this ball making sure it stays within the bounds of the rectangle
	 *
	 */
	public void move() {
		erase();

		// set new position
		xPosition += xSpeed;
		yPosition += ySpeed;
		// check boundry of left wall
		if (xPosition <= offset) {
			xPosition = offset;
			xSpeed = -xSpeed;
		}
		// check boundry of right wall
		if (xPosition >= canvas.getSize().getWidth() - offset - diameter) {
			xPosition = (int) (canvas.getSize().getWidth() - offset - diameter);
			xSpeed = -xSpeed;
		}
		// check boundry of top wall
		if (yPosition <= offset) {
			yPosition = offset;
			ySpeed = -ySpeed;
		}
		// check boundry of bottom wall
		if (yPosition >= canvas.getSize().getHeight() - offset - diameter) {
			yPosition = (int) (canvas.getSize().getHeight() - offset - diameter);
			ySpeed = -ySpeed;
		}
		draw();
	}
}
