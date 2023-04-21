import java.util.Scanner;

public class StoneGame {

    public static void main(String[] args){
        System.out.println("プレイするモード(基本課題 → 1,発展課題 → 2)：");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var num = Integer.parseInt(s1);

        if(num == 1){
            basicStoneGame();
        }else if(num == 2){
            developmentStoneGame();
        }else{
            System.out.println("エラーです");
        }

    }

    public static void basicStoneGame(){
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
    }       //基本課題メイン
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


    //発展課題
    public static void developmentStoneGame(){
        var stoneNum = stoneSumInput();
        var onePut =onePutNumInput();
        var putNum = 0;
        var playerName = playerNameInput();
        var playerNum = playerName.length;
        var symbol = stoneSymbolInput();
        var endflag = false;

        var turn = 0;

        stoneOutput(stoneNum,symbol);

        while(true) {
            for(turn = 0;turn < playerNum;turn++){
                putNum = playerInput(playerName[turn],onePut);
                stoneNum -= putNum;
                if(stoneNum <= 0){
                    endflag = true;
                    break;
                }
                stoneOutput(stoneNum,symbol);
            }
            if(endflag) break;
//            turn = 0;
//            putNum = playerInput(playerName[turn],onePut);
//            stoneNum -= putNum;
//            if(stoneNum <= 0)   break;
//            stoneOutput(stoneNum,symbol);
//
//            turn = 1;
//            putNum = playerInput(playerName[turn],onePut);
//            stoneNum -= putNum;
//            if(stoneNum <= 0)   break;
//            stoneOutput(stoneNum,symbol);
        }
        resultOutput(turn,playerName);
    }       //発展課題メイン

    public static int stoneSumInput(){
        System.out.println("石の総数を指定してください。");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var stoneNum = Integer.parseInt(s1);
        while(!(stoneNum >=10 && stoneNum <=100)){
            System.out.println("石の総数を指定してください。(10~100)");
            s1 = sc.nextLine();
            stoneNum = Integer.parseInt(s1);
        }

        return stoneNum;
    }

    public static int onePutNumInput(){
        System.out.println("１度に取れる石の数を指定してください。");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var putNum = Integer.parseInt(s1);
        while(!(putNum >=1 && putNum <=10)){
            System.out.println("１度に取れる石の数を指定してください。(1~10)");
            s1 = sc.nextLine();
            putNum = Integer.parseInt(s1);
        }

        return putNum;
    }

    public static String[] playerNameInput(){
        System.out.println("プレイヤーを指定してください。");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var errorFlag = false;
        String[] name = s1.split(",");
        for (var i = 0; i < name.length; i++) {
            errorFlag |= !(name[i].matches("[a-zA-Z]+"));
        }
        while(errorFlag) {
            System.out.println("再度プレイヤーを指定してください。");
            s1 = sc.nextLine();
            errorFlag = false;
            name = s1.split(",");
            for (var i = 0; i < name.length; i++) {
                errorFlag |= !(name[i].matches("[a-zA-Z]+"));
            }
        }
        return name;
    }

    public static char stoneSymbolInput(){
        System.out.println("石の記号を指定してください。");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var symbol = s1.charAt(0);

        return symbol;
    }

    public static int playerInput(String name,int onePut){
        System.out.println(name + "の番");
        System.out.println("石の数を入力してください。（1〜" + onePut + "まで入力可能です。）");
        var sc = new Scanner(System.in);
        var s1 = sc.nextLine();
        var putNum = Integer.parseInt(s1);

        while(!(putNum >= 1 && putNum <= onePut)) {
            System.out.println("1~" + onePut + "の間で入力してください。");
            s1 = sc.nextLine();
            putNum = Integer.parseInt(s1);
        }

        return putNum;
    }

    public static void stoneOutput(int num,char symbol){
        System.out.println("残り:" + num);
        for(var i = 0;i < num;i++){
            System.out.print(symbol);
        }
        System.out.println();
        System.out.println("------------------------------");
    }

    public static void resultOutput(int num,String ...names){
        System.out.print("勝者：");
        for(var i = 0;i < names.length;i++){
            if(i != num) System.out.print(names[i] + " ");
        }
        System.out.println();
        System.out.println("敗者："+ names[num]);
    }

}
