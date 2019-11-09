package pl.put.poznan.sqc.controller;

import pl.put.poznan.sqc.interfaces.IController;
import pl.put.poznan.sqc.interfaces.IElement;
import pl.put.poznan.sqc.interfaces.IVisitor;

import java.util.ArrayList;

public class ScenarioStepCounterController implements IController {

    public ArrayList<IElement> _elements = new ArrayList<IElement>();

    public void Attach(IElement element){
        _elements.add(element);
    }

    public void Detach(IElement element){
        _elements.remove(element);
    }

    public void Accept(IVisitor visitor){
        for (IElement element: _elements) {
            element.accept(visitor);
        }
    }
}



