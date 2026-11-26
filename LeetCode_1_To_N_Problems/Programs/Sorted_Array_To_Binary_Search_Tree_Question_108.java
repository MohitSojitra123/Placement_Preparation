public class Sorted_Array_To_Binary_Search_Tree_Question_108 {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Convert Sorted Array to Balanced BST
    public static TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    // Recursive Helper Function
    public static TreeNode helper(int[] nums, int start, int end) {

        // Base Condition
        if (start > end) {
            return null;
        }

        // Find Middle Element
        int mid = start + (end - start) / 2;

        // Create Root Node
        TreeNode root = new TreeNode(nums[mid]);

        // Create Left Subtree
        root.left = helper(nums, start, mid - 1);

        // Create Right Subtree
        root.right = helper(nums, mid + 1, end);

        return root;
    }

    // Inorder Traversal
    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    // Main Method
    public static void main(String[] args) {

        // Static Input Array
        int[] nums = {-10, -3, 0, 5, 9};

        // Convert Sorted Array to BST
        TreeNode root = sortedArrayToBST(nums);

        // Print Inorder Traversal
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}