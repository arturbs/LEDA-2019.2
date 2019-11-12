package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	protected int height (BTNode<T> node) {
		int height = -1;

		if (!node.isEmpty()) {
			height = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (element != null) {
			if (!isEmpty()) {
				return search(this.root, element);
			}
		}
		return new BSTNode<>();
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> aux = new BSTNode<>();

		if (!node.isEmpty()) {
			if (node.getData().equals(element)) {
				aux = node;
			} else if (node.getData().compareTo(element) > 0) {
				aux = search((BSTNode<T>) node.getLeft(), element);
			} else {
				aux = search((BSTNode<T>) node.getRight(), element);
			}
		}

		return aux;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (element != null) {
			if (node.isEmpty()) {

				node.setData(element);
				node.setLeft(new BSTNode<>());
				node.setRight(new BSTNode<>());

				if (node.getParent() == null) {
					node.setParent(new BSTNode<>());

				}
				node.getLeft().setParent(node);
				node.getRight().setParent(node);
			} else {
				if (node.getData().compareTo(element) > 0) {
					this.insert((BSTNode<T>) node.getLeft(), element);
				} else {
					this.insert((BSTNode<T>) node.getRight(), element);
				}
			}
		}

	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> saida = null;
		if (!isEmpty()) {
			saida = this.maximum(this.getRoot());
		}
		return saida;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> resultado = null;
		if (!node.isEmpty()) {
			if (node.getRight().isEmpty()) {
				resultado = (BSTNode<T>) node;
			} else {
				resultado = maximum((BSTNode<T>) node.getRight());
			}
		}

		return resultado;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> saida = null;
		if (!isEmpty()) {
			saida = this.minimum(this.getRoot());
		}
		return saida;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> resultado = null;
		if (!node.isEmpty()) {
			if (node.getLeft().isEmpty()) {
				resultado = (BSTNode<T>) node;
			} else {
				resultado = minimum((BSTNode<T>) node.getLeft());
			}
		}

		return resultado;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		}
		if (!node.getRight().isEmpty()) {
			return minimum((BSTNode<T>) node.getRight());
		} else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (!parent.isEmpty() && node.equals(parent.getRight())) {
				node = parent;
				parent = (BSTNode<T>) node.getParent();
			}
			if (parent.isEmpty()) {
				return null;
			}
			return parent;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		}
		if (!node.getLeft().isEmpty()) {
			return maximum((BSTNode<T>) node.getLeft());
		} else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (!parent.isEmpty() && node.equals(parent.getLeft())) {
				node = parent;
				parent = (BSTNode<T>) node.getParent();
			}
			if (parent.isEmpty()) {
				return null;
			}
			return parent;
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty())
			return;
		remove(node);
	}

	private void remove(BSTNode<T> node) {
		if (node.isEmpty())
			return;
		if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			BSTNode<T> newNode = sucessor(node.getData());
			node.setData(newNode.getData());
			remove(newNode);
		} else {
			BSTNode<T> newNode = (BSTNode<T>) node.getLeft();

			if (newNode.isEmpty())
				newNode = (BSTNode<T>) node.getRight();

			node.setData(newNode.getData());
			node.setRight(newNode.getRight());
			node.setLeft(newNode.getLeft());

			if (!node.isEmpty() && node.getRight() != null)
				node.getRight().setParent(node);
			if (!node.isEmpty() && node.getLeft() != null)
				node.getLeft().setParent(node);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];

		if (!isEmpty()) {
			preOrder(this.root, 0, array);
		}

		return array;
	}

	private void preOrder(BSTNode<T> node, int index, T[] array) {
		if (!node.isEmpty()) {

			array[index] = node.getData();
			preOrder((BSTNode<T>) node.getLeft(), index + 1, array);
			preOrder((BSTNode<T>) node.getRight(), index + 1 + size((BSTNode<T>) node.getLeft()), array);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];

		if (!isEmpty()) {
			order(this.root, 0, array);
		}

		return array;
	}

	private int order (BSTNode<T> node, int index, T[] array) {
		if (!node.isEmpty()) {
			index = order((BSTNode<T>) node.getLeft(), index, array);
			array[index++] = node.getData();
			index = order((BSTNode<T>) node.getRight(), index, array);
		}

		return index;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];

		if (!isEmpty()) {
			postOrder(this.root, 0, array);
		}

		return array;
	}

	private int postOrder(BSTNode<T> node, int index, T[] array) {
		if (!node.isEmpty()) {
			index = postOrder((BSTNode<T>) node.getLeft(), index, array);
			index = postOrder((BSTNode<T>) node.getRight(), index, array);
			array[index++] = node.getData();
		}

		return index;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
