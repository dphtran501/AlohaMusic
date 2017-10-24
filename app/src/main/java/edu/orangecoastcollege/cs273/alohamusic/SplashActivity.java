package edu.orangecoastcollege.cs273.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This activity loads a 3-second splash screen before loading <code>MusicActivity</code>.
 *
 * @author Derek Tran
 * @version 1.0
 * @since October 24, 2017
 */
public class SplashActivity extends AppCompatActivity
{

    /**
     * Initializes <code>SplashActivity</code> by inflating its UI and loading a TimerTask.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Create a TimerTask to defer the loading of MusicActivity by 3 seconds
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                // Finish current SplashActivity, then:
                finish();
                // Launch the MusicActivity
                Intent musicIntent = new Intent(SplashActivity.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        };

        // Run the timer task after 3 seconds (3000ms)
        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);
    }
}
