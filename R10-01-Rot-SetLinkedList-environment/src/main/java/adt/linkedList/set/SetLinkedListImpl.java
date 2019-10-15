package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

   @Override
   public void removeDuplicates() {
      T[] array = super.toArray();
      SingleLinkedListImpl<T> newList = new SingleLinkedListImpl<>();

      for (int i = 0; i < array.length; i++) {
         if (newList.search(array[i]) == null) {
            newList.insert(array[i]);
         }
      }
      this.setHead(newList.getHead());
   }

   @Override
   public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
      SetLinkedList<T> newSet = new SetLinkedListImpl<>();

      for (T element : super.toArray()) {
         newSet.insert(element);
      }

      for (T element : otherSet.toArray()) {
         newSet.insert(element);
      }

      newSet.removeDuplicates();
      return newSet;
   }

   @Override
   public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
      SetLinkedList<T> newSet = new SetLinkedListImpl<T>();

      for (T element : otherSet.toArray()) {
         for (T elemento : this.toArray()) {
            if (element.equals(elemento)) {
               newSet.insert(element);
            }
         }
      }

      newSet.removeDuplicates();
      return newSet;
   }

   @Override
   public void concatenate(SetLinkedList<T> otherSet) {
      SingleLinkedListNode<T> auxNode = this.getHead();

      while (!auxNode.getNext().isNIL()) {
         auxNode = auxNode.getNext();
      }
      auxNode.setNext(((SingleLinkedListImpl<T>) otherSet).getHead());

      this.removeDuplicates();
   }
}