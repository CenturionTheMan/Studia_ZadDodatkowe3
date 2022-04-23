import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Node
 */
public class Node {

    public Person Current;
    public Node Father;
    public Node Partner;

    public List<Node> Children;
    


    public Node() {
        Children = new ArrayList<Node>();
    }

    public Node(Person current, Node father, Node partner)
    {
        Children = new ArrayList<Node>();
        Current = current;
        Father = father;
        Partner = partner;
    }

    public String ShowPerson()
    {
        return Current.Name + " " + Current.SurName;
    }

    public boolean CheckChild(Node child)
    {
        for (Node node : Children) {
            if(node.Compare(child))
            {
                return true;
            }
        }

        return false;
    }

    public boolean Compare(Node toComp)
    {
        if(Current.Name.contentEquals(toComp.Current.Name) && Current.SurName.contentEquals(toComp.Current.SurName)) return true;
        else return false;
    }
}

class Person
{
    public String Name;
    public String SurName;
    public boolean IsMan;

    public Person(String name, String surName) {
        Name = name;
        SurName = surName;
        
        if(name.charAt(name.length()-1) == 'a')
        {
            IsMan = false;
        }
        else
        {
            IsMan = true;
        }
    }
}