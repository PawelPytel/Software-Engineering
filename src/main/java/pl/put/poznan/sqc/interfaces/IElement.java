package pl.put.poznan.sqc.interfaces;

public interface IElement {
    void accept(IVisitor visitor);
}
