package subparts;

import java.util.List;
import java.util.Set;

public interface SubPartEnumerator<E> {

	/**
	 * Will enumerate all subsets of the set in input of size subsetSize. 
	 * @param set a set of unique elements
	 * @param subsetSize the size of the subsets to search 
	 * @return a list of subsets
	 */
	public List<List<E>> getSubsets(Set<E> set, int subsetSize); 
	
}
