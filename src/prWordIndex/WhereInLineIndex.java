package prWordIndex;

import java.io.PrintWriter;
import java.util.*;

public class WhereInLineIndex extends AbstractIndex {

    private Map<String, Map<Integer, Set<Integer>>> index;

    public WhereInLineIndex(){
        super();
        index = new TreeMap<String,Map<Integer, Set<Integer>>>();
    }

    @Override
    public void solve (String del){
        Scanner sc = null;
        String word;
        String statement;
        int occurences;
        Set <Integer> number;
        Set<Integer> positionOfWord;
        Map<Integer, Set<Integer>> positionOfLine;
        Iterator<String> iterator = this.statements.iterator();
        int numberOfLine = 1;
        int numberOfWord;
        while (iterator.hasNext()){
            statement = iterator.next();
            sc = new Scanner(statement);
            sc.useDelimiter(del);
            numberOfWord=1;
            while(sc.hasNext()){
                word = sc.next().toLowerCase();
                if (this.index.containsKey(word)){
                    positionOfLine = this.index.get(word);
                    if (positionOfLine.containsKey(numberOfLine)){
                        positionOfWord = positionOfLine.get(numberOfLine);
                        positionOfWord.add(numberOfWord);
                        positionOfLine.put(numberOfLine,positionOfWord);
                        this.index.put(word, positionOfLine);
                    }
                    else {
                        positionOfWord = new HashSet<Integer>();
                        positionOfWord.add(numberOfWord);
                        positionOfLine.put(numberOfLine,positionOfWord);
                        this.index.put(word,positionOfLine);
                    }
                }
                else {
                    positionOfWord = new HashSet<Integer>();
                    positionOfWord.add(numberOfWord);
                    positionOfLine = new TreeMap<Integer, Set<Integer>>();
                    positionOfLine.put(numberOfLine,positionOfWord);
                    this.index.put(word,positionOfLine);
                }
                numberOfWord++;
            }
            numberOfLine++;
        }
    }

    @Override
    public void consoleIndexPrint(){
        for(String word : this.index.keySet()){
            System.out.println(word);
            Map<Integer, Set<Integer>> positionOfLine = this.index.get(word);
            for(int i : positionOfLine.keySet()){
                System.out.println(" " + i + " " + positionOfLine.get(i));
            }
        }
    }

    @Override
    public void indexPrint(PrintWriter pw){
        for(String word : this.index.keySet()){
            pw.println(word);
            Map<Integer, Set<Integer>> positionOfLine = this.index.get(word);
            for(int i : positionOfLine.keySet()){
                pw.println(" " + i + " " + positionOfLine.get(i));
            }
        }
    }
}
