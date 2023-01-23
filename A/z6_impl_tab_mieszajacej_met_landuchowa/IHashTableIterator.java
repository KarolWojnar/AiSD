package A.z6_impl_tab_mieszajacej_met_landuchowa;

import java.util.Iterator;
import java.util.Objects;

public class IHashTableIterator {
    private IHashTable hashTable;//tbalica mieszajaca dla iteratora
    private int size;//rozmiar
    private int listIndex;//numer aktualnej listy na ktora wskazuje iterator
    private Iterator listIterator;//iterator aktualnej listy, na którą wskazuje iterator

    public IHashTableIterator(IHashTable hashTable) {//konstruktor
        this.hashTable = hashTable;
        this.listIndex = 0;
        this.size = hashTable.size();
        listIterator = hashTable.getLinkedList(listIndex).iterator();
    }
    public boolean hasNext()//sprawdza, czy jest kolejny element
    {
        if(listIterator.hasNext()) return  true;//jak jest to true
        int locListIndex = listIndex;//a jak nie ma to index listy się do lokalengo zapisuje
        Iterator locListIterator = listIterator;//iterator do lokalnego
        while(true)//szukanie kolejnej listy z elementami
        {
            locListIndex++;
            if(locListIndex == size) return false;//jak osiągnie ostatni index listy list to koniec!
            locListIterator =hashTable.getLinkedList(locListIndex).iterator();//jak nie skonczy to pobiera iterator dla kolejnej listy
            if(locListIterator.hasNext()) return true;//jesli jest kolejna lista to true
        }
    }
    public Object next()//pobieranie kolejnego elementu
    {
        if(listIterator.hasNext())//jesli jest kolejny element na liscie
        {
            return listIterator.next();//zwroc kolejny element
        }
        else//a jak nie ma to:
        {
            while(!listIterator.hasNext())//dopuki jest kolejna lista i jest niepusta:
            {
                listIndex++;//przejdz na kolejny index listy mieszanej
                if(listIndex == size) return false;//jesli ten index bedzie już wielkosci tablicy i nie znajdzie listy niepustej to koniec, bo to znazczy ze przekorczył liczbe dostepnych miejsc
                listIterator = hashTable.getLinkedList(listIndex).iterator();//pobiera kolejny iterator dla listy niepustej
            }
            return listIterator.next();//pobiera kolejny element
        }
    }
}
