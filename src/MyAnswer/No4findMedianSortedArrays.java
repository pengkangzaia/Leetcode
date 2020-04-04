package MyAnswer;

public class No4findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        double mid = getMid(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
        System.out.println("两数组的中位数为： "+mid);
        return mid;
    }

    public static double getMid(int[] x,int startx,int endx, int[] y, int starty, int endy){
        int midindexx = (startx+endx)/2;
        int midindexy = (starty+endy)/2;
        int midx = x[midindexx];
        int midy = y[midindexy];
        if(midx < midy){
            double mid = getMid(x, midindexx, endx, y, starty, midindexy);
        }
        if(midx > midy){
            double mid = getMid(x, startx, midindexx, y, midindexy, endy);
        }
        return midx;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};
        findMedianSortedArrays(a,b);
    }
}
