package training.generics;

public class ImmutableList<E> {

	private final E head;
	private final ImmutableList<E> tail;

	private ImmutableList(E head, ImmutableList<E> tail) {
		this.head = head;
		this.tail = tail;
	}

	public ImmutableList() {
		this(null, null);
	}

	public ImmutableList<E> prepend(E element) {
		return new ImmutableList<E>(element, this);
	}

	public E head() {
		return head;
	}

	public ImmutableList<E> tail() {
		return tail;
	}

	public int length() {
		return tail == null ? 0 : 1 + tail.length();
	}

	public ImmutableList<E> map(Function<E, E> fn) {
		return tail == null ? this : tail.map(fn).prepend(fn.apply(head));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		@SuppressWarnings("rawtypes")
		ImmutableList other = (ImmutableList) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (tail == null) {
			if (other.tail != null)
				return false;
		} else if (!tail.equals(other.tail))
			return false;
		return true;
	}

}
