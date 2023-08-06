package trees;
import java.util.*;

import org.w3c.dom.NodeList;

public class BinaryTrees {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1; //we will be using a recursive fx;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]); //fed data into the new node;
            newNode.left = buildTree(nodes);//idx will be ++ automatically because recursiion;
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static void preorder(Node root){ //O(n)
        //Root->LS->RS
        if(root==null){
            return;
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void Inorder(Node root){
        //LS->root->RS
        if(root==null){
            return;
        }
        Inorder(root.left);
        System.out.print(root.data+ " ");
        Inorder(root.right);
    }
    public static void Postorder(Node root){
        //LS->RS->Root
        if(root==null){
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data+ " ");
    }
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root) ;
        q.add(null);
        
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode!=null){
                System.out.print(currNode.data+ " ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            else{
                System.out.println(" ");
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
        }

    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int maxheight = Math.max(lh, rh)+1;
        return maxheight;
    }
    public static int countNodes(Node root){
        int count = 0;
        if(root==null){
            return 0;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
        count = lc+rc +1; //adds 1 for every node it's on.
        return count;
    }
    public static int SumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int ls = SumOfNodes(root.left);
        int rs = SumOfNodes(root.right);
        int TotalSum = ls+rs + root.data;
        return TotalSum;
    }
    public static int DiameterForTreeApproach1(Node root)//O(N^2) 
    //longest distance between any two leaves
    {
         if(root==null){
            return 0 ;
         }
         int leftDiam = DiameterForTreeApproach1(root.left);
         int leftHt = height(root.left);
         int rightDiam = DiameterForTreeApproach1(root.right);
         int rightHt = height(root.right);
         int selfDiam = leftHt + rightHt +1;
         return Math.max(selfDiam, Math.max(leftDiam,rightDiam));
        }
    
