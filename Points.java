import java.util.Random;

public class Points {
    Random ran = new Random();
    int x;
    int y;
    int answer;
    public Points(){
        x=ran.nextInt(0,100);
        y= ran.nextInt(0,100);
        if(y<=2*x+1){
            answer=1;
        }
        else{answer=0;}
       
    }
}
  
