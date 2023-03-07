package lk.ijse.dep.service.impl;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.BoardUI;
import lk.ijse.dep.service.Piece;

import java.util.Arrays;

public class BoardImpl implements Board {

    private Piece[][] pieces;
    private BoardUI boardUI;

    public BoardImpl() {

    }

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces =new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        if (col<NUM_OF_COLS&&col>=0) {
            for (int i = 0; i < NUM_OF_ROWS; i++) {
                if (pieces[col][i] == Piece.EMPTY) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        return findNextAvailableSpot(col)!=-1? true:false;
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (findNextAvailableSpot(i)!=-1){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        if (isLegalMove(col)){
            for (int i = 0; i < NUM_OF_ROWS; i++) {
                if (pieces[col][i]==Piece.EMPTY){
                    pieces[col][i]=move;
                    return;
                }
            }
        }
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        if (isLegalMove(col)){
            if (pieces[col][row]==Piece.EMPTY){
                pieces[col][row]=move;
            }
        }
    }

    @Override
    public Winner findWinner() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            int countBlue=0;
            int countGreen=0;
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (pieces[i][j]==Piece.BLUE){
                    countGreen=0;
                    countBlue++;
                    if (countBlue==4){
                        return new Winner(Piece.BLUE,i,j-3,i,j);
                    }
                }else if (pieces[i][j]==Piece.GREEN){
                    countBlue=0;
                    countGreen++;
                    if (countGreen==4){
                        return new Winner(Piece.GREEN,i,j-3,i,j);
                    }
                }
            }
        }
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            int countBlue=0;
            int countGreen=0;
            for (int j = 0; j < NUM_OF_COLS; j++) {
                if (pieces[j][i]==Piece.BLUE){
                    countGreen=0;
                    countBlue++;
                    if (countBlue==4){
                        return new Winner(Piece.BLUE,j-3,i,j,i);
                    }
                }else if (pieces[j][i]==Piece.GREEN){
                    countBlue=0;
                    countGreen++;
                    if (countGreen==4){
                        return new Winner(Piece.GREEN,j-3,i,j,i);
                    }
                }else {
                    countBlue=0;
                    countGreen=0;
                }
            }
        }
        if (!existLegalMoves()) {
            return new Winner(Piece.EMPTY);
        }
        return null;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public void setBoardUI(BoardUI boardUI) {
        this.boardUI = boardUI;
    }

    @Override
    public String toString() {
        return "BoardImpl{" +
                "pieces=" + Arrays.toString(pieces) +
                ", boardUI=" + boardUI +
                '}';
    }
}
