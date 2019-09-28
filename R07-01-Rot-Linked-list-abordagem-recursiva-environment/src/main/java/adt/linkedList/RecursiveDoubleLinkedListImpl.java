package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void remove(T element) {
		if (element != null){
			if (!this.isEmpty()) {
				if (this.getData().equals(element)) {
					if (this.getPrevious() == null) {
						removeFirst();
					}
					else if (this.getNext() == null) {
						removeLast();
					}
					else {
						this.getPrevious().setNext(this.getNext());
						((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this.getPrevious());
					}

				}
				else {
					this.getNext().remove(element);
				}
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
			} else {
				if (this.getNext().isEmpty()) {
					this.getNext().setData(element);
					this.getNext().setNext(new RecursiveDoubleLinkedListImpl<>());
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
				} else {
					this.getNext().insert(element);
				}
			}
		}
	}

	@Override
	public void insertFirst(T element) {

		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				setPrevious(new RecursiveDoubleLinkedListImpl<>());
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.size() == 1) {
				this.setData(null);
				this.setPrevious(null);
				this.setNext(null);
			} else {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().getData() == null) {
				this.setData(null);
				this.getPrevious().setNext(new RecursiveDoubleLinkedListImpl<>());
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}



	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
