
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    boolean root;
    boolean traversed;

    TreeNode(int val, boolean root) {
        this.val = val;
        this.root = root;
        this.traversed = false;
    }

    private void setLeft(TreeNode left) {
        this.left = left;
    }

    private void setRight(TreeNode right) {
        this.right = right;
    }
}
