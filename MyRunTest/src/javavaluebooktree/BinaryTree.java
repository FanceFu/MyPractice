package javavaluebooktree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 实现二叉排序
 * 树
 */

class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        root=null;
    }


    public void insert(int data){
        Node newNode=new Node(data);
        if(root==null)
            root=newNode;
        else {
            Node current=root;
            Node parent;
            while (true){  //寻找合适的位置
                parent=current;
                if(data<current.data){
                    current=current.left;
                    if(current==null){
                        parent.left=newNode;
                        return;
                    }
                }else {
                    current=current.right;
                    if(current==null){
                        parent.right=newNode;
                        return;
                    }
                }
            }
        }
    }


    /**
     * 构建二叉排序树
     * @param data
     */
    public  void  buildTree(int[] data){
        for (int i = 0; i <data.length ; i++) {
            insert(data[i]);
        }
    }

    /**
     * 递归中序遍历
     * @param loaclRoot
     */
    public void inOrder(Node loaclRoot){
        if(loaclRoot!=null){
            inOrder(loaclRoot.left);
            System.out.print(loaclRoot.data+" ");
            inOrder(loaclRoot.right);
        }
    }



    public void preOrder(Node loaclRoot){
        if(loaclRoot!=null){
            System.out.print(loaclRoot.data+" ");
            preOrder(loaclRoot.left);
            preOrder(loaclRoot.right);
        }
    }

    public void preOrder(){
        this.preOrder(this.root);
    }
    public void inOrder(){
        this.inOrder(this.root);
    }
    public void postOrder(){
        this.postOrder(this.root);
    }
    public void postOrder(Node loaclRoot){
        if(loaclRoot!=null){
            postOrder(loaclRoot.left);
            postOrder(loaclRoot.right);
            System.out.print(loaclRoot.data+" ");

        }
    }


    /**
     * 层次遍历二叉树
     * @param root
     * @return
     */
    public static ArrayList<Node> cengci(Node root){
        if (root==null) return null;
        ArrayList<Node> res=new ArrayList<>();
        LinkedList<Node> list=new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            Node cur=list.poll();
            if(cur.left!=null)
                list.add(cur.left);
            if(cur.right!=null)
                list.add(cur.right);
            res.add(cur);
        }
        return res;
    }
    public void initTree(int[] preOrder,int[] inOrder){
        root=this.initTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    /**
     * 根据先序 中序  构建二叉树 并输出后序遍历
     * @return
     */
    public Node initTree(int[] preOrder,int start1,int end1,int[] inOrder,int start2,int end2){
        if(start1>end1||start2>end2)return null;
        int rootData=preOrder[start1]; //先序的第一个为根节点
        Node head=new Node(rootData);
        int rootIndex=findIndexInArr(inOrder,rootData,start2,end2); //找到根节点在中序的位置
        int offSet=rootIndex-start2-1;
        //构建左子树
        Node left=initTree(preOrder,start1+1,start1+1+offSet,inOrder,start2,start2+offSet);
        //构建右子树
        Node right=initTree(preOrder,start1+offSet+2,end1,inOrder,rootIndex+1,end2);
        head.left=left;
        head.right=right;
        return head;

    }
    public int findIndexInArr(int[] a,int x,int start,int end){
        for (int i = start; i <=end ; i++) {
            if(a[i]==x)
                return i;
        }
        return -1;
    }

    /**
     * 求树中节点的最大距离
     * @param root
     * @return
     */
    public static int maxDis(Node root){
        if(root==null) return 0;
        return Math.max(maxDis(root.left),maxDis(root.right))+1;
    }

    public static int findMaxDis(Node root){
        if(root==null) return 0;
        return maxDis(root.left)+maxDis(root.right);
    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();

       // int[] preOrder={1,2,4,8,9,5,10,3,6,7};
      //  int[] inOrder={8,4,9,2,10,5,1,6,3,7};
      //  tree.initTree(preOrder,inOrder);
       // tree.postOrder();
        //tree.initTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
        int[] data ={2,1,3,4,0,-1,-2};
        tree.buildTree(data);
       tree.preOrder();
        System.out.println("-----");
        System.out.println(findMaxDis(tree.getRoot()));
       // tree.inOrder();
        //tree.postOrder();
       // ArrayList<Node> res=  cengci(tree.getRoot());
       // for (Node tmp:res
       //      ) {
       //     System.out.print(tmp.data);
       // }
    }

}
