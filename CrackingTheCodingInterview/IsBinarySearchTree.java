import java.util.*;

class IsBinarySearchTree {

  private class Node {
    int data;
    Node left;
    Node right;
  }

  public boolean checkBST(Node root) {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(Node root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.data < min || root.data > max) {
      return false;
    }
    return (isBinarySearchTree(root.left, min, root.data - 1)
        && isBinarySearchTree(root.right, root.data + 1, max));
  }
}
