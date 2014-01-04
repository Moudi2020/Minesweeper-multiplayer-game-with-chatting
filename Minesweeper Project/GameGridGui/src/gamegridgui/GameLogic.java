/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegridgui;

/**
 *
 * @author Mohammed Touban
 */
public class GameLogic {
    
    public boolean succ;
    static int nu_mines=15;
    static int number_flags=nu_mines;
    static int [][] labels=new int[10][10];
    static boolean [][] isopen=new boolean[10][10];
    static boolean [][] isFlag=new boolean[10][10];
    public GameLogic()
    {
        succ=false;
        number_flags=nu_mines;
        for(int i=0;i<10;i++) 
        { 
            for(int j=0;j<10;j++) 
            {
                labels[i][j]=0;
                isopen[i][j]=false;
                isFlag[i][j]=false;
            }
        }
        int mines=nu_mines;
        while(mines>0)
        {
            int x=(int) Math.floor ( Math.random ( ) * 10 );
            int y=(int) Math.floor ( Math.random ( )* 10 );
            if(labels[x][y] != -1)
            {
                labels[x][y] = -1;
                mines--;
            }

        }

    }
    public void new_game()
    {
        succ=false;
        number_flags=nu_mines;
        for(int i=0;i<10;i++) 
        { 
            for(int j=0;j<10;j++) 
            {
                labels[i][j]=0;
                isopen[i][j]=false;
                isFlag[i][j]=false;
            }
        }
        int mines=nu_mines;
        while(mines>0)
        {
            int x=(int) Math.floor ( Math.random ( ) * 10 );
            int y=(int) Math.floor ( Math.random ( )* 10 );
            if(labels[x][y] != -1)
            {
                labels[x][y] = -1;
                mines--;
            }

        }
    }
    public int get_label(int i, int j)
    {
        return labels[i][j];
    }
    public int get_flags()
    {
        return number_flags;
    }
    public boolean get_isopen(int i, int j)
    {
        return isopen[i][j];
    }
    public void set_isopen(int i, int j)
    {
        isopen[i][j]=true;
    }
    public boolean get_isFlag(int i, int j)
    {
        return isFlag[i][j];
    }
    public void set_isFlag(int i, int j)
    {
        if(!isFlag[i][j]&&number_flags>0) {
            isFlag[i][j]=true;
            number_flags--;
        }
        else if(isFlag[i][j]) {
            isFlag[i][j]=false;
            number_flags++;
        }
    }
    public void issucc()
    {
        int sum=0;
        for(int i=0;i<10;i++)
          for(int j=0;j<10;j++)
              if(!isopen[i][j])
                  sum++;
        if(sum==nu_mines)
            succ=true;
    }
    public boolean openCell(int i, int j)
    {
        if(i<0||i>9||j<0||j>9||isFlag[i][j])
            return false;
        if(isopen[i][j])
            return true;
        isopen[i][j]=true;
        if(i>0)
            if(labels[i-1][j]==-1)
                labels[i][j]++;
        if(i>0&&j>0)
            if(labels[i-1][j-1]==-1)
                labels[i][j]++;
        if(j>0)
            if(labels[i][j-1]==-1)
                labels[i][j]++;
        if(i<9&&j>0)
            if(labels[i+1][j-1]==-1)
                labels[i][j]++;
        if(i<9)
            if(labels[i+1][j]==-1)
                labels[i][j]++;
        if(i<9&&j<9)
            if(labels[i+1][j+1]==-1)
                labels[i][j]++;
        if(j<9)
            if(labels[i][j+1]==-1)
                labels[i][j]++;
        if(i>0&&j<9)
        if(labels[i-1][j+1]==-1)
            labels[i][j]++;
        
       if(labels[i][j]==0)
       {
            openCell( i - 1, j );
            openCell( i - 1, j - 1 );
            openCell( i, j - 1 );
            openCell( i + 1, j - 1 );
            openCell( i + 1, j );
            openCell( i + 1, j + 1 );
            openCell( i , j + 1 );
            openCell( i - 1, j + 1 );
       }         
        return true;

     }                

           
}
