package javanowcoder;



/**
 * Created by shkstart on 2017/12/10.
 */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class BinaryTree {

    /**
     * 前序的第一个节点 为根， 根据中序 找到 根节点位置 划分左子树和右子树 递归构建
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return initTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public static TreeNode initTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2){
        if(start1>end1||start2>end2)return null;
        int rootData=preOrder[start1]; //先序的第一个为根节点
        TreeNode head=new TreeNode(rootData);
        int rootIndex=findIndexInArr(inOrder,rootData,start2,end2); //找到根节点在中序的位置
        int offSet=rootIndex-start2-1;
        //构建左子树
        TreeNode left=initTree(preOrder,start1+1,start1+1+offSet,inOrder,start2,start2+offSet);
        //构建右子树
        TreeNode right=initTree(preOrder,start1+offSet+2,end1,inOrder,rootIndex+1,end2);
        head.left=left;
        head.right=right;
        return head;

    }

    public static int findIndexInArr(int[] a,int x,int start,int end){
        for (int i = start; i <=end ; i++) {
            if(a[i]==x)
                return i;
        }
        return -1;
    }

    public static void postOrder(TreeNode root){
        if(root!=null){

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
    public static void main(String[] args) {
        int[] pre={1,2,3,4,5,6};
        int[] in={3,2,1,5,4,6};
       TreeNode root= reConstructBinaryTree(pre,in);

        postOrder(root);
    }
}
