
class ListNode{
  int value;
  ListNode next;
  ListNode(int x) { value = x; }
}

class recursion {
  // public static recursion(){
  //   pass;
  // }
  public ListNode swapPairs(ListNode head) {
      if(head == null || head.next == null){
          return head;
      }
      ListNode next = head.next;
      head.next = swapPairs(next.next);
      next.next = head;
      return next;
  }


  public static void main(String[] args) {
    recursion t = new recursion();
    t.swapPairs(new ListNode(4));
  }}


