package lk.ijse.dep.service.impl;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.Piece;

import java.util.Random;

public class AiPlayer extends Player{
    public AiPlayer(Board board) {
        this.board=board;
    }

    public void movePiece(int col){
        col=minimax();
        board.getBoardUI().update(col,false);
        Winner winner = board.findWinner();
        if (winner!=null) {
            board.getBoardUI().notifyWinner(winner);
        }
    }

    private int minimax(){
        Piece[][] pieces = this.board.getPieces();

        //=============for Ai Win==============
        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (board.isLegalMove(i)){
                int count=0;
                for (int j = 0; j < NUM_OF_ROWS; j++) {
                    if (pieces[i][j]==Piece.GREEN){
                        count++;
                        if (count==3){
                            board.updateMove(i,Piece.GREEN);
                            return i;
                        }
                    }else{
                        count=0;
                    }
                }
            }
        }
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            int count=0;
            for (int j = 0; j < NUM_OF_COLS; j++) {
                if (pieces[j][i]==Piece.GREEN){
                    count++;
                    if (count==3){
                        if (board.isLegalMove(j+1)&&pieces[j+1][i]==Piece.EMPTY){
                            board.updateMove(j+1,Piece.GREEN);
                            return j+1;
                        }else if (board.isLegalMove(j-3)&&pieces[j-3][i]==Piece.EMPTY){
                            board.updateMove(j-3,Piece.GREEN);
                            return j-3;
                        }else if (board.isLegalMove(j-2)&&pieces[j-2][i]==Piece.EMPTY){
                            board.updateMove(j-2,Piece.GREEN);
                            return j-2;
                        }
                    }
                }else{
                    count=0;
                }
            }
        }
        //======================================================

        //========for break Human Win=======================

        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (board.isLegalMove(i)){
                int count=0;
                for (int j = 0; j < NUM_OF_ROWS; j++) {
                    if (pieces[i][j]==Piece.BLUE){
                        count++;
                        if (count==3){
                            board.updateMove(i,Piece.GREEN);
                            return i;
                        }
                    }else{
                        count=0;
                    }
                }
            }
        }

        for (int i = 0; i < NUM_OF_ROWS; i++) {
            int count=0;
            for (int j = 0; j < NUM_OF_COLS; j++) {
                if (pieces[j][i]==Piece.BLUE){
                    count++;
                    if (count==3){
                        if (board.isLegalMove(j+1)&&pieces[j+1][i]==Piece.EMPTY){
                            board.updateMove(j+1,Piece.GREEN);
                            return j+1;
                        }else if (board.isLegalMove(j-3)&&pieces[j-3][i]==Piece.EMPTY){
                            board.updateMove(j-3,Piece.GREEN);
                            return j-3;
                        }else if (board.isLegalMove(j-2)&&pieces[j-2][i]==Piece.EMPTY){
                            board.updateMove(j-2,Piece.GREEN);
                            return j-2;
                        }
                    }
                    /*if (count==2){
                        if (board.isLegalMove(j+1)&&pieces[j+1][i]==Piece.EMPTY){
                            board.updateMove(j+1,i,Piece.GREEN);
                            return j+1;
                        }else if (board.isLegalMove(j-2)&&pieces[j-2][i]==Piece.EMPTY){
                            board.updateMove(j-2,i,Piece.GREEN);
                            return j-2;
                        }
                    }*/
                }else{
                    count=0;
                }
            }
        }
        //============================

        int randCol=new Random().nextInt(6);
        while (!board.isLegalMove(randCol)){
            randCol=new Random().nextInt(6);
        }
        board.updateMove(randCol,Piece.GREEN);
        return randCol;
    }
}
