package hello.kazuate;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kazuate {
    // プログラムが設定するランダムな2桁の正の整数
    private static int randomNumber;

    // プレイヤーが数値を入力できる回数
    private static final int PLAY_NUM = 5;

    // メイン関数
    public static void main( String[] args ) {
        System.out.println( "数当てゲームを始めます．" );
        System.out.println( "5回以内に当ててください．" );
        System.out.println( "----------------------------------" );

        // ランダムな数値を決定する
        randomNumber = getRandom2DigitsNumber();

        // プレイヤーの入力を受けるためのreaderを用意
        InputStreamReader inputStream = new InputStreamReader( System.in );
        BufferedReader bufferedReader = new BufferedReader( inputStream );

        // PLAY_NUM回ループ
        int i = 0;
        while ( i < PLAY_NUM ) {
            System.out.println( i+1 + "回目" );
            System.out.println( "2桁の正の整数を入力してください．" );
            
            // プレイヤーが予測する値を取得
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
            if ( validateNum( predictNum ) ) {
                System.out.println( "2桁の正の整数を入力し直してください．" );
                System.out.println( "----------------------------------" );
            } else {
                // 勝利判定
                if ( judgeNumber( predictNum ) ) break;
                i++;
            }
        }

        System.out.println( "数当てゲームを終了します．" );
        return;
    }

    // 10 ~ 99の整数を生成
    private static int getRandom2DigitsNumber() {
        return new Random().nextInt( 90 ) + 10;
    }

    // numが2桁の正の整数かチェック
    private static boolean validateNum( int num ) {
        if ( num >= 10 && num < 100 ) return false;
        else return true;
    }

    // numとrandomNumberの値に応じて当たりはずれ(true/false)を示す
    private static boolean judgeNumber( int num ) {
        if ( num == randomNumber ) {
            System.out.println( "当たり" );
            System.out.println( "----------------------------------" );
            return true;
        } else if ( num < randomNumber ) {
            if ( randomNumber - num >= 20 ) System.out.println( "正解の数より20以上小さいです" );
            else System.out.println( "正解の数より小さいです" );
        } else if ( num > randomNumber ) {
            if ( num - randomNumber >= 20 ) System.out.println( "正解の数より20以上大きいです" );
            else System.out.println( "正解の数より大きいです" );
        }
        System.out.println( "----------------------------------" );
        return false;
    }
}
