import java.util.Random;

public class Perceptron {
    int[] input=new int[3];
    double learningRate=0.1;
    int step;
    double sum;
  

    Perceptron(int[] twoNodes){
        for (int i = 0; i < 2; i++) {
            this.input[i]=twoNodes[i];
        }
        this.input[2]=1; // bias node
    }
    public double sumInputFunction( int[] input, double[]weight){
        double sum = 0;
        for (int i = 0; i < weight.length; i++) {
            sum+=(weight[i]*input[i]);
        }
        this.sum=sum;
        return sum;
    }
    public int stepFunction(double sum){
        if(sum>=0){
            this.step=1;
            return 1;
        }
        else{
            this.step=0;
            return 0;
        }
    }
    public double[] deltaWeight(double[] weight,int[] input){
        for (int i = 0; i < weight.length; i++) {
            weight[i] = weight[i]-learningRate*(answer(input)-sumInputFunction(input,weight))*input[i];
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

    
}
