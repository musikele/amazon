package subparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IterativeSubPartEnumeratorOnly1Size<E> implements SubPartEnumerator<E> {

	@Override
	public List<List<E>> getSubsets(Set<E> set, int subsetSize) {

		//error catching
		if (subsetSize > set.size()) 
			return null; 
		
		List<List<E>> allSubParts = new ArrayList<List<E>>();

		for (E elem : set) {

			allSubParts.add(createSubPartFromElement(elem));

			for (int i=0; i<allSubParts.size(); i++) {
				
				List<E> subSet = allSubParts.get(i);
				
				if (subSet.size() == 1 && subSet.get(0) == elem)
					break;

				allSubParts.add(createSubPartFromSet(elem, subSet));
			}
		}
		return allSubParts;
	}

	private List<E> createSubPartFromSet(E elem, List<E> subSet) {

		List<E> subPart = new ArrayList<>();

		if (subSet != null) {
			
			for (E elemSubSet : subSet) {
				
				subPart.add(elemSubSet);
			}
		}

		if (elem != null) {
			
			subPart.add(elem);
		}

		return subPart;
	}

	private List<E> createSubPartFromElement(E elem) {

		List<E> subPart = new ArrayList<>();

		if (elem != null) {
			
			subPart.add(elem);
		}

		return subPart;

	}



}
