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

        Stack <Integer> myStack = new Stack<>();
        Scanner newScan = new Scanner(expr);
        int finalResult = 0;

        int value1 = 0;
        int value2 = 0;

        while (newScan.hasNext()) {

            if(newScan.next().equals("+")){
                value1 = myStack.pop();
                value2 = myStack.pop();
                finalResult = finalResult + value1 + value2;
             }
            if(newScan.next().equals("-")){
                value1 = myStack.pop();
                value2 = myStack.pop();
                finalResult = finalResult + (value1 - value2);
            }
            if(newScan.next().equals("/")){
                value1 = myStack.pop();
                value2 = myStack.pop();
                finalResult = finalResult + (value1/value2);
            }
            if(newScan.next().equals("*")){
                value1 = myStack.pop();
                value2 = myStack.pop();
                finalResult = finalResult + (value1*value2);
            }
            else{
                int num = Integer.parseInt(newScan.next());
                myStack.push(num);
                System.out.print(num);
            }



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
