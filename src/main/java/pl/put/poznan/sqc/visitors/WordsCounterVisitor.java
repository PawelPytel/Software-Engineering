package pl.put.poznan.sqc.visitors;

import pl.put.poznan.sqc.Helpers.WhiteSpace;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

/**
 * Counts steps in a scenario.
 */
public class WordsCounterVisitor implements IVisitor{

    /**
     * Stores the current number of letters found in a scenario.
     */
    private int numberOfWords;

    public int getNumberOfWords() {
        return numberOfWords;
    }

    /**
     * Constructor: sets the starting number of letters.
     */
    public WordsCounterVisitor() {
        numberOfWords = 0;
    }
    /**
     * Increments number of letters if the title is not empty.
     * @param element Title.
     */
    public void Visit(Title element){
        int tmpAmount = AmountWhiteSpace(element.getTitle()) - WhiteSpace.AmountOnFront(element.getTitle());
        if( tmpAmount > numberOfWords)
            numberOfWords = tmpAmount;
    }
    /**
     * Increments number of letters if the System Actor is not empty.
     * @param element SystemActor.
     */
    public void Visit(SystemActor element){
        int tmpAmount = AmountWhiteSpace(element.getSystemActor()) - WhiteSpace.AmountOnFront(element.getSystemActor());

        if( tmpAmount > numberOfWords)
            numberOfWords = tmpAmount;
    }
    /**
     * Increments number of letters if the Normal Actor is not empty.
     * @param element NormalActor.
     */
    public void Visit(NormalActor element){
        int tmpAmount = AmountWhiteSpace(element.getNormalActor()) - WhiteSpace.AmountOnFront(element.getNormalActor());
        if( tmpAmount > numberOfWords)
            numberOfWords = tmpAmount;
    }
    /**
     * Increments number of letters if the Scenario Line is not empty.
     * @param element ScenarioLine.
     */
    public void Visit(ScenarioLine element){
        int tmpAmount = AmountWhiteSpace(element.getScenarioLine()) - WhiteSpace.AmountOnFront(element.getScenarioLine());
        if( tmpAmount > numberOfWords)
            numberOfWords = tmpAmount;
    }


    private int AmountWhiteSpace(String sentence){
        int amount = 0;
        for (int i = 0; i< sentence.length(); i++){
            if(sentence.charAt(i) == ' ')
                amount++;
        }

        if(!sentence.isEmpty() && sentence.lastIndexOf(" ") != sentence.length()-1)
            amount++;

        return amount;
    }
}
