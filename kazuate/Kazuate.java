package hello.kazuate;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kazuate {
    // プログラムが設定するランダムな2桁の正の整数
    private static int randomNumber;

    // プレイヤーが数値を入力できる回数
    private static final int PLAY_NUM = 5;

    /**
     * メイン関数
     */
    public static void main( String[] args ) {
        System.out.println( "数当てゲームを始めます．" );
        System.out.println( "5回以内に当ててください．" );
        System.out.println( "----------------------------------" );

        // ランダムな数値を決定する
        randomNumber = getRandom2DigitsNumber();

        // プレイヤーの入力を受ける
        InputStreamReader inputStream = new InputStreamReader( System.in );
        BufferedReader bufferedReader = new BufferedReader( inputStream );

        int i = 0;
        while ( i < PLAY_NUM ) {
            System.out.println( i+1 + "回目" );
            System.out.println( "2桁の正の整数を入力してください．" );
            
            int predictNum = 0;
            try {
                predictNum = Integer.parseInt( bufferedReader.readLine() );
            } catch (Exception e) {
                System.out.println( "数値入力の際にエラーが発生しました．" );
                System.out.println( "数当てゲームを終了します．" );
                System.out.println( "----------------------------------" );
                break;
            }

            // プレイヤーの入力を精査する

            // 勝利判定
        }

        System.out.println( "数当てゲームを終了します．" );
        return;
    }

    private static int getRandom2DigitsNumber() {
        return new Random().nextInt( 90 ) + 10;
    }
}