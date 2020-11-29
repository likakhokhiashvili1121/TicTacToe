package com.example.tictactoe

import android.graphics.Color
import android.icu.text.UnicodeSetSpanner
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {




    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    private var button9: Button? = null

    private var resetButton: Button? = null

    private var playerFirst = ArrayList<Int>()
    private var playerSecond = ArrayList<Int>()

    private var activePlayer = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


    }

    private fun init() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.resetButton)

        button1?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)
        button4?.setOnClickListener(this)
        button5?.setOnClickListener(this)
        button6?.setOnClickListener(this)
        button7?.setOnClickListener(this)
        button8?.setOnClickListener(this)
        button9?.setOnClickListener(this)

        resetButton?.setOnClickListener {

            button1?.setBackgroundResource(android.R.drawable.btn_default)
            button2?.setBackgroundResource(android.R.drawable.btn_default)
            button3?.setBackgroundResource(android.R.drawable.btn_default)
            button4?.setBackgroundResource(android.R.drawable.btn_default)
            button5?.setBackgroundResource(android.R.drawable.btn_default)
            button6?.setBackgroundResource(android.R.drawable.btn_default)
            button7?.setBackgroundResource(android.R.drawable.btn_default)
            button8?.setBackgroundResource(android.R.drawable.btn_default)
            button9?.setBackgroundResource(android.R.drawable.btn_default)

            button1?.text = ""
            button2?.text = ""
            button3?.text = ""
            button4?.text = ""
            button5?.text = ""
            button6?.text = ""
            button7?.text = ""
            button8?.text = ""
            button9?.text = ""

            playerFirst.clear()
            playerSecond.clear()

            activePlayer = 1

            setGameButtonsState(true)

        }

    }


    override fun onClick(clickedView: View?) {

        if (clickedView is Button?) {

            var buttonNumber = 0

            when (clickedView?.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView)
            }

        }

    }
    private fun playGame(buttonNumber: Int, clickedButton: Button?) {
        if (activePlayer == 1) {
            clickedButton?.text = "X"
            clickedButton?.setTextColor(Color.WHITE)
            clickedButton?.setBackgroundColor(Color.BLACK)
            playerFirst.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedButton?.text = "O"
            clickedButton?.setTextColor(Color.WHITE)
            clickedButton?.setBackgroundColor(Color.RED)
            playerSecond.add(buttonNumber)
            activePlayer = 1
        }
        clickedButton?.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0

        if (playerFirst.contains(1) && playerFirst.contains(2) && playerFirst.contains(3)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(1) && playerSecond.contains(2) && playerSecond.contains(3)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(4) && playerFirst.contains(5) && playerFirst.contains(6)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(4) && playerSecond.contains(5) && playerSecond.contains(6)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(7) && playerFirst.contains(8) && playerFirst.contains(9)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(7) && playerSecond.contains(8) && playerSecond.contains(9)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(1) && playerFirst.contains(4) && playerFirst.contains(7)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(1) && playerSecond.contains(4) && playerSecond.contains(7)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(2) && playerFirst.contains(5) && playerFirst.contains(8)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(2) && playerSecond.contains(5) && playerSecond.contains(8)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(3) && playerFirst.contains(6) && playerFirst.contains(9)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(3) && playerSecond.contains(6) && playerSecond.contains(9)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(1) && playerFirst.contains(5) && playerFirst.contains(9)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(1) && playerSecond.contains(5) && playerSecond.contains(9)) {
            winnerPlayer = 2
        }

        if (playerFirst.contains(3) && playerFirst.contains(5) && playerFirst.contains(7)) {
            winnerPlayer = 1
        }
        if (playerSecond.contains(3) && playerSecond.contains(5) && playerSecond.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X Wins!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "O Wins!", Toast.LENGTH_SHORT).show()
            }
            setGameButtonsState(false)
        }

    }

    private fun setGameButtonsState(isEnabled: Boolean) {
        button1?.isEnabled = isEnabled
        button2?.isEnabled = isEnabled
        button3?.isEnabled = isEnabled
        button4?.isEnabled = isEnabled
        button5?.isEnabled = isEnabled
        button6?.isEnabled = isEnabled
        button7?.isEnabled = isEnabled
        button8?.isEnabled = isEnabled
        button9?.isEnabled = isEnabled
    }




}