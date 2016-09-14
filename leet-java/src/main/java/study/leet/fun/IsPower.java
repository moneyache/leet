package study.leet.fun;

/**
 * @author teng.qian
 * @date 2016/2/18.
 */
public class IsPower {
    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }
        int temp = n;
        while ((temp & 1) == 0) {
            temp = temp >> 1;
        }
        if ((temp >> 1) == 0) {
            return true;
        }
        return false;
    }

    public boolean isPowerOfThree(int n) {

        if (n == 0) {
            return false;
        }
        return Math.pow(3, (Math.log10(n) / Math.log10(3))) == n;
    }

    public static void main(String[] args) {
        IsPower isPower = new IsPower();
        System.out.println(isPower.isPowerOfThree(177148));
    }
}
