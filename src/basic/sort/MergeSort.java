package basic.sort;

/**
 * 归并排序
 *
 * @author bingo
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 主排序过程
     * @param arr
     * @param l
     * @param r
     */
    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 两个排好序的数组(arr[l, mid], arr[mid+1, r])进行merge
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        // 创建额外空间
        int[] space = new int[r - l + 1];

        // i指向space
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
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

    }

}
