import java.util.Scanner;

public class StoneGame {

    public static void main(String[] args){
        System.out.println("""
                ------------------------------
                石取りゲームを開始します。
                石の総数：25個
                １度に取れる石の数：3個
                ------------------------------
                """);

        var stoneNum = 25;
        var putNum = 0;
        var player1 = "プレイヤーA";
        var player2 = "プレイヤーB";
        var turn = 0;

        stoneOutput(stoneNum);

        while(true) {
            turn = 0;
            putNum = playerInput(player1);
            stoneNum -= putNum;
            if(stoneNum <= 0)   break;
            stoneOutput(stoneNum);

            turn = 1;
            putNum = playerInput(player2);
            stoneNum -= putNum;
            if(stoneNum <= 0)   break;
            stoneOutput(stoneNum);
        }
        resultOutput(turn,player1,player2);
    }

    public static void stoneOutput(int num){
        System.out.println("残り:" + num);
        for(var i = 0;i < num;i++){
            System.out.print('●');
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    public static int playerInput(String name){
        System.out.println(name + "の番");
        System.out.println("石の数を入力してください。（1〜3まで入力可能です。）");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var putNum = Integer.parseInt(s1);

        while(!(putNum >= 1 && putNum <= 3)) {
            System.out.println("1~3の間で入力してください。");
            s1 = sc.nextLine();
            putNum = Integer.parseInt(s1);
        }

        return putNum;
    }

    public static void resultOutput(int num,String player1,String player2){
        if(num == 0){
            System.out.println("勝者："+ player2);
        }else{
            System.out.println("勝者：" + player1);
        }
    }
}
