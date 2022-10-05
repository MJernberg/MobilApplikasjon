package com.example.handleliste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetaljertActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaljert)

        val tjeneste = intent.getParcelableExtra<Tjeneste>("tjeneste")
        if (tjeneste != null){
            val textView : TextView = findViewById(R.id.detaljertActivityTW)
            val imageView : ImageView = findViewById(R.id.detaljertActivityIW)

            textView.text = tjeneste.name
            imageView.setImageResource(tjeneste.image)
        }
    }
}