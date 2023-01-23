package A.z5_implementacja_drzewa_BST;

import java.util.ArrayList;

public class Drzewko {//klasa definiująca drzewo poszukiwan binarnych
    private DrzewkoNode root;
    Drzewko()
    {
        root = null;
    }
    public DrzewkoNode getRoot()//pobranie roota
    {
        return root;
    }
    public void insert(int elem)//wstawia element essa
    {
        DrzewkoNode newNode = new DrzewkoNode();//nowy wezeł
        newNode.iData = elem;//do wartosci wezla przypisujemy jaka wartosc chcemy wrzucic
        if(root == null) root = newNode;//dla pustego ustawiamy nowy jak roota
        else {//a jak nie jest puste to
            DrzewkoNode curr = root;//ustawiamy currenta na korzeniu
            while(true)
            {
                DrzewkoNode parent = curr;//deklarujemy parenta jako aktualnego currenta
                if(elem < curr.iData)//jesli element do wstawienia jest mniejszy od currenta
                {
                    curr = curr.left;//to idziemy w lewo czyli do mniejszej wartosci niz aktualna
                    if(curr == null)//jesli to niższe juz jest puste to
                    {
                        parent.left = newNode;//wstawiamy tam naszą wartość
                        newNode.parent = parent;//i sutawiamy dla rodzica adnotacje
                        return; //koniec
                    }
                }
                else {//a jesli liczba jest wieksza od aktualnej to przechodzimy na prawą gałąź
                    curr = curr.right;
                    if(curr == null)//jesli juz jest pusta to
                    {
                        parent.right = newNode;//wstawiamy tam nasz element
                        newNode.parent = parent;//ustawiamy adnotacje do rodzica
                        return;
                    }
                }
            }
        }
    }
    public boolean find(int elem)//sprawdzamy czy takie element istnieje
    {
        if(root == null) return false;//jak pusta to po co szukac
        DrzewkoNode curr = root;//ustawiamy currenta na korzeniu
        while(curr.iData != elem)//dopuki current nie bedzie taki jak szukany
        {
            if(elem < curr.iData) curr = curr.left;//jesli szukany element jest mniejszy od aktualnego liscia to idziemy na lewą gałąź
            else curr = curr.right;//a jak jest wiekszy to idziemy na prawą gałąź
            if(curr == null) return false;//jak jest nullem to znaczy ze nie ma takiego elementu
        }
        return true;
    }
    private DrzewkoNode getSuccesor(DrzewkoNode node)//pobranie liczby jakby najbliższej do liczby którą chcemy usunąć
    {
        DrzewkoNode curr = node.right;//ustawiamy na prawo currenta bo potem lecimy ciągle po lewych krawędziach do konca
        while(curr.left != null)//az lewa gałąź sie nie skonczy
        {
            curr = curr.left;//przeskok na kolejną
        }
        return curr;//zwracamy najbliższą liczbe
    }
    private void deleteWithoutChilds(DrzewkoNode curr)//usuwanie bez dzieci
    {
        if(curr == root) root = null;//jak jest to root to usuwamy roota
        else {//a jak nie to
            if (curr.parent.left == curr) curr.parent.left = null;//jak jestes na lewo od rodzica to lewa gałąź rodzica zostaje odcieta
            else curr.parent.right = null;//a jak na prawo to prawa gałąź rodica zostaje ucięta
        }
    }
    private void deleteWithOneLeftChild(DrzewkoNode curr)//lewostronne dziecko
    {
        if(curr == root) root = curr.left;//dziecko zostaje rootem
        else{
            if(curr.parent.left == curr) curr.parent.left = null;//jesli jestes lewą gałęzią rodzica to zostaje ona ucięta
                else curr.parent.right = null;//jak prawą to prawą ucinamy
                curr.left.parent = curr.parent;//lewe dziecko dostaje jako parenta twojego parenta
        }
    }
    private void deleteWithOneRightChild(DrzewkoNode curr)
    {
        if(curr == root) root = curr.right;//dziecko zostaje rootem
        else{
            if(curr.parent.left == curr) curr.parent.left = null;//jesli jestes lewą gałęzią rodzica to zostaje ona ucięta
            else curr.parent.right = null;//jak prawą to prawą ucinamy
            curr.right.parent = curr.parent;//prawe dziecko dostaje jako parenta twojego parenta
        }
    }
    private void deleteWithTwoChilds(DrzewkoNode curr)
    {
        DrzewkoNode succesor = getSuccesor(curr);//szukamy po uciętej wartosci kto ma cie zastąpić
        if(succesor.left == null && succesor.right == null) deleteWithoutChilds(succesor);//jak liczba zastepowana nie ma dzieci to odcinamy połączenia z góry
        else deleteWithOneRightChild(succesor);//succesor juz nie ma lewej gałęzi wiec i tak tu tylko by przeszło uciecie prawego dziecka i to sie dzieje
        succesor.parent = curr.parent;//liczba zastepująca za rodzica dostaje rodzica currenta
        succesor.left = curr.left;//succesro za lewe dziecko przyjmuje dziecko currentaa
        succesor.right = curr.right;//to samo
        if(succesor.left != null) succesor.left.parent = succesor;//jak succesor ma lewe dziecko to to dziecko ustawia succesor na rodzica
        if(succesor.right != null) succesor.right.parent = succesor;//tp samo z prawą
        if(curr.parent.left == curr) curr.parent.left = succesor;//jak current był na lewo to ty idziesz na lewo
        else curr.parent.right = succesor;//tu na prawo
    }
    public boolean delete(int elem)//usuwaine ppolega na opowiednim wywoływaniu powyższych metod
    {
        if(root == null) return false;
        DrzewkoNode curr = root;
        while(curr.iData != elem)
        {
            if(curr.iData > elem) curr = curr.left;
            else curr = curr.right;
            if(curr == null) return false;
        }
        if(curr.left == null && curr.right == null) deleteWithoutChilds(curr);
        else if(curr.left != null & curr.right == null) deleteWithOneLeftChild(curr);
        else if(curr.left == null & curr.right != null) deleteWithOneRightChild(curr);
        else deleteWithTwoChilds(curr);
        return true;
    }
    public void view(DrzewkoNode node, int level)//pokaż drzewko ładnie
    {
        if(node == null) return;//jak puste to koniec
        for(int i = 0; i < level; i++) System.out.print("- ");//który poziom gałęzi tyle kresel
        System.out.println(node.iData);//wypisz liczbe
        view(node.left, level + 1);//przejdz na lewą gałąź
        view(node.right, level + 1);//przejdz na prawą gałąź
    }
    private void copyDrzewkoToArrayList(DrzewkoNode node, ArrayList<DrzewkoNode> nodeListy)//kopiowanie drzewka do tablicy dynamicznej
    {
        if(node.left != null) copyDrzewkoToArrayList(node.left, nodeListy);//jak node ma lewe dziecko to wywołaj znów ale jako lewe dziecko
        nodeListy.add(node);//dodaj najniższą wartość z lewej strony
        if(node.right != null) copyDrzewkoToArrayList(node.right, nodeListy);//jak prawo ma gałąź to wykonaj i spawdz najpierw czy ma lewą gałąź
    }
    public void print()//wypisz wszystkie elementy
    {
        ArrayList<DrzewkoNode> nodeList = new ArrayList<>();//deklaracja pystej listy typu naszeDrzewko
        if(root != null)//jak root nie jest pusty
        {
            copyDrzewkoToArrayList(root, nodeList);//wykonaj wyższą metode
        }
        System.out.print("bst: ");
        int i = 0;
        while(nodeList.size() > i)//dopuki i nie przekroczy wielkosci naszej listy
        {
            System.out.print(nodeList.get(i) + " ");//wpyisuje kolejne elementy naszej listy
            i++;//powieksza index
        }
        nodeList.clear();//wyczyszczenie listy po wszytskim
        System.out.println();
    }

    public static void main(String[] args) {
        Drzewko drzewo = new Drzewko();
        drzewo.insert(50);
        drzewo.insert(11);
        drzewo.insert(33);
        drzewo.insert(44);
        drzewo.insert(55);
        drzewo.insert(66);
        drzewo.insert(77);
        drzewo.insert(58);
        drzewo.insert(69);
        drzewo.insert(22);
        drzewo.insert(9);
        drzewo.insert(75);
        drzewo.insert(51);
        drzewo.print();
        drzewo.print();
        drzewo.view(drzewo.getRoot(), 0);
        drzewo.delete(51);
        drzewo.delete(69);
        drzewo.delete(44);
        drzewo.view(drzewo.getRoot(), 0);

    }
}
class DrzewkoNode {
    public int iData;
    public DrzewkoNode parent;
    public DrzewkoNode left;//lewy potomek
    public DrzewkoNode right;
    DrzewkoNode()
    {
        iData = 0;
        parent = null;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "{" + iData + "}";
    }
}
