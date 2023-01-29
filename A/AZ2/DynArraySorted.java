package AZ2;

import AZ1.DynArray;

public class DynArraySorted {
    private Person[] table;
    private int nElems;
    DynArraySorted(int maxSize)
    {
        this.table = new Person[maxSize];
        this.nElems = 0;
    }
    public int size()
    {
        return nElems;
    }
    public void add(Person p)
    {
        if (nElems >= table.length) {
            Person[] tempTab = new Person[table.length * 2];
            for (int i = 0; i < table.length; i++) tempTab[i] = table[i];
            table = tempTab;
        }
        int i;
        for (i = 0; i < nElems; i++) {
            if (table[i].compareTo(p) > 0) break;
        }
        for (int j = nElems; j > i; j--) {
            table[j] = table[j - 1];
        }
        table[i] = p;
        nElems++;
    }
    public Person get(int index)
    {
        if(index >= nElems || index < 0) return null;
        return table[index];
    }
    public Person find(Person p)
    {
        for(int i = 0; i < nElems; i++)
        {
            if(table[i].getImie().equals(p.getImie())
                    && table[i].getNazwisko().equals(p.getNazwisko())
                    && table[i].getWiek() == p.getWiek()) return table[i];
        }
        return null;
    }
    public boolean remove(Person p)
    {
        int i;
        for(i = 0; i < nElems; i++)
        {
            if(table[i].getImie().equals(p.getImie())
                    && table[i].getNazwisko().equals(p.getNazwisko())
                    && table[i].getWiek() == p.getWiek()) break;
        }
        if(i == (nElems - 1)){
            table[nElems] = null;
            nElems--;
            return true;
        }
        else if(i < (nElems - 1)) {
            for (int j = i; j < (nElems - 1); j++) {
                table[j] = table[j + 1];
            }
            nElems--;
            return true;
        }
        return false;
    }
    public void print() {
        for (int i = 0; i < nElems; i++)
        {
            System.out.println(table[i]);
        }
    }

    public static void main(String[] args) {
        DynArraySorted tablica = new DynArraySorted(1);
        tablica.add(new Person("Janek", "Jankowski", 44));
        tablica.add(new Person("Kamil", "Grabowski", 33));
        tablica.add(new Person("Wojtek", "Frankowski", 22));
        tablica.add(new Person("Michal", "Dabrowski", 11));
        tablica.add(new Person("Adam", "Cwierkowski", 22));
        tablica.add(new Person("Bartek", "Nowak", 66));
        tablica.add(new Person("Damian", "Kowalski", 77));
        tablica.print();
//        System.out.println(tablica.find(new Person("Janek", "Jankowski", 41)));
//        System.out.println(tablica.get(5));
//        System.out.println(tablica.size());
//        tablica.remove(new Person("Wojtek", "Frankowski", 22));
//        tablica.print();
//        System.out.println(tablica.size());
    }
}
class Person implements Comparable<Person>{
    private String imie, nazwisko;
    private int wiek;

    Person(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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
        //wiek
        //imie
        //nazwisko
        if(this.getWiek() > o.getWiek()) return 1;
        if(this.getWiek() < o.getWiek()) return -1;
        else if(this.getWiek() == o.getWiek()){
            if(this.getImie().compareTo(o.getImie()) != 0) return this.getImie().compareTo(o.getImie());
            else return this.getNazwisko().compareTo(o.getNazwisko());
        }
        return 0;
    }
}
