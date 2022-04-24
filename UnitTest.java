import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class UnitTest {
    
    @Test
    public void DoTest()
    {
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Mariola Markowska","Henryk Markowski"),"zona");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Krzysztof Nosarzewski","Agata Nosarzewska"),"maz");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Oliwia Sobel","Marcin Sobel"),"corka");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Oliwia Sobel","Emilia Sobel"),"corka");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Wojciech Sobel","Rafal Sobel"),"syn");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Emilia Markowska","Ryszard Markowski"),"matka");   
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Halina Markowska","Czeslaw Markowski"),"corka");   
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Halina Markowska","Ryszard Markowski"),"siostra"); 
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Joanna Markowska"),"brat");      
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Bogdan Waza"),"wnuk");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Ryszarda Waza"),"wnuk");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Czeslaw Markowski"),"wnuk");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Emilia Markowska"),"wnuk");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Bogdan Waza"),"wnuczka");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Ryszarda Waza"),"wnuczka");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Czeslaw Markowski"),"wnuczka");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Emilia Markowska"),"wnuczka");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Krzysztof Nosarzewski","Oliwia Sobel"),"dziadek");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Agata Nosarzewska","Zuzanna Sobel"),"babcia");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Mariola Markowska","Czeslaw Markowski"),"synowa");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Henryk Markowski","Ryszarda Waza"),"ziec");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Krzysztof Nosarzewski","Bogdan Waza"),"ziec");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Czeslaw Markowski","Mariola Markowska"),"tesc");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Ryszarda Waza","Henryk Markowski"),"tesciowa");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Bogdan Waza","Krzysztof Nosarzewski"),"tesc");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Tomasz Markowski","Halina Markowska"),"bratanek");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Tomasz Markowski","Ryszard Markowski"),"bratanek");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Halina Markowska"),"bratanica");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Ryszard Markowski"),"bratanica");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Joanna Markowska","Agata Nosarzewska"),"siostrzenica");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Tomasz Markowski","Agata Nosarzewska"),"siostrzeniec");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Oliwia Sobel","Magda Sobel"),"siostrzenica");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Zuzanna Sobel","Emilia Sobel"),"siostrzenica");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Wojciech Sobel","Emilia Sobel"),"siostrzeniec");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Wojciech Sobel","Mateusz Nosarzewski"),"siostrzeniec");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Jozefa Szal","Emilia Markowska"),"tesciowa");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Emilia Markowska","Jozefa Szal"),"synowa");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Mariola Markowska","Halina Markowska"),"bratowa");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Mariola Markowska","Ryszard Markowski"),"bratowa");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Tomasz Markowski"),"brat");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Pawel Markowski","Ryszard Markowski"),"bratanek");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Bronislawa Markowska","Halina Markowska"),"babcia");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Feliks Szal","Ryszard Markowski"),"dziadek");
        assertEquals(Prog.GetRelation("D:\\JavaProjects\\Studia\\Zad_dodatkowe_3\\persons.txt","Roman Waza","Agata Nosarzewska"),"dziadek");

    }
    
}

