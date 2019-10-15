package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			int probe = 0;
			int index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			while (probe <= table.length) {
				if (this.table[index] == null || this.table[index] == deletedElement) {
					table[index] = element;
					elements++;
					break;
				} else {
					probe++;
					index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
				}
				COLLISIONS++;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && search(element) != null) {
			int probe = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			while (probe < table.length && table[hash] != null) {
				if (table[hash].equals(element) && table[hash] != deletedElement) {
					table[hash] = deletedElement;
					elements--;
				} else {
					probe++;
					hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
				}
			}
		}
	}

	@Override
	public T search(T element) {
		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
			while (probe < table.length && table[hash] != null) {
				if (table[hash].equals(element) && table[hash] != deletedElement) {
					return element;
				} else {
					probe++;
					hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
				}
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		int indexOf = -1;
		int probe = 0;
		int hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
		if (element != null && table[hash] != null) {
			while (probe <= table.length) {
				if (table[hash].equals(element) && table[hash] != deletedElement) {
					return hash;
				} else {
					probe++;
					hash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);
				}
			}
		}
		return indexOf;
	}
}