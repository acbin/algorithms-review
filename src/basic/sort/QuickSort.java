package basic.sort;

/**
 * 利用荷兰国旗问题改进快速排序
 *
 * 时间复杂度: O(N * log N)
 * 空间复杂度: O(log N), 划分 log N 次，每次都需要记录划分点
 *
 * @author bingo
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;

        // 数组基本有序时，快速排序时间复杂度达O(N²)
        // 可利用随机快排，随机一个索引与数组最后一个数arr[r]交换，再拿它对数组划分
        swap(arr, r, l + (int)(Math.random() * (r - l + 1)));

        while (l < more) {
            // 拿最后一个数arr[r]对数组进行划分
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                ++l;
            }
        }
        swap(arr, more, r);
        return new int[] {less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
