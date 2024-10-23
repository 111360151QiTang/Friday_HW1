package com.example.lab3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edName: EditText
    private lateinit var tvText: TextView
    private lateinit var tvName: TextView
    private lateinit var tvWinner: TextView
    private lateinit var tvMmora: TextView
    private lateinit var tvCmora: TextView
    private lateinit var btnScissor: RadioButton
    private lateinit var btnStone: RadioButton
    private lateinit var btnPaper: RadioButton
    private lateinit var btnMora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName = findViewById(R.id.ed_name)
        tvText = findViewById(R.id.tv_text)
        tvName = findViewById(R.id.tv_name)
        tvWinner = findViewById(R.id.tv_winner)
        tvMmora = findViewById(R.id.tv_mmora)
        tvCmora = findViewById(R.id.tv_cmora)
        btnScissor = findViewById(R.id.btn_scissor)
        btnStone = findViewById(R.id.btn_stone)
        btnPaper = findViewById(R.id.btn_paper)
        btnMora = findViewById(R.id.btn_mora)

        btnMora.setOnClickListener {
            if (edName.length() < 1) {
                tvText.text = "請輸入玩家姓名"
            } else {
                tvName.text = "名字\n${edName.text}"

                when {
                    btnScissor.isChecked -> tvMmora.text = "我方出拳\n剪刀"
                    btnStone.isChecked -> tvMmora.text = "我方出拳\n石頭"
                    else -> tvMmora.text = "我方出拳\n布"
                }

                val computerRandom = (Math.random() * 3).toInt()
                when (computerRandom) {
                    0 -> tvCmora.text = "電腦出拳\n剪刀"
                    1 -> tvCmora.text = "電腦出拳\n石頭"
                    else -> tvCmora.text = "電腦出拳\n布"
                }

                when {
                    (btnScissor.isChecked && computerRandom == 2) ||
                            (btnStone.isChecked && computerRandom == 0) ||
                            (btnPaper.isChecked && computerRandom == 1) -> {
                        tvWinner.text = "勝利者\n${edName.text}"
                        tvText.text = "恭喜您獲勝了！！！"
                    }
                    (btnScissor.isChecked && computerRandom == 1) ||
                            (btnStone.isChecked && computerRandom == 2) ||
                            (btnPaper.isChecked && computerRandom == 0) -> {
                        tvWinner.text = "勝利者\n電腦"
                        tvText.text = "可惜，電腦獲勝了！"
                    }
                    else -> {
                        tvWinner.text = "勝利者\n平手"
                        tvText.text = "平局，請再試一次！"
                    }
                }
            }
        }
    }
}
