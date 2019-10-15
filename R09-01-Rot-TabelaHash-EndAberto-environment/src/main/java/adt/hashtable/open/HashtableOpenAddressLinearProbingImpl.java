package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			while (probe <= table.length) {
				if (this.table[hash] == null || this.table[hash] == deletedElement) {
					table[hash] = element;
					elements++;
					break;
				} else {
					probe++;
					hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
				}
				COLLISIONS++;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && search(element) != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			while (probe < table.length && table[hash] != null) {
				if (table[hash].equals(element) && table[hash] != deletedElement) {
					table[hash] = deletedElement;
					elements--;
				} else {
					probe++;
					hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
				}
			}
		}
	}

	@Override
	public T search(T element) {
		if (element != null) {
			int probe = 0;
			int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
			while (probe < table.length && table[hash] != null) {
				if (table[hash].equals(element) && table[hash] != deletedElement) {
					return element;
				} else {
					probe++;
					hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
				}
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		int indexOf = -1;
		int probe = 0;
		int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
		if (element != null) {
			while (probe <= table.length && table[hash] != null) {
				if (table[hash].equals(element) && table[hash] != deletedElement) {
					return hash;
				} else {
					probe++;
					hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probe);
				}
			}
		}
		return indexOf;
	}
}