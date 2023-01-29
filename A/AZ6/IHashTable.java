package AZ6;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
public class IHashTable {
    private LinkedList[] hashArray;
    private int arraySize;
    IHashTable(int size)
    {
        arraySize = size;
        hashArray = new LinkedList[size];
        for(int i = 0; i < size; i++)
        {
            hashArray[i] = new LinkedList();
        }
    }
    public LinkedList getLinkedList(int index)
    {
        return hashArray[index];
    }
    public int size()
    {
        return arraySize;
    }
    private int hashFunct(int x)
    {
        return x % arraySize;
    }
    public void insert(int elem)
    {
        int after = hashFunct(elem);
        if(!hashArray[after].contains(elem)) hashArray[after].addFirst(elem);
    }
    public void delete(int elem)
    {
        int find = hashFunct(elem);
        if(hashArray[find].contains(elem)) hashArray[find].remove((Object)elem);
    }
    public boolean find(int elem)
    {
        int hashVal = hashFunct(elem);
        return hashArray[hashVal].contains(elem);
    }
    public void print()
    {
        System.out.println("Tablica mieszająca: ");
        for(int i = 0; i < arraySize; i++)
        {
            System.out.print(hashArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IHashTable arrayTab = new IHashTable(10);
        arrayTab.insert(8);
        arrayTab.insert(4);
        arrayTab.insert(1);
        arrayTab.insert(2);
        arrayTab.insert(5);
        arrayTab.insert(11);
        arrayTab.insert(76);
        arrayTab.insert(88);
        arrayTab.insert(14);
        arrayTab.insert(55);
        arrayTab.print();
        arrayTab.delete(14);
        arrayTab.print();
    }
}