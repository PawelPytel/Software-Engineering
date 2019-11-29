package pl.put.poznan.sqc.controller;

import pl.put.poznan.sqc.interfaces.IController;
import pl.put.poznan.sqc.interfaces.IElement;
import pl.put.poznan.sqc.interfaces.IVisitor;

import java.util.ArrayList;

/**
 *  Prepares data and accepts the given visitor.
 */
public class ScenarioStepCounterController implements IController {
    /**
     * An ArrayList of elements found in a scenario.
     */
    public ArrayList<IElement> _elements = new ArrayList<IElement>();

    /**
     * Adds an element to the elements list.
     * @param element An element.
     */
    public void Attach(IElement element){
        _elements.add(element);
    }
    /**
     * Removes an element from the elements list.
     * @param element An element.
     */
    public void Detach(IElement element){
        _elements.remove(element);
    }

    /**
     * Lets the visitor visit all _elements.
     * @param visitor The given visitor.
     */
    public void Accept(IVisitor visitor){
        for (IElement element: _elements) {
            element.accept(visitor);
        }
    }
}



