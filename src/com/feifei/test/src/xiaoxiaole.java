import java.util.ArrayList;
import java.util.Scanner;

 class ListNode {
      int val;
      ListNode next;
      /*
      ListNode(int x){
          val = x;
         next = null;
      }*/
 }
public class xiaoxiaole {
    public ListNode insertionSortList(ListNode head){
        if(head==null||head.next==null)
          return head;
        ListNode tmp1=head;
        ListNode tmp2=head.next;
        while(tmp1.next!=null){
              while(tmp2!=null){
                  if(tmp2.val<tmp1.val){
                      int tmp=tmp2.val;
                      tmp2.val=tmp1.val;
                      tmp1.val=tmp;
                  }
                  tmp2=tmp2.next;
              }
              tmp1=tmp1.next;
              tmp2=tmp1.next;
        }
        return head;
    }
    public void printList(ListNode head){
         while(head!=null){
             System.out.print(head.val+" ");
             head=head.next;
         }
         System.out.println();
    }
    public static void main(String[]args){
    	Scanner sc = new Scanner(System.in);
    	
    	
        ArrayList<Integer> array = new ArrayList<>();
        String s = sc.nextLine();
        
        String[] s1 = s.split(" ");//此处修改分隔符类型
        for (int i = 0; i < s1.length; i++) {
            array.add(Integer.valueOf(s1[i]));
        }
        
    	ListNode [] head = new ListNode[array.size()];
    	
    	for(int i=0;i<array.size();i++)
    	{
    		head[i] = new ListNode();
    		head[i].val = array.get(i);
    	}
    	
    	
    	
    	for(int i=1;i<array.size();i++)
    		head[i-1].next = head[i];
    	
        xiaoxiaole ss=new xiaoxiaole();
        ss.printList(ss.insertionSortList(head[0]));
    }
}