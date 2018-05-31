package prWordIndex;

import java.util.*;

public abstract class AbstractIndex implements Index {

    protected List<String> statements;

    public AbstractIndex(){
        this.statements = new ArrayList<String>();
        }


    @Override
    public void addSentence(String statement) {
        this.statements.add(statement);
    }

    @Override
    public void consoleIndexPrint(){
        Iterator<String> iterator = statements.iterator();
        while(iterator.hasNext());
        System.out.println(iterator.next());

    }
}
