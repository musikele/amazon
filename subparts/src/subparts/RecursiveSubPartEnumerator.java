package subparts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RecursiveSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@Override
	public List<List<E>> getSubsets(Set<E> set, int subsetSize) {

		List<E> array = new LinkedList<>(set);

		if (subsetSize > set.size()) {
			return null;
		}

		List<List<E>> subParts = new LinkedList<List<E>>();
		
		combineSubParts(subParts, new LinkedList<E>(), array, subsetSize, subsetSize); 
		
		return subParts;

	}

	void combineSubParts(List<List<E>> subParts, List<E> currentSubSet, List<E> tailList, int subsetSize , int groupSize) {
		
		if (subsetSize <= 0 && currentSubSet.size() == groupSize) {
			
			subParts.add(new LinkedList(currentSubSet));
			return;
		}
		
		for (int i=0; i<tailList.size(); i++) {
			if (currentSubSet.size() == groupSize) {
				currentSubSet.remove(currentSubSet.size()-1);
			}
			currentSubSet.add(tailList.get(i));
			
			if (!tailList.isEmpty()) {				
				
				combineSubParts(subParts, currentSubSet, tailList.subList(i+1, tailList.size()), subsetSize-1, groupSize);
			}
		}
		
	}
}
