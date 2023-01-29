package AZ3_4;

public class DoublyLinkedList {
    public DListElem first;
    public DListElem last;
    DoublyLinkedList()
    {
        this.first = null;
        this.last = null;
    }
    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(int x)
    {
        DListElem nElem = new DListElem(x);
        if(isEmpty()) last = nElem;
        else first.prev = nElem;
        nElem.next = first;
        first = nElem;
    }
    public void insertLast(int x)
    {
        DListElem nElem = new DListElem(x);
        if(isEmpty()) first = nElem;
        else last.next = nElem;
        nElem.prev = last;
        last = nElem;
    }
    public DListElem deleteLast()
    {
        if(isEmpty()) return null;
        DListElem tempLast = last;
        if(first.next == null) first = null;
        else last.prev.next = null;
        last = last.prev;
        return tempLast;
    }
    public DListElem deleteFirst()
    {
        if(isEmpty()) return null;
        DListElem tempFirst = first;
        if(first.next == null) last = null;
        else first.next.prev = null;
        first = first.next;
        return tempFirst;
    }
    public void insert(int x)
    {
        DListElem nElem = new DListElem(x);
        if(isEmpty())
        {
            first = nElem;
            last = nElem;
        }
        else {
            DListElem curr = first;
            while(curr != null)
            {
                if(curr.iData > x) break;
                curr = curr.next;
            }
            if(curr == null) insertLast(x);
            else if(curr == first) insertFirst(x);
            else{
                nElem.next = curr;
                nElem.prev = curr.prev;
                curr.prev.next = nElem;
                curr.prev = nElem;
            }
        }
    }
    public DListElem delete(int x)
    {
        if(isEmpty()) return null;
        DListElem curr = first;
        while(curr != null) {
            if(curr.iData == x) break;
            curr = curr.next;
        }
        if(curr == null)
        {
            System.out.println("Nie ma takiej liczby");
            return null;
        }
        else {
            if (curr == first) deleteFirst();
            else if (curr == last) deleteLast();
            else {
                curr.next.prev = curr.prev;
                curr.prev.next = curr.next;
                curr.next = null;
                curr.prev = null;
            }
        }
        return curr;
    }
    public void print()
    {
        DListElem curr = first;
        while(curr != null)
        {
            System.out.print(curr.iData + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public DListElem find(int x)
    {
        if(isEmpty()) return null;
        DListElem curr = first;
        while(curr != null)
        {
            if(curr.iData == x) return curr;
            curr = curr.next;
        }
        return null;
    }
    public static void main(String[] args) {
        DoublyLinkedList lista = new DoublyLinkedList();
        lista.insert(4);
        lista.insert(2);
        lista.insert(6);
        lista.insert(1);
        lista.insert(8);
        lista.insert(44);
        System.out.println(lista.find(11));
        System.out.println(lista.find(2));
        lista.print();
        lista.delete(2);
        lista.print();
        lista.delete(8);
        lista.print();
        lista.delete(1);
        lista.print();
    }
}
class DListElem{
    public int iData;
    public DListElem next;
    public DListElem prev;
    DListElem(int iData)
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
