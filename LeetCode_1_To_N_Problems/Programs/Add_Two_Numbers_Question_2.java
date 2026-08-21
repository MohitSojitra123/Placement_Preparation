public class Add_Two_Numbers_Question_2 {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Create Linked List
    static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    // Add Two Numbers
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        int carry = 0;

        while (ptr1 != null || ptr2 != null) {

            int val1 = ptr1 != null ? ptr1.val : 0;
            int val2 = ptr2 != null ? ptr2.val : 0;

            int sum = val1 + val2 + carry;

            int d = sum % 10;

            carry = sum / 10;

            ListNode temp = new ListNode(d);

            dummy.next = temp;
            dummy = dummy.next;

            ptr1 = ptr1 != null ? ptr1.next : null;
            ptr2 = ptr2 != null ? ptr2.next : null;
        }

        if (carry > 0) {
            ListNode temp = new ListNode(carry);

            dummy.next = temp;
            dummy = dummy.next;
        }

        return ans.next;
    }

    // Print Linked List
    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Input Lists
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};

        // Create Linked Lists
        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        // Add Two Numbers
        ListNode result = addTwoNumbers(l1, l2);

        // Print Result
        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        System.out.print("Result: ");
        printList(result);
    }
}