package lk.ijse.dep.service.impl;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.BoardUI;
import lk.ijse.dep.service.Piece;

public class Player implements Board{
    protected Board board;

    public Player() {
    }

    public Player(Board board) {
        this.board = board;
    }

    public void movePiece(int col){

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public BoardUI getBoardUI() {
        return null;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }

    @Override
    public Piece[][] getPieces() {
        return null;
    }
}
