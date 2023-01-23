package A.z2_implementacja_uporzadkowanej_tab_dyn;

public class OrdDynArrayPerson {
    private Person[] table;
    private int nElems;
    OrdDynArrayPerson(int maxSize)
    {
        table = new Person[maxSize];
        nElems = 0;
    }
    public void add(Person p)
    {
        if(nElems >= table.length)//jesli liczba osob przekracza dlugosc tabeli
        {
            Person[] tempTab = new Person[table.length * 2];
            for(int i = 0; i < table.length; i++) tempTab[i] = table[i];
            table = tempTab;// naszą tabele powiekszam dwukrotnie
        }
        int i;
        for(i = 0; i < nElems; i++)
        {
            if(table[i].compareTo(p) > 0) // jesli natrafimy na emelent juz wyższy po porównaniu przerywamy
            {
                break;
            }
        }
        for(int j = nElems; j > i; j--)//od ustalonego miejsca breaka przenosimy wartości o index do góry
        {
            table[j] = table[j - 1];
        }
        table[i] = p;//wstawiamy osobe którą chcemy
        nElems++;
    }
    public Person get(int index)
    {
        return table[index];
    }
    public int size()
    {
        return nElems;
    }
    public boolean remove(int index)
    {
        for(int i = index; i < nElems - 1; i++)//od miejsca usuwanego indexu zmienamy wartosci indexów o jeden w dół
        {
            table[i] = table[i + 1];
        }
        nElems--;
        return  true;
    }
    public int find(Person x)
    {
        for(int i = 0; i < nElems; i++)
        {
            if(table[i].compareTo(x) == 0) return i;//jak nam sie porówna wszystko w funkcji compareTo to nam wypisze naszego osbnika
        }
        return -1;
    }
    public int find2(Person x)
    {
        for(int i = 0; i < nElems; i++)
        {
            if(table[i].getImie().equals(x.getImie()) && table[i].getNazwisko().equals(x.getNazwisko()) && table[i].getWiek() == x.getWiek()) return i;
        }
        return -1;
    }
    public void print()
    {
        for(int i = 0; i < nElems; i++)
        {
            System.out.print(table[i].toString() + "\n");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OrdDynArrayPerson array = new OrdDynArrayPerson(1);
        Person p1 = new Person("Janek", "Wojtowicz", 43);
        Person p2 = new Person("Jakub", "Kowalski", 35);
        Person p3 = new Person("Adam", "Nowak", 24);
        Person p4 = new Person();
        p4.setImie("Kamil");
        p4.setNazwisko("Nowakowski");
        p4.setWiek(21);
        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);
        array.add(new Person("Zofia", "Grabowska", 15));
        array.print();
        array.find(p2);
        array.remove(3);
        array.print();
        array.add(new Person("Zofia", "Grabowska", 41));
        array.print();
    }
}


class Person implements  Comparable<Person>{
    private String imie, nazwisko;
    private int wiek;


    Person(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }
    Person(){
        this.imie = "";
        this.nazwisko = "";
        this.wiek = 0;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //kolejnosc:
        //od najmlodszej --> nazwisko(a do z) --> imie(a do z)
        if(this.getWiek() < o.getWiek()) return -1;
        if(this.getWiek() > o.getWiek()) return 1;
        if(this.getWiek() == o.getWiek())
        {
            if(this.getNazwisko().compareTo(o.getNazwisko()) != 0)
                return this.getNazwisko().compareTo(o.getNazwisko());
            else return this.getImie().compareTo(o.getImie());
        }
        return 0;
    }
}
