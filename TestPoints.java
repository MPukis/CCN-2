import java.util.Random;

public class TestPoints {
   static String X ="";
    static String Y ="";
    static TestPoints[] refernceSet= new TestPoints[100];
    Random ran = new Random();
    int x;
    int y;
    int answer;
    public TestPoints(int x, int y){
       this.x=x;
       this.y= y;
        if(y<=2*x+1){
            answer=1;
        }
        else{answer=0;}
       
    }
    public static void main(String[] args) {
        
    
    }
    public static TestPoints[] generateReferenceSet(){
        int count=0;
        for (int i = 0; i < 100; i++) {
            refernceSet[i]=new TestPoints(i, generateCoordinates(i));
            System.out.println(refernceSet[i].x+" "+refernceSet[i].y+" "+refernceSet[i].answer );
        }
        refernceSet[2]=new TestPoints(3, 50);
        refernceSet[3]=new TestPoints(4, 1);

        refernceSet[40]=new TestPoints(41, 90);
        refernceSet[51]=new TestPoints(52, 3);

        refernceSet[90]=new TestPoints(91, 1);
        refernceSet[94]=new TestPoints(95, 200);
        return refernceSet;
    }
    public static int generateCoordinates(int x){
        if(x%2==0){
            return 2*x+2;
        }
        if(x%5==0){
            return 2*x-2;
        }
        else return 2*x+1;
    }
    public static String XToString(TestPoints[] reffernceSet){
        for (int i = 0; i < reffernceSet.length; i++) {
           X+=reffernceSet[i].x+",";
        }
        return X;
    }
    public static String YToString(TestPoints[] reffernceSet){
        for (int i = 0; i < reffernceSet.length; i++) {
           Y+=reffernceSet[i].x+",";
        }
        return Y;
    }
}
