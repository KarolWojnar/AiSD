package A.z1_implementacja_tab_dynamicznej;

public class DynArrrayStudent {
    private Student[] table;
    private int nElems;

    public DynArrrayStudent(int maxSize) { // no kontruktor do klasy tworządy tablice na tyle miejsc na ile ustalimy
        this.table = new Student[maxSize]; // tworzenie tablicy o rozmiarze "maxSize"
        this.nElems = 0;  //w razie jakby nie było elemetów to defaultowo 0
    }
    public void add(Student student)//dodawanie studenta
    {
        if(nElems >= table.length)//jesli elementów jest wiecej niz ma tablica miejsc to
        {
            Student [] tempTab = new Student[table.length * 2]; // deklarujemy nową tablice powiększoną dwukrotnie
            for(int i = 0; i < table.length; i++) tempTab[i] = table[i];
            table = tempTab; // zmienymy długość naszej globalnej tablicy
        }
        table[nElems] = student;//dodajemy nowy rekord
        nElems++; // powiększamy licznik elementów
    }
    public Student get(int index)//bierz studenta z indexu INDEX
    {
        return table[index];//nic trudnego
    }
    public int size()//zwracamy nElems
    {
        return nElems;
    }
    public boolean remove(int index)
    {
        if(nElems == 0 || index >= nElems || index < 0)//jesli wybrany index = 0 lub index jest wiekszy niz tablica lub index jest mniejszy niz 0
        {
            return false;//zwróć false
        }
        else{//jesli tak nie jest to:
            for(int i = index; i < nElems - 1; i++)//przejdz po tablicy
            {
                table[i] = table[i + 1];//przesuwamy wartości na index o jeden w tyl
            }
            nElems--;//zmniejszamy ilosc elementów w tablicy
            return true;
        }
    }
    public int find(Student searchElem)
    {
        for(int i = 0; i < nElems; i++)
        {
            if(table[i].equals(searchElem)) return i;//zwracamy pasujacy index
        }
        return -1; //czyli poza skalą czyli nie ma takiego indexu
    }
    public int find2(Student searchElem)//jak chcemy przeszukiwać podając po kolei imie nazwisko i wiek bla bla
    {
        for(int i = 0; i < nElems; i++)
        {
            if(table[i].getImie().equals(searchElem.getImie())
            && table[i].getNazwisko().equals(searchElem.getNazwisko())
            && table[i].getWiek() == searchElem.getWiek())
            {
                return i;
            }
        }
        return -1;
    }
    public void print()//wypisz
    {
        for(int i = 0; i < nElems; i++)//przez cała tablice
            System.out.print(get(i).toString() + "\n");//wypisz z arraya wszytskie elementy po kolei
        System.out.println();//pauza!!!
    }
    public void print2()//wypisz po kolei czyli to samo ale utrudnione
    {
        for(int i = 0; i < nElems; i++)
            System.out.print(get(i).getImie() + " " + get(i).getNazwisko() + " " + get(i).getWiek());
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 1;//deklaracja wieplości początkowej naszej tablicy
        DynArrrayStudent array = new DynArrrayStudent(maxSize);// wywoływanie konstruktora który tworzy nam tablice essa
        Student s1 = new Student("Jan", "Bednarek", 88);//nowi studenci i różne sposoby dodawania studentów
        Student s2 = new Student("Adam", "Szczur", 18);
        Student s3 = new Student("Michał", "Balicki", 28);
        Student s4 = new Student("Krystian", "Bal", 44);
        Student s5 = new Student("Wojtek", "Nowak", 33);
        Student s6 = new Student("Kacper", "Kowalski", 22);
        Student s7 = new Student();
        s7.setImie("Mateusz");
        s7.setNazwisko("Witkowski");
        s7.setWiek(25);
        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);
        array.add(s5);
        array.add(s6);
        array.add(s7);
        array.print();
        array.add(new Student("Kamil", "Puszka", 66));
        System.out.println(array.find(s2));
        System.out.println(array.find2(s5));
        System.out.println(array.find2(new Student("Krystian", "Bal", 44)));
        array.find(s5);
        array.print();
    }
}


class Student
{
    private String imie, nazwisko;
    private int wiek;

    Student(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }
    Student(){}

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
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
