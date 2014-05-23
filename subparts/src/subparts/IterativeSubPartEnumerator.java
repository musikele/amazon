package subparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IterativeSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@Override
	public List<List<E>> getSubsets(Set<E> set, int sizeOfSubset) {
		//this will be the output
		List<List<E>> subParts = new ArrayList<>();
		//will work with arrays to better manage low level memory 
		Object[] arraySet = set.toArray(); 
		//check on input size
		if (sizeOfSubset > set.size() || sizeOfSubset <= 0 ) 
			return null; 
		
		//this array holds the indexes of the current subset
		int[] cursor = new int[sizeOfSubset];
		
		//this array holds the current iteration and will be updated 
		//when cursor[sizeOfSubset-1] reaches the end of the subset.
		//if size = 2, it will contain [1,2], than [2,3], etc. 
		int[] whereWeAre = new int[sizeOfSubset];
		
		//initialization of the two arrays 
		for (int i=0; i<sizeOfSubset ; i++) {
			cursor[i] = i; 
			whereWeAre[i] = i;
		}
		
		//flag for the main loop
		boolean stayAlive = true; 
		
		while (stayAlive) {
			
			// check to see if we are at the end 
			if (cursor[0] == set.size()-sizeOfSubset ) {
				stayAlive = false; 
			}
			
			//this variable is the subPart that will be calculated in this iteration
			List<E> subPart = new ArrayList<>(); 

			
			for (int i=0; i<sizeOfSubset ; i++) {
				subPart.add((E) arraySet[cursor[i]]);
				
			}
			
			for (int j = sizeOfSubset-1 ; j>=0 ; j-- ) {
				if (cursor[j] != set.size()-1) {
					cursor[j]++;
					break; 
				} else {
					updateCursorAndWhereWeAre(cursor, whereWeAre); 
					break;
				}
			}
			
			
			subParts.add(subPart);
		}
		
		return subParts;
	}

	private void updateCursorAndWhereWeAre(int[] cursor, int[] whereWeAre) {
		for (int i=0; i<whereWeAre.length ; i++) {
			whereWeAre[i]++;
			cursor[i]=whereWeAre[i];
		}
		
	}

}
