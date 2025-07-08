import java.util.ArrayList;

public class a_Binary_ST {
  static class Node {
     int data;
     Node left,right;

     public Node(int data){
      this.data=data;
      this.right=null;
      this.left=null;
     }

  }

  public static Node Build_BST(Node root,int val){
    if (root==null) {
      root = new Node(val);
      return root ;
    }

    if (root.data<val) {
       root.right=Build_BST(root.right, val);
    }else{
      root.left=Build_BST(root.left, val);
    }

    return root;


  }

  public static void inorder(Node root){
    if (root==null) {
      return ;
    }

    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }

  public static boolean search_inBst(Node root,int key){
    if (root==null) {
       return false;
    }
    if (root.data==key) {
       return true;
    }

    if (root.data>key) {
      return search_inBst(root.left, key);
    }else{
      return search_inBst(root.right, key);
    }

  }

   public static Node deleteNode(Node root,int val){

    if (root.data > val) {
        root.left=deleteNode(root.left, val);
    }else if (root.data < val) {
        root.right=deleteNode(root.right, val);
    }else{
      // no child

      if (root.left ==null && root.right==null) {
        return null;
      }

      // 1 child

      if (root.left==null) {
        return root.right;
      }else if(root.right==null) {
          return root.left;
      }

      //both childs

      Node IS=findInorderSucc(root.right);
      root.data=IS.data;
      root.right=deleteNode(root.right,IS.data);
    }
    return root;
   }

   public static Node findInorderSucc(Node root){


     while (root.left != null) {
       root=root.left;
     }

     return root;
   }
   public static void printInRange(Node root,int k1,int k2){
    if (root==null) {
      return;
    }
      if (root.data <k1) {
        printInRange(root.left, k1, k2);
      }else if (root.data > k2) {
        printInRange(root.right, k1, k2);
      }else if (root.data >= k1 && root.data <= k2) {
        printInRange(root.left, k1, k2);
        System.out.print(root.data+" ");
        printInRange(root.right, k1, k2);
      }
   }

   public static void searchPath(Node root,ArrayList<Integer>list){
    if (root==null) {
      return ;
    }



    list.add(root.data);
    if (root.left==null && root.right==null) {
        printPath(list);
    }
    searchPath(root.left,list);
    searchPath(root.right,list);
    list.remove(list.size()-1);




   }

   public static void printPath(ArrayList<Integer>list){
     for(int i=0;i<list.size();i++){
          System.out.print(list.get(i)+"->");
     }


     System.out.println();
   }


public static boolean isValidBSTHelper(Node root, long min, long max) {
    if (root == null) {
        return true;
    }

    if (root.data <= min || root.data >= max) {
        return false;
    }

    return isValidBSTHelper(root.left, min, root.data) &&
           isValidBSTHelper(root.right, root.data, max);
}

public static Node mirror(Node root) {
    if (root == null) {
        return null;
    }

    // Recursively mirror left and right subtrees
    Node leftMirror = mirror(root.left);
    Node rightMirror = mirror(root.right);

    // Swap left and right
    root.left = rightMirror;
    root.right = leftMirror;

    return root;
}

public static void preOrder(Node root){
  if (root==null) {
    return ;
  }
  System.out.print(root.data+" ");
  preOrder(root.right);
  preOrder(root.left);
}
public static Node sortedArrayBalBst(int values[],int start,int end){
    if (start > end ) {
      return null;
    }

    int mid=start+(end-start)/2;
    Node newNode=new Node(values[mid]);

    newNode.right=sortedArrayBalBst(values, mid+1, end);
    newNode.left=sortedArrayBalBst(values, start, mid-1);

    return newNode;
  }

  public static void inorderArr(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inorderArr(root.left, list);
        list.add(root.data);
        inorderArr(root.right, list);
    }
  public static Node sortedArrayBalBst(ArrayList <Integer>list,int start,int end){
    if (start > end ) {
      return null;
    }

    int mid=start+(end-start)/2;
    Node newNode=new Node(list.get(mid));

    newNode.right=sortedArrayBalBst(list, mid+1, end);
    newNode.left=sortedArrayBalBst(list, start, mid-1);

    return newNode;
  }

   static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
     static int maxBSTSize = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        if (leftInfo.isBST && rightInfo.isBST &&
            root.data > leftInfo.max && root.data < rightInfo.min) {

            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, leftInfo.min);
            int max = Math.max(root.data, rightInfo.max);

            maxBSTSize = Math.max(maxBSTSize, size);

            return new Info(true, size, min, max);
        }

        // If not BST
        return new Info(false, 0, 0, 0);
    }

    public static int sizeOfLargestBST(Node root) {
        maxBSTSize = 0;
        largestBST(root);
        return maxBSTSize;
    }


public static Node mergeBSTs(Node root1,Node root2){

  ArrayList<Integer>list1=new ArrayList<>(); 
  inorderArr(root1, list1);

  ArrayList<Integer>list2=new ArrayList<>();
  inorderArr(root2, list2); 

  ArrayList<Integer>finalList=new ArrayList<>();

  int i=0,j=0;

  while (i<list1.size() && j<list2.size()) {
    if (list1.get(i)<=list2.get(j)) {
      finalList.add(list1.get(i));
      i++;
    }else{
      finalList.add(list2.get(j));
      j++;
    }
  }

  while (i<list1.size()) {
    finalList.add(list1.get(i));
     i++;
  }
  while (j<list2.size()) {
    finalList.add(list2.get(j));
     j++;
  }


  return sortedArrayBalBst(finalList, 0, finalList.size()-1);

}

  public static void main(String[] args) {
    
        // BST 1
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        //  BST 2
        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);


        Node root=mergeBSTs(root1, root2);

        inorder(root);
   
}


}

