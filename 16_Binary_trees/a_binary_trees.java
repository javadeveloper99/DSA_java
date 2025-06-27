import java.util.*;

public class a_binary_trees {
  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  static class BinaryTree {
    static int idx = -1;

    public Node BuildBinaryTree(int[] nodes) {
      idx++;
      if (idx >= nodes.length || nodes[idx] == -1) {
        return null;
      }

      Node newNode = new Node(nodes[idx]);
      newNode.left = BuildBinaryTree(nodes);
      newNode.right = BuildBinaryTree(nodes);

      return newNode;
    }

    public void preorder(Node root) {
      if (root == null)
        return;
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);
    }

    public void inorder(Node root) {
      if (root == null)
        return;
      inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);
    }

    public void postorder(Node root) {
      if (root == null)
        return;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + " ");
    }

    public void levelOrder(Node root) {
      if (root == null)
        return;

      Queue<Node> q = new LinkedList<>();
      q.add(root);
      q.add(null);
      int height = 0;

      while (!q.isEmpty()) {
        Node curNode = q.remove();
        if (curNode == null) {
          System.out.println();
          height++;
          if (q.isEmpty())
            break;
          q.add(null);
        } else {
          System.out.print(curNode.data + " ");
          if (curNode.left != null)
            q.add(curNode.left);
          if (curNode.right != null)
            q.add(curNode.right);
        }
      }
      System.out.println("Height: " + height);
    }

    public int height(Node root) {
      if (root == null)
        return 0;
      int lh = height(root.left);
      int rh = height(root.right);
      return Math.max(lh, rh) + 1;
    }

    public int countNodes(Node root) {
      if (root == null)
        return 0;
      return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int sumOfNodes(Node root) {
      if (root == null)
        return 0;
      return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    public int diameter2(Node root) {
      if (root == null)
        return 0;
      int leftDia = diameter2(root.left);
      int rightDia = diameter2(root.right);
      int leftH = height(root.left);
      int rightH = height(root.right);
      int currDia = leftH + rightH + 1;
      return Math.max(currDia, Math.max(leftDia, rightDia));
    }

    static class Info {
      int dia, ht;

      Info(int dia, int ht) {
        this.dia = dia;
        this.ht = ht;
      }
    }

    public Info diameter(Node root) {
      if (root == null)
        return new Info(0, 0);
      Info leftInfo = diameter(root.left);
      Info rightInfo = diameter(root.right);
      int diam = Math.max(leftInfo.dia, Math.max(rightInfo.dia, leftInfo.ht + rightInfo.ht + 1));
      int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
      return new Info(diam, ht);
    }

    public boolean isSubTree(Node root, Node subRoot) {
      if (root == null)
        return false;
      if (root.data == subRoot.data && isIdentical(root, subRoot))
        return true;
      return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public boolean isIdentical(Node node, Node subRoot) {
      if (node == null && subRoot == null)
        return true;
      if (node == null || subRoot == null)
        return false;
      if (node.data != subRoot.data)
        return false;
      return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    static class Inf {
      Node node;
      int hd;

      Inf(Node node, int hd) {
        this.node = node;
        this.hd = hd;
      }
    }

    public void topNode(Node root) {
      if (root == null)
        return;

      Queue<Inf> q = new LinkedList<>();
      HashMap<Integer, Node> map = new HashMap<>();
      int min = 0, max = 0;

      q.add(new Inf(root, 0));
      q.add(null);

      while (!q.isEmpty()) {
        Inf curr = q.remove();
        if (curr == null) {
          if (q.isEmpty())
            break;
          q.add(null);
          continue;
        }

        if (!map.containsKey(curr.hd)) {
          map.put(curr.hd, curr.node);
        }

        if (curr.node.left != null) {
          q.add(new Inf(curr.node.left, curr.hd - 1));
          min = Math.min(min, curr.hd - 1);
        }
        if (curr.node.right != null) {
          q.add(new Inf(curr.node.right, curr.hd + 1));
          max = Math.max(max, curr.hd + 1);
        }
      }

      for (int i = min; i <= max; i++) {
        System.out.print(map.get(i).data + " ");
      }
      System.out.println();
    }

    public void kthLevel(Node root, int level, int k) {
      if (root == null)
        return;
      if (level == k) {
        System.out.print(root.data + " ");
        return;
      }
      kthLevel(root.left, level + 1, k);
      kthLevel(root.right, level + 1, k);
    }

    public boolean getPath(Node root, int n, ArrayList<Integer> path) {
      if (root == null)
        return false;
      path.add(root.data);
      if (root.data == n)
        return true;
      if (getPath(root.left, n, path) || getPath(root.right, n, path))
        return true;
      path.remove(path.size() - 1);
      return false;
    }

    public int lca(Node root, int n1, int n2) {
      ArrayList<Integer> path1 = new ArrayList<>();
      ArrayList<Integer> path2 = new ArrayList<>();
      boolean found1 = getPath(root, n1, path1);
      boolean found2 = getPath(root, n2, path2);
      if (!found1 || !found2)
        return -1;
      int i = 0;
      while (i < path1.size() && i < path2.size()) {
        if (!path1.get(i).equals(path2.get(i)))
          break;
        i++;
      }
      return path1.get(i - 1);
    }
  }

public static Node lca2(Node root, int n1, int n2) {
  if (root == null) return null;

  if (root.data == n1 || root.data == n2) {
    return root;
  }

  Node leftLCA = lca2(root.left, n1, n2);
  Node rightLCA = lca2(root.right, n1, n2);

  if (leftLCA != null && rightLCA != null) {
    return root; // This is the LCA
  }

  return (leftLCA != null) ? leftLCA : rightLCA;
}


  public static void main(String[] args) {
    int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
   BinaryTree tree = new BinaryTree();
   Node root = tree.BuildBinaryTree(nodes);

    Node ans = lca2(root, 4, 5);
    System.out.println("LCA of 4 and 5 is: " + ans.data);  // Output: 2

   ans = lca2(root, 4, 6);
   System.out.println("LCA of 4 and 6 is: " + ans.data);  // Output: 1

  }
}
