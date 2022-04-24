
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prog {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print(" Podaj imie i nazwisko pierwszej osoby: ");
        String base = scanner.nextLine();

        System.out.print(" Podaj imie i nazwisko drugiej osoby: ");
        String point = scanner.nextLine();

        System.out.println(" " +base +" to " + GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt", base,point) + " dla " + point);
        scanner.close();
    }

    //INIT
    public static String GetRelation(String path, String nameBase, String namePoint)
    {
        Node[] data = ReadFromFile("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt");
        //PrintTree(base);

        Node base = GetNodeByName(data, nameBase);
        Node point = GetNodeByName(data, namePoint);

        return GetRelationInit(data, base, point);
    }

    //IFOKAPILSA
    static String GetRelationInit(Node[] data, Node base, Node point)
    {
        if(base.GetPartner().Compare(point))
        {
            if(base.GetId().IsMan()) return "maz";
            else return "zona";
        }

        if(base.CheckChild(point))
        {
            if(base.GetId().IsMan()) return "ojciec";
            else return "matka";
        }

        if(base.GetFather().Compare(point) || base.GetFather().GetPartner().Compare(point))
        {
            if(base.GetId().IsMan()) return "syn";
            else return "corka";
        }

        if(base.GetFather().CheckChild(point))
        {
            if(base.GetId().IsMan()) return "brat";
            else return "siostra";
        }

        if(point.GetFather().GetFather().Compare(base) || point.GetFather().GetPartner().GetFather().Compare(base)) return "dziadek";

        if(point.GetFather().GetFather().GetPartner().Compare(base) || point.GetFather().GetPartner().GetFather().GetPartner().Compare(base)) return "babcia";

        if(base.GetFather().GetFather().Compare(point) || base.GetFather().GetPartner().GetFather().Compare(point) || base.GetFather().GetFather().GetPartner().Compare(point) || base.GetFather().GetPartner().GetFather().GetPartner().Compare(point))
        {
            if(base.GetId().IsMan()) return "wnuk";
            else return "wnuczka";
        }
        
        if(base.GetPartner().GetFather().CheckChild(point)) return "bratowa";

        if(base.GetPartner().GetFather().Compare(point) || base.GetPartner().GetFather().GetPartner().Compare(point))
        {
            if(base.GetId().IsMan()) return "ziec";
                else return "synowa";
        }

        if(point.GetPartner().GetFather().Compare(base)) return "tesc";
        
        if(point.GetPartner().GetFather().GetPartner().Compare(base)) return "tesciowa";

        if(base.GetFather().GetFather().CheckChild(point) || base.GetFather().GetPartner().GetFather().CheckChild(point))
        {
            if(point.GetFather().CheckChild(base.GetFather()))
            {
                if(base.GetId() == null) return "ERROR";

                if(base.GetId().IsMan()) return "bratanek";
                else return "bratanica";
            }
            else
            {
                if(base.GetId() == null) return "ERROR";

                if(base.GetId().IsMan()) return "siostrzeniec";
                else return "siostrzenica";
            }
        }

        return "ERROR";
    }

    static void PrintTree(Node[] base)
    {
        for (int i = 0; i < base.length; i++) {
            System.out.println(base[i].GetId().FullName +", "+ base[i].GetFather().GetId().FullName+", " + base[i].GetPartner().GetId().FullName);
            
            for (int j = 0; j < base[i].Children.size(); j++) {
                 System.out.println("   -" + base[i].Children.get(j).GetId().FullName);
            }
        }
    }

    //CONVERT FILE
    static Node[] ReadFromFile(String path)
    {
        try {
            var file = new File(path);
            var scanner = new Scanner(file);
            
            List<String[]> rawText = new ArrayList<String[]>();
            List<Node> nodes = new ArrayList<Node>();

            scanner.nextLine();

            //Loop through file
            while(scanner.hasNext())
            {
                String[] split = scanner.nextLine().split(";");
                rawText.add(split);
                
                //Add nodes
                for (int i = 0; i < split.length; i++) {
                    if(split[i].contentEquals("-")) continue;

                    if(GetNodeByName(nodes, split[i]) == null) //skip while already added
                    {
                        nodes.add(new Node(new Person(split[i])));
                    }
                }
            }

            //Loop through all persons again, set father and partner for each
            for (String[] str : rawText) { 
                Node base = GetNodeByName(nodes, str[0]);
                Node father = GetNodeByName(nodes, str[1]);
                Node partner = GetNodeByName(nodes, str[2]);

                if(father == null) father = (str[1].contentEquals("-"))? new Node(new Person("NONE")): new Node(new Person(str[1]));
                if(partner == null) partner = (str[2].contentEquals("-"))? new Node(new Person("NONE")): new Node(new Person(str[2]));

                base.SetFather(father);
                base.SetPartner(partner);
            }

            //Set childern of each node
            for (Node node : nodes) {
                
                if(!node.GetFather().GetId().FullName.contentEquals("NONE"))
                {
                    node.GetFather().Children.add(node);
                }
            }

            scanner.close();

            //converting
            Node[] arr = new Node[nodes.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=nodes.get(i);
            }
            return arr;
        } 
        catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("FILE ERROR!");
            return null;
        }
    }

    static Node GetNodeByName(Node[] nodes, String name)
    {
        for (Node node : nodes) {
            if(node.GetId().FullName.contentEquals(name)) return node;
        }

        return null;
    }

    static Node GetNodeByName(List<Node> nodes, String name)
    {
        for (Node node : nodes) {
            if(node.GetId().FullName.contentEquals(name)) return node;
        }

        return null;
    }
}
