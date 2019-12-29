import javax.swing.*; 

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Play the game.
 *
 * @author Larry Armstrong
 */
public class Game {

    // properties
    protected JButton [][] board = new JButton[9][9];  // do not change or remove this line

    /**
     * Set up GUI.
     */
    public Game() {

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(9,9,2,2));
        Container window = frame.getContentPane();
        window.setBackground(Color.black);

        try {
            Scanner S = new Scanner(new File("initial.txt"));

            for (int column = 0; column < 9; column++){
                for(int row = 0; row < 9; row++){
                    board[column][row] = new JButton(S.next());
                    board[column][row].setBackground(Color.white);
                    if(board[column][row].getText().equals(".")){
                        board[column][row].setBackground(Color.white);
                    }
                    else{
                        board[column][row].setBackground(Color.gray);
                    }
                    frame.add(board[column][row]);
                    SudokuListener J = new SudokuListener(board[column][row],column,row);
                    board[column][row].addActionListener(J);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("no file\n");
        }





        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

    } // end of constructor

    public boolean buttonCheck(int r, int c){
        for (int a = 0; a < 9; a++){
            if (r != a){
                if (board[r][c].getText().equals(board[a][c])){
                    return true;
                }
            }
        }

        return false;
    }

    public class SudokuListener implements ActionListener {


        private JButton Button;

        private int column;

        private int row;

        public SudokuListener(JButton button, int row, int column){
            Button = button;
            this.column = column;
            this.row = row;
        }

        public void actionPerformed(ActionEvent event) {

            Button.getText();
            if (Button.getText() .equals ( ".") || Button.getText() .equals ( " ")){
                Button.setText("1");
            }
            else if (Button.getText() == "1"){
                Button.setText("2");
            }
            else if (Button.getText() == "2"){
                Button.setText("3");
            }
            else if (Button.getText() == "3"){
                Button.setText("4");
            }
            else if (Button.getText() == "4"){
                Button.setText("5");
            }
            else if (Button.getText() == "5"){
                Button.setText("6");
            }
            else if (Button.getText() == "6"){
                Button.setText("7");
            }
            else if (Button.getText() == "7"){
                Button.setText("8");
            }
            else if (Button.getText() == "8"){
                Button.setText("9");
            }
            else if (Button.getText() == "9"){
                Button.setText(" ");
            }
            Button.setBackground(Color.white);
            for (int a = 0; a < 9; a++){
                if (a != row ){
                    if (Button.getText().equals(board[a][column].getText())){
                        Button.setBackground(Color.red);
                    }

                }
            }



            for (int b = 0; b < 9; b++){
                if (b != column){
                    if (Button.getText().equals(board[row][b].getText())){
                        Button.setBackground(Color.red);
                    }

                }

            }

            if(row < 3){
                if(column < 3){

                    for(int i = 0; i < 3; i ++){
                        for(int j = 0; j < 3; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);   
                                }
                            }
                        }
                    }
                }else if (column > 2 && column < 6){
                    for(int i = 0; i < 3; i ++){
                        for(int j = 3; j < 5; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);
                                }
                            }
                        }
                    }
                }else if (column > 5){
                    for(int i = 0; i < 3; i ++){
                        for(int j = 6; j < 9; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);

                                }
                            }
                        }
                    }
                }
            }
            else if(row > 2 && row < 6){
                if(column < 3){
                    for(int i = 3; i < 6; i ++){
                        for(int j = 0; j < 3; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);
                                }
                            }
                        }
                    }
                }else if (column > 2 && column < 6){
                    for(int i = 3; i < 6; i ++){
                        for(int j = 3; j < 6; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);
                                }
                            }
                        }
                    }
                }else if (column > 5){
                    for(int i = 3; i < 6; i ++){
                        for(int j = 6; j < 9; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);

                                }
                            }


                        }

                    }
                }
            }
            else if(row > 5){
                if(column < 3){
                    for(int i = 6; i < 9; i ++){
                        for(int j = 0; j < 3; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);
                                }
                            }
                        }
                    }
                }else if (column > 2 && column < 6){
                    for(int i = 6; i < 9; i ++){
                        for(int j = 3; j < 6; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);
                                }
                            }
                        }
                    }
                }else if (column > 5){
                    for(int i = 6; i < 9; i ++){
                        for(int j = 6; j < 9; j++){
                            if(i != row && j != column){
                                if (Button.getText().equals(board[i][j].getText())){
                                    Button.setBackground(Color.red);
                                }
                            }
                        }
                    }
                }
               
            }
            //Check the board for gameover here
            boolean gameOver = true;
            for(int i=0;i<9;i++){
            	for(int j=0;j<9;j++){
            		if (board[i][j].getBackground().equals(Color.red) || board[i][j].getText().equals(".") || board[i][j].getText().equals(" ")){
                        gameOver = false;
            	}
            }
            
            }
            if(gameOver==true){
            	for(int i=0;i<9;i++){
                	for(int j=0;j<9;j++){
                		board[i][j].setBackground(Color.green);
                	}
            }
        }
    }
    }

}




// end of Game class
