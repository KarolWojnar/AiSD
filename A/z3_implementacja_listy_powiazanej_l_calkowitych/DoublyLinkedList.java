package A.z3_implementacja_listy_powiazanej_l_calkowitych;

public class DoublyLinkedList {
    private DlisElem first;//referencja do pierwszego elementu
    private DlisElem last;//referencja do ostatniego elementu

    public DoublyLinkedList() {
        this.first = null;//deklaracja pustej listy essa
        this.last = null;//deklaracja pustej listy essa
    }

    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(int x)
    {
        DlisElem newElem = new DlisElem(x);
        if(isEmpty()) last = newElem;// wstawiamy pierwszy element listy
        else first.prev = newElem;// wstawiamy na początek
        newElem.next = first;
        first = newElem;
    }
    public void insertLast(int x)
    {
        DlisElem newElem = new DlisElem(x);
        if(isEmpty()) first = newElem;//jesli jest pusta to na pierwsze miejsce wstawiamy
        else last.next = newElem;//jesli nie to nastepnik lasta zostaje nowy element
        newElem.prev = last;//poprzednikiem nowego elementu zostaje last
        last = newElem;//nowy element zostaje lastem
    }
    public DlisElem deleteFirst()
    {
        if(isEmpty()) return null;//jesli pusta to nie ma co usuwać
        DlisElem temp = first;//zmienna zapamietująca co usuwamy
        if(first.next == null) last = null;//jest jest tylko jeden element to jako lasta dajemy nulla
        else first.next.prev = null;//jesli jest wiecej niz jeden to odcinamy połączenie z nastepnika poprzednika firsta
        first = first.next;//nastepnik firsta zostej firstem
        return temp;
    }
    public DlisElem deleteLast()
    {
        if(isEmpty()) return null;//jak pusta to nic
        DlisElem temp = last;
        if(first.next == null) first = null;//jak jest tylko jeden element to last zostaje nullem
        else last.prev.next = null;//jak jest wiecej to poprzednik nastepnika lasta zostaje nullem
        last = last.prev;//lasem zostaje poprzednik
        return temp;
    }
    public void print()
    {
        System.out.println("Lista: ");
        DlisElem current = first;//przpisanie pierwszego elementu do currenta
        while(current != null)//dpouki current nie jest pusty
        {
            System.out.println(current.toString() + " ");//wywołaj currenta
            current = current.next;//zastąp currenta nastepnym
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList lista = new DoublyLinkedList();
        lista.insertFirst(44);
        lista.insertFirst(11);
        lista.insertFirst(22);
        lista.insertFirst(33);
        lista.print();
        lista.deleteFirst();
        lista.print();
        lista.insertLast(69);
        lista.deleteFirst();
        lista.print();
    }
}


class DlisElem
{
    public int iData; // dana w elemencie listy
    public DlisElem next;//referencja do nexta
    public DlisElem prev;//referencja do wczesniejszego

    DlisElem(int iData)
    {
        this.iData = iData;//inicjalizacja danych
        this.next = null; // no pusto to jak ma byc nastepnik i poprzednik
        this.prev = null;
    }

    @Override
    public String toString() { return Integer.toString(iData);}
}