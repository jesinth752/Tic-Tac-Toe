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
    StringBuilder row1=new StringBuilder("");
    StringBuilder row2=new StringBuilder("");
     StringBuilder col0=new StringBuilder("");
    StringBuilder col1=new StringBuilder("");
    StringBuilder col2=new StringBuilder("");
 
  
    StringBuilder dia1=new StringBuilder("");
    StringBuilder dia2=new StringBuilder("");
    String r0;
    String r1;
    String r2;
    String d1;
    String d2;
    String c0;
    String c1;
    String c2;
    String cc;
    String plx="Player X Wins !";
    String plo=" Player O Wins !";


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
                    
                    col0.append(t[i][j]);
                } else if (j== 1) {
                     col1.append(t[i][j]);
                } else {
                     col2.append(t[i][j]);
                }

            }
            c0=col0.toString();
            c1=col1.toString();
            c2=col2.toString();

            if (c0.equals("xxx")) {
                bool2=1;

            } else if (c0.equals("ooo")) {
                bool2= 2;
            }
            if (c1.equals("xxx")) {
                bool2= 1;
            }else if (c1.equals("ooo")) {
                bool2= 2;
            }
            if (c2.equals("xxx")) {
                bool2= 1;
            } else if (c2.equals("ooo")) {
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
                   row1.append(t[i][j]);
               } else {
                   row2.append(t[i][j]);
               }

           }
            r0=row0.toString();
            r1=row0.toString();
            r2=row0.toString();
           if (r0.equals("xxx")) {
               bool=1;

           } else if (r0.equals("ooo")) {
               bool= 2;
           }
           if (r1.equals("xxx")) {
              bool= 1;
           }else if (r1.equals("ooo")) {
              bool= 2;
           }
           if (r2.equals("xxx")) {
             bool= 1;
           } else if (r2.equals("ooo")) {
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
                   dia2.append(t[i][j]);
               }
                if(i==j)
               {
                   dia1.append(t[i][j]);
               }
           }
           d2=dia2.toString();
           d1=dia1.toString();
           if (d1.equals("xxx")) {
               bool1=1;

           } else if (d1.equals("ooo")) {
               bool1= 2;
           }
           if (d2.equals("xxx")) {
               bool1= 1;
           }else if (d2.equals("ooo")) {
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
    void resultant(int k)
    {
        if(k==1)
        {
            log.info(plx);
        }
        else if(k==2)
        {
            log.info(plo);
        }
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
                    if (t[i][j] == blocknumber) {
                        t[i][j] = player;
                    }
                }
            }
            displayGame();
            int k=checkRows();
            resultant(k);
            int l=checkDiagonal();
             resultant(l);
            int m=checkCols();
             resultant(m);
          
            if(bool==0 && bool1==0 && bool2==0)
            {
                set++;
            }
            if(set==10)
            {
                log.info("Tie");
            }


            time++;
            row0.delete(0,r0.length());
            row1.delete(0,r1.length());
            row2.delete(0,r2.length());
            dia1.delete(0,d1.length());
            dia2.delete(0,d2.length());
            col0.delete(0,c0.length());
            col1.delete(0,c1.length());
            col2.delete(0,c2.length());
           
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
