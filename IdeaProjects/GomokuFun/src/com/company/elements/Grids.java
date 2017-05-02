package com.company.elements;

import java.awt.*;

/**
 * Created by jize.jiang on 17/1/5.
 */
public class Grids {

    protected final Color DEFAULTCOLOR = Color.BLACK;

    protected int sizeX;
    protected int sizeY;
    protected int numberOfGridsX;
    protected int numberOfGridsY;
    protected int width;
    protected int height;

    Grids(int _sizeX, int _sizeY, int _numberOfGridsX, int _numberOfGridsY) {
        sizeX = _sizeX;
        sizeY = _sizeY;
        numberOfGridsX = _numberOfGridsX;
        numberOfGridsY = _numberOfGridsY;
        width = sizeX / numberOfGridsX;
        height = sizeY / numberOfGridsY;
    }

    public void draw(Graphics g, int axisX, int axisY) {
        g.setColor(DEFAULTCOLOR);
        for (int i = 0; i <= numberOfGridsY; i++) {
            g.drawLine(axisX, axisY + i * height, axisX + sizeX, axisY + i * height);
        }
        for (int j = 0; j <= numberOfGridsX; j++) {
            g.drawLine(axisX + j * width, axisY, axisX + j * width, axisY + sizeY);
        }
    }

    public void draw(Graphics g, Color[][] gridsColorInfo, int axisX, int axisY) {
        g.setColor(DEFAULTCOLOR);
        for (int i = 0; i <= numberOfGridsY; i++) {
            g.drawLine(axisX, axisY + i * height, axisX + sizeX, axisY + i * height);
        }
        for (int j = 0; j <= numberOfGridsX; j++) {
            g.drawLine(axisX + j * width, axisY, axisX + j * width, axisY + sizeY);
        }

        //color
        for(int i = 0; i <= numberOfGridsX; i++) {
            for(int j = 0; j <= numberOfGridsX; j++) {
                if (gridsColorInfo != null) {
                    g.fillRect(axisX + (i) * width, axisY + (j) * height, width, height);
                }
            }
        }
    }

    public int getNumberOfGridsX() { return numberOfGridsX; }

    public int getNumberOfGridsY() { return numberOfGridsY; }

    public int getSizeX() { return sizeX; }

    public int getSizeY() { return sizeY; }

}
