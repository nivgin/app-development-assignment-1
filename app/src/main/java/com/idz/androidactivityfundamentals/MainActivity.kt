package com.idz.androidactivityfundamentals

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /**
     * Called when the activity is first created.
     * - This is where you initialize your activity, set up UI components, and restore any previous state.
     * - Triggered when the activity is launched for the first time.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("ActivityLifecycle", "onCreate called")

        // Start SecondActivity when a button is clicked
        findViewById<Button>(R.id.buttonNavigate).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Called when the activity becomes visible to the user.
     * - Triggered after onCreate (or onRestart) when the activity is brought to the foreground.
     */
    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifecycle", "onStart called")
    }

    /**
     * Called when the activity starts interacting with the user.
     * - Triggered after onStart when the activity is ready to receive input.
     */
    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "onResume called")
    }

    /**
     * Called when the system is about to pause the activity.
     * - Triggered when another activity comes partially over the current one (e.g., a dialog or phone call).
     * - Use this to pause animations or save temporary data.
     */
    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifecycle", "onPause called")
    }

    /**
     * Called when the activity is no longer visible to the user.
     * - Triggered when the activity is completely obscured (e.g., another activity is launched).
     * - Use this to release resources that are not needed when the activity is not visible.
     */
    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifecycle", "onStop called")
    }

    /**
     * Called when the activity is restarting after being stopped.
     * - Triggered when the activity is coming back to the foreground from a stopped state.
     */
    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifecycle", "onRestart called")
    }

    /**
     * Called when the activity is being destroyed.
     * - Triggered when the activity is finishing or the system is reclaiming resources.
     * - Use this to clean up any resources (e.g., close database connections).
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifecycle", "onDestroy called")
    }
}