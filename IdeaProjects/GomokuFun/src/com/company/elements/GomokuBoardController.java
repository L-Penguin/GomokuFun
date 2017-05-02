package com.company.elements;

import com.company.GomokuMain;
import com.company.WJ.Tools;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by jize.jiang on 17/2/23.
 */
public class GomokuBoardController {

    private int mouseX;
    private int mouseY;
    private int axisX;
    private int axisY;
    private boolean legalMove = true;

    private GomokuBoard gomokuBoard;

    private int[][] boardInfo;
    private String winner = "none";

    public GomokuBoardController(int _axisX, int _axisY, int _sizeX, int _sizeY, int _numberOfGridsX, int _numberOfGridsY) {
        gomokuBoard = new GomokuBoard(_sizeX, _sizeY, _numberOfGridsX, _numberOfGridsY);
        boardInfo = new int[_numberOfGridsX][_numberOfGridsY];
        bigBoardInfo = new int[_numberOfGridsX + 8][_numberOfGridsY + 8];
        axisX = _axisX;
        axisY = _axisY;
    }

    public void draw(Graphics g) {
        gomokuBoard.draw(g, boardInfo, axisX, axisY);
        g.drawString(""+winner, 0,450);
    }

    public void updateBoardInfo(int x, int y, int num) {
        boardInfo[x][y] = num;
    }

    public void updateBoardInfoFromMouseEvent(MouseEvent mouseEvent, int num) {
        readMouse(mouseEvent);
        if (isMouseInRange(mouseEvent)) {
            int i = (int)(Tools.map(mouseX, axisX, axisX + gomokuBoard.getSizeX(), 0, gomokuBoard.getNumberOfGridsX()));
            int j = (int)(Tools.map(mouseY, axisY, axisY + gomokuBoard.getSizeY(), 0, gomokuBoard.getNumberOfGridsY()));


            //num should be either 1 or 2 or 0;

            if (boardInfo[i][j] == 0) {
                legalMove = true;
                bigBoardInfo[i + 5][j + 5] = num;
                boardInfo[i][j] = num;
            } else {
                legalMove = false;
            }
            winner = checkBoardState(i + 5, j + 5);
        }
    }

    public Boolean isLegalMove() {
        return legalMove;
    }

    public void readMouse(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
    }

    public boolean isMouseInRange(MouseEvent mouseEvent) {
        readMouse(mouseEvent);
        if (Tools.isInRange(mouseX, axisX, axisX + gomokuBoard.getSizeX())
                &&
                Tools.isInRange(mouseY, axisY, axisY + gomokuBoard.getSizeY())) {
            return true;
        }
        return false;
    }

    protected void wipeBoard() {
        for (int i = 0; i < boardInfo.length; i++) {
            for (int j = 0; j < boardInfo[0].length; j++) {
                boardInfo[i][j] = 0;
            }
        }
    }

    int[][] bigBoardInfo;

    public String checkBoardState(int i, int j) {
        int winner = 0;

        if (allEqual(getArray1(bigBoardInfo, i, j), bigBoardInfo[i][j],5) || allEqual(getArray2(bigBoardInfo, i, j), bigBoardInfo[i][j],5) || allEqual(getArray3(bigBoardInfo, i, j), bigBoardInfo[i][j],5) || allEqual(getArray4(bigBoardInfo, i, j), bigBoardInfo[i][j],5)) {
            System.out.println(allEqual(getArray1(bigBoardInfo, i, j), bigBoardInfo[i][j], 5));
            winner = bigBoardInfo[i][j];
        }

        switch (winner) {
            case 0:
                return "none";
            case 1:
                return "white wins";
            case 2:
                return "black wins";
            default:
                return "none";
        }
    }

    public boolean allEqual(int[] array, int num,int target) {
        for (int i = 0; i < array.length; i++)
        {
            if (continuousNum(array, num, i) == target)
                return true;
        }
        return false;
    }

    public int continuousNum(int[] array, int num,int index) {
        int current = array[index], count = 0;

        for (int i = index; i < array.length; i++)
        {
            int j = array[i];
            if (j != current)
                break;
            else
                count++;
        }
        if (current == num)
            return count;
        else
            return 0;
    }

    public int[] getArray1(int[][] _array, int x, int y){
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = _array[x][y + i - 4];
        }
        return array;
    }

    public int[] getArray2(int[][] _array, int x, int y){
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = _array[x + i - 4][y];
        }
        return array;
    }

    public int[] getArray3(int[][] _array, int x, int y){
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = _array[x + i - 4][y + i - 4];
        }
        return array;
    }

    public int[] getArray4(int[][] _array, int x, int y){
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = _array[x + 4 - i][y + 4 - i];
        }
        return array;
    }

    protected boolean numInRange(int _num) {
        return Tools.isInRange(_num, 0,2);
    }

    public int[][] getBoardInfo() {
        return boardInfo;
    }

    public class IllegalInputException extends Exception {
        public IllegalInputException(String msg) {
            super(msg);
        }
    }
}
