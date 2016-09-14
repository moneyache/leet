package study.leet.fun;

/**
 * @author teng.qian
 * @date 2016/2/19.
 */
public class FindIndex {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int end = nums.length - 1;
        int start = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
    
    public int find(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int max = array.length - 1;
        int min = 0;
        return recurse(array, num, max, min);
    }

    private int recurse(int[] array, int num, int max, int min) {

        if ((max < min)) {
            return -1;
        }
        int mid = (max - min) / 2 + min;
        if (array[mid] == num) {
            return mid;
        } else if (array[mid] > num) {
            if (array[min] == num) {
                return min;
            } else if (array[min] > num) {
                return recurse(array, num, max, mid + 1);
            } else {
                return recurse(array, num, mid - 1, min + 1);
            }
        } else {
            return recurse(array, num, max, mid + 1);
        }
    }

    public static void main(String[] args) {
        FindIndex findIndex = new FindIndex();
        int[] array = {9, 10, 15, 17, 20, 1, 3, 5, 7};
        System.out.println(findIndex.find(array, 1));
        System.out.println(findIndex.findMin(array));
    }
}
