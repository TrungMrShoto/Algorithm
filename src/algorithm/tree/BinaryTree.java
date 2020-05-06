package algorithm.tree;


/**
 * @author : Nguyen Trong TRUNG
 */
public interface BinaryTree {
    TreeNode getRoot();
    int insertValue(int value);
    int removeValue(int value);
    boolean contains(int value);
    default void printAllValueRecursivePreOrder(TreeNode subroot){
        if(subroot!=null)
        {
            System.out.print(subroot.key+"\t");
            printAllValueRecursivePreOrder(subroot.left);
            printAllValueRecursivePreOrder(subroot.right);
        }
    }
    default void printAllValueRecursiveInOrder(TreeNode subroot){
        if(subroot!=null)
        {
            printAllValueRecursiveInOrder(subroot.left);
            System.out.print(subroot.key+"\t");
            printAllValueRecursiveInOrder(subroot.right);
        }
    }
    default void printAllValueRecursivePostOrder(TreeNode subroot){
        if(subroot!=null)
        {
            printAllValueRecursivePostOrder(subroot.left);
            printAllValueRecursivePostOrder(subroot.right);
            System.out.print(subroot.key+"\t");
        }
    }
}
