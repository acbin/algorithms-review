package basic.solution;

/**
 * 荷兰国旗问题
 * 对于arr[l, r]，小于num的数放左边，大于num的数放右边
 *
 * 思路
 * 初始化：less指向l前一个位置，more指向r后一个位置
 * 遍历arr：
 * 1）arr[l] < num：arr[l]与less下一个位置的值交换，向右扩大less区域，l++
 * 2）arr[l] > num：arr[l]与more前一个位置的值交换，向左扩大more区域，此时l不变，需要对交换过来的数进行再次比较
 * 3）arr[l] == num：l++
 *
 * @author bingo
 */
public class NetherlandsFlag {

    public static int[] partition(int[] arr, int l, int r, int num) {
        if (arr == null || l > r) {
            return null;
        }

        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < num) {
                swap(arr, ++less, l++);
            } else if (arr[l] > num) {
                swap(arr, --more, l);
            } else {
                ++l;
            }
        }

        // 返回等于num的数组区域
        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
