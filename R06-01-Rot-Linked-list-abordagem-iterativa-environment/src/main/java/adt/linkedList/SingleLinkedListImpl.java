package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> auxHead = this.head;
		int contSize = 0;
		while ((!auxHead.isNIL())) {
			contSize++;
			auxHead = auxHead.getNext();
		}
		return contSize;
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (element != null) {
			SingleLinkedListNode<T> auxHead = this.head;
			while (auxHead.data != null) {
				if (element.equals(auxHead.getData())){
					retorno = element;
				}
				auxHead = auxHead.getNext();
			}
		}
		return retorno;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if (element != null) {
			while (!auxHead.isNIL()){
				auxHead = auxHead.getNext();
			}
			auxHead.data = element;
			auxHead.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if (element != null) {
			if (head.getData().equals(element)) {
				setHead(getHead().getNext());
			}
			else {
				while (!auxHead.getNext().equals(element) && auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setNext(auxHead.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		int index = 0;
		SingleLinkedListNode<T> auxHead = this.head;
		while (!auxHead.isNIL()) {
			array[index] = auxHead.getData();
			auxHead = auxHead.getNext();
			index++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
