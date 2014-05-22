package subparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IterativeSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@Override
	public List<List<E>> getSubsets(Set<E> set, int subsetSize) {
		
		List<List<E>> subParts = new ArrayList<>();
		
		Object[] arraySet = set.toArray(); 
		
		if (subsetSize > set.size() || subsetSize <= 0 ) 
			return null; 
		
		int[] cursor = new int[subsetSize];
		int[] whereWeAre = new int[subsetSize];
		
		for (int i=0; i<subsetSize ; i++) {
			cursor[i] = i; 
			whereWeAre[i] = i;
		}
		
		boolean stayAlive = true; 
		
		while (stayAlive) {
			
			if (cursor[0] == set.size()-subsetSize ) {
				stayAlive = false; 
			}
			
//			if (cursor[cursor.length-1] == set.size()) {
//					updateCursorAndWhereWeAre(cursor, whereWeAre); 
//			}
			
			List<E> subPart = new ArrayList<>(); 
			
			for (int i=0; i<subsetSize ; i++) {
				
				subPart.add((E) arraySet[cursor[i]]);
				
			}
			
			for (int j = subsetSize-1 ; j>=0 ; j-- ) {
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
