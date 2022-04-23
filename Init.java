import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init {
    public static void main(String[] args) {
        Node[] nodes = ReadFromFile("persons.txt");
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i].ShowPerson() + " |" + nodes[i].Children.size());
        }

        
    }

    static String GetRelation(Node[] dataSet, Person base, Person point)
    {;
        Node baseNode = null;
        Node pointNode = null;
        for (Node node : dataSet) {
            if(ComparePersons(node.Current, base))
            {
                baseNode = node;
            }
            if(ComparePersons(node.Current, point))
            {
                pointNode = node;
            }
            if(pointNode != null && baseNode != null) break;
        }

        if(pointNode == null || baseNode == null)
        {
            System.out.println("ERROR!");
            return null;
        }

        if(baseNode.Partner.Compare(pointNode)){
            if(baseNode.Current.IsMan)
            {
                return "maz";
            }
            else
            {
                return "zona";
            }
        }

        if(baseNode.CheckChild(pointNode))
        {
            return "ojciec";
        }

        if(baseNode.Compare(pointNode.Father.Partner))
        {
            return "matka";
        }

        if(baseNode.Father.Compare(pointNode) || baseNode.Father.Partner.Compare(pointNode))
        {
            if(baseNode.Current.IsMan)
            {
                return "syn";
            }
            else
                return "corka";
        }

        if(baseNode.Father.Compare(pointNode.Father))
        {
            if(baseNode.Current.IsMan)
            {
                return "brat";
            }
            else
                return "siostra";
        }

        if(baseNode.Compare(pointNode.Father.Father) || baseNode.Compare(pointNode.Partner.Father))
        {
            return "dziadek";
        }

        if(baseNode.Compare(pointNode.Father.Father.Partner) || baseNode.Compare(pointNode.Partner.Father.Partner))
        {
            return "babcia";
        }

        if(baseNode.Father.Father.Compare(pointNode) || baseNode.Father.Partner.Father.Compare(pointNode) || baseNode.Father.Father.Partner.Compare(pointNode) || baseNode.Father.Partner.Father.Partner.Compare(pointNode))
        {
            if(baseNode.Current.IsMan)
            {
                return "wnuk";
            }
            else
                return "wnuczka";
        }

        
    }

    static boolean ComparePersons(Person one, Person two)
    {
        if(one.Name == two.Name && one.SurName == two.SurName)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    static void SetupChildrens(Node[] nodes)
    {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
               
                if(nodes[i].Compare(nodes[j].Father))
                {
                    nodes[i].Children.add(nodes[j]);
                }
            }
        }
    }

    //READS FROM FILE
    static Node[] ReadFromFile(String path)
    {
        try {
            var file = new File(path);
            var scanner = new Scanner(file);

            List<Node> nodes = new ArrayList<Node>();

            scanner.nextLine();
            while(scanner.hasNext())
            {
                String[] holder = scanner.nextLine().split(";");

                String[][] supHolder = new String[3][];
                for (int i = 0; i < holder.length; i++) {
                    supHolder[i] = holder[i].split(" ");
                }


                Person[] pers = new Person[3];
                for (int i = 0; i < pers.length; i++) {
                    
                    if(supHolder[i][0].contentEquals("-"))
                    {
                        pers[i] = new Person("None", "None");
                    }
                    else
                    {
                        pers[i] = new Person(supHolder[i][0], supHolder[i][1]);
                    }
                }

                Node temp = new Node();
                temp.Current = pers[0];
                
                temp.Father = new Node();
                temp.Father.Current = pers[1];

                temp.Partner = new Node();
                temp.Partner.Current = pers[2];

                nodes.add(temp);
            }

            scanner.close();

            Node[] arr = new Node[nodes.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nodes.get(i);
            }

            SetupChildrens(arr);

            return arr;
        } catch (Exception e) {
            System.out.println("FILE ERROR!");
            return null;
        }
    }
}
