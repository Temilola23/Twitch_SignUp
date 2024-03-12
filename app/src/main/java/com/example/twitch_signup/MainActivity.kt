package com.example.twitch_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the TextView
        val legalTextView = findViewById<TextView>(R.id.textView)

        // Create a SpannableString from your text
        val spannable = SpannableString(legalTextView.text)

        // Get the color from the resources
        val primaryTextColor = ContextCompat.getColor(this, R.color.black) // Change 'R.color.black' to the color you want for the main text
        val linkTextColor = Color.parseColor("#792DE7") // Change 'R.color.purple_200' to the color you want for "Terms of Service" and "Privacy Notice"

        // Set the color of the entire text first
        spannable.setSpan(ForegroundColorSpan(primaryTextColor), 0, spannable.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val purpleColorHex = "#000000" // Replace 'yourHexColor' with the actual hex code
        val purple = Color.parseColor(purpleColorHex)

        // Define the color for the "Terms of Service" link
        val termsStart = spannable.indexOf("Terms of the Animal Kingdom")
        val termsEnd = termsStart + "Terms of the Animal Kingdom".length
        spannable.setSpan(ForegroundColorSpan(linkTextColor), termsStart, termsEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Define the color for the "Privacy Notice" link
        val privacyStart = spannable.indexOf("Privacy Notice")
        val privacyEnd = privacyStart + "Privacy Notice".length
        spannable.setSpan(ForegroundColorSpan(linkTextColor), privacyStart, privacyEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Set the SpannableString to the TextView
        legalTextView.text = spannable

        // Rest of your onCreate code...
    }
}
