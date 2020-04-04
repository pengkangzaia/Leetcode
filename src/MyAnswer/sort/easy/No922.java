package MyAnswer.sort.easy;

public class No922 {
    public static void main(String[] args) {
        int[] a = {4,2,5,7};
        int[] b = sortArrayByParityII(a);
        for (int i : b) {
            System.out.print(i+" ");
        }
    }

    private static int[] sortArrayByParityII(int[] a) {
        int[] b = new int[a.length];
        int m = 0;
        int n = 1;
        for(int i = 0;i < b.length;i++){
            if(a[i]%2==0) {
                b[m] = a[i];
                m += 2;
            }
            if(a[i]%2==1){
                b[n] = a[i];
                n += 2;
            }

        }
        return b;
    }


}
