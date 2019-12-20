package pl.put.poznan.sqc.visitors;

import org.junit.*;
import pl.put.poznan.sqc.controller.KeyWordsCounterController;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.Title;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KeyWordsCounterVisitorTest {
    private KeyWordsCounterVisitor visitor;
    @Before
    public void setUp(){
        visitor=new KeyWordsCounterVisitor();
    }
    @Test
    public void testElseDetection(){
        ScenarioLine element=mock(ScenarioLine.class);
        when(element.getScenarioLine()).thenReturn("ELSE: some random words");
        KeyWordsCounterVisitor visitor= new KeyWordsCounterVisitor();
        visitor.Visit(element);
        assertEquals(1,visitor.numberOfKeyWords);
        visitor.numberOfKeyWords=0;
    }
    @Test
    public void testIFDetection(){
        ScenarioLine element=mock(ScenarioLine.class);
        when(element.getScenarioLine()).thenReturn("IF: some random words");
        KeyWordsCounterVisitor visitor= new KeyWordsCounterVisitor();
        visitor.Visit(element);
        assertEquals(1,visitor.numberOfKeyWords);
        visitor.numberOfKeyWords=0;
    }
    @Test
    public void testFOREACHDetection(){
        ScenarioLine element=mock(ScenarioLine.class);
        when(element.getScenarioLine()).thenReturn("FOR EACH some random words");
        KeyWordsCounterVisitor visitor= new KeyWordsCounterVisitor();
        visitor.Visit(element);
        assertEquals(1,visitor.numberOfKeyWords);
        visitor.numberOfKeyWords=0;
    }
    @Test
    public void testNoKeyWordDetection(){
        ScenarioLine element=mock(ScenarioLine.class);
        when(element.getScenarioLine()).thenReturn(" some random words");
        KeyWordsCounterVisitor visitor= new KeyWordsCounterVisitor();
        visitor.Visit(element);
        assertEquals(0,visitor.numberOfKeyWords);
        visitor.numberOfKeyWords=0;
    }
    @Test
    public void testAcceptWithKeyWordsCounterVisitor(){
        KeyWordsCounterVisitor mockVisitor=mock(KeyWordsCounterVisitor.class);
        KeyWordsCounterController keyWordsCounterList = new KeyWordsCounterController();
        // Adding all model elements
        keyWordsCounterList.Attach(new Title());
        keyWordsCounterList.Attach(new NormalActor());
        for (int i=0;i<3;i++){
            keyWordsCounterList.Attach(new ScenarioLine());
        }
        keyWordsCounterList.Accept(mockVisitor);
        verify(mockVisitor,times(1)).Visit(any(Title.class));
        verify(mockVisitor,times(1)).Visit(any(NormalActor.class));
        verify(mockVisitor,times(3)).Visit(any(ScenarioLine.class));
    }
}