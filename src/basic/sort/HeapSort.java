package basic.sort;

/**
 * 堆(完全二叉树、数组)
 *
 * 若当前结点下标i：
 * 左孩子下标(2i+1)，右孩子下标(2i+2)
 * 父结点下标(i-1)/2
 *
 * 步骤：
 * 1）建立大根堆
 * 2) 将堆顶与最后一个数交换，剪堆，调整，loop...
 *
 * @author bingo
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 建立大根堆
        // 复杂度：log1 + log2 + ... + log(N-1) => N
        for (int i = 0; i < arr.length; ++i) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }


    }

    /**
     * 新加入一个结点arr[i]，向上依次比对
     * @param arr
     * @param i
     */
    private static void heapInsert(int[] arr, int i) {

        // 当前位置i上的数与父结点上的数比较
        while (arr[i] > arr[(i - 1) / 2]) {
            // 交换
            swap(arr, i, (i - 1) / 2);
            // 把父结点位置赋给当前位置
            i = (i - 1) / 2;
        }
    }

    /**
     * 调整大根堆
     * @param arr
     * @param index
     * @param heapSize
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // left < heapSize保证不越界

            // 右孩子存在(不越界)并且比左孩子大
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;

            // 最大的下标
            largest = arr[largest] > arr[index] ? largest : index;

            // largest是index本身，已是最大的值，不用往下沉
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
