package com.example.admob

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, getString(R.string.admob_app_id))
        val adRequest = AdRequest.Builder().build()
      val  mAdView = findViewById<AdView>(R.id.adView)
        mAdView.loadAd(adRequest)

        mAdView.visibility = View.GONE
        mAdView.adListener = object : AdListener(){
            override fun onAdLoaded() {
                mAdView.visibility = View.VISIBLE
                super.onAdLoaded()
            }
        }
    }
}