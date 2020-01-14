package pl.put.poznan.sqc.visitors;

import org.junit.*;
import pl.put.poznan.sqc.controller.KeyWordsCounterController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ScenarioStepCounterVisitorTest {

    private ScenarioStepCounterVisitor visitor;

    @Before
    public void setUp(){
        visitor=new ScenarioStepCounterVisitor();
    }
    @Test
    public void testTitle(){
        Title title = new Title();
        title.title = "Dodanie ksiazki";

        visitor.Visit(title);
        assertEquals(1,visitor.numberOfSteps);
    }

    @Test
    public void testTitleNull(){
        Title title = new Title();
        title.title = "";

        visitor.Visit(title);
        assertEquals(0,visitor.numberOfSteps);
    }

    @Test
    public void testNormalActors(){
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";

        visitor.Visit(normalActor);
        assertEquals(1,visitor.numberOfSteps);
    }

    @Test
    public void testNormalActorsNull(){
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "";

        visitor.Visit(normalActor);
        assertEquals(0,visitor.numberOfSteps);
    }

    @Test
    public void testMoreNormalActors(){
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";
        NormalActor normalActor1 = new NormalActor();
        normalActor1.normalActor = "Olek";

        visitor.Visit(normalActor);
        visitor.Visit(normalActor1);
        assertEquals(1,visitor.numberOfSteps);
    }
    @Test
    public void testSystemActor(){
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "System";

        visitor.Visit(systemActor);
        assertEquals(1,visitor.numberOfSteps);
    }
    @Test
    public void testSystemActorNull(){
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "";

        visitor.Visit(systemActor);
        assertEquals(0,visitor.numberOfSteps);
    }
    @Test
    public void testScenarioLineNull(){
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="";

        visitor.Visit(scenarioLine);
        System.out.println(visitor.numberOfSteps);
        assertEquals(0,visitor.numberOfSteps);
    }
    @Test
    public void testScenarioLine(){
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine =" some random words";

        visitor.Visit(scenarioLine);
        System.out.println(visitor.numberOfSteps);
        assertEquals(1,visitor.numberOfSteps);
    }
    @Test
    public void testTwoScenarioLine(){
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine =" some random words";

        visitor.Visit(scenarioLine);
        visitor.Visit(scenarioLine);
        assertEquals(2,visitor.numberOfSteps);
    }
    @Test
    public void testMoreScenarioLine(){
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine =" some random words";

        visitor.Visit(scenarioLine);
        visitor.Visit(scenarioLine);
        visitor.Visit(scenarioLine);
        assertEquals(3,visitor.numberOfSteps);
    }

    @Test
    public void testTitleAndNormalActors(){
        Title title = new Title();
        title.title = "Dodanie ksiazki";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";

        visitor.Visit(title);
        visitor.Visit(normalActor);
        assertEquals(2,visitor.numberOfSteps);
    }

    @Test
    public void testTitleAndNormalActorsAndSystemActors(){
        Title title = new Title();
        title.title = "Dodanie ksiazki";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "System";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        assertEquals(3,visitor.numberOfSteps);
    }

    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine(){
        Title title = new Title();
        title.title = "Dodanie ksiazki";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "System";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine =" some random words";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(4,visitor.numberOfSteps);
    }

    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine2(){
        Title title = new Title();
        title.title = "Dodanie ksiazki";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "System";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(3,visitor.numberOfSteps);
    }
    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine3(){
        Title title = new Title();
        title.title = "Dodanie ksiazki";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "System";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(2,visitor.numberOfSteps);
    }
    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine4(){
        Title title = new Title();
        title.title = "";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "System";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(1,visitor.numberOfSteps);
    }

    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine5(){
        Title title = new Title();
        title.title = "";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(0,visitor.numberOfSteps);
    }
    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine6(){
        Title title = new Title();
        title.title = "";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Actor";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(1,visitor.numberOfSteps);
    }
    @Test
    public void testTitleAndNormalActorsAndSystemActorsAndLine7(){
        Title title = new Title();
        title.title = "";
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Actor";
        SystemActor systemActor = new SystemActor();
        systemActor.systemActor = "";
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine ="Linia";


        visitor.Visit(title);
        visitor.Visit(normalActor);
        visitor.Visit(systemActor);
        visitor.Visit(scenarioLine);
        assertEquals(2,visitor.numberOfSteps);
    }
}