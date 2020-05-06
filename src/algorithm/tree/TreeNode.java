package algorithm.tree;

/**
 * @author : Nguyen Trong TRUNG
 */
public class TreeNode {
    int balance;
    int key;
    TreeNode left,right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.balance = 0;
    }

    public TreeNode(int key, int balance) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.balance = balance;
    }
}
