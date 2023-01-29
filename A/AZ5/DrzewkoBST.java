package AZ5;

import java.util.ArrayList;

public class DrzewkoBST {
    private DrzewkoNode root;
    DrzewkoBST()
    {
        root = null;
    }
    public DrzewkoNode getRoot()
    {
        return root;
    }
    public void insert(int elem)
    {
        DrzewkoNode newNode = new DrzewkoNode();
        newNode.iData = elem;
        if(root == null) root = newNode;
        else{
            DrzewkoNode curr = root;
            while(true)
            {
                DrzewkoNode parent = curr;
                if(curr.iData > elem) {
                    curr = curr.left;
                    if(curr == null)
                    {
                        parent.left = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
                else if(curr.iData < elem) {
                    curr = curr.right;
                    if(curr == null)
                    {
                        parent.right = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
            }
        }
    }
    public boolean find(int elem)
    {
        if(root == null) return false;
        else{
            DrzewkoNode curr = root;
            while(curr != null)
            {
                if(curr.iData > elem) curr = curr.left;
                else if(curr.iData < elem) curr = curr.right;
                else return true;
            }
        }
        return false;
    }
    private DrzewkoNode getSuccesor(DrzewkoNode succesor)
    {
        DrzewkoNode curr = succesor.right;
        while(curr.left != null) curr = curr.left;
        return curr;
    }
    private void deleteWithoutChilds(DrzewkoNode node)
    {
        if(node == root) root = null;
        else
        {

            if(node.parent.left == node) node.parent.left = null;
            else  node.parent.right = null;
        }
    }
    private void deleteWithOneLeftChild(DrzewkoNode node)
    {
        if(node == root) root = node.left;
        else{
            if(node.parent.left == node) node.parent.left = node.left;
            else node.parent.right = node.left;
            node.left.parent = node.parent;
        }
    }
    private void deleteWithOneRightChild(DrzewkoNode node)
    {
        if(node == root) root = root.right;
        else{
            if(node.parent.left == node) node.parent.left = node.right;
            else node.parent.right = node.right;
            node.right = node.parent;
        }
    }
    private void deleteWithTwoChilds(DrzewkoNode node)
    {
        DrzewkoNode succesor = getSuccesor(node);
        if(succesor.left == null && succesor.right == null) deleteWithoutChilds(succesor);
        else deleteWithOneRightChild(succesor);
        DrzewkoNode currParent = node.parent;
        if(currParent.left == node) currParent.left = succesor;
        else currParent.right = succesor;
        succesor.left = node.left;
        succesor.right = node.right;
        succesor.parent = currParent;
        if(succesor.left != null) succesor.left.parent = succesor;
        if(succesor.right != null) succesor.right.parent = succesor;
    }
    public boolean delete(int elem)
    {
        DrzewkoNode curr = root;
        if(root == null) return false;
        else{
            while(curr.iData != elem)
            {
                if(curr.iData > elem) curr = curr.left;
                else curr = curr.right;
                if(curr == null) return false;
            }
            if(curr.left != null && curr.right != null) deleteWithTwoChilds(curr);
            else {
                if(curr.left != null) deleteWithOneLeftChild(curr);
                else if(curr.right != null) deleteWithOneRightChild(curr);
                else deleteWithoutChilds(curr);
            }
        }
        return true;
    }
    public void view(DrzewkoNode node, int level)
    {
        if(node == null) return;
        for(int i = 0; i < level; i++) System.out.print("- ");
        System.out.println(node.iData);
        if(node.left != null) view(node.left, level + 1);
        if(node.right != null) view(node.right, level + 1);
    }
    private void copyBSTtoArray(DrzewkoNode node, ArrayList<DrzewkoNode> nodeList)
    {
        if(node.left != null) copyBSTtoArray(node.left, nodeList);
        nodeList.add(node);
        if(node.right != null) copyBSTtoArray(node.right, nodeList);
    }
    public void print()
    {
        ArrayList<DrzewkoNode> lista = new ArrayList<>();
        System.out.println("BST :");
        copyBSTtoArray(root, lista);
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.print(lista.get(i).toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DrzewkoBST drzewo = new DrzewkoBST();
        drzewo.insert(50);
        drzewo.insert(11);
        drzewo.insert(33);
        drzewo.insert(44);
        drzewo.insert(55);
        drzewo.insert(66);
        drzewo.insert(77);
        drzewo.insert(58);
        drzewo.insert(69);
        drzewo.insert(22);
        drzewo.insert(9);
        drzewo.insert(75);
        drzewo.insert(51);
        drzewo.delete(11);
        System.out.println(drzewo.find(11));
        drzewo.view(drzewo.getRoot(), 0);
        drzewo.print();
        drzewo.delete(66);
        drzewo.print();
    }
}

class DrzewkoNode{
    public int iData;
    public DrzewkoNode parent, left, right;
    DrzewkoNode()
    {
        this.iData = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    @Override
    public String toString() {
        return "{"+ iData + "}";
    }
}
