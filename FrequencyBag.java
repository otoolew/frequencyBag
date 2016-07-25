package frequencyBag;
public class FrequencyBag<T> {
	/**
	 * Instance variables
	 */
	private Node firstNode;
	private int numEntries;
	/**
	 * Constructor Constructs an empty frequency bag.
	 */
	public FrequencyBag() {
		firstNode = null;
		numEntries = 0;
	}// COMPLETED

	/**
	 * Adds new entry into this frequency bag.
	 * 
	 * @param aData
	 *            the data to be added into this frequency bag.
	 */
	public void add(T aData) {
		Node newNode = new Node(aData);
		newNode.next = firstNode;
		firstNode = newNode;
		numEntries++;
	}// end add

	/**
	 * Gets the number of occurrences of aData in this frequency bag.
	 * 
	 * @param aData
	 *            the data to be checked for its number of occurrences.
	 * @return the number of occurrences of aData in this frequency bag.
	 */
	public int getFrequencyOf(T aData) {
		
		int frequency = 0;

		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numEntries) && (currentNode != null)) {
			if (aData.equals(currentNode.data)) {
				frequency++;
			} // end if

			counter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	}
	/**
	 * 
	 * @param aData
	 * @return true if data is equal
	 */		
	public boolean contains(T aData){
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)){
			if(aData.equals(currentNode.data)){				
				found = true;
			}else{
				currentNode = currentNode.next;
			}
		}
		return found;
	}

	/**
	 * Gets the maximum number of occurrences in this frequency bag.
	 * 
	 * @return the maximum number of occurrences of an entry in this frequency
	 *         bag.
	 */
	public int getMaxFrequency() {
		
		if(firstNode!=null){
			Node currentNode = firstNode;
			Node maxNode = firstNode;
			while(currentNode!=null){
				if(currentNode.getFrequencyOfNode()>=maxNode.getFrequencyOfNode()){
					maxNode = currentNode;
				}
				currentNode = currentNode.next;
			}
			return maxNode.getFrequencyOfNode();
		}
			
		return 0;
	}// TO DO

	/**
	 * Gets the probability of aData
	 * 
	 * @param aData
	 *            the specific data to get its probability.
	 * @return the probability of aData
	 */
	public double getProbabilityOf(T aData) {
		double freq = this.getFrequencyOf(aData);
		double dblSize = numEntries;
		return freq/dblSize;
	}

	/**
	 * Empty this bag.
	 */
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
	}// COMPLETED

	public T remove() {
		T result = null;
		if (!isEmpty()) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numEntries--;
		}
		return result;
	}// COMPLETED

	/**
	 * Gets the number of entries in this bag.
	 * 
	 * @return the number of entries in this bag.
	 */
	public int size() {
		return numEntries;
	}// COMPLETED

	/**
	 * Checks if the bag is empty
	 * 
	 * @return True if bag is empty
	 */
	public boolean isEmpty() {
		return firstNode == null;
	}

	/**
	 * This is an Inner Node class
	 * 
	 * @author Textbook Reference
	 *
	 */
	private class Node {
		private T data;
		private Node next;
		private int frequency;

		private Node(T aData) {
			this(aData, null);
		}
		private Node(T aData, Node nextNode) {
			data = aData;
			next = nextNode;
		}
		public int getFrequencyOfNode(){
			return frequency;
		}
	} // end Node
}
