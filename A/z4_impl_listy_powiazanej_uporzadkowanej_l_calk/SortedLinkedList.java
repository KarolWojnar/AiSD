package A.z4_impl_listy_powiazanej_uporzadkowanej_l_calk;

import jdk.jshell.spi.SPIResolutionException;

public class SortedLinkedList {
    private ListElem first;
    private ListElem last;

    SortedLinkedList()
    {
        first = null;
        last = null;
    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(int x)
    {
        ListElem nElem = new ListElem(x);
        if(isEmpty()) last = nElem;
        else first.prev = nElem;
        nElem.next = first;
        first = nElem;
    }
    public void insertLast(int x)
    {
        ListElem nElem = new ListElem(x);
        if(isEmpty()) first = nElem;
        else last.next = nElem;
        nElem.prev = last;
        last = nElem;
    }
    public ListElem deleteFirst()
    {
        if(isEmpty()) return null;
        ListElem temp = first;
        if(first.next == null) last = null;
        else first.next.prev = null;
        first = first.next;
        return temp;
    }
    public ListElem deleteLast()
    {
        if(isEmpty()) return null;
        ListElem temp = last;
        if(first.next == null) first = null;
        else last.prev.next = null;
        last = last.prev;
        return temp;
    }
    public ListElem delete(int x)
    {
        if(isEmpty()) return null;
        ListElem current = first;
        while(current != null)
        {
            if(current.iData == x) break;
            current = current.next;
        }
        if(current == first)
        {
            first.next.prev = null;
            first = first.next;
        }
        else if(current == last)
        {
            last.prev.next = null;
            last = last.prev;
        }
        else if(current == null) return null;
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return current;
    }
    public void print()
    {
        System.out.println("Lista: ");
        ListElem current = first;
        while(current != null)
        {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void insert(int x)
    {
        ListElem nElem = new ListElem(x);
        ListElem current = first;
        while(current != null)
        {
            if(nElem.iData < current.iData) break;
            current = current.next;
        }
        if(isEmpty()){
            first = nElem;
            last = nElem;
        }
        else{
            if(first.next == null)
            {
                if(first.iData < nElem.iData)
                {
                    first.next = nElem;
                    last = nElem;
                    nElem.prev = first;
                }
                else{
                    last.prev = nElem;
                    first = nElem;
                    nElem.next = last;
                }
            }
            else{
                if(current == first)
                {
                    nElem.next = first;
                    first.prev = nElem;
                    first = nElem;
                }
                else if(current == null){
                    nElem.prev = last;
                    last.next = nElem;
                    last = nElem;
                }
                else{
                    nElem.prev = current.prev;
                    nElem.next = current;
                    current.prev.next = nElem;
                    current.prev = nElem;
                }

            }
        }
    }
    public ListElem find(int x)
    {
        if(isEmpty()) return null;
        ListElem current = first;
        while(current != null)
        {
            if(current.iData == x) return current;
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SortedLinkedList lista = new SortedLinkedList();
        lista.insert(7);
        lista.insert(4);
        lista.insert(2);
        lista.insert(6);
        lista.insert(1);
        lista.insert(9);
        lista.insert(4);
        lista.insert(2);
        lista.print();
        lista.insert(10);
        lista.insert(1);
        lista.insert(5);
        lista.print();
        lista.delete(2);
        lista.delete(2);
        lista.delete(3);
        lista.print();
        System.out.println(lista.find(0));
    }
}

class ListElem
{
    public int iData;
    public ListElem next;
    public ListElem prev;
    ListElem(int iData)
    {
        this.iData = iData;
        this.next = null;
        this.prev = null;
    }
    @Override
    public String toString() {
        return Integer.toString(iData);
    }
}
