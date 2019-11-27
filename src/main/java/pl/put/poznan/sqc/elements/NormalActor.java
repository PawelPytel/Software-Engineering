package pl.put.poznan.sqc.elements;

import pl.put.poznan.sqc.interfaces.IElement;
import pl.put.poznan.sqc.interfaces.IVisitor;

/**
 * @author
 * JA
 * */

public class NormalActor implements IElement {
    public String normalActor;

    public void accept(IVisitor visitor){
        visitor.Visit(this);
    }
}
