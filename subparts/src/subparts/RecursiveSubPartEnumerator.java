package subparts;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RecursiveSubPartEnumerator<E> implements SubPartEnumerator<E> {

	@Override
	public List<List<E>> getSubsets(Set<E> set, int subsetSize) {

		return recursiveStep(new LinkedList<E>(set), subsetSize);
	}

	public List<List<E>> recursiveStep(List<E> list, int subsetSize) {

		if (subsetSize == 0) {
			System.out.println("} \n");
			return new LinkedList<>();
		}

		if (list.isEmpty())
			return null;

		System.out.print(list.get(0) + " ");
		List<E> newListA = new LinkedList<>();
		List<E> newListB = new LinkedList<>();
		newListA.add(list.get(0));
		List<List<E>> returnedLeft = recursiveStep(list.subList(1, list.size()), subsetSize - 1);
		if (returnedLeft != null) {
			for (List<E> returnedLeftList : returnedLeft) {

				newListA.addAll(returnedLeftList);
			}
		}

		List<List<E>> returnedRight = recursiveStep(list.subList(1, list.size()), subsetSize);
		if (returnedRight != null) {
			for (List<E> returnedRightList : returnedRight) {

				newListB.addAll(returnedRightList);
			}
		}

		List<List<E>> listOfList = new LinkedList<>();
		listOfList.add(newListA);
		listOfList.add(newListB);

		return listOfList;

	}

}
