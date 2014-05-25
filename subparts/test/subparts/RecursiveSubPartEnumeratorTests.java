package subparts;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class RecursiveSubPartEnumeratorTests {

	@Test
	public void testSize1() {

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 1);
		printCollection(subsets);

		Assert.assertNotNull(subsets);
		Assert.assertTrue(subsets.size() == 5);

	}

	@Test
	public void testSize0() {

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 0);
		printCollection(subsets);

		Assert.assertNull(subsets);

	}

	@Test
	public void testSize2() {

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 2);
		printCollection(subsets);

		Assert.assertNotNull(subsets);

		Assert.assertTrue(subsets.size() == 10);
	}
	
	@Test
	public void testSize3() {
		//{[1, 2, 5]X,[1, 2, 4]X,[1, 2, 3]X,[1, 3, 5],[1, 3, 4],[1, 4, 5],[2, 3, 5]X,[2, 3, 4]X,[2, 4, 5],[3, 4, 5]X}

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 3);
		printCollection(subsets);

		Assert.assertNotNull(subsets);

		Assert.assertTrue(subsets.size() == 10);
	}
	
	@Test
	public void testSize4() {

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 4);
		printCollection(subsets);

		Assert.assertNotNull(subsets);

		Assert.assertTrue(subsets.size() == 5);
	}
	
	
	@Test
	public void testSize5() {

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 5);
		printCollection(subsets);

		Assert.assertNotNull(subsets);

		Assert.assertTrue(subsets.size() == 1);
	}
	
	@Test
	public void testSize6() {

		// input
		Set<Integer> set = createSet();

		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 6);
		printCollection(subsets);

		Assert.assertNull(subsets);

	}
	
	@Test
	public void test2of3() {
		Set<Integer> set = new HashSet<Integer>();
		Collections.addAll(set, 1,2,3); 
		
		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 2);
		printCollection(subsets);

		Assert.assertNotNull(subsets);
		Assert.assertTrue(subsets.size() == 3);
	}
	
	@Test
	public void testHighNumbers() {
		Set<Integer> set = new HashSet<Integer>();
		for (int i=1; i<=16; i++)
			set.add(i);
		
		SubPartEnumerator<Integer> subPartEnumerator = new RecursiveSubPartEnumerator<Integer>();
		List<List<Integer>> subsets = subPartEnumerator.getSubsets(set, 8);
		printCollection(subsets);

		Assert.assertNotNull(subsets);
		Assert.assertEquals(12870, subsets.size());
	}
	
	private Set<Integer> createSet() {
		Set<Integer> set = new HashSet<Integer>();
		for (int i=1; i<=5; i++)
			set.add(i);
		return set;
	}


	static void printCollection(Collection<?> c) {

		if (c == null)
			return;

		String toReturn = "{";

		for (Object e : c) {

			toReturn = toReturn + e + ",";
		}
		// remove last comma
		toReturn = toReturn.substring(0, toReturn.length() - 1);
		toReturn = toReturn + "}";
		System.out.println(toReturn);
	}

}
