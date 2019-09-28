package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		if (this.getData() == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {

		if (this.data != null) {
			if (!this.isEmpty()) {
				return 1 + this.getNext().size();
			}
        }
        return 0;
	}

	@Override
	public T search(T element) {
	    if (element != null) {
	        if (!isEmpty()){
                if (this.getData().equals(element)) {
                    return element;
                }
                else {
                    return this.getNext().search(element);
                }
            }
            }

        return null;
	}

	@Override
	public void insert(T element) {
	    if (element != null) {
            if (this.getData() == null) {
                this.setData(element);
                this.setNext(new RecursiveSingleLinkedListImpl<T>());
            }
            else {
                this.getNext().insert(element);
            }
        }
    }

	@Override
	public void remove(T element) {
	    if (element != null) {
	        if (!this.isEmpty()) {
                if (this.getData().equals( element)){
                    this.setData(this.getNext().getData());
                    this.setNext(this.getNext().getNext());
                }
                else {
                    this.getNext().remove(element);
                }
            }
        }


    }

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		toArray(array, this, 0);
		return array;
	}

	private void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (!node.isEmpty()) {
			array[index] = node.getData();
			toArray(array, node.getNext(), ++index);
		}
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}


