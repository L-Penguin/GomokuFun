package com.company.elements;

import java.awt.*;

/**
 * Created by jize.jiang on 17/2/23.
 */
public class GomokuBoardController {

    private GomokuBoard gomokuBoard;

    private int[][] boardInfo;

    public GomokuBoardController(int _sizeX, int _sizeY, int _numberOfGridsX, int _numberOfGridsY) {
        gomokuBoard = new GomokuBoard(_sizeX, _sizeY, _numberOfGridsX, _numberOfGridsY);
        boardInfo = new int[_numberOfGridsX][_numberOfGridsY];
    }

    public void draw(Graphics g, int axisX, int axisY) {
        gomokuBoard.draw(g, boardInfo, axisX, axisY);
    }

    public void updateBoardInfo(int x, int y, int num) {
        boardInfo[x][y] = num;
    }

    public int[][] getBoardInfo() {
        return boardInfo;
    }
}
