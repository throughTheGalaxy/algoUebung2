package sort;

import java.util.List;

public class BubbleSort<T> extends Swap<T> implements Sortable<T> {

	@Override
	public void sort(List<T> list, Comparator<T> comp) {
		for (int i = 1; i < list.size(); i++) {
			for (int e = 0; e < list.size() - i; e++) {
				if (comp.compare(list.get(e), list.get(e + 1)) > 0) { // Sortiert Aufsteigend > Absteigend <
					swap(list, e, e + 1);
				}
			}
		}
	}
}
