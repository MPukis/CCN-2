import java.util.Random;

public class TestPoints {
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
}
