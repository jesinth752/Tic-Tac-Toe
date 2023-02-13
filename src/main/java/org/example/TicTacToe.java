package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class GameFunction
{
    Logger log=Logger.getLogger("com-api-jar");
    Scanner input=new Scanner(System.in);
    StringBuilder gb= new StringBuilder("\n");
    StringBuilder dg= new StringBuilder("\n");
    char [][] t=new char[3][3];
    int time=0;
    int bool=0;
    int bool1=0;
    int bool2=0;
    int set=1;
    char blocknumber;
    char player;
    StringBuilder row0=new StringBuilder("");
    String row1="";
    String row2="";

    String dia2="";
    String dia1="";

    String col0="";
    String col1="";
    String col2="";
    String cc;


    GameFunction() {
        int k = 49;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                t[i][j] = (char) k;
                k = k + 1;
            }
        }
    }
    void gameBoard()
    {
        log.info("X or O");
        log.info("Rules : select the Block Number and then Fill X or O ");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                gb.append(t[i][j]+" ");

            }
           gb.append("\n");

        }
        cc=gb.toString();
        log.info(cc);
    }

    int checkCols()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    col0 = col0 + t[i][j];

                } else if (j== 1) {
                    col1 = col1 + t[i][j];
                } else {
                    col2 = col2 + t[i][j];
                }

            }

            if (col0.equals("xxx")) {
                bool2=1;

            } else if (col0.equals("ooo")) {
                bool2= 2;
            }
            if (col1.equals("xxx")) {
                bool2= 1;
            }else if (col1.equals("ooo")) {
                bool2= 2;
            }
            if (col2.equals("xxx")) {
                bool2= 1;
            } else if (col2.equals("ooo")) {
                bool2= 2;
            }


        }

        return bool2;
    }
   int checkRows() {

       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               if (i == 0) {
                   row0.append(t[i][j]);

               } else if (i == 1) {
                   row1 = row1 + t[i][j];
               } else {
                   row2 = row2 + t[i][j];
               }

           }
           String r0=row0.toString();
           if (r0.equals("xxx")) {
               bool=1;

           } else if (row0.equals("ooo")) {
               bool= 2;
           }
           if (row1.equals("xxx")) {
              bool= 1;
           }else if (row1.equals("ooo")) {
              bool= 2;
           }
           if (row2.equals("xxx")) {
             bool= 1;
           } else if (row2.equals("ooo")) {
              bool= 2;
           }


       }
       return bool;
   }
   int checkDiagonal()
   {
       for (int i=0;i<3;i++)
       {
           for (int j=0;j<3;j++)
           {
               if(i+j==2)
               {
                   dia2=dia2+t[i][j];
               }
                if(i==j)
               {
                   dia1=dia1+t[i][j];
               }
           }
           if (dia1.equals("xxx")) {
               bool1=1;

           } else if (dia1.equals("ooo")) {
               bool1= 2;
           }
           if (dia2.equals("xxx")) {
               bool1= 1;
           }else if (dia2.equals("ooo")) {
               bool1= 2;
           }
       }

       return bool1;
   }
   void displayGame()   {
        dg.append("\n");
       for (int i=0;i<3;i++) {
           for (int j = 0; j < 3; j++) {
               dg.append(t[i][j]+"  ");

           }
         dg.append("\n");
       }
       String dd=dg.toString();
     log.info(dd);
   }
    void fillGameBoard()
    {
        do{

            log.info("Enter Block Number");
            blocknumber=input.next().charAt(0);
            log.info("Enter X or O");
            player=input.next().charAt(0);
            for (int i=0;i<3;i++) {
                for (int j = 0; j < 3; j++) {
                    if (t[i][j] == Blocknumber) {
                        t[i][j] = Player;
                    }
                }
            }
            displayGame();

            if(checkRows()==1)
            {
                log.info("Player X Wins !");
                break;
            }
            else if(checkRows()==2)
            {
                log.info(" Player O Wins !");
                break;
            }
            if(checkDiagonal()==1)
            {
                log.info("Player X Wins !");
                break;
            }
            else if(checkDiagonal()==2)
            {
                log.info("Player O Wins !");
                break;
            }
            if(checkCols()==1)
            {
                log.info("Player X Wins !");
                break;
            }
            else if(checkCols()==2)
            {
                log.info("Player O Wins !");
                break;
            }
            if(bool==0 && bool1==0 && bool2==0)
            {
                set++;
            }
            if(set==10)
            {
                log.info("Tie");
            }


            time++;
            row0.delete(0,r.length());
            row1="";
            row2="";
            dia1="";
            dia2="";
            col0="";
            col1="";
            col2="";
        }while(time!=9);
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        GameFunction gf=new GameFunction();
        gf.gameBoard();
        gf.fillGameBoard();
    }

}
