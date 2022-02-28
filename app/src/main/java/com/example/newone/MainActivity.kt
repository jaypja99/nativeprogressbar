package com.example.newone

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.sql.Time
import java.util.*
import kotlin.concurrent.schedule
import android.os.CountDownTimer
import com.google.android.material.color.DynamicColors


class MainActivity : AppCompatActivity() {
    private var progress1=0
    private var progress2=0
    var buttonIncrement: Button? = null
    var buttonDecrement: Button? = null
//    var progressBar: ProgressBar? = null
//    var progressBar2: ProgressBar? = null
//
//    var progressleftBottom:ProgressBar?=null;
    var progressleftTop:ProgressBar?=null
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DynamicColors.applyToActivitiesIfAvailable(application, R.style.ThemeOverlay_Material3_DynamicColors_Light);
        buttonDecrement = findViewById<View>(R.id.button_decr) as Button
        buttonIncrement = findViewById<View>(R.id.button_incr) as Button
//        progressBar = findViewById<View>(R.id.progress_bar) as ProgressBar
//        progressBar2 = findViewById<View>(R.id.progress_bar2) as ProgressBar

        textView = findViewById<View>(R.id.text_view_progress) as TextView
//        progressleftBottom=findViewById(R.id.progress_bar_leftbottom)
        progressleftTop=findViewById(R.id.progress_bar_lefttop)

        object : CountDownTimer(99999999, 50) {
            override fun onTick(millisUntilFinished: Long) {
                if (progress1 < 100) {
                    progress1 += 1

//                    if (progress1>=100) {
//                        progress1 = 0
//                        if (progress1 < 100) {
//                            progress1 += 1
//                            updateProgressBar()
//                        }
//                    }
                    updateProgressBar()

//                    progressleftBottom?.progress=progress1
                    progressleftTop?.progress=progress1
                }

//                if (progress1 >30){
//                    progress2+=1
//                    updateProgressBar()
//                }

            }

            override fun onFinish() {
            }
        }.start()


        // when clicked on buttonIncrement progress in increased by 10%
        buttonIncrement!!.setOnClickListener { // if progress is less than or equal
            // to 90% then only it can be increased
            if (progress1 < 100) {
                progress1 += 10
                updateProgressBar()
                if (progress1>100) {
                    progress1 = 0
                }
            }
        }

        // when clicked on buttonIncrement progress in decreased by 10%
        buttonDecrement!!.setOnClickListener { // If progress is greater than
            // 10% then only it can be decreased
            if (progress1 >= 10) {
                progress1 -= 10
                updateProgressBar()
            }
        }
    }

    // updateProgressBar() method sets
    // the progress of ProgressBar in text
    private fun updateProgressBar() {
//        progressBar!!.progress = progress1

        if(progress1>50){
//            progressBar2!!.progress = progress2
        }
        textView!!.text = progress1.toString()
    }
}