        static class Info{
            int diam;
            int ht;
            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;

            }
        }
        public static Info DiameterForTreeApproach2(Node root){
            if(root==null){
                return new Info(0,0);
            }
            Info leftInfo = DiameterForTreeApproach2(root.left);
            Info rightInfo = DiameterForTreeApproach2(root.right);
            int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1 );
            int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new Info(diam, ht);
        }
        public static boolean isIdentical(Node node, Node subroot){
            if(node==null & subroot ==null){
                return true;
            }else if(node==null||subroot==null||node.data!=subroot.data){
                return false;
            }
            if(!isIdentical(node.left, subroot.left)){
                return false;
            }
            if(!isIdentical(node.right, subroot.right)){
                return false;
            }
            return true;
        
        }
        public static boolean isSubtree(Node root, Node subRoot){//subroot is root for the tree we're checking.
            if(root==null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        static class InfoTopView{
            int hd; //horizontal distance
            Node node;
            public InfoTopView(Node node,int hd){
                this.node =node;
                this.hd = hd;
            }
        }
        public static void TopView(Node root){
            Queue<InfoTopView> q = new LinkedList<>();
            HashMap<Integer,Node> map = new HashMap<>();
            int max=0, min=0;
            q.add(new InfoTopView(root, 0));
            q.add(null); //for moving to next line and identifying it
            while(!q.isEmpty()){
                InfoTopView curr= q.remove();
                if(curr==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                if(!map.containsKey(curr.hd)){ //if a node with this hd already exists, we donot want to print it in top view
                    map.put(curr.hd, curr.node);
                    
                }
                if(curr.node.left!=null){
                    q.add(new InfoTopView(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);       
                }
                if(curr.node.right!=null){
                    q.add(new InfoTopView(curr.node.right, curr.hd+1));
                    max = Math.max(max,curr.hd+1);  
                }
            }
            }
            System.out.println("top view:");
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data);
            }
            System.out.println();
        }

        public static void PrintKthLevel(Node root, int level, int k){
            if(root == null){
                return;
            }
            //basically preorder traversal
            if(level==k){
                System.out.println(root.data + " ");
            }
            PrintKthLevel(root.left, level+1, k);
            PrintKthLevel(root.right, level+1, k);
        }
        public static boolean getPath(Node root, int n, ArrayList<Node> path){ //fun to understand
            if(root == null){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }
            //this will keep altering the path argument and will affect the original variable provided
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);
            if(foundLeft || foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;


        }
        public static Node LowestCommonAncestor(Node root,int n1, int n2){ //O(n) and O(n) 
            //get all possible paths for each of the nodes
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n2, path1);
            getPath(root, n2, path2);

            int i =0;
            for(;i<path1.size() && i<path2.size();i++){
                if(path1.get(i) !=path2.get(i)){
                    break;
                }
            }

            //last equal node -> i-1th
            Node lca = path1.get(i-1);
            return lca;
        }
        public static Node LowestCommonAncestorApproach2(Node root, int n1, int n2){
            //find the first node in whose subtree both nodes exist
            if(root==null || root.data == n1 || root.data == n2){
                return root;

            }
            Node leftLca = LowestCommonAncestorApproach2(root.left, n1, n2);
            Node rightLca = LowestCommonAncestorApproach2(root.right, n1, n2);

            //if leftLca = valid and rightLca = null
            if(rightLca == null){
                return leftLca; //meaning both nodes exist in the left sub tree
            }
            if(leftLca== null){
                return rightLca;
            }

            return root;//if both lca's have valid values ;
            //no external auxillary space is used except for the stack of recursion
        }
        public static int lcaDist(Node root,int n){
            //distanc from common ancestor
            if(root== null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if(leftDist== -1 && rightDist ==-1){
                return -1;
            }
            else if(leftDist == -1){
                return rightDist + 1;
            }
            else{
                return leftDist+1;
            }
        }
        public static int MinimumDistance(Node root, int n1, int n2){
            //min dist bw two nodes
            //we do this by searching distance of both nodes from their lowest common ancestor(lca)
            Node lca = LowestCommonAncestorApproach2(root, n1, n2);
            int dist1 = lcaDist(lca, n1);
            int dist2 = lcaDist(lca, n2);

            return dist1+dist2;
        }
        public static int KthAncestor(Node root, int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int leftDist = KthAncestor(root.left, n, k);
            int rightDist = KthAncestor(root.right, n, k);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }
            int max = Math.max(leftDist,rightDist);
            if(max + 1 == k){
                System.out.println(root.data);
            }
            return max+1;

        }
        public static int SumOfAllNodesBelow(Node root){
            if(root == null){
                return 0;
            }
            else{
                int currData = root.data;
                int sum = currData + SumOfAllNodesBelow(root.left) + SumOfAllNodesBelow(root.right);
                return sum - currData;
            }
        }
        public static int TransformToSumTree(Node root){
            if(root==null){
                return 0 ;
            }
            int leftChild = TransformToSumTree(root.left);
            int rightChild = TransformToSumTree(root.right);

            int data = root.data;
            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null? 0:root.right.data;
            root.data = newLeft+ leftChild + newRight + rightChild;
            return data;
        }
        public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preorder(root);
        System.out.println(" ");
        Inorder(root);
        System.out.println(" ");
        Postorder(root);
        System.out.println(" ");
        levelOrder(root);
        System.out.println(" ");
        System.out.print(height(root));
        System.out.println(" ");
        System.out.print("number of nodes is :"+ countNodes(root));
        System.out.println(" ");
        System.out.println("sum of all nodes is: " + SumOfNodes(root));
        System.out.println(DiameterForTreeApproach1(root));
        System.out.println(DiameterForTreeApproach2(root).diam);
        /*              1
         *            /   \        
         *           2     3  
         *          / \   / \
         *         4   5     6
         */
        TopView(root);
        TransformToSumTree(root);
        preorder(root);
        //transformeToASumTree will alter the original tree be carefull
    }
}
