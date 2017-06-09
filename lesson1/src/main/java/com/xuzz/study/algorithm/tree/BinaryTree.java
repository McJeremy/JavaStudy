package com.xuzz.study.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by win10 on 2017/6/8.
 */
public class BinaryTree {

    public TreeNode root = null;
    public BinaryTree()
    {
        root = new TreeNode(1,"A");
    }
    public void createBinaryTree()
    {
        /**
         *               A
         *             B      C
         *         D      E      F
         *           X  M   N
         */
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        TreeNode newNodeF = new TreeNode(6,"F");
        root.leftChild=newNodeB;
        root.rightChild=newNodeC;
        root.leftChild.leftChild=newNodeD;
        root.leftChild.rightChild=newNodeE;
        root.rightChild.rightChild=newNodeF;
        root.leftChild.rightChild.leftChild = new TreeNode(7, "M");
        root.leftChild.rightChild.rightChild = new TreeNode(8,"N");

        root.leftChild.leftChild.rightChild= new TreeNode(9,"X");
    }

    public boolean isEmpty()
    {
        return root ==null;
    }

    public int height()
    {
        return height(root);
    }

    public int height(TreeNode node)
    {
        if(null==node)
        {
            return 0;
        }
        else
        {
            int i = height(node.leftChild);
            int j=height(node.rightChild);
            return (i>j)?i+1:j+1;
        }
    }

    private void visit(TreeNode node)
    {
        System.out.println("key:"+node.key+"--name:"+node.data);;
    }

    public void preOrder(TreeNode node)
    {
        if(null!=node) {
            visit(node);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder(TreeNode node)
    {
        if(null!=node) {

            inOrder(node.leftChild);
            visit(node);
            inOrder(node.rightChild);
        }
    }

    public void postOrder(TreeNode node)
    {
        if(null!=node) {

            postOrder(node.leftChild);
            postOrder(node.rightChild);
            visit(node);
        }
    }

    /**
     * 层次遍历
     * @param node
     */
    public void levelOrder(TreeNode node)
    {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty())
        {
            TreeNode t = queue.poll();
            if(null!=t)
            {
                visit(t);
            }
            if(null!=t.leftChild) {
                queue.offer(t.leftChild);
            }
            if(null!=t.rightChild) {
                queue.offer(t.rightChild);
            }
        }
    }

    /**
     * 锯齿层级遍历
     * @param root
     */
    public void zigzagLevelOrder(TreeNode root) {

        /**
         *               A
         *             B      C
         *         D      E      F
         *           X  M   N
         */

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<TreeNode> childQueue=new LinkedList<TreeNode>();  //存放子节点
        boolean ltr=false;  //0的时候表示从左往后，1的时候表示从右往左
        boolean copyChild=false;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            if(queue.size()==1)
            {   //本层最后一个元素，开始复制
                copyChild=true;
            }
            TreeNode t = queue.poll();
            if(null!=t)
            {
                System.out.println(t.data);
            }
            if(ltr)
            {
                if(null!=t.leftChild)
                {
                    childQueue.offer(t.leftChild);
                }
                if(null!=t.rightChild)
                {
                    childQueue.offer(t.rightChild);
                }
            }
            if(!ltr)
            {
                if(null!=t.rightChild)
                {
                    childQueue.add(t.rightChild);
                }
                if(null!=t.leftChild)
                {
                    childQueue.add(t.leftChild);
                }
            }
            if(copyChild)
            {
                ltr=!ltr;
                queue.addAll(childQueue);
                childQueue.clear();
                copyChild=false;
            }
        }
    }
}
