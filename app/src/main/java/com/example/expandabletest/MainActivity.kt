package com.example.expandabletest

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandabletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var list : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        list = ArrayList(
            listOf(
            "The aroma of freshly baked bread wafted through the bustling marketplace, enticing passersby to linger at the stall overflowing with golden brown loaves and delicate pastries, each a testament to the baker's meticulous craftsmanship.",
            "As the first rays of dawn painted the horizon with streaks of orange and pink, a lone hiker crested the summit, gazing out at the breathtaking panorama of snow-capped peaks shrouded in mist, a sense of accomplishment washing over them for conquering the challenging ascent.",
            "Curled up in her favorite armchair with a well-worn book in hand, she reveled in the captivating story that unfolded before her, the characters leaping off the pages and transporting her to a world of adventure and intrigue, lost in the magical realm conjured by the author's words.",
            "With meticulous precision, the surgeon guided the tiny instruments through the intricate network of veins and arteries, their movements a silent symphony of focus and skill, each step crucial in the delicate operation that held the fate of the patient in their balance.",
            "The once vibrant coral reef, teeming with an explosion of color and life, now lay eerily silent, bleached white by the relentless rise in ocean temperatures, a stark reminder of the fragile ecosystem and the devastating consequences of climate change.",
                "The aroma of freshly baked bread wafted through the bustling marketplace, enticing passersby to linger at the stall overflowing with golden brown loaves and delicate pastries, each a testament to the baker's meticulous craftsmanship.",
                "As the first rays of dawn painted the horizon with streaks of orange and pink, a lone hiker crested the summit, gazing out at the breathtaking panorama of snow-capped peaks shrouded in mist, a sense of accomplishment washing over them for conquering the challenging ascent.",
                "Curled up in her favorite armchair with a well-worn book in hand, she reveled in the captivating story that unfolded before her, the characters leaping off the pages and transporting her to a world of adventure and intrigue, lost in the magical realm conjured by the author's words.",
                "With meticulous precision, the surgeon guided the tiny instruments through the intricate network of veins and arteries, their movements a silent symphony of focus and skill, each step crucial in the delicate operation that held the fate of the patient in their balance.",
                "The once vibrant coral reef, teeming with an explosion of color and life, now lay eerily silent, bleached white by the relentless rise in ocean temperatures, a stark reminder of the fragile ecosystem and the devastating consequences of climate change."

            ))

        val recyclerView = mainBinding.rv
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.hasFixedSize()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = myAdapter(list)




    }
}