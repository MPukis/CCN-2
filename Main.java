import java.util.Random;

public class Main {
    public static void assignWeight(double[] weight){
        Random r = new Random();
        for (int i = 0; i < weight.length; i++) {
            double randomavlue=-1 + (2) * r.nextDouble();
            System.out.println("weight " +randomavlue);
            weight[i]= randomavlue;
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
        System.out.println("sum " +p1.sumInputFunction(p1.input,weight));
        System.out.println("sum " +p2.sumInputFunction(p2.input,weight));
        System.out.println("sum " +p3.sumInputFunction(p3.input,weight));
        System.out.println("sum " +p4.sumInputFunction(p4.input,weight));

        System.out.println("step " +p1.stepFunction(p1.sumInputFunction(p1.input,weight)));
        System.out.println("step " +p2.stepFunction(p2.sumInputFunction(p2.input,weight)));
        System.out.println("step " +p3.stepFunction(p3.sumInputFunction(p3.input,weight)));
        System.out.println("step " +p4.stepFunction(p4.sumInputFunction(p4.input,weight)));

        for (int i = 0; i < answers[i]; i++) {
            if (answers[i]!=step[i]){
                weight=list[i].deltaWeight(weight,list[i].input);
                break;
            }
        }
        for (int i = 0; i < weight.length; i++) {
            System.out.println("weight " +weight[i]);
        }

//        while (!main1.check(answers,step)){
//            for (int i = 0; i < answers[i]; i++) {
//                if (answers[i]!=step[i]){
//                    weight=list[i].deltaWeight(weight,list[i].input);
//                }
//            }
//             answers[0] = p1.answer(hoe);
//             answers[1] = p2.answer(hoe1);
//             answers[2] = p3.answer(hoe2);
//             answers[3] = p4.answer(hoe3);
//             step[0] = p1.stepFunction(p1.sumInputFunction(p1.input,weight));
//             step[1] = p2.stepFunction(p2.sumInputFunction(p2.input,weight));
//             step[2] = p3.stepFunction(p3.sumInputFunction(p3.input,weight));
//             step[3] = p4.stepFunction(p4.sumInputFunction(p4.input,weight));
//        }
        for (int i = 0; i < answers.length; i++) {
            System.out.println("answer : " + answers[i]);
            System.out.println("guess by algo : " + step[i]);
        }
    }
}