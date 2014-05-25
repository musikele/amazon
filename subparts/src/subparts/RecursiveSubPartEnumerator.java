package subparts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RecursiveSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@SuppressWarnings("unchecked")
	@Override
	public List<List<E>> getSubsets(Set<E> set, int subsetSize) {

		//my default: instead of the empty list i return null
		if (subsetSize <= 0) return null;
		if (subsetSize > set.size()) return null;
		
		List<List<E>> output = new LinkedList<List<E>>();
		
		//start recursion!
		recursiveStep(new LinkedList<>(set), subsetSize, subsetSize, (E[]) new Object[0], output);
		
		return output; 
	}

	/**
	 * searches sublists in a recursive way. 
	 * @param input the list in input. It is assumed that is a list of unique items.
	 * @param subSize the size of the currently searching subset. It is decremented during recursive iterations 
	 * @param originalSubSize the size of the subsets to be found 
	 * @param currentList the list that the recursion is currently building 
	 * @param output the set of subsets built by the algorithm. If the recursiveStep finds a subset of elements, they will be added to output. 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void recursiveStep(List<E> input, int subSize, int originalSubSize, E[] currentList, List<List<E>> output) {
		
		//base cases
		if ( subSize == 0 )
			return; 
		
		if (input.isEmpty()) 
			return; 
		
		if (currentList.length > originalSubSize) return;
		
		if (input.size() < subSize) return;
		
		//my array of elements. I've decided to use arrays to work with low level memory and 
		//to avoid problems with pointers and function scope. 
		//newCurrentList is the list that I'm building in this branch of the recursion
		E[] newCurrentList = (E[]) new Object[currentList.length + 1]; 
		
		//we add the first element of the input to the last position of the array 
		newCurrentList[newCurrentList.length-1] = input.get(0);
		
		//...then we copy the partial solution that we are building 
		copyArrayFromFirstPosition(newCurrentList, currentList);
		
		//two recursive steps: the first is on a subList of smaller size
		recursiveStep(input.subList(1, input.size()), subSize-1, originalSubSize, newCurrentList, output); 
		//the second is on a smaller sublist but we are not decrementing the subsize 
		recursiveStep(input.subList(1, input.size()), subSize, originalSubSize, currentList, output); 
		
		//if the list built in the recursion is equal to original chosen size we will add it to the output
		if (newCurrentList.length == originalSubSize) 
			output.add(new LinkedList(Arrays.asList(newCurrentList))); 
		
		
	}
	
	/**
	 * 
	 * @param newCurrentList the list in wich we will copy 
	 * @param currentList the list to be copied 
	 */
	private void copyArrayFromFirstPosition(E[] newCurrentList, E[] currentList) {
		for (int i=0; i<currentList.length; i++) {
		newCurrentList[i] = currentList[i]; 
		}
	}
	

}
