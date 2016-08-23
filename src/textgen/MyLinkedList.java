package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size=0;
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		LLNode<E> temp=new LLNode<E>();
		temp.data=element;
		temp.prev=this.tail.prev;
		this.tail.prev=temp;
		temp.next=this.tail;
		LLNode<E> LastElement=temp.prev;
		LastElement.next=temp;
		this.size+=1;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0 || this.head.next==this.tail || index>=this.size()) {
			IndexOutOfBoundsException e=new IndexOutOfBoundsException();
			throw e;
		}
		LLNode<E> currentNode=this.head;
		
		int i=0;
		while(i<=index){
		currentNode=currentNode.next;	
		i++;
		}
		
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index<0 || index>=this.size()){
			IndexOutOfBoundsException e=new IndexOutOfBoundsException();
			throw e;
		}
		else {
		LLNode newNode=new LLNode(element);
		LLNode prevNode=head;
		int i=0;
		while(i<index) {
			prevNode=prevNode.next;
			i++;
		}
		newNode.next=prevNode.next;
		prevNode.next=newNode;

		newNode.prev=prevNode;
		prevNode.next.prev=newNode;

		this.size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		/*LLNode currentNode=this.head;
		int count=0;
		while(! ((currentNode.next).equals(this.tail))) {
		count++;	
		currentNode=currentNode.next;
		}
		return count;*/
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0 || index>=this.size()){
			IndexOutOfBoundsException e=new IndexOutOfBoundsException();
			throw e;	
		}
		else {
		E data=this.get(index);
		LLNode prevNode=head;
		LLNode currNode=head;
		int i=0;
		while(i<index) {
			prevNode=prevNode.next;
			i++;
		}
		i=0;
		while(i<=index) {
			currNode=currNode.next;
			i++;
		}
		prevNode.next=currNode.next;
		currNode.next.prev=prevNode;
		this.size--;
		return data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<0 || index>=this.size()){
			IndexOutOfBoundsException e=new IndexOutOfBoundsException();
			throw e;	
		} else {
		LLNode currNode=head;
		int i=0;
		while(i<=index){
			currNode=currNode.next;
			i++;
		}
		E replaced=this.get(index);
		currNode.data=element;
		return replaced;
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	public LLNode() 
	{
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
