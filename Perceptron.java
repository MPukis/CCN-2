import java.util.Random;

public class Perceptron {
    int[] input=new int[3];
    double[] weight = new double[3];
    double learningRate=0.1;
  

    Perceptron(int[] twoNodes){
        for (int i = 0; i < 2; i++) {
            this.input[i]=twoNodes[i];
        }
        this.input[2]=1; // bias node
        Random r = new Random();
        for (int i = 0; i < weight.length; i++) {
            double randomavlue=-1 + (2) * r.nextDouble();
            System.out.println( "random "+ i + " " +randomavlue);
            weight[i]= randomavlue;
        }
    }
    public double sumInputFunction( int[] input){
        double sum = 0;
        for (int i = 0; i < weight.length; i++) {
            sum+=(weight[i]*input[i]);
        }
        return sum;
    }
    public int stepFunction(double sum){
        if(sum>=0){
            return 1;
        }
        else{
            return 0;
        }
    }
    public double[] deltaWeight(double[] weight,int[] input){
        for (int i = 0; i < weight.length; i++) {
            weight[i] = weight[i]-learningRate*(answer(input)-sumInputFunction(input))*input[i]; 
        }
        return weight;
    }

    public int answer(int[] input){
        for (int i = 0; i < input.length-1; i++) {
            if(input[i]==1 && input[i]==input[i+1]){
                return 1;
            } else return 0;
        }
        return 2;
    }
    public static void main(String[] args) {
        int[] hoe = {0,0};
        int[] hoe1 = {0,1};
        int[] hoe2 = {1,0};
        int[] hoe3 = {1,1};
       Perceptron p1 = new Perceptron(hoe);
        for (int i = 0; i < p1.input.length; i++) {
            System.out.println("inputs" + p1.input[i]);
        }
        System.out.println("sum "+p1.sumInputFunction(p1.input));
        System.out.println("step "+p1.stepFunction(p1.sumInputFunction(p1.input)));
        System.out.println("answer " + p1.answer(hoe));
    }
    
}
