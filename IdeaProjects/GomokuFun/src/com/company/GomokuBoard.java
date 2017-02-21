package com.company;

import java.awt.*;

/**
 * Created by jize.jiang on 17/2/21.
 */
public class GomokuBoard extends Grids {

    GomokuBoard(int _sizeX, int _sizeY, int _numberOfGridsX, int _numberOfGridsY) {
        super(_sizeX, _sizeY, _numberOfGridsX, _numberOfGridsY);
    }

    public void draw(Graphics g, int[][] whiteInfo, int[][] blackInfo, int axisX, int axisY) {
        super.draw(g, axisX, axisY);
        for(int i = 0; i < numberOfGridsX; i++) {
            for(int j = 0; j < numberOfGridsX; j++) {
                g.setColor(Color.GRAY);
                if (whiteInfo[i][j] == 1) {
                    g.fillOval(axisX + i * width, axisY + j * height, width, height);
                }
                g.setColor(Color.black);
                if (blackInfo[i][j] == 1) {
                    g.fillOval(axisX + i * width, axisY + j * height, width, height);
                }
            }
        }
    }

}
