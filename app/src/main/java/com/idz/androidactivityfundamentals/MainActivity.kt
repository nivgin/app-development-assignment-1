package com.idz.androidactivityfundamentals

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /**
     * Called when the activity is first created.
     * - This is where you initialize your activity, set up UI components, and restore any previous state.
     * - Triggered when the activity is launched for the first time.
     */
    private lateinit var board: Array<Array<ImageView>>
    private var turn = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        board = arrayOf(
            arrayOf(findViewById(R.id.cell0), findViewById(R.id.cell3), findViewById(R.id.cell6)),
            arrayOf(findViewById(R.id.cell1), findViewById(R.id.cell4), findViewById(R.id.cell7)),
            arrayOf(findViewById(R.id.cell2), findViewById(R.id.cell5), findViewById(R.id.cell8))
        )

        for (row in 0..2) {
            for (col in 0..2) {
                board[row][col].setOnClickListener { view -> onCellClick(view as ImageView) }
                board[row][col].setTag(R.id.row, row)
                board[row][col].setTag(R.id.col, col)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun onCellClick(cell: ImageView) {
        val player = turn % 2;
        if (cell.tag == "X" || cell.tag == "O") {
            return;
        }

        if (player == 0) {
            cell.setImageResource(R.drawable.ic_x)
            cell.tag = "X"
        } else {
            cell.setImageResource(R.drawable.ic_o)
            cell.tag = "O"
        }

        val row = cell.getTag(R.id.row) as Int;
        val col = cell.getTag(R.id.col) as Int;

        if (turn >= 9) {
            //DRAW
            return
        }

        if (isWinner(row, col)) {
            //WIN
            turn = 10;
            return;
        }

        turn++;
    }

    private fun isWinner(row: Int, col: Int): Boolean {
        val playerTag = board[row][col].tag;

        if (board[row].all { cell -> cell.tag == playerTag }) {
            board[row].forEach { cell -> cell.setBackgroundResource(R.drawable.cell_win) }
            return true
        }

        if ((0..2).all { curRow -> board[curRow][col].tag == playerTag }) {
            (0..2).forEach { curRow -> board[curRow][col].setBackgroundResource(R.drawable.cell_win) }
            return true
        }

        if (row==col && (0..2).all { mainDiag -> board[mainDiag][mainDiag].tag == playerTag }) {
            (0..2).forEach { mainDiag -> board[mainDiag][mainDiag].setBackgroundResource(R.drawable.cell_win) }
            return true
        }

        if (row+col==2 && (0..2).all { revDiag -> board[2-revDiag][revDiag].tag == playerTag }) {
            (0..2).forEach { revDiag -> board[2-revDiag][revDiag].setBackgroundResource(R.drawable.cell_win) }
            return true
        }

        return false

    }
}