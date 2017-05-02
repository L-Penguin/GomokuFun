package com.company;

import com.company.elements.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by jize.jiang on 17/2/20.
 */
public class GomokuMain extends Applet implements MouseListener, MouseMotionListener, ActionListener {

    public enum GamePhase {
        INIT, MENU, WHITEMOVE, BLACKMOVE;
    };

    GomokuBoardController gomokuBoardController = new GomokuBoardController(0,0,400, 400,15, 15);

    GamePhase gamePhase = GamePhase.INIT;

    String gamePhaseString;

    String[] gamePhaseStrings = {"GameStarted", "Black's Turn", "White's Turn"};

    public void init() {
        gamePhase = GamePhase.BLACKMOVE;
        gamePhaseString = gamePhaseStrings[1];
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        gomokuBoardController.draw(g);
        g.setColor(Color.BLACK);
        g.drawString(gamePhaseString, 0, 400);
    }

    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        switch (gamePhase) {
            case WHITEMOVE:

                gomokuBoardController.updateBoardInfoFromMouseEvent(mouseEvent, 1);

                if (gomokuBoardController.isLegalMove()) {
                    gamePhase = GamePhase.BLACKMOVE;
                    gamePhaseString = gamePhaseStrings[1];
                }
                break;
            case BLACKMOVE:

                gomokuBoardController.updateBoardInfoFromMouseEvent(mouseEvent, 2);

                if (gomokuBoardController.isLegalMove()) {
                    gamePhase = GamePhase.WHITEMOVE;
                    gamePhaseString = gamePhaseStrings[2];
                }
                break;
        }

        repaint();
    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {

    }

    public void mouseDragged(MouseEvent mouseEvent) {

    }

    public void actionPerformed(ActionEvent actionEvent){
    }

}
