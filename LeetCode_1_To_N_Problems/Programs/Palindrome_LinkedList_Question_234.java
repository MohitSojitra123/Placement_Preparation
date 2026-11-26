import java.util.ArrayList;

public class Palindrome_LinkedList_Question_234{

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        System.out.println("Is Palindrome: " + result);
    }
}