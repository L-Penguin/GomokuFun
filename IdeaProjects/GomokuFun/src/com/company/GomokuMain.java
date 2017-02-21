package com.company;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by jize.jiang on 17/2/20.
 */
public class GomokuMain extends Applet {

    GomokuBoard gomokuBoard = new GomokuBoard(400, 400,20, 20);

    int[][] whiteInfo;
    int[][] blackInfo;

    public void init() {
        whiteInfo = new int[20][20];
        blackInfo = new int[20][20];

        whiteInfo[5][5] = 1;

        blackInfo[6][6] = 1;
    }

    public void paint(Graphics g) {
        gomokuBoard.draw(g, whiteInfo, blackInfo, 0, 0);
    }

}
