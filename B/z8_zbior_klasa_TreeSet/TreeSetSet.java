package B.z8_zbior_klasa_TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetSet {
    private TreeSet<Integer> tSet;
    TreeSetSet()
    {
        tSet = new TreeSet<Integer>();
    }
    public TreeSet<Integer> gettSet()
    {
        return tSet;
    }
    public int size()
    {
        return tSet.size();
    }
    public boolean member(int elem){
        return tSet.contains(new Integer(elem));
    }
    public void insert(Integer p)
    {
        if(!member(p)) tSet.add(p);
    }
    public boolean delete(Integer p)
    {
        if(member(p)) {tSet.remove(p); return true;}
        return false;
    }
    public TreeSetSet union(TreeSetSet secondSet)//oblicza sumę zbioru bierzącego ze zbirem z parametru metody
    {
        TreeSetSet unionSet = new TreeSetSet();//deklaracja nowa
        Iterator<Integer> iterator = tSet.iterator();//do iteratora se przypisuje wartosci z drzewa
        while(iterator.hasNext())//dopuki w iteratorze są kolejne wartości(przechodzi po całym drzewie)
        {
            Integer tempElem = iterator.next();//tworze chwilowy obiekt z następną osobą
            unionSet.insert(tempElem);//wrzucam go do naszego uniona
        }
        Iterator<Integer> iteratorS = secondSet.gettSet().iterator();//kolejne drzewko ale teraz wartosci z drzewa które podajemy
        while(iteratorS.hasNext())//dopuki ma cos kolejnego
        {
            Integer tempElem = iteratorS.next();//wstaw
            unionSet.insert(tempElem);//wstaw do uniona
        }
        return unionSet;//zwraca wszystkie elementy z obu drzew
    }
    public TreeSetSet insertSection(TreeSetSet secondSet)//zwróci wartosci które się pokrywają w obu drzewach
    {
        TreeSetSet insertSet = new TreeSetSet();
        Iterator<Integer> iterator = tSet.iterator();
        while(iterator.hasNext())
        {
            Integer tempElem = iterator.next();
            if(secondSet.member(tempElem)) insertSet.insert(tempElem);
        }
        return insertSet;
    }
    public TreeSetSet diferenceSection(TreeSetSet secondSet)
    {
        TreeSetSet diferentSet = new TreeSetSet();
        Iterator<Integer> iterator = tSet.iterator();
        while(iterator.hasNext())
        {
            Integer tempPerson = iterator.next();
            if(!secondSet.member(tempPerson)) diferentSet.insert(tempPerson);
        }
        return diferentSet;
    }
    public void print()
    {
        Iterator<Integer> iterator = tSet.iterator();
        while(iterator.hasNext())
        {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeSetSet tsSet = new TreeSetSet();
        tsSet.insert(2);
        tsSet.insert(11);
        tsSet.insert(11);
        tsSet.insert(33);
        tsSet.insert(44);

        TreeSetSet tsSet2 = new TreeSetSet();
        tsSet2.insert(21);
        tsSet2.insert(111);
        tsSet2.insert(11);
        tsSet2.insert(333);
        tsSet2.insert(44);
        tsSet.diferenceSection(tsSet2).print();
        System.out.println("^roznia");
        tsSet.insertSection(tsSet2).print();
        System.out.println("^iloczyn");
        tsSet.union(tsSet2).print();
        System.out.println("^wszytskie");
    }
}

