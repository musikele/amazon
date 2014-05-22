package subparts;

import java.util.List;
import java.util.Set;

public interface SubPartEnumerator<E> {

	public List<List<E>> getSubsets(Set<E> set, int subsetSize); 
	
}
