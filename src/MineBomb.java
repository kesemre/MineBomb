import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineBomb {
    int row,col,bomb;
    String[][] frontField,BombField;
    int[][] BombKordinat;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    boolean isFindBomb = false;
    MineBomb(int row,int col){
        if(row> 0 && col>0){this.row = row;
            this.col = col;
            this.bomb = (row*col)/4;
            this.BombField = new String[row][col];
            this.frontField = new String[row][col];
            this.BombKordinat = new int[bomb][2];
            System.out.println(row+"x"+col+" lık "+this.bomb+" mayınlı"+" oyun oluşturuldu");}
        else{
            System.out.println("Satır veya Sütunlar 1 den küçük verilemez");
        }


    }
    public void gamerField(){
        for(int i=0;i<this.row;i++){
            for (int j=0;j<this.col;j++){
                this.frontField[i][j] = " _ ";
                this.BombField[i][j] = " _ ";
        }}
        for(String[] i: this.frontField){
            for(String j : i){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("==============");

    }
    public void bombField(){
        for (int[] i: this.BombKordinat){
            this.BombField[i[0]][i[1]] = " * ";

        }
        for(String[] i: this.BombField){
            for(String j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public void bombKordinat(){
        for(int i = 0;i<2;i++){
            for(int j=0; j < this.bomb;j++)
            {if (i==0){
                int x = random.nextInt(this.row);
                this.BombKordinat[j][i] = x;
            }
            else { int y = random.nextInt(this.row);
                this.BombKordinat[j][i] = y;}
            }

        }
        for (int[] i :this.BombKordinat){
            System.out.println(Arrays.toString(i));
        }
    }
    public void bombFind(){
        while(!this.isFindBomb){
        System.out.print("Lütfen x kordinatını giriniz: ");
        int x = scanner.nextInt();
        System.out.print("Lütfen y kordinatını giriniz: ");
        int y = scanner.nextInt();
        int [] inputKor = {x,y};
        for(int[]i :this.BombKordinat) {
            if(Arrays.equals(i,inputKor)){
                this.isFindBomb = true;
                break;
            }
        }
        if (isFindBomb){
            System.out.println("Bombaya bastınız.");
            System.out.println("============================");
        }
        else {
            short bombNum = 0;
            if((x!=0 && x!=(this.row-1))&&(y!=0 && y!=this.col-1)){
                for (int i=x-1;i<=x+1  ;i++){
                    for(int j=y-1;j <= y+1;j++){ if(this.BombField[i][j].equals(" * "))
                    { ++bombNum;}

                    }
                }

            } else if (x==0 && (y!=0 && y!=this.col)) {
                for (int i=x;i<=x+1  ;i++){
                    for(int j=y-1;j <= y+1;j++){ if(this.BombField[i][j].equals(" * "))
                    { ++bombNum;}

                    }
                }
            } else if ((x!=0 && x!=(this.row-1)&& y==0)){for (int i=x-1;i<=x+1  ;i++){
                for(int j=y;j <= y+1;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}

                }
            }
            } else if (x==(this.row-1)&&(y!=0 && y!=this.col-1)) {for (int i=x-1;i<=x  ;i++){
                for(int j=y-1;j <= y+1;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}

                }
            }

            } else if ((x!=0 && x!=(this.row-1)) && y==(this.col-1)) {for (int i=x-1;i<=x+1  ;i++){
                for(int j=y-1;j <= y;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}

                }
            }
            } else if (x==0&&y==0) {for (int i=x;i<=x+1  ;i++){
                for(int j=y;j <= y+1;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}

                }
            }
            } else if (x==(this.row-1) && y==(this.col-1) ) {for (int i=x-1;i<=x  ;i++){
                for(int j=y-1;j <= y;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}

                }
            }
            } else if (x==0 && y==(this.col-1)) {for (int i=x;i<=x+1  ;i++){
                for(int j=y-1;j <= y;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}

                }
            }
            }else{for (int i=x-1;i<=x  ;i++){
                for(int j=y;j <= y+1;j++){ if(this.BombField[i][j].equals(" * "))
                { ++bombNum;}
                }
            }}
            System.out.println("============================");

           this.frontField[x][y]=(" "+Short.toString(bombNum)+" ");
            for (String[] a: frontField ){
                for(String b:a){System.out.print(b);}
                System.out.println();

            }
        }


    }}
    public void run(){
        gamerField();
        bombKordinat();
        bombField();
        bombFind();

    }
    }
