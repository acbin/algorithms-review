package basic.solution;

/**
 * 求一个数组从小到大排序后相邻两数之间的最大差值
 *
 * 要求
 * 时间复杂度O(N)，且不能使用非基于比较的排序
 *
 * 思路
 * 例子：数组9个数，最大值99，最小值0
 * 步骤：
 * 1）求出数组最大值，最小值
 * 2）利用10(比数组长度多1)个空桶，按比例切分：
 *      数组0-9 范围的数存放在0号桶
 *        10-19 范围的数存放在1号桶
 *        ...
 *        90-99 范围的数存放在9号桶
 * 3）在1号至8号桶之间必定至少存在一个空桶，利用此结论，可以排除相邻两个数出现在同一个桶中的情况
 * 4）遍历桶，以后一个桶的最小值减去前一个非空桶的最大值，可以得到一个最大的差值
 *
 * @author bingo
 */

public class MaxGap {

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 遍历数组，求出数组的最大值、最小值
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (max == min) {
            return 0;
        }

        // n个数，n+1个桶
        // hasNum数组判断桶是否有值
        boolean[] hasNum = new boolean[n + 1];

        // maxs数组存放每个桶的最大值
        int[] maxs = new int[n + 1];

        // mins数组存放每个桶的最小值
        int[] mins = new int[n + 1];

        // 遍历数组
        for (int i = 0; i < n; ++i) {
            // 求出当前数arr[i]所对应的桶号
            int bid = bucket(arr[i], n, max, min);

            // 如果arr[i]是bid号同的最大值/最小值，将arr[i]存入maxs[bid]/mins[bid]中
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        // 以上遍历结束后，一定存在至少一个空桶，由此，可以判定最大差值的相邻两个数一定不是在同一个桶中

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= n; ++i) {
            if (hasNum[i]) {
                res = Math.max(mins[i] - lastMax, res);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    /**
     *
     * @param num 数组中某个元素
     * @param n 数组元素个数
     * @param max 数组最大值
     * @param min 数组最小值
     * @return 元素对应的桶号
     */
    private static int bucket(int num, int n, int max, int min) {
        // (num - min) / ((max - min) / n)
        return (int) ((num - min) * n / (max - min));
    }
}
