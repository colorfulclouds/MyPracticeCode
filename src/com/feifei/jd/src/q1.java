import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr= new int[n];
        for(int i =0;i<n;i++){
            arr[i]=s.nextInt();
        }
       // int[] arr ={2,1,3,2};
        System.out.println(maxChunksToSorted(arr));
        // write your code here

    }

    public static int maxChunksToSorted(int[] arr) {
        int[] a = Arrays.copyOf(arr,arr.length);
        int[] a_cnt=new int[arr.length];
        Arrays.fill(a_cnt,1);
        Arrays.sort(a);
        for (int i=1;i<a.length;i++)
        {
            if(a[i]==a[i-1])
            {
                a_cnt[i]=a_cnt[i-1]+1;
            }
        }

        int res=0,max=0,cnt=0;
        for (int i=0;i<arr.length;i++)
        {
            if(max==arr[i])cnt++;
            else if(max<arr[i])
            {
                cnt=1;
                max=arr[i];
            }
            if(max==a[i]&&cnt==a_cnt[i])
            {
                res++;
            }
        }
        return res;
    }



}