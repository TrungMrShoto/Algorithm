package algorithm.tree;

import algorithm.ErrorMessage;
import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 */
public class AVLTree implements BinaryTree{
    private static final int LEFT_HIGHER = -1;
    private static final int EQUAL_HEIGHT = 0;
    private static final int RIGHT_HIGHER = 1;

    private TreeNode root = null;

    @Override
    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * Insert a value into AVL Tree
     */
    @Override
    public int insertValue(int value){
        if(this.contains(value))
            return ErrorMessage.DUPLICATE_ERROR;
        Boolean taller = true;
        this.root = recursiveInsert(this.root,value,taller);
        return ErrorMessage.SUCCESS;
    }

    private TreeNode recursiveInsert(TreeNode subroot, int value, Boolean taller) {
       if(subroot == null)
       {
           return (new TreeNode(value, EQUAL_HEIGHT));
       }
       else if (value < subroot.key)
       {
           subroot.left = recursiveInsert(subroot.left,value,taller);

           //left subtree is taller
           if(taller)
           {
               if(subroot.balance == LEFT_HIGHER)
               {

                   taller=false;
                   return leftBalance(subroot);
               }
               else if (subroot.balance == EQUAL_HEIGHT)
               {
                   subroot.balance=LEFT_HIGHER;
               }
               else
               {
                   subroot.balance = EQUAL_HEIGHT;
                   taller=false;
               }
           }

       }
       else
       {
           subroot.right = recursiveInsert(subroot.right,value,taller);

           //right subtree is taller
           if(taller)
           {
               if(subroot.balance == RIGHT_HIGHER)
               {
                   taller=false;
                   return rightBalance(subroot);
               }
               else if (subroot.balance == EQUAL_HEIGHT)
               {
                   subroot.balance=RIGHT_HIGHER;
               }
               else
               {
                   subroot.balance = EQUAL_HEIGHT;
                   taller=false;
               }
           }

       }
       return subroot;
    }

    private @NotNull TreeNode rightBalance(@NotNull TreeNode subroot) {
        TreeNode rightTree = subroot.right;

        /*
          Case 1 : Right of right => Single left rotation
          		  z                                   y
          		/  \                                /   \
          	   T1   y        rotateLeft(z)         z     x
          	      /  \		- - - - - - - ->      / \    / \
          	     T2   x							T1  T2 T3  T4
                    / \
                   T3  T4
         */
        if(RIGHT_HIGHER == rightTree.balance)
        {
            subroot.balance=EQUAL_HEIGHT;
            rightTree.balance=EQUAL_HEIGHT;
        }
        /*
          Case 2: Right of left => Double right left Rotation
          		/*
          		 z                          z                            x
          		/ \                        / \                          /  \
          	  T1   y   rotateRight(y)    T1   x      rotateLeft(z)   z      y
          	     / \   - - - - - - ->       /  \      - - - - ->    / \    / \
               x   T4                     T2   y				  T1  T2  T3  T4
              / \                            /  \
            T2  T3                          T3   T4
         */
        else
        {
            TreeNode leftTree = rightTree.left;
            if(leftTree.balance==EQUAL_HEIGHT)
            {
                subroot.balance = EQUAL_HEIGHT;
                rightTree.balance=EQUAL_HEIGHT;
            }
            else if (leftTree.balance==LEFT_HIGHER)
            {
                subroot.balance = EQUAL_HEIGHT;
                rightTree.balance = RIGHT_HIGHER;
            }
            else
            {
                subroot.balance = LEFT_HIGHER;
                rightTree.balance = EQUAL_HEIGHT;
            }

            leftTree.balance = EQUAL_HEIGHT;
            subroot.right = rotateRight(rightTree);
        }
        return rotateLeft(subroot);
    }

    private @NotNull TreeNode leftBalance(@NotNull TreeNode subroot) {
        TreeNode leftTree = subroot.left;

        /*
          Case 1 : Left of left => Single right rotation
          		     z                                      y
          			/ \									  /  \
          		   y   T4		rotateRight(z)          x     z
          		  / \			------------>		   / \   / \
          		 x   T3                               T1  T2 T3 T4
          		/ \
          	  T1   T2
         */
        if(leftTree.balance == LEFT_HIGHER)
        {
            subroot.balance=EQUAL_HEIGHT;
            leftTree.balance=EQUAL_HEIGHT;
        }
        /*
          Case 2: Left of right => Double right left Rotation
                   z                               z                             x
          	       / \                            /   \                         /  \
          	     y   T4        rotateLeft(y)     x    T4    rotateRight(z)    y      z
          	   / \	        - - - - - - - - ->  /  \       - - - - - - - ->  / \    / \
          	 T1   x                            y    T3                      T1  T2 T3  T4
          	     / \	                      / \
          	   T2   T3				       T1   T2
         */
        else
        {
            TreeNode rightTree = leftTree.left;
            if(rightTree.balance==EQUAL_HEIGHT)
            {
                subroot.balance = EQUAL_HEIGHT;
                leftTree.balance=EQUAL_HEIGHT;
            }
            else if (rightTree.balance==LEFT_HIGHER)
            {
                subroot.balance = RIGHT_HIGHER;
                leftTree.balance = EQUAL_HEIGHT;
            }
            else
            {
                subroot.balance = EQUAL_HEIGHT;
                leftTree.balance = LEFT_HIGHER;
            }

            rightTree.balance = EQUAL_HEIGHT;
            subroot.left= rotateLeft(leftTree);
        }
        return rotateRight(subroot);
    }

    private @NotNull TreeNode rotateRight(@NotNull TreeNode subroot) {
        TreeNode nodeTemp = subroot.left;
        subroot.left = nodeTemp.right;
        nodeTemp.right = subroot;
        return nodeTemp;
    }

    private @NotNull TreeNode rotateLeft(@NotNull TreeNode subroot) {
        TreeNode nodeTemp = subroot.right;
        subroot.right = nodeTemp.left;
        nodeTemp.left = subroot;
        return nodeTemp;
    }

    @Override
    public int removeValue(int value){
        if (!this.contains(value))
            return ErrorMessage.NOT_FOUND_VALUE;
        Boolean shorter = true;
        this.root = recursiveRemove(this.root,value,shorter);
        return ErrorMessage.SUCCESS;
    }

    private TreeNode recursiveRemove(TreeNode subroot, int value, Boolean shorter){
        if (subroot==null)
        {
            shorter=false;
        }
        // If the key to be deleted is smaller than the root's key, then it lies in left subtree
        else if (value < subroot.key) {
            subroot.left = recursiveRemove(subroot.left, value, shorter);
            if (shorter)
                subroot = deleteRightBalance(subroot, shorter);
        }
        // If the key to be deleted is greater than the root's key, then it lies in right subtree
        else if (value > subroot.key){
            subroot.right = recursiveRemove(subroot.right,value,shorter);
            if (shorter)
                subroot = deleteLeftBalance(subroot, shorter);
        }
        // if key is same as root's key, then this is the node to be deleted
        else
        {
            //node with only one child
           if (subroot.right==null)
           {
               subroot = subroot.left;
               shorter = true;
           }
           else if (subroot.left == null)
           {
               subroot = subroot.right;
               shorter = true;
           }
           else{
               //node with 2 children: get largest key in the left subtree
               TreeNode nodeTemp = maxValueNode(subroot.left);

               //copy it's data to this node
               subroot.key = nodeTemp.key;

               //delete the successor's key
               subroot.left = recursiveRemove(subroot.left,nodeTemp.key,shorter);
               if (shorter)
                   subroot = deleteRightBalance(subroot,shorter);
           }
        }
        return subroot;
    }

    private @NotNull TreeNode deleteLeftBalance(@NotNull TreeNode subroot, Boolean shorter) {
        if (subroot.balance == RIGHT_HIGHER)
            subroot.balance = EQUAL_HEIGHT;
        else if (subroot.balance == EQUAL_HEIGHT)
        {
            subroot.balance = LEFT_HIGHER;
            shorter = false;
        }
        else {
            TreeNode leftTree = subroot.left;
            if (leftTree.balance == RIGHT_HIGHER)
            {
                TreeNode rightTree = leftTree.right;
                if (rightTree.balance == RIGHT_HIGHER) {
                    subroot.balance = EQUAL_HEIGHT;
                    leftTree.balance = LEFT_HIGHER;
                }
                else if (rightTree.balance == EQUAL_HEIGHT) {
                    subroot.balance = EQUAL_HEIGHT;
                    leftTree.balance = EQUAL_HEIGHT;
                }
                else
                {
                    subroot.balance = RIGHT_HIGHER;
                    leftTree.balance = EQUAL_HEIGHT;
                }
                rightTree.balance = EQUAL_HEIGHT;
                subroot.left = rotateLeft(leftTree);
            }
            else {
                if (leftTree.balance != EQUAL_HEIGHT)
                {
                    subroot.balance = EQUAL_HEIGHT;
                    leftTree.balance = EQUAL_HEIGHT;
                }
                else
                {
                    subroot.balance = LEFT_HIGHER;
                    leftTree.balance = RIGHT_HIGHER;
                    shorter = false;
                }
            }
            return rotateRight(subroot);
        }
        return subroot;
    }

    private @NotNull TreeNode deleteRightBalance(@NotNull TreeNode subroot, Boolean shorter) {
        if (subroot.balance == LEFT_HIGHER)
            subroot.balance = EQUAL_HEIGHT;
        else if (subroot.balance == EQUAL_HEIGHT)
        {
            subroot.balance = RIGHT_HIGHER;
            shorter = false;
        }
        else {
            TreeNode rightTree = subroot.right;
            if (rightTree.balance == LEFT_HIGHER)
            {
                TreeNode leftTree = rightTree.left;
                if (leftTree.balance == LEFT_HIGHER) {

                    subroot.balance = EQUAL_HEIGHT;
                    rightTree.balance = RIGHT_HIGHER;
                }
                else if (leftTree.balance == EQUAL_HEIGHT) {
                    subroot.balance = EQUAL_HEIGHT;
                    rightTree.balance = EQUAL_HEIGHT;
                }
                else
                {
                    subroot.balance = LEFT_HIGHER;
                    rightTree.balance = EQUAL_HEIGHT;
                }
                leftTree.balance = EQUAL_HEIGHT;
                subroot.right = rotateRight(rightTree);
            }
            else {
                if (rightTree.balance != EQUAL_HEIGHT)
                {
                    subroot.balance = EQUAL_HEIGHT;
                    rightTree.balance = EQUAL_HEIGHT;
                }
                else
                {
                    subroot.balance = RIGHT_HIGHER;
                    rightTree.balance = LEFT_HIGHER;
                    shorter = false;
                }
            }
            return rotateLeft(subroot);
        }
        return subroot;
    }

    private TreeNode maxValueNode(TreeNode node) {
        TreeNode currentNode = node;
        while(currentNode.right != null)
            currentNode=currentNode.right;
        return currentNode;
    }

    @Override
    public boolean contains(int value){
        return search(this.root,value);
    }

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
