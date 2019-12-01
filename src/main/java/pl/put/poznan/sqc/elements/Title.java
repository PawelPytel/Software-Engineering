package pl.put.poznan.sqc.elements;

import pl.put.poznan.sqc.interfaces.IElement;
import pl.put.poznan.sqc.interfaces.IVisitor;
import pl.put.poznan.sqc.interfaces.IVisitorWithIntParametr;

public class Title implements IElement {
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void accept(IVisitor visitor){
        visitor.Visit(this);
    }
    public void accept(IVisitorWithIntParametr visitor, int parameter){
        visitor.Visit(this, parameter);
    }
}
