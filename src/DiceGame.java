import java.util.Scanner;

import static java.lang.Math.floor;
import static java.lang.Math.random;

public class DiceGame {
    public static void main(String[] args) {
        var num = startInit();
        var n = 1;
        var record = new int[2];

        while(true) {

            var playerDice = new int[num];
            var comDice = new int[num];

            System.out.println("------------------------------");
            System.out.println( n + "回目のゲーム");

            rollDice(playerDice,num);
            rollDice(comDice,num);

            var playerSum = calcOutput(playerDice,"あなた");
            var comSum = calcOutput(comDice,"コンピュータ");
            var result = resultOutput(playerSum,comSum);
            recordOutput(record,result);

            System.out.println("------------------------------");

            n = newGame(n);
            if(n == 0 ) break;
        }
    }
    public static int calcOutput(int[] num,String name){
        System.out.print(name + "の出た目：");
        for (var i : num) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println();

        var sum = 0;
        for (var i : num) {
            sum += i;
        }
        System.out.println("合計値：" + sum);
        System.out.println();

        return sum;
    }

    public static String resultOutput(int n1,int n2){
        var result = n1 >= n2 ? "あなた" : "コンピュータ";
        System.out.println("結果：" + result + "の勝ちです。");
        System.out.println();

        return result;
    }

    public static void recordOutput(int[] record,String str){
        if (str.equals("あなた")) {
            record[0] += 1;
        } else {
            record[1] += 1;
        }
        System.out.println("戦歴：" + record[0] + "勝" + record[1] + "敗");
        System.out.println();
    }

    public static int startInit(){
        System.out.println("""
                ------------------------------
                サイコロゲームを開始します。
                ------------------------------
                サイコロを振る回数を指定してください。
                """);
        System.out.print("回数：");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();

        return Integer.parseInt(s1);
    }

    public static void rollDice(int[] num, int n){
        for (var i = 0; i < n; i++) {
            num[i] = (int) floor(random() * 6) + 1;
        }
    }

    public static int newGame(int n){
        System.out.println("ゲームを続けますか？(y/n)");
        var sc = new Scanner(System.in);
        var more = sc.nextLine();

        if (more.equals("y")) {
            return n + 1;
        } else {
            System.out.println("サイコロゲームを終了します。");
            return 0;
        }
    }
}
