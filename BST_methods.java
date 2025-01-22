public class BST_methods {

    class Node {
        int value;
        Node leftchild;
        Node rightchild;

        Node(int value) {
            this.value = value;
        }
    }

    // Method to display the tree
    public void treeformation(Node root, int level) {
        if (root == null) {
            return;
        }

        treeformation(root.leftchild, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(root.value);
        treeformation(root.rightchild, level + 1);
    }

    // Method to insert a node
    public Node insertbinary(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.leftchild = insertbinary(root.leftchild, value);
        } else if (value > root.value) {
            root.rightchild = insertbinary(root.rightchild, value);
        }
        return root;
    }

    // Method to search for a value
    public Node searchbinary(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value == root.value) {
            return root;
        } else if (value < root.value) {
            return searchbinary(root.leftchild, value);
        } else {
            return searchbinary(root.rightchild, value);
        }
    }

    // Method to delete a node
    public Node deletenode(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.leftchild = deletenode(root.leftchild, value);
        } else if (value > root.value) {
            root.rightchild = deletenode(root.rightchild, value);
        } else {
            // Node with no children
            if (root.leftchild == null && root.rightchild == null) {
                return null;
            }

            // Node with one child
            if (root.leftchild == null) {
                return root.rightchild;
            } else if (root.rightchild == null) {
                return root.leftchild;
            }

            // Node with two children
            root.value = minValue(root.rightchild);
            root.rightchild = deletenode(root.rightchild, root.value);
        }
        return root;
    }

    // Method to find the minimum value in a subtree
    int minValue(Node root) {
        int minvalue = root.value;
        while (root.leftchild != null) {
            root = root.leftchild;
            minvalue = root.value;
        }
        return minvalue;
    }

    // In-order traversal
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.leftchild);
        System.out.print(root.value + " ");
        inorder(root.rightchild);
    }

    public static void main(String[] args) {
        BST_methods concept = new BST_methods();

        // Manually created tree
        Node n100 = concept.new Node(100);
        Node n90 = concept.new Node(90);
        Node n102 = concept.new Node(102);
        Node n101 = concept.new Node(101);
        Node n104 = concept.new Node(104);
        Node n89 = concept.new Node(89);
        Node n91 = concept.new Node(91);
        Node n40 = concept.new Node(40);
        Node n35 = concept.new Node(35);

        n100.leftchild = n90;
        n100.rightchild = n102;

        n102.leftchild = n101;
        n102.rightchild = n104;

        n90.leftchild = n89;
        n90.rightchild = n91;

        n89.leftchild = n40;
        n40.leftchild = n35;

        System.out.println("Binary tree formation :: (manual)");
        concept.treeformation(n100, 0);

        System.out.println("=========================");

        // Tree formed using insertions
        Node root = null;
        root = concept.insertbinary(root, 1000);
        root = concept.insertbinary(root, 999);
        root = concept.insertbinary(root, 1001);
        root = concept.insertbinary(root, 1002);
        root = concept.insertbinary(root, 100);
        root = concept.insertbinary(root, 899);
        root = concept.insertbinary(root, 790);
        root = concept.insertbinary(root, 1100);

        System.out.println("Binary tree formation :: (insert)");
        concept.treeformation(root, 0);

        System.out.println("=========================");

        // Search for a value
        Node searchvalue = concept.searchbinary(root, 899);
        if (searchvalue != null) {
            System.out.println("Element entered is available in the node");
            concept.treeformation(searchvalue, 0);
        } else {
            System.out.println("Element entered is not available in the node");
        }

        System.out.println("=============================");

        // Delete a node
        root = concept.deletenode(root, 1000);
        System.out.println("In-order traversal after deletion:");
        concept.inorder(root);
    }
}
