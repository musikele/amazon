package subparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IterativeSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@SuppressWarnings("unchecked")
	@Override
	public List<List<E>> getSubsets(Set<E> set, int sizeOfSubset) {
		// this will be the output
		List<List<E>> subParts = new ArrayList<>();
		// will work with arrays to better manage low level memory
		Object[] arraySet = set.toArray();
		// check on input size
		if (sizeOfSubset > set.size() || sizeOfSubset <= 0)
			return null;

		// this array holds the indexes of the current subset
		int[] cursor = new int[sizeOfSubset];

		// initialization of the two arrays
		for (int i = 0; i < sizeOfSubset; i++) {
			cursor[i] = i;
		}

		// flag for the main loop
		boolean stayAlive = true;

		while (stayAlive) {

			// check to see if we are at the end
			if (cursor[0] == set.size() - sizeOfSubset) {
				stayAlive = false;
			}

			// this variable is the subPart that will be calculated in this
			// iteration
			List<E> subset = new ArrayList<>();

			//let's add to the subset the elements defined by the cursor
			for (int i = 0; i < sizeOfSubset; i++) {
				subset.add((E) arraySet[cursor[i]]);
			}

			//check this method to understand how cursors are built
			updateCursor(cursor, set.size());

			subParts.add(subset);
		}

		return subParts;
	}
	
	
	/**
	 * If the set size is 5, and we have a subsetSize of 3 (defined here by cursor.length), this 
	 * private method will build the cursor by enumerating all the positions of the items in the set 
	 * to choose. Example (positions will start from 0): [0,1,2] [0,1,3], [0,1,4] [0,2,3] [0,2,4] etc.   
	 * @param cursor is the array of the various cursors needed to choose the items of the subset. 
	 * @param setSize the size of the set. 
	 */
	private void updateCursor(int[] cursor, int setSize ) {
		
		if (cursor[cursor.length-1] != setSize-1 ) {
				cursor[cursor.length-1]++;
		} else {
			for (int j=cursor.length-1 ; j>0 ; j--) {
				if (j-1 >= 0 && cursor[j] - cursor[j-1] != 1) {
					cursor[j-1] = cursor[j-1]+1; 
					for (int i = j ; i< cursor.length; i++) {
						cursor[i] = cursor[i-1]+1;
					}
					break; 
				}
			}
		}
		
	}

}
