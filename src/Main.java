import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.NoSuchElementException;



public class Main {

    private static String expr;

    public static void main(String [] args){


        //scanner to file
        Scanner fileReader = openInputFile();

        //queue
        Queue<Integer> qu = new LinkedList<Integer>();

        //adding integers to queue
        qu.add(17);
        qu.add(24);


        //calling the evaluate post fix when the file has nex line
        while(fileReader.hasNextLine()){
         String line = fileReader.nextLine();
         evaluatePostfix(line);
        }

        //call stutter
        Stutter(qu);

    }


    static public Scanner openInputFile(){
        FileInputStream myFile = null;
        Scanner reader = null;

        //try catch for opening file
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

        //declare variables
        Stack <Integer> myStack = new Stack<>();
        Scanner newScan = new Scanner(expr);
        int finalResult = 0;

        int value1 = 0;
        int value2 = 0;

while(newScan.hasNext()){

    //executes operations
    if(newScan.hasNextInt()){
        int num = newScan.nextInt();
        myStack.push(num);
        System.out.println(num);
    }
    if(newScan.next().equals("+")){
        value2 = myStack.pop();
        value1 = myStack.pop();
        finalResult = value1+value2;
        myStack.push(finalResult);
    }
    if(newScan.next().equals("-")){
        value2 = myStack.pop();
        value1 = myStack.pop();
        finalResult = value1-value2;
        myStack.push(finalResult);
    }
    if(newScan.next().equals("/")){
        value2 = myStack.pop();
        value1 = myStack.pop();
        finalResult = value1/value2;
        myStack.push(finalResult);
    }
    if(newScan.next().equals("*")){
        value2 = myStack.pop();
        value1 = myStack.pop();
        finalResult = value1*value2;
        myStack.push(finalResult);

    }
}




            System.out.println(finalResult);


       return finalResult;

    }


    public static void Stutter(Queue<Integer>q){

        int size = q.size();

        //for loop that removes the first term and adds it back twice
        for (int i = 0; i<size; i++){
            int hello = q.remove();
            q.add(hello);
            q.add(hello);
        }

        System.out.println(q);

    }


}
