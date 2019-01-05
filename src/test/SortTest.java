package test;

import basic.sort.HeapSort;

import java.util.Arrays;

/**
 * 测试排序算法正确性
 *
 * @author bingo
 */
public class SortTest {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; ++i) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            // 自己写的排序算法
            // BubbleSort.bubbleSort(arr1);
            // SelectionSort.selectionSort(arr1);
            // InsertionSort.insertionSort(arr1);
            // MergeSort.mergeSort(arr1);
            // QuickSort.quickSort(arr1);
            HeapSort.heapSort(arr1);

            // Java自带排序算法，绝对正确
            Arrays.sort(arr2);

            // 比对排序结果
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


    /**
     * 随机生成指定大小、范围的数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


    /**
     * 数组拷贝
     * @param arr
     * @return
     */
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 数组比对
     * @param arr1
     * @param arr2
     * @return
     */
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }

        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        int len = arr1.length;
        for (int i = 0; i < len; ++i) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}