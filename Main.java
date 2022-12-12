import java.math.RoundingMode;
import java.util.Random;

public class Main {
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    public static void assignWeight(double[] weight){
        Random r = new Random();
        for (int i = 0; i < weight.length; i++) {
            double randomavlue=-1 + (2) * r.nextDouble();
            System.out.println("weight " +roundAvoid(randomavlue,1));
            weight[i]= roundAvoid(randomavlue,1);
        }
    }
    public boolean check (int answer[],int[] stepResult){
        int count=0;
        for (int i = 0; i < stepResult.length; i++) {
            if (answer[i]==stepResult[i]){
                count++;
            }
            System.out.println("answer : " + answer[i]);
            System.out.println("guess by algo : " + stepResult[i]);
        }
        System.out.println(" ");
        if (count==4){ return true; } else return false;
    }
    public static void main(String[] args) {
        Main main1 = new Main();
        double[] weight = new double[3];
        assignWeight(weight);

        int[] hoe = {0,0};
        int[] hoe1 = {0,1};
        int[] hoe2 = {1,0};
        int[] hoe3 = {1,1};
        Perceptron p1 = new Perceptron(hoe);
        Perceptron p2 = new Perceptron(hoe1);
        Perceptron p3 = new Perceptron(hoe2);
        Perceptron p4 = new Perceptron(hoe3);
        Perceptron[] list = {p1,p2,p3,p4};

        int answers[] = {p1.answer(hoe),p2.answer(hoe1),p3.answer(hoe2),p4.answer(hoe3)};
        int step[] = {p1.stepFunction(p1.sumInputFunction(p1.input,weight)),
                      p2.stepFunction(p2.sumInputFunction(p2.input,weight)),
                      p3.stepFunction(p3.sumInputFunction(p3.input,weight)),
                      p4.stepFunction(p4.sumInputFunction(p4.input,weight))};
//        System.out.println("sum " +p1.sumInputFunction(p1.input,weight));
//        System.out.println("sum " +p2.sumInputFunction(p2.input,weight));
//        System.out.println("sum " +p3.sumInputFunction(p3.input,weight));
//        System.out.println("sum " +p4.sumInputFunction(p4.input,weight));
//
//        System.out.println("step " +p1.stepFunction(p1.sumInputFunction(p1.input,weight)));
//        System.out.println("step " +p2.stepFunction(p2.sumInputFunction(p2.input,weight)));
//        System.out.println("step " +p3.stepFunction(p3.sumInputFunction(p3.input,weight)));
//        System.out.println("step " +p4.stepFunction(p4.sumInputFunction(p4.input,weight)));

//        for (int i = 0; i < answers.length; i++) {
//            if (answers[i]!=step[i]){
//                weight=list[i].deltaWeight(weight,list[i].input,answers);
//                break;
//            }
//        }
//        for (int i = 0; i < weight.length; i++) {
//            System.out.println("weight " +weight[i]);
//        }
        int counter=0;
        //while (counter!=20) {
        while (!main1.check(answers,step)){

//            }
            for (int i = 0; i < answers.length; i++) {
                if (answers[i]!=step[i]){
                    int answer = answers[i];
                    int guessed = list[i].stepFunction(list[i].sumInputFunction(list[i].input,weight));
                    weight=list[i].deltaWeight(weight,list[i].input,answer,guessed);
                    break;
                }
            }
             step[0] = p1.stepFunction(p1.sumInputFunction(p1.input,weight));
             step[1] = p2.stepFunction(p2.sumInputFunction(p2.input,weight));
             step[2] = p3.stepFunction(p3.sumInputFunction(p3.input,weight));
             step[3] = p4.stepFunction(p4.sumInputFunction(p4.input,weight));
             counter++;
                System.out.println(" ");
                System.out.println(counter);
//            for (int i = 0; i < weight.length; i++) {
//                System.out.println(weight[i]);
//            }
//                System.out.println("sum " +p1.sumInputFunction(p1.input,weight));
//                System.out.println("sum " +p2.sumInputFunction(p2.input,weight));
//                System.out.println("sum " +p3.sumInputFunction(p3.input,weight));
//                System.out.println("sum " +p4.sumInputFunction(p4.input,weight));
//                main1.check(answers,step);
//                System.out.println("step " +p1.stepFunction(p1.sumInputFunction(p1.input,weight)));
//                System.out.println("step " +p2.stepFunction(p2.sumInputFunction(p2.input,weight)));
//                System.out.println("step " +p3.stepFunction(p3.sumInputFunction(p3.input,weight)));
//                System.out.println("step " +p4.stepFunction(p4.sumInputFunction(p4.input,weight)));

//                for (int i = 0; i < weight.length; i++) {
//                    System.out.println("weight " +weight[i]);
//                }
        }
        for (int i = 0; i < answers.length; i++) {
            System.out.println("answer : " + answers[i]);
            System.out.println("guess by algo : " + step[i]);
            System.out.println(" ");
        }
    }
}