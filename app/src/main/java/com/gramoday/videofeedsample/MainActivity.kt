package com.gramoday.videofeedsample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupList()

        setupDescriptionDisplay()
    }

    private fun setupList() {
        val videoListRV = findViewById<RecyclerView>(R.id.videoListRV)
        videoListRV.layoutManager = LinearLayoutManager(this)
        videoListRV.adapter = VideoAdapter()
    }

    private fun setupDescriptionDisplay() {
        val rootConstraintLayout = findViewById<ConstraintLayout>(R.id.rootConstraintLayout)
        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(rootConstraintLayout)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(rootConstraintLayout)
        constraintSet2.connect(
            R.id.descriptionScroll,
            ConstraintSet.TOP,
            R.id.videoTV,
            ConstraintSet.BOTTOM
        )

        findViewById<Button>(R.id.showDescriptionBtn).setOnClickListener {
            TransitionManager.beginDelayedTransition(rootConstraintLayout)
            constraintSet2.applyTo(rootConstraintLayout)
        }

        findViewById<Button>(R.id.closeBtn).setOnClickListener {
            TransitionManager.beginDelayedTransition(rootConstraintLayout)
            constraintSet1.applyTo(rootConstraintLayout)
        }


    }
}