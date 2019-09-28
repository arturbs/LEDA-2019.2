package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (element != null) {


		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			setHead(head.getNext());
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			getLast().getPrevious().setNext(getLast().getNext());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
