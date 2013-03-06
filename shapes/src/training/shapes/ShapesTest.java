package training.shapes;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ShapesTest {

	private static final Random RANDOM = new Random();

	/**
	 * TODO
	 *    - ??? substitutability?
	 */

	@Test
	public void squaresMustRemainSquare() {
		for (int i = 0; i < 100; i++) {
			Square s = arbitrarySquare();
			s.setWidth(RANDOM.nextInt(50));
			assertEquals(s.getWidth(), s.getHeight());
		}
	}

	@Test
	public void equalRectanglesMustBeEqual() {
		for (int i = 0; i < 100; i++) {
			Rectangle
				r1 = arbitraryRectangle(),
				r2 = new Rectangle(r1.getWidth(), r1.getHeight());
			assertEquals(r2, r1);
		}
	}

	private static Rectangle arbitraryRectangle() {
		return RANDOM.nextBoolean()
			? new Rectangle(RANDOM.nextInt(50), RANDOM.nextInt(50))
			: arbitrarySquare();
	}

	private static Square arbitrarySquare() {
		return new Square(RANDOM.nextInt(50));
	}
}
