import java.util.Random;

public class FunctionCalculator {
    public static void main(String[] args) {
        Random ran = new Random();
        Points[] trainingSet = new Points[100];
        for (int i = 0; i < trainingSet.length; i++) {
            trainingSet[i]= new Points();
        }
        for (int i=0;i<100;i++) {
          System.out.println( trainingSet[i].x+ " "+trainingSet[i].y+ " " +trainingSet[i].answer);

        }


        int tmp[]=  new int [100];
        int inputs[]={0,0,0};
        double[] weights = new double[3];
        Main.assignWeight(weights);
        Perceptron p = new Perceptron(inputs);
        int count=0;
        while(count!=100){
            for (int i = 0; i < trainingSet.length; i++) {
                inputs[0]=trainingSet[i].x;
                inputs[1] =trainingSet[i].y;
                p.input=inputs;
               // System.out.println(p.sumInputFunction(inputs, weights));
                if(p.stepFunction(p.sumInputFunction(inputs, weights))!= trainingSet[i].answer){
                   weights=p.deltaWeight(weights, inputs,trainingSet[i].answer, p.stepFunction(p.sumInputFunction(inputs, weights)));
                   count=0;
                   break;
                }
                else{
                    tmp[i]= p.stepFunction(p.sumInputFunction(inputs, weights));
                    count++;
                }
            }
            System.out.println(count);
        }
        for (int i = 0; i < trainingSet.length; i++) {
            if(trainingSet[i].answer!=tmp[i]){
                System.out.println("get fucked");
            }
            else{System.out.println("you good mf");}
        }
    }
    
}
