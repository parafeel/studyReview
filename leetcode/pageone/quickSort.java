package parafeel.pageone;

public class quickSort {
	// 快速排序
	public void quicksort(int[] num, int left, int right) {
		if (left < right) {
			int l = left, r = right, pivot = num[left];
			while (l < r) {
				while (l < r && num[r] >= pivot) {
					r--;
				}
				if (l < r) {
					changNum(num, l, r);
				}
				while (l < r && num[l] < pivot) {
					l++;
				}
				if (l < r) {
					changNum(num, l, r);
				}
			}
			quicksort(num, left, l - 1);
			quicksort(num, l + 1, right);
		}

	}

	public void changNum(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
