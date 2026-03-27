import java.util.Scanner;
import java.util.Random;
public class Main{
    static Scanner scanner = new Scanner(System.in);
    static char[] row_1 = {' ',' ',' '};
    static char[] row_2 = {' ',' ',' '};
    static char[] row_3 = {' ',' ',' '};
    static char player1_symbol;
    static char player2_symbol;
    static int[] blocks_filled = new int[9];
    static int index = 0;
    static char[][] total_rows = {row_1,row_2,row_3};
    static boolean printAgain = true;
    static boolean player_1_start =true;
    static boolean player_2_start =true;
    static boolean statusWin = false;
public static void main(String[] args){
    if (printAgain){startingDisplay();}
    while(true){

        while(player_1_start && isBlockRemaining()){
            player_1();
            display_currStatus(total_rows);
        }
        if (player_1_win_check()){
            System.out.println("Player 1 wins !!!");
            display_currStatus(total_rows);
            break;}
        while(player_2_start && isBlockRemaining()){
            player_2();
            display_currStatus(total_rows);
        }
        if (player_2_win_check()) {
            System.out.println("Player 2 wins !!!");
            display_currStatus(total_rows);
            break;}
        checkDraw();
        player_1_start = true;
        player_2_start = true;
        if (!isBlockRemaining()){
            break;
        }

    }
}
    static void startingDisplay(){
        System.out.println("Welcome to Tic-Tac-Toe!\nA strategic two-player game of wit and tactics.\nEnter a number from 1 to 9 to claim your position on the board.");
        int to_print = 1;
        for (int i =0 ;i<3;i++){
            System.out.println(" ___ ___ ___");
            System.out.printf("| %d | %d | %d |\n",to_print,to_print+1,to_print+2);
            System.out.println(" --- --- ---");
            to_print+=3;
        }
        System.out.println("The Game Begins!!!\n=================");
        printAgain = false;
        Position_decision();
        display_currStatus(total_rows);
    }
    static void display_currStatus(char[][] total_rows){
        for (char[] i :total_rows){
            System.out.println(" ___ ___ ___");
            System.out.printf("| %c | %c | %c |\n",i[0],i[1],i[2]);
            System.out.println(" --- --- ---");
        }
    }
    static void player_1() {
        System.out.println("── Player 1's Turn ──\nSelect a position (1-9) to place your symbol on the board:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (validate_entry(choice)) {
            blocks_filled[index] = choice;
            index++;
            switch (choice) {
                case 1 -> {
                    row_1[0] = player1_symbol;
                }
                case 2 -> {
                    row_1[1] = player1_symbol;
                }
                case 3 -> {
                    row_1[2] = player1_symbol;
                }
                case 4 -> {
                    row_2[0] = player1_symbol;
                }
                case 5 -> {
                    row_2[1] = player1_symbol;
                }
                case 6 -> {
                    row_2[2] = player1_symbol;
                }
                case 7 -> {
                    row_3[0] = player1_symbol;
                }
                case 8 -> {
                    row_3[1] = player1_symbol;
                }
                case 9 -> {
                    row_3[2] = player1_symbol;
                }
            }
            player_1_start=false;
        } else {
            player_1_start = true;

        }
}
    static void player_2(){
        System.out.println("── Player 2's Turn ──\nSelect a position (1-9) to place your symbol on the board:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (validate_entry(choice)){
            blocks_filled[index] = choice;
            index++;
            switch(choice) {
                case 1 -> {
                    row_1[0] = player2_symbol;
                }
                case 2 -> {
                    row_1[1] = player2_symbol;
                }
                case 3 -> {
                    row_1[2] = player2_symbol;
                }
                case 4 -> {
                    row_2[0] = player2_symbol;
                }
                case 5 -> {
                    row_2[1] = player2_symbol;
                }
                case 6 -> {
                    row_2[2] = player2_symbol;
                }
                case 7 -> {
                    row_3[0] = player2_symbol;
                }
                case 8 -> {
                    row_3[1] = player2_symbol;
                }
                case 9 -> {
                    row_3[2] = player2_symbol;
                }
            }
            player_2_start =false;
        }
        else {
            player_2_start =true;
            }
    }
    static boolean validate_entry(int given_block){
        if (!(given_block > 0 && given_block < 10)){
            return false;
        }
        for(int i : blocks_filled){
            if (i == given_block){
                return false;
            }
        }
        return true;
    }
    static void Position_decision(){
        Random random = new Random();
        int player_1_symbol = random.nextInt(0,2);
        if (player_1_symbol == 0){
            System.out.println("The fate has decided!\n⚔  Player 1 wields [ X ]\n⚔  Player 2 wields [ O ]\nMay the best player win!");
            player1_symbol = 'X';
            player2_symbol = 'O';

        }
        else {
            System.out.println("The fate has decided!\n⚔  Player 1 wields [ O ]\n⚔  Player 2 wields [ X ]\nMay the best player win!");
            player1_symbol = 'O';
            player2_symbol = 'X';
        }

    }
    static boolean player_1_win_check(){
        return row_1[0] == row_1[1] && row_1[1] == row_1[2] && row_1[2] == player1_symbol ||
                row_2[0] == row_2[1] && row_2[1] == row_2[2] && row_2[2] == player1_symbol ||
                row_3[0] == row_3[1] && row_3[1] == row_3[2] && row_3[2] == player1_symbol ||
                row_1[0] == row_2[1] && row_2[1] == row_3[2] && row_3[2] == player1_symbol ||
                row_1[2] == row_2[1] && row_2[1] == row_3[0] && row_3[0] == player1_symbol ||
                row_1[0] == row_2[0] && row_2[0] == row_3[0] && row_3[0] == player1_symbol ||
                row_1[1] == row_2[1] && row_2[1] == row_3[1] && row_3[1] == player1_symbol ||
                row_1[2] == row_2[2] && row_2[2] == row_3[2] && row_3[2] == player1_symbol;
    }
    static boolean player_2_win_check(){
        return  row_1[0] ==row_1[1] &&row_1[1]== row_1[2] && row_1[2]== player2_symbol||
                row_2[0] ==row_2[1] &&row_2[1]== row_2[2] && row_2[2]== player2_symbol ||
                row_3[0] ==row_3[1] &&row_3[1]== row_3[2] && row_3[2]== player2_symbol ||
                row_1[0] ==row_2[1] &&row_2[1]== row_3[2] && row_3[2]== player2_symbol ||
                row_1[2] ==row_2[1] &&row_2[1]== row_3[0] && row_3[0]== player2_symbol ||
                row_1[0] ==row_2[0] &&row_2[0]== row_3[0] && row_3[0]== player2_symbol ||
                row_1[1] ==row_2[1] &&row_2[1]== row_3[1] && row_3[1]== player2_symbol ||
                row_1[2] ==row_2[2] &&row_2[2]== row_3[2] && row_3[2]== player2_symbol ;

    }
    static void checkDraw(){
        boolean proceedCheck = true;
        for (int i:blocks_filled){
            if (i == 0) {proceedCheck = false;break;}}
        if(proceedCheck){
            if (!player_1_win_check() && !player_2_win_check()){System.out.println("The game ends Here Match Draw!!");}
        }
    }
    static boolean isBlockRemaining(){
        int blocksLeft =0;
        for (int i:blocks_filled){
            if (i == 0) {
                blocksLeft++;
            }
        }
        return blocksLeft != 0;
    }
}
