package subparts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RecursiveSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@SuppressWarnings("unchecked")
	@Override
	public List<List<E>> getSubsets(Set<E> set, int subsetSize) {

		if (subsetSize <= 0) return null;
		if (subsetSize > set.size()) return null;
		
		List<List<E>> output = new LinkedList<List<E>>();
		
		recursiveStep(new LinkedList<>(set), subsetSize, subsetSize, (E[]) new Object[0], output);
		
		return output; 
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void recursiveStep(List<E> input, int subSize, int originalSubSize, E[] currentList, List<List<E>> output) {
		
		if ( subSize == 0 )
			return; 
		
		if (input.isEmpty()) 
			return; 
		
		if (currentList.length > originalSubSize) return;
		
		if (input.size() < subSize) return;
		
		E[] newCurrentList = (E[]) new Object[currentList.length + 1]; 
		newCurrentList[newCurrentList.length-1] = input.get(0);
		copyArrayFromFirstPosition(newCurrentList, currentList);
		
		recursiveStep(input.subList(1, input.size()), subSize-1, originalSubSize, newCurrentList, output); 
		recursiveStep(input.subList(1, input.size()), subSize, originalSubSize, currentList, output); 
		
		
		//System.out.println("currentList: " + printArray(newCurrentList)); 
		if (newCurrentList.length == originalSubSize) 
			output.add(new LinkedList(Arrays.asList(newCurrentList))); 
		
		
	}
	
	private void copyArrayFromFirstPosition(E[] newCurrentList, E[] currentList) {
		for (int i=0; i<currentList.length; i++) {
		newCurrentList[i] = currentList[i]; 
		}
	}
	
	private String printArray(E[] array) {
		String toReturn = ""; 
		for (int i=0; i<array.length; i++) {
			toReturn = toReturn + " " + array[i];
		}
		return toReturn;
	}

}
