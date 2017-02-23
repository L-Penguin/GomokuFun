package com.company;

import com.company.elements.*;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by jize.jiang on 17/2/20.
 */
public class GomokuMain extends Applet {

    GomokuBoardController gomokuBoardController = new GomokuBoardController(400, 400,15, 15);



    public void init() {
        gomokuBoardController.updateBoardInfo(3,3,1);
        gomokuBoardController.updateBoardInfo(4,4,2);
    }

    public void paint(Graphics g) {
        gomokuBoardController.draw(g, 0,0);
    }

}
