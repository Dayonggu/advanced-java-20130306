package training.generics;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImmutableListTest {

	private static final ImmutableList<Integer> ONE_TWO_THREE =
		new ImmutableList<Integer>().prepend(3).prepend(2).prepend(1);

	private static final ImmutableList<Integer> ONE_TWO_THREE_AGAIN =
			new ImmutableList<Integer>().prepend(3).prepend(2).prepend(1);

	@Test
	public void tailOfPrependMustBeSame() {
		ImmutableList<Integer> prepended = ONE_TWO_THREE.prepend(0);
		assertSame(ONE_TWO_THREE, prepended.tail());
	}

	@Test
	public void equalListsMustBeEqual() {
		assertEquals(ONE_TWO_THREE, ONE_TWO_THREE_AGAIN);
	}
}
