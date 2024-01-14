public class Main {
    public static void main(String[] args) {
        binaryTree();
    }

    public static void binaryTree() {
        int[] items = {4,3,2,1,5,7,6,10,8,11,12,16,17,20,13,14,18,19,22,21,15};
        TreeNode sourceNode = new TreeNode(9, true);

        TreeNode sortedTree = addItems(items, sourceNode);
        TreeNode preSortedTree = sortedTree;
        TreeNode postSortedTree = sortedTree;

        InOrder(sortedTree);
        System.out.println();
        PreOrder(preSortedTree);
        System.out.println();
        PostOrder(postSortedTree);
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
            System.out.println(sortedTree.val);
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

    public static void PreOrder(TreeNode sortedTree) {
        if (sortedTree.left != null) {
            System.out.println(sortedTree.val);
            PreOrder(sortedTree.left);
        }
        else {
            System.out.println(sortedTree.val);
        }

        if (sortedTree.right != null) {
            PreOrder(sortedTree.right);
        }
    }

    public static void PostOrder(TreeNode sortedNode) {
        if (sortedNode.left != null) {
            PostOrder(sortedNode.left);
        }
        if (sortedNode.right != null) {
            PostOrder(sortedNode.right);
        }
        if (sortedNode.left == null && sortedNode.right == null) {
            System.out.println(sortedNode.val);
            sortedNode.traversed = true;
        }
        else if (sortedNode.right != null && sortedNode.right.traversed && sortedNode.left == null) {
            System.out.println(sortedNode.val);
            sortedNode.traversed = true;
        }
        else if (sortedNode.left != null && sortedNode.left.traversed && sortedNode.right == null) {
            System.out.println(sortedNode.val);
            sortedNode.traversed = true;
        }
        else if (sortedNode.left.traversed && sortedNode.right.traversed) {
            System.out.println(sortedNode.val);
            sortedNode.traversed = true;
        }
    }
}