package com.jason.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_mora.setOnClickListener {
            // 判斷字串是否空白
            if(ed_name.length() < 1) {
                tv_text.text = "請輸入玩家姓名"
            } else {
                // 顯示玩家姓名與我方出拳結果
                tv_name.text = "名字\n${ed_name.text}"
                tv_mmora.text = "我方出拳\n${if(btn_scissors.isChecked) "剪刀" else if(btn_rock.isChecked) "石頭" else "布"}"
                // 隨機產生0, 1 or 2
                val computer = (Math.random() * 3).toInt()
                tv_cmora.text = "電腦出拳\n${if(computer == 0) "剪刀" else if(computer == 1) "石頭" else "布"}"
                // 用三個判斷式判斷並顯示結果
                when {
                    btn_scissors.isChecked && computer==2 ||
                    btn_rock.isChecked && computer==0 ||
                    btn_papper.isChecked && computer==1 -> {
                        tv_winner.text = "勝利者\n玩家"
                        tv_text.text = "恭喜你獲勝了！"
                    }

                    btn_scissors.isChecked && computer==1 ||
                            btn_rock.isChecked && computer==2 ||
                            btn_papper.isChecked && computer==0 -> {
                        tv_winner.text = "勝利者\n電腦"
                        tv_text.text = "可惜，電腦獲勝了！"
                    }

                    else -> {
                        tv_winner.text = "勝利者\n平手"
                        tv_text.text= "平手，請再試一次～"
                    }
                }
            }
        }
    }
}