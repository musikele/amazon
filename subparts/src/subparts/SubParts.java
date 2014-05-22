package subparts;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Given a set S = {A0, A1, A2, …, aN} with N unique symbols. Enumerate all unique subsets of size M, M <= N.
For example, S = ('a', 'b', 'c'}, N = 3, M = 2, the unique subsets are {'a', 'b'}, {'a', 'c'}, and {'b', 'c'}.
Please write a recursive solution as well as an iterative solution and discuss the performance.
*/
public class SubParts {

	public static void main(String[] args) {

		SubPartEnumerator<Integer> subPartCreator = new IterativeSubPartEnumerator<>();

		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);

		//TO REMOVE !!! 
		List<List<Integer>> iterativeSubParts = subPartCreator
				.getSubsets(set, 5);

		
		for (List<Integer> subSet : iterativeSubParts) {
			printCollection(subSet);
		}

	}

	

	static void printCollection(Collection<?> c) {
		
		String toReturn = "{";
		
		for (Object e : c) {
			
			toReturn = toReturn + e + ",";
		}
		//remove last comma
		toReturn = toReturn.substring(0, toReturn.length() - 1);
		toReturn = toReturn + "}";
		System.out.println(toReturn);
	}

}
