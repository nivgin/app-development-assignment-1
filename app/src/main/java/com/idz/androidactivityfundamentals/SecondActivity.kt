package com.idz.androidactivityfundamentals

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    /**
     * Called when the activity is first created.
     * - This is where you initialize your activity, set up UI components, and restore any previous state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("ActivityLifecycle", "SecondActivity: onCreate called")
    }

    /**
     * Called when the activity becomes visible to the user.
     */
    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "SecondActivity: onStart called")
    }

    /**
     * Called when the activity starts interacting with the user.
     */
    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "SecondActivity: onResume called")
    }

    /**
     * Called when the system is about to pause the activity.
     */
    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "SecondActivity: onPause called")
    }

    /**
     * Called when the activity is no longer visible to the user.
     */
    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "SecondActivity: onStop called")
    }

    /**
     * Called when the activity is being destroyed.
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "SecondActivity: onDestroy called")
    }
}