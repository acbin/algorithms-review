package basic.solution;

/**
 * 逆序对问题：
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，求逆序对个数
 *
 *
 * 思路：
 * 利用归并排序，升序排列；
 * merge过程中，左数跟右数比较，若左>右，则说明左数开始的每一个数都大于右数
 *
 * @author bingo
 */

public class ReversePair {

    public static int reversePair(int[] arr) {
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

        int cnt = 0;

        while (p1 <= mid && p2 <= r) {
            cnt += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            space[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
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

        return cnt;

    }

}
