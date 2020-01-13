package pl.put.poznan.sqc.visitors;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.models.ScenarioJSONModel;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccessLevelVisitorTest {

    private AccessLevelPointVisitor visitor;

    @Before
    public void setUp(){
        visitor=new AccessLevelPointVisitor();
    }
    @Test
    public void testTitle(){
        Title title=mock(Title.class);
        when(title.getTitle()).thenReturn("Dodanie ksiazki");

        visitor.Visit(title,0);
        assertTrue(!visitor.scenarioJSONModel.Title.isEmpty());
    }

    @Test
    public void testTitleEmpty(){
        Title title=mock(Title.class);
        when(title.getTitle()).thenReturn("");

        visitor.Visit(title,1);
        assertTrue(visitor.scenarioJSONModel.Title == null);
    }

    @Test
    public void testSystemActors(){
        SystemActor systemActor=mock(SystemActor.class);
        when(systemActor.getSystemActor()).thenReturn("Janek");

        visitor.Visit(systemActor,2);
        assertTrue(!visitor.scenarioJSONModel.SystemActor.isEmpty());
    }
    @Test
    public void testSystemActorsEmpty(){
        SystemActor systemActor=mock(SystemActor.class);
        when(systemActor.getSystemActor()).thenReturn("");

        visitor.Visit(systemActor,2);
        assertTrue(visitor.scenarioJSONModel.SystemActor == null);
    }

    @Test
    public void testNormalActors(){
        NormalActor normalActor=mock(NormalActor.class);
        when(normalActor.getNormalActor()).thenReturn("Janek");

        visitor.Visit(normalActor,2);
        assertTrue(visitor.scenarioJSONModel.ActorsList.size() == 1);
    }

    @Test
    public void testNormalActorsList(){
        NormalActor normalActor=mock(NormalActor.class);
        when(normalActor.getNormalActor()).thenReturn("Janek");

        for(int i=0; i<3; i++)
            visitor.Visit(normalActor,0);
        verify(normalActor, times(6)).getNormalActor();

        assertTrue(visitor.scenarioJSONModel.ActorsList.size() == 3);
    }
    @Test
    public void testNormalActorsEmpty(){
        NormalActor normalActor=mock(NormalActor.class);
        when(normalActor.getNormalActor()).thenReturn("");
        visitor.Visit(normalActor,0);

        verify(normalActor, times(1)).getNormalActor();
    }

    @Test
    public void testScenarioLineEmpty(){
        ScenarioLine scenarioLine=mock(ScenarioLine.class);
        when(scenarioLine.getScenarioLine()).thenReturn("");
        visitor.Visit(scenarioLine,0);
        assertTrue(visitor.scenarioJSONModel.ScenarioLinesList.size() == 0);
    }
    @Test
    public void testScenarioLineZeroLevel(){
        ScenarioLine scenarioLine=mock(ScenarioLine.class);
        when(scenarioLine.getScenarioLine()).thenReturn(" tescik");
        visitor.Visit(scenarioLine,0);
        assertTrue(visitor.scenarioJSONModel.ScenarioLinesList.size() == 0);
    }
    @Test
    public void testScenarioLineFirstLevel(){
        ScenarioLine scenarioLine=mock(ScenarioLine.class);
        when(scenarioLine.getScenarioLine()).thenReturn(" tescik");
        visitor.Visit(scenarioLine,1);
        assertTrue(visitor.scenarioJSONModel.ScenarioLinesList.size() == 0);
    }
    @Test
    public void testScenarioLineSecondLevel(){
        ScenarioLine scenarioLine=mock(ScenarioLine.class);
        when(scenarioLine.getScenarioLine()).thenReturn(" tescik");
        visitor.Visit(scenarioLine,2);
        assertTrue(visitor.scenarioJSONModel.ScenarioLinesList.size() == 1);
    }


}