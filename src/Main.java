import static java.lang.Math.floor;
import static java.lang.Math.random;
import static java.sql.Types.NULL;

public class Main {
    public static void main(String[] args) {
        String s = "c+a+b";
        var str = new char[s.length()];
        var i = 0;
        var n = 0;
        char temp1 =' ';
        char temp2 = ' ';
        char temp3 = ' ';
        int flag=0;
        while(i < s.length()) {
            if(s.charAt(i) == '+' || s.charAt(i) == '-' ){
                if(temp2 == '*' || temp2 == '/'){
                    str[i-n] = temp2;
                    temp2 = ' ';

                }else {
                    str[i-n] = temp1;
                    temp1 = s.charAt(i);
                    n = 0;
                }
               // temp1 = s.charAt(i);
            }else if(s.charAt(i) == '*' || s.charAt(i) == '/') {
                if(temp1 == '+' || temp1 == '-'){
                    temp2 = s.charAt(i);
                }else{
                    str[i-n] = temp2;
                    temp2 = s.charAt(i);
                    n = 0;
                }
                n += 1;
            }else{
                str[i - n] = s.charAt(i);
            }
            i++;
        }
        var cnt =0;
        for(var k = 0; k< str.length;k++){
            if(str[k] != NULL){
                cnt++;
            }
        }
        //System.out.print(cnt+","+temp1+","+temp2);
        if(temp2 == '*' || temp2 == '/'){
            str[cnt] = temp2;
            cnt++;
        }
        if(temp1 == '+' || temp1 == '-'){
            str[cnt] = temp1;
        }

        for (var k:str){
            System.out.print(k + " ");
        }
    }
}