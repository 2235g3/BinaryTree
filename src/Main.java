import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        binaryTree();
    }

    public static void binaryTree() {
        int[] items = {1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22};
        TreeNode sourceNode = new TreeNode(9, true);

        TreeNode sortedTree = addItems(items, sourceNode);

        InOrder(sortedTree);
    }

    public static TreeNode addItems(int[] items, TreeNode source) {
        TreeNode current = source;
        for (int item: items) {
            current = recursAdd(current, item);
        }

        return current;
    }

    public static TreeNode recursAdd(TreeNode current, int item) {
        TreeNode next;
        TreeNode temp;

        if (current == null) {
            return new TreeNode(item, false);
        }
        else {
            if (current.val > item) {
                next = current.left;
                temp = recursAdd(next, item);
                current.left = temp;
            }
            else if (current.val < item) {
                next = current.right;
                temp = recursAdd(next, item);
                current.right = temp;
            }
            else {
                return current;
            }
        }
        return current;
    }

    public static void InOrder(TreeNode sortedTree) {
        if (sortedTree.left != null) {
            InOrder(sortedTree.left);
        }
        else {
            System.out.println(sortedTree.val);
            sortedTree.traversed = true;
        }

        if (sortedTree.root && sortedTree.left != null && sortedTree.left.traversed) {
            System.out.println(sortedTree.val);
        }

        if (sortedTree.right != null) {
            InOrder(sortedTree.right);
        }
    }
}