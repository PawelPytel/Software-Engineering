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
    public void testNormalActors(){
        NormalActor normalActor = new NormalActor();
        normalActor.normalActor = "Janek";

        visitor.Visit(normalActor);
        assertEquals(1,visitor.numberOfSteps);
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
    public void testScenarioLine(){
        ScenarioLine scenarioLine= new ScenarioLine();
        scenarioLine.scenarioLine =" some random words";

        visitor.Visit(scenarioLine);
        System.out.println(visitor.numberOfSteps);
        assertEquals(1,visitor.numberOfSteps);
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
}