/*
Create a treenode structure and a class BST where you will create following methods-
1) insert method using recursion
2) method that will find out minimum value from right subtree and maximum value from left subtree
3)method to search the value is present or not
5) method to traverse the tree
 */
public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data=data;
    }
}
class BST{
    public static Node insert(Node root,Node newnode){
        if(root==null){
            root=newnode;
            return root;
        }
        if(root.data>newnode.data){
            if(root.left==null){
                root.left=newnode;
            }
            else {
                insert(root.left,newnode);
            }
        }
        if(root.data<newnode.data){
            if (root.right==null){
                root.right=newnode;
            }
            else {
                insert(root.right,newnode);
            }
        }
        return root;
    }
    public static int findMax(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int res=node.data;
        int lres=findMax(node.left);
        if (lres>res){
            res=lres;
        }
        return res;
    }
    public static int findMin(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        int res=node.data;
        int rres=findMin(node.right);
        if(rres<res){
            res=rres;
        }
        return res;
    }
    public static boolean search(Node root,Node newnode){
        boolean result;
        if (root==null){
            return false;
        }
        if(root.data==newnode.data){
            return true;
        }
        if (root.data>newnode.data){
            result= search(root.left,newnode);
        }
       else {
           result=search(root.right,newnode);
        }
       return result;

    }
    public static void PreorderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        PreorderTraversal(root.left);
        PreorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(50);
        Node Res=insert(null,root);
        Node n1=new Node(30);
        Node n2=new Node(40);
         Res=insert(Res,n1);
         Res=insert(Res,n2);

         findMax(n1);

         findMin(n2);
         PreorderTraversal(root);
         search(root,n1);
    }

}
