package algorithm.tree;

import algorithm.ErrorMessage;
import org.jetbrains.annotations.NotNull;


/**
 * @author : Nguyen Trong TRUNG
 */
public class BinarySearchTree implements BinaryTree{

    private TreeNode root;

    @Override
    public TreeNode getRoot() {
        return this.root;
    }

    @Override
    public int insertValue(int value) {
        if (this.contains(value))
            return ErrorMessage.DUPLICATE_ERROR;
        this.root = recursiveInsert(this.root, value);
        return ErrorMessage.SUCCESS;
    }

    private @NotNull TreeNode recursiveInsert(TreeNode subroot, int value) {
        if (subroot==null)
        {
            return (new TreeNode(value));
        }
        else if (value<subroot.key){
            subroot.left = recursiveInsert(subroot.left,value);
        }
        else
            subroot.right = recursiveInsert(subroot.right,value);
        return subroot;
    }

    @Override
    public int removeValue(int value) {
        if (!this.contains(value))
            return ErrorMessage.NOT_FOUND_VALUE;
        this.root = recursiveRemove(this.root,value);
        return ErrorMessage.SUCCESS;
    }

    private TreeNode recursiveRemove(@NotNull TreeNode subroot, int value) {
        if(value<subroot.key)
        {
            subroot.left = recursiveRemove(subroot.left,value);
        }
        else if (value>subroot.key)
        {
            subroot.right = recursiveRemove(subroot.right,value);
        }
        else
            subroot = this.removeNode(subroot);
        return subroot;
    }

    private TreeNode removeNode(@NotNull TreeNode subroot) {
        if(subroot.left == null) //node has only right subtree
        {
            subroot=subroot.right;
        }
        else if(subroot.right == null) // node has only left subtree
            subroot = subroot.left;
        else{   // node has both subtrees
            TreeNode nodeParent = subroot;
            TreeNode nodeDelete = nodeParent.left;
            while(nodeDelete.right!=null)
            {
                nodeParent = nodeDelete;
                nodeDelete = nodeParent.right;
            }
            subroot.key = nodeDelete.key;
            if(nodeParent == subroot)
                nodeParent.left = nodeDelete.left;
            else
                nodeParent.right = nodeDelete.left;
        }
        return subroot;
    }


    @Override
    public boolean contains(int value){
        return search(this.root,value);
    }

    /**
     *Best case : O(1)
     * Average case : 2ln n in O(log2 n)
     * Worst case : O(n)
     */
    private boolean search(TreeNode subroot, int value) {
        if(subroot==null)
            return false;
        else if(subroot.key ==value)
            return true;
        else if(value < subroot.key)
            return search(subroot.left,value);
        else
            return search(subroot.right,value);
    }
}
