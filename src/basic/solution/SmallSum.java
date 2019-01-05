package basic.solution;

/**
 * 小和问题：
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * eg.
 * [3, 2, 1, 5, 4, 6]
 * 3左边比3小的数，没有；
 * 2左边比2小的数，没有；
 * 1左边比1小的数，没有；
 * 5左边比5小的数，3、2、1
 * 4左边比4小的数，3、2、1
 * 6左边比6小的数，3、2、1、5、4
 * smallSum = 3+2+1+3+2+1+3+2+1+5+4 = 27
 *
 *
 * 思路：
 * 利用归并排序，排好序；
 * merge过程中，左数跟右数比较，若左<右，则说明左数小于右数开始的每一个数
 *
 *
 * @author bingo
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] space = new int[r - l + 1];

        // i指向space
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        int res = 0;

        while (p1 <= mid && p2 <= r) {
            // 累加小和
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            space[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            space[i++] = arr[p1++];
        }

        while (p2 <= r) {
            space[i++] = arr[p2++];
        }

        for (i = l; i <= r; ++i) {
            arr[i] = space[i - l];
        }

        return res;
    }

}
