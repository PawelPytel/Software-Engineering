package pl.put.poznan.sqc.interfaces;

public interface IControllerWithIntParametr {
    void Attach(IElement element);

    void Detach(IElement element);

    void Accept(IVisitorWithIntParametr visitor, int parametr);
}
