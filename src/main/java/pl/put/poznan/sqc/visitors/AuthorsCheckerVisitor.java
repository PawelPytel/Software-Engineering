package pl.put.poznan.sqc.visitors;


import pl.put.poznan.sqc.Helpers.WhiteSpace;
import pl.put.poznan.sqc.elements.NormalActor;
import pl.put.poznan.sqc.elements.ScenarioLine;
import pl.put.poznan.sqc.elements.SystemActor;
import pl.put.poznan.sqc.elements.Title;
import pl.put.poznan.sqc.interfaces.IVisitor;

import java.util.ArrayList;

public class AuthorsCheckerVisitor implements IVisitor {
    public ArrayList<String> actors;
    public ArrayList<String> linesWithoutActors;
    public AuthorsCheckerVisitor(){
        actors=new ArrayList<String>();
        linesWithoutActors=new ArrayList<String>();

    }
    @Override
    public void Visit(Title element) {

    }

    @Override
    public void Visit(NormalActor element) {
        actors.add(element.normalActor);
    }

    @Override
    public void Visit(SystemActor element) {
        actors.add(element.systemActor);
    }

    @Override
    public void Visit(ScenarioLine element) {
        if (actors==null){
            linesWithoutActors.add(element.scenarioLine);
            return;
        }
        if(!element.scenarioLine.isEmpty()) {
            String noWhiteSpaceScenarioLine = element.scenarioLine.
                    substring(WhiteSpace.AmountOnFront(element.scenarioLine));
            String words[] = noWhiteSpaceScenarioLine.split(" ");
            if (words != null && words.length > 0) {
                if (words.length > 1) {
                    if (words[0].equals("IF:")|| words[0].equals("ELSE:")) {
                        if (!actors.contains(words[1])) {
                            linesWithoutActors.add(element.scenarioLine);
                        }
                        return;
                    }
                    if (words.length > 2) {
                        if (words[0].equals("FOR") && words[1].equals("EACH")) {
                            if (!actors.contains(words[2])) {
                                linesWithoutActors.add(element.scenarioLine);
                            }
                            return;
                        }
                    }
                }
                if (!actors.contains(words[0])) {
                    linesWithoutActors.add(element.scenarioLine);
                }
                return;
            }
        }
    }
}

