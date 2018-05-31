package prWordIndex;

import java.io.PrintWriter;
import java.util.*;

public class LineIndex extends AbstractIndex {

    private Map<String, Set<Integer>> index;

    public LineIndex(){
        super();
        index = new TreeMap<String, Set<Integer>>();
    }

    @Override
    public void solve(String del) {
        Scanner sc = null;
        String word;
        String statement;
        int occurences;
        Set <Integer> number;
        Iterator<String> iterator = this.statements.iterator();
        int numberOfLine = 1;
        while (iterator.hasNext()){
            statement = iterator.next();
            sc = new Scanner(statement);
            sc.useDelimiter(del);
            while (sc.hasNext()){
                word = sc.next().toLowerCase();
                if (this.index.containsKey(word)) {
                    number = this.index.get(word);
                    number.add(numberOfLine);
                    this.index.put(word, number);
                }
                else {
                    number = new HashSet<Integer>();
                    number.add(numberOfLine);
                    this.index.put(word, number);
                }
            }
                    numberOfLine++;


        }
    }

    @Override
    public void consoleIndexPrint() {
        for (String word : this.index.keySet())
            System.out.println(word + "  " + this.index.get(word));

    }

    @Override
    public void indexPrint(PrintWriter pw) {
        for (String word : this.index.keySet())
            pw.println(word + "  " + this.index.get(word));

    }

}
