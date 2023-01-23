package B.z9_zbior_HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetSet {
    private HashSet<Integer> hsSet;

    public HashSetSet() {
        hsSet = new HashSet<Integer>();
    }

    public HashSet<Integer> getHsSet() {
        return hsSet;
    }
    public int size()
    {
        return hsSet.size();
    }
    public void insert(int elem)
    {
        if(!member(elem)) hsSet.add(new Integer(elem));
    }
    public boolean member(int elem)
    {
        return hsSet.contains(new Integer(elem));
    }
    public boolean delete(int elem)
    {
        if(member(elem)) {
            return hsSet.remove(new Integer(elem));
        }
        return false;
    }
    public HashSetSet union(HashSetSet secondSet)
    {
        HashSetSet summarySet = new HashSetSet();
        Iterator<Integer> iterator = hsSet.iterator();
        while(iterator.hasNext())
        {
            int tempSet = iterator.next().intValue();
            summarySet.insert(tempSet);
        }
        Iterator<Integer> secIter = secondSet.getHsSet().iterator();
        while(secIter.hasNext())
        {
            int temp = secIter.next();
            summarySet.insert(temp);
        }
        return summarySet;
    }
    public HashSetSet intersection(HashSetSet secSet)
    {
        HashSetSet intersectionSet = new HashSetSet();
        Iterator<Integer> iterator = hsSet.iterator();
        while(iterator.hasNext())
        {
            int temp = iterator.next().intValue();
            if(secSet.member(temp)) intersectionSet.insert(temp);
        }
        return intersectionSet;
    }
    public HashSetSet difference(HashSetSet secSet)
    {
        HashSetSet differenceSet = new HashSetSet();
        Iterator<Integer> iterator = hsSet.iterator();
        while(iterator.hasNext())
        {
            int temp = iterator.next();
            if(!secSet.member(temp)) differenceSet.insert(temp);
        }
        return differenceSet;
    }
    public void print()
    {
        Iterator<Integer> iterator = hsSet.iterator();
        while(iterator.hasNext())
        {
            int temp = iterator.next();
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashSetSet hsSet = new HashSetSet();
        hsSet.insert(6);
        hsSet.insert(63);
        hsSet.insert(62);
        hsSet.insert(123);
        hsSet.insert(11);
        hsSet.insert(41);
        hsSet.insert(13);
        hsSet.insert(77);
        hsSet.insert(45);
        hsSet.print();
        HashSetSet hsSet2 = new HashSetSet();
        hsSet2.insert(6);
        hsSet2.insert(63);
        hsSet2.insert(9);
        hsSet2.insert(33);
        hsSet2.insert(12);
        hsSet2.insert(41);
        hsSet2.insert(99);
        hsSet2.insert(65);
        hsSet2.insert(45);
        hsSet2.print();
        hsSet.difference(hsSet2).print();
        hsSet.intersection(hsSet2).print();
        hsSet.union(hsSet2).print();
    }
}
