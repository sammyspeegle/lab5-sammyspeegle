import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;



public class Main {

    private static String expr;

    public static void main(String [] args){


        Scanner fileReader = openInputFile();

        Queue<Integer> qu = new LinkedList<Integer>();

        qu.add(17);
        qu.add(24);


        while(fileReader.hasNextLine()){
            System.out.println(fileReader.nextLine());
            evaluatePostfix(fileReader.nextLine());
        }

        Stutter(qu);

    }

    static public Scanner openInputFile(){
        FileInputStream myFile = null;
        Scanner reader = null;

        try {
            myFile = new FileInputStream("src/Postfixexperssions");
            reader = new Scanner (myFile);
        }
        catch (FileNotFoundException e){
            System.out.println("Could not open input file - ending program");
            System.exit(1);
        }

        return reader;
    }

    public static int evaluatePostfix(String expr){
        /*Stack<String> s = new Stack<String>();
        Stack<String> backup = new Stack<String>();

       while(!s.isEmpty()){
            System.out.println(s.pop());
            backup.push(s.pop());
        }

        while (!backup.isEmpty()){
            s.push(backup.pop());
        }*/

        Stack <String> myStack = new Stack<>();
        Scanner newScan = new Scanner(expr);
        int finalResult = 0;

        System.out.println(newScan.next());

        while (newScan.hasNext()) {
        myStack.push(newScan.next());
        }




        return finalResult;

    }


    public static void Stutter(Queue<Integer>q){

        System.out.println(q);

        int size = q.size();

        for (int i = 0; i<size; i++){
            int hello = q.remove();
            q.add(hello);
            q.add(hello);
        }

        System.out.println(q);

    }


}
