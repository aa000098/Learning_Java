package section4_2;

public class MyUtilities {
	/*
	public static void bubbleSort(MyComparable[] data, int size) {
		for (int i=0; i<size-1; i++) {
			for (int j = i; j<size; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					MyComparable tmp = data[j];
					data[j] = data[i];
					data[i] = tmp;
				}
			}
		}
	}
	*/
	public static void bubbleSort(Comparable[] data, int size) {
		for (int i=0; i<size-1; i++) {
			for (int j = i; j<size; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					Comparable tmp = data[j];
					data[j] = data[i];
					data[i] = tmp;
				}
			}
		}
	}
}
