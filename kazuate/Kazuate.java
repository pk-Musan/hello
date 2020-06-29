package hello.kazuate;

import java.util.Random;

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

        // プレイヤーの入力を精査する

        // 勝利判定

        System.out.println( "数当てゲームを終了します．" );
        return;
    }

    private static int getRandom2DigitsNumber() {
        return new Random().nextInt( 90 ) + 10;
    }
}