package training.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * List(1, 2, 3)
 *   .head() ==> 1
 *   .tail() ==> List(2, 3)
 */
public class ImmutableList<E> {

	private final List<E> list;

	private ImmutableList(List<E> list) {
		this.list = list;
	}

	public ImmutableList() {
		this(new ArrayList<E>());
	}

	public ImmutableList<E> prepend(E element) {
		List<E> list = new ArrayList<E>();
		list.add(element);
		list.addAll(this.list);
		return new ImmutableList<E>(list);
	}

	public E head() {
		return list.isEmpty() ? null : list.get(0);
	}

	public ImmutableList<E> tail() {
		if (list.isEmpty())
			return null;
		List<E> list = this.list.subList(1, this.list.size());
		return new ImmutableList<E>(list);
	}

}
