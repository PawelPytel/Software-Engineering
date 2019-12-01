package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.Helpers.WhiteSpace;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

/**
 * Counts key words in a scenario.
 */
public class KeyWordsCounterVisitor implements IVisitor {
    /**
     * Stores the current number of key words found in a scenario.
     */
    public int numberOfKeyWords;

    /**
     * Constructor: sets the starting number of key words.
     */
    public KeyWordsCounterVisitor() {
        numberOfKeyWords = 0;
    }

    /**
     * An empty method, implements IVisitor.
     *
     * @param element --
     */
    public void Visit(Title element) {
    }

    /**
     * An empty method, implements IVisitor.
     *
     * @param element --
     */
    public void Visit(SystemActor element) {
    }

    /**
     * An empty method, implements IVisitor.
     *
     * @param element --
     */
    public void Visit(NormalActor element) {
    }

    /**
     * Checks if the scenario line begins with a key word.
     *
     * @param element Scenario line.
     */
    public void Visit(ScenarioLine element) {
        if (!element.scenarioLine.isEmpty()) {
            String noWhiteSpaceScenarioLine = element.scenarioLine.
                    substring(WhiteSpace.AmountOnFront(element.scenarioLine));
            if (noWhiteSpaceScenarioLine.length() >= 3) {
                if (noWhiteSpaceScenarioLine.substring(0, 4).equals("IF: "))
                    numberOfKeyWords++;
                else if (noWhiteSpaceScenarioLine.length() >= 6) {
                    if (noWhiteSpaceScenarioLine.substring(0, 6).equals("ELSE: "))
                        numberOfKeyWords++;
                    else if (noWhiteSpaceScenarioLine.length() >= 9) {
                        if (noWhiteSpaceScenarioLine.substring(0, 9).equals("FOR EACH "))
                            numberOfKeyWords++;
                    }
                }
            }
        }
    }
}
