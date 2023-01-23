package A.z6_impl_tab_mieszajacej_met_landuchowa;

import java.util.LinkedList;
import java.util.Objects;

public class IHashTable {
    private LinkedList[] hashArray;//deklaracja tablicy mieszajacej
    private int arraySize;//rozmiar tej tablicy

    public IHashTable(int size) {//konstruktor
        this.arraySize = size;
        this.hashArray = new LinkedList[size];
        for(int i = 0; i < size; i++)//tworzenie pustych list na każdym miejscu w tablicy mieszajacej
        {
            hashArray[i] = new LinkedList();
        }
    }
    public LinkedList getLinkedList(int index)//zwraca liste o podanym numerze z tablicy mieszającej
    {
        return hashArray[index];
    }
    public int size()
    {
        return arraySize;
    }
    private int hashFunct(int elem)//funkcja mieszająca
    {
        return elem % arraySize;
    }
    public void insert(int x)//wstawianie do tablicy mieszajacej
    {
        int hashVal = hashFunct(x);
        if(!hashArray[hashVal].contains(x)) //jesli nie ma elementu na liscie to:
        {
            hashArray[hashVal].addFirst(x);//wstaw go na pozycji hashVal
        }
    }
    public void delete(int index)//usuwa daną liczbe
    {
        int hashVal = hashFunct(index);//najpierw pozyskanie poprzezfunckje dobrego indeksu
        hashArray[hashVal].remove((Object)index);//usuniecie
    }
    public boolean find(int x)//szukanie odpowiedniej liczby
    {
        return hashArray[hashFunct(x)].contains(x);//zwaraca true jak znajdzie, false jak nie ma
    }
    public IHashTableIterator iterator()//nie wiem ale tworzy iterator
    {
        return new IHashTableIterator(this);
    }
    public void print()
    {
        System.out.println("Tablica mieszająca: ");
        IHashTableIterator iterator = this.iterator();
        while(iterator.hasNext())
        {
            Object elem = iterator.next();
            System.out.print(elem.toString() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        IHashTable hashTable = new IHashTable(10);
        hashTable.insert(1);
        hashTable.insert(11);
        hashTable.insert(2);
        hashTable.insert(32);
        hashTable.insert(42);
        hashTable.insert(3);
        hashTable.insert(33);
        hashTable.insert(4);
        hashTable.print();
        System.out.println(hashTable.find(33));
        hashTable.delete(5);
        hashTable.print();
        hashTable.delete(33);
        System.out.println(hashTable.find(33));
        hashTable.print();
    }
}
