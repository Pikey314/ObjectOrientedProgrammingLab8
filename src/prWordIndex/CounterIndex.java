package prWordIndex;

import java.io.PrintWriter;
import java.util.*;

public class CounterIndex extends AbstractIndex {

    private Map<String,Integer> index;

    public CounterIndex(){
        super();
        this.index = new TreeMap<String, Integer>();
    }

    @Override
    public void solve(String del) {
        Scanner sc = null;
        String word;
        String statement;
        int occurences;
        Iterator<String> iterator = this.statements.iterator();
        while (iterator.hasNext()) {
            statement = iterator.next();
            sc = new Scanner(statement);
            sc.useDelimiter(del);
            while (sc.hasNext()){
                word = sc.next().toLowerCase();
                if (this.index.containsKey(word)) {
                    occurences = this.index.get(word) + 1;
                    this.index.put(word, occurences);
                }
                else
                    this.index.put(word,1);

                }

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
