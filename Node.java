import java.util.ArrayList;
import java.util.List;


public class Node {

    private Person id;
    
    private Node father;
    private Node partner;

    public List<Node> Children;
    
    public Person GetId()
    {
        return id;
    }

    public Node GetFather()
    {
        if(father == null)
        {
            Person temp = new Person("NONE");
            Node temp2 = new Node(temp,new Node(),new Node());
            return temp2;
        }

        return father;
    }
    public void SetFather(Node father)
    {
        this.father = father;
    }

    public Node GetPartner()
    {
        if(partner == null)
        {
            Person temp = new Person("NONE");
            Node temp2 = new Node(temp,new Node(),new Node());
            return temp2;
        }
        
        return partner;
    }
    public void SetPartner(Node partner)
    {
        this.partner = partner;
    }

    public Node() {
        Children = new ArrayList<Node>();
    }

    public Node(Person id)
    {
        Children = new ArrayList<Node>();
        this.id = id;
    }

    public Node(Person id, Node father, Node partner)
    {
        Children = new ArrayList<Node>();
        this.id = id;
        this.father = father;
        this.partner = partner;
    }

    public boolean CheckFullName(String toCheck)
    {
        if(toCheck.contentEquals(id.FullName)) return true;
        else return false;
    }

    public boolean CheckChild(Node child)
    {
        if(Children == null) return false;

        if(id.IsMan())
        {
            for (Node node : Children) {
                if(node.Compare(child))
                {
                    return true;
                }
            }

            return false;
        }
        else
        {
            for (Node node : partner.Children) {
                if(node.Compare(child))
                {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean Compare(Node point)
    {
        if(point == null || point.id == null || id == null || !point.GetId().FullName.contentEquals(id.FullName) || point.GetId().FullName.contentEquals("NONE"))
        {
            return false;
        }
        else return true;
    }
}

class Person
{
    public String FullName;

    public Person(String name) {
        FullName = name;
    }

    public boolean IsMan()
    {
        String[] temp = FullName.split(" ");
        
        if(temp[0].charAt(temp[0].length()-1) == 'a')
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}