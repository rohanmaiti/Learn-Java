
// 
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        left = right = null;
        this.data = data;
    }
}
public class Main{
    static Scanner sc = new Scanner(System.in);
    static int idx = -1;
    public static void main(String []args){

    // buildTree using user input     
    // Node root = BuildTree();
    int arr[] = {1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,-1};
    Node root = buildTreeByArray(arr);
    printLevelOrder(root);
    System.out.println();
    System.out.println("heightOfTree is : "+heightOfTree(root));
    System.out.println("No of Nodes in Tree is : "+countNodes(root));
    System.out.println("Sum of All nodes is : "+sumOfNodes(root));

    // Build Tree using array
    }
    public static Node buildTreeByArray(int arr[]){
        idx++;
        if(arr[idx] == -1)
        return null;
        
        Node newNode = new Node(arr[idx]);
        newNode.left = buildTreeByArray(arr);
        newNode.right = buildTreeByArray(arr);

        return newNode;
        
    }
    public static Node BuildTree(){
        System.out.println("wating..: ");
        int data = sc.nextInt();
        if(data == -1)
        return null;

        Node root = new Node(data);
        System.out.print("Enter left of "+data+" : ");
        root.left = BuildTree();
        System.out.print("Enter right of "+data+" : ");
        root.right = BuildTree();

        return root;
    }
    public static void printLevelOrder(Node root){
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    q.offer(null);

    while( !q.isEmpty() )
    {
        Node front = q.poll();
        if(front == null)
        {
            if(q.isEmpty())
            break;
            else
            {
            System.out.println();
            q.offer(null);
            }
        }
        else{
            System.out.print(front.data + " ");
            if(front.left != null)
            q.offer(front.left);
            if(front.right != null)
            q.offer(front.right);
        }
    }
    }

    static void printPreorder(Node root){
        if(root == null)
        return ;
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    static void printInorder(Node root){
        if(root == null)
        return ;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    static void printPostorder(Node root){
        if(root == null)
        return ;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data+" ");
    }

    static int heightOfTree(Node root){
        if(root == null)
        return -1;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
    static int countNodes(Node root){
        if(root == null)
        return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return (leftCount + rightCount + 1);
    }
    static int sumOfNodes(Node root){
        if(root == null)
        return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

}
class Pair{
    int height;
    int diameter;
}