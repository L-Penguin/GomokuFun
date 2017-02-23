package com.company;

import java.awt.*;

/**
 * Created by jize.jiang on 17/2/21.
 */
public class GomokuBoard extends Grids {

    GomokuBoard(int _sizeX, int _sizeY, int _numberOfGridsX, int _numberOfGridsY) {
        super(_sizeX, _sizeY, _numberOfGridsX, _numberOfGridsY);
    }

    public void draw(Graphics g, int[][] boardState, int axisX, int axisY) {
        super.draw(g, axisX, axisY);

        //draw colors.
        for(int i = 0; i < numberOfGridsX; i++) {
            for(int j = 0; j < numberOfGridsX; j++) {
                switch (boardState[i][j]) {
                    case 1:
                        g.setColor(Color.GRAY);
                        g.fillOval(axisX + i * width, axisY + j * height, width, height);
                        break;
                    case 2:
                        g.setColor(Color.BLACK);
                        g.fillOval(axisX + i * width, axisY + j * height, width, height);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
