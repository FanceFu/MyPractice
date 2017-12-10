package javavaluebooktree;

import com.sun.xml.internal.ws.util.Pool;

import javax.swing.tree.TreeNode;
import java.util.logging.Level;
import java.util.regex.Matcher;

/**
 * 程序员面试金典   9.4 树与图
 */
public class TreeTest {

    /**
     * 判断树是否为平衡树  1.递归获取子树的高度  2.检查 高度
     * @return
     */
    public static boolean isBalanced(Node root){
        if(checkHeight(root)==-1)
            return false;
        return true;
    }
    public static int checkHeight(Node root){
        if(root==null) return 0;

        int leftHeight=checkHeight(root.left);
        if (leftHeight==-1)
            return -1;
        int rightHeight=checkHeight(root.right);
        if (rightHeight==-1)
            return -1;

        int heightDiff=leftHeight-rightHeight;
        if(Math.abs(heightDiff)>1)
            return -1;
        else return Math.max(leftHeight,rightHeight)+1;
    }

    /**
     * 获取最大高度 104. Maximum Depth of Binary Tree
     * @param root
     * @return
     */
    public static int maxHeight(Node root){
        if(root==null) return 0;
        return Math.max(maxHeight(root.left),maxHeight(root.right))+1;
    }

    public static Node createMinimalBST(int a[],int start,int end){
        if(end<start){
            return null;
        }
        int mid=start+(end-start)/2;
        Node root=new Node(a[mid]);
        root.left=createMinimalBST(a,start,mid-1);
        root.right=createMinimalBST(a,mid+1,end);
        return root;
    }

    /**
     * 元素各不相同的升序数组 创建高度最小的二叉查找数  1.插入 2.利用有序 直接将中间元素插入，左边 左子树 右边 右子树
     * @param a
     * @return
     */
    public static Node createMinimalBST(int a[]){
        return createMinimalBST(a,0,a.length-1);
    }

    /**
     * 617. Merge Two Binary Trees
     * @param t1
     * @param t2
     * @return
     */
    public static Node mergeTrees(Node t1, Node t2) {
        if(t1==null)return t2;
        if(t2==null)return t1;
        t1.data=t1.data+t2.data;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;

    }

    /**
     * 226. Invert Binary Tree
     * @param root
     * @return
     */
    public static Node invertTree(Node root) {
        if(root==null)return null;
        invert(root);
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        return root;
    }
    public  static void invert(Node root){
        if(root==null||root.left==null||root.right==null) return;
        Node tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }

    public static void main(String[] args) {
        BinaryTree tree1=new BinaryTree();
        BinaryTree tree2=new BinaryTree();
        int[] data1 ={2,1,3,4,0};
        tree1.buildTree(data1);
        tree1.preOrder();
        System.out.println("------");
        tree1.setRoot(invertTree(tree1.getRoot()));
        tree1.preOrder();
       // int[] a={1,2,3,4,5,6};
       // Node curRoot= createMinimalBST(a);
        //tree.setRoot(curRoot);

        //tree.preOrder();
       /* int[] data1 ={2,1,3,4,0};
        int[] data2 ={2};
        tree1.buildTree(data1);
        tree2.buildTree(data2);
       tree1.setRoot(mergeTrees(tree1.getRoot(),tree2.getRoot()));
        tree1.preOrder();*/
        //System.out.println(isBalanced(tree.getRoot()));
       // System.out.println(maxHeight(tree.getRoot()));


    }
}
