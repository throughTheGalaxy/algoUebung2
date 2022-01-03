package sort;

import java.util.List;

public class SelectionSort<T> extends Swap<T> implements Sortable<T> {

	@Override
	public void sort(List<T> list, Comparator<T> comp) {
		int minimum = 0;
		for (int i = 0; i < list.size(); i++) {
			minimum = i;
			for (int e = i + 1; e < list.size(); e++) {
				if (comp.compare(list.get(e), list.get(minimum)) < 0) { // Sortiere aufsteigend/absteigend
					minimum = e;
				}
			}
			swap(list, i, minimum);
		}
	}

}
