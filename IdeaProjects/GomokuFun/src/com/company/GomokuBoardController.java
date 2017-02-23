package com.company;

import java.awt.*;

/**
 * Created by jize.jiang on 17/2/23.
 */
public class GomokuBoardController {

    private GomokuBoard gomokuBoard;

    private int[][] boardInfo;

    GomokuBoardController(int _sizeX, int _sizeY, int _numberOfGridsX, int _numberOfGridsY) {
        gomokuBoard = new GomokuBoard(_sizeX, _sizeY, _numberOfGridsX, _numberOfGridsY);
        boardInfo = new int[_numberOfGridsX][_numberOfGridsY];
    }

    public void draw(Graphics g, int[][] boardInfo, int axisX, int axisY) {
        gomokuBoard.draw(g, boardInfo, axisX, axisY);
    }

    public void updateBoardInfo(int x, int y) {
        boardInfo[x][y] = 1;
    }

    public int[][] getBoardInfo() {
        return boardInfo;
    }
}
