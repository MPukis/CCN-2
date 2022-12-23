import java.util.Random;

public class FunctionCalculator {
   static double accuracy=0;
    static int[][] result= new int[100][4];

    public static void main(String[] args) {
//initialzing training set
        Random ran = new Random();
        Points[] trainingSet = new Points[10];
        for (int i = 0; i < trainingSet.length; i++) {
            trainingSet[i]= new Points();
        }
        for (int i=0;i<5;i++) {
          System.out.println( trainingSet[i].x+ " "+trainingSet[i].y+ " " +trainingSet[i].answer);

        }

        // TestPoints[] trainingSet= {new TestPoints(9,11),
        //                         new TestPoints(4,11),
        //                         new TestPoints(2,50),
        //                         new TestPoints(4,7),
        //                         new TestPoints(40,100)};
//setting up the actual loop
    //variable init
        //perceptron and program variables
        int tmp[]=  new int [10];
        int inputs[]={0,0,1};
        //weight init
        double[] weights = new double[3];
        Main.assignWeight(weights);
        //perceptron init
        Perceptron p = new Perceptron(inputs);
        int count=0;
        while(count!=10){
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



    //experiment
    TestPoints.refernceSet=TestPoints.generateReferenceSet();

    Perceptron p5 = new Perceptron(inputs);
    Points[] trainingSet5 = new Points[5];
    for (int i = 0; i < trainingSet5.length; i++) {
        trainingSet5[i]= new Points();
    }
    double[] weights5=fivePoints(trainingSet5);
    measureAccuracy(p5, weights5, TestPoints.refernceSet);
    double accuracy5 =accuracy;
    System.out.println(accuracy5+ "-------------------------------------------------------");

    Perceptron p10 = new Perceptron(inputs);
    Points[] trainingSet10 = new Points[10];
    for (int i = 0; i < trainingSet10.length; i++) {
        trainingSet10[i]= new Points();
    }
    double[] weights10=tenPoints(trainingSet10);
    measureAccuracy(p10, weights10, TestPoints.refernceSet);
    double accuracy10 =accuracy;
    System.out.println(accuracy10+ "-------------------------------------------------------");
    Perceptron p100 = new Perceptron(inputs);
    Points[] trainingSet100 = new Points[100];
    for (int i = 0; i < trainingSet100.length; i++) {
        trainingSet100[i]= new Points();
    }
    double[] weights100=hundredPoints(trainingSet100);
    measureAccuracy(p100, weights100, TestPoints.refernceSet);
    double accuracy100 =accuracy;
    System.out.println(accuracy5+" "+accuracy10+" "+accuracy100);



    }
    public static int[][] measureAccuracy( Perceptron p, double[] weights, TestPoints[] reffenceSet){
        double count=0;
        double totalPoints=reffenceSet.length;
        int inputs[]= new int[3];
        inputs[2]=1;
        for (int i = 0; i < reffenceSet.length; i++) {
            for(int j=0; j<4;j++){
                if(i==100){break;}
                switch (j) {
                    case 0:
                    result[i][j]=reffenceSet[i].x;
                        break;
                    case 1:
                    result[i][j]=reffenceSet[i].y;
                        break;
                    case 2:
                    result[i][j]=reffenceSet[i].answer;
                    break;
                    case 3:
                    inputs[0]=reffenceSet[i].x;
                    inputs[1]=reffenceSet[i].y;
                    result[i][j]=p.stepFunction(p.sumInputFunction(inputs, weights));
                    if(p.stepFunction(p.sumInputFunction(inputs, weights))==reffenceSet[i].answer){
                        count++;
                    }
                    default:
                        break;
                }
               
            }
        }
        accuracy=count/totalPoints;
        return result;
    }
    public static void resultsToString(int[][] result){
        for (int i = 0; i < result.length; i++) {
           
                System.out.println("For point:" +i+" "+ "x:"+result[i][0]+" y:"+result[i][1]+" correct answer:"+result[i][2]+" given guess:"+result[i][3]);
            
        }

    }
public static double[] fivePoints(Points[] trainingSet){
            //setting up the actual loop
                //variable init
                    //perceptron and program variables
                    int inputs[]={0,0,1};
                    //weight init
                    double[] weights = new double[3];
                    Main.assignWeight(weights);
                    //perceptron init
                    Perceptron p = new Perceptron(inputs);
                    int count=0;
                    while(count!=5){
                        for (int i = 0; i < trainingSet.length; i++) {
                            inputs[0]=trainingSet[i].x;
                            inputs[1] =trainingSet[i].y;
                            p.input=inputs;
                            if(p.stepFunction(p.sumInputFunction(inputs, weights))!= trainingSet[i].answer){
                               weights=p.deltaWeight(weights, inputs,trainingSet[i].answer, p.stepFunction(p.sumInputFunction(inputs, weights)));
                               count=0;
                               break;
                            }
                            else{
                                count++;
                            }
                        }
                    }
                    return weights;
                }

 public static double[] tenPoints(Points[] trainingSet){
                    //setting up the actual loop
                        //variable init
                            //perceptron and program variables
                            int inputs[]={0,0,1};
                            //weight init
                            double[] weights = new double[3];
                            Main.assignWeight(weights);
                            //perceptron init
                            Perceptron p = new Perceptron(inputs);
                            int count=0;
                            while(count!=10){
                                for (int i = 0; i < trainingSet.length; i++) {
                                    inputs[0]=trainingSet[i].x;
                                    inputs[1] =trainingSet[i].y;
                                    p.input=inputs;
                                    if(p.stepFunction(p.sumInputFunction(inputs, weights))!= trainingSet[i].answer){
                                       weights=p.deltaWeight(weights, inputs,trainingSet[i].answer, p.stepFunction(p.sumInputFunction(inputs, weights)));
                                       count=0;
                                       break;
                                    }
                                    else{
                                        count++;
                                    }
                                }
                            }
                            return weights;
                        }
public static double[] hundredPoints(Points[] trainingSet){
                            //setting up the actual loop
                                //variable init
                                    //perceptron and program variables
                                    int inputs[]={0,0,1};
                                    //weight init
                                    double[] weights = new double[3];
                                    Main.assignWeight(weights);
                                    //perceptron init
                                    Perceptron p = new Perceptron(inputs);
                                    int count=0;
                                    while(count!=100){
                                        for (int i = 0; i < trainingSet.length; i++) {
                                            inputs[0]=trainingSet[i].x;
                                            inputs[1] =trainingSet[i].y;
                                            p.input=inputs;
                                            if(p.stepFunction(p.sumInputFunction(inputs, weights))!= trainingSet[i].answer){
                                               weights=p.deltaWeight(weights, inputs,trainingSet[i].answer, p.stepFunction(p.sumInputFunction(inputs, weights)));
                                               count=0;
                                               break;
                                            }
                                            else{
                                                count++;
                                            }
                                        }
                                    }
                                    return weights;
                                }
    }
    

