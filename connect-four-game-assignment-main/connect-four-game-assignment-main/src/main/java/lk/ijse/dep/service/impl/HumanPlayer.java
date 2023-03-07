package lk.ijse.dep.service.impl;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.Piece;

public class HumanPlayer extends Player{
    public HumanPlayer(Board board) {
        this.board=board;
    }

    public void movePiece(int col){
        if (board.isLegalMove(col)){
            board.updateMove(col, Piece.BLUE);
            board.getBoardUI().update(col,true);
            Winner winner = board.findWinner();
            if (winner!=null) {
                board.getBoardUI().notifyWinner(winner);
            }
        }
    }
}
