package pl.put.poznan.sqc.interfaces;

public interface IController {

    void Attach(IElement element);

    void Detach(IElement element);

    void Accept(IVisitor visitor);
}
