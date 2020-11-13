package com.hanshunping.sparsearray;

/**
 * @author Miluo
 * @description 稀疏数组
 **/
public class SparseArray {

    private static int[][] chessArr;

    public static void main(String[] args) {
        //设计：一个五子棋棋盘，用二维数组表示，通过稀疏数组压缩保存数据
        //棋盘行列各位11,黑棋为1，白棋为2，空位为0
        chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        //假设两子，显示棋盘
        System.out.println("原棋盘为：");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //用稀疏数组保存数据
        //获取棋盘大小
        int chessLong = chessArr.length;
        int chessWidth = chessArr[0].length;
        //找出非零数据个数
        int sum = 0 ;
        for (int i = 0; i < chessLong; i++) {
            for (int j = 0; j < chessWidth; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = chessLong;
        sparseArr[0][1] = chessLong;
        sparseArr[0][2] = sum;


        //遍历二维数组将数据存入稀疏数组
        int count = 0;
        for (int i = 0; i < chessLong; i++) {
            for (int j = 0; j < chessWidth; j++) {
                if (chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组为：");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将稀疏数组还原成二维数组
        int chesslong2 = sparseArr[0][0];
        int chessWidth2 = sparseArr[0][1];
        int[][] chessArr2 = new int[chesslong2][chessWidth2];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //打印还原的二维数组
        System.out.println("还原二维数组为：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
