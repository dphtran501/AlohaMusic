package edu.orangecoastcollege.cs273.alohamusic;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity
{
    // References to UI components
    Button ukuleleButton;
    Button ipuButton;
    Button hulaButton;

    VideoView hulaVideoView;

    MediaPlayer ukuleleMediaPlayer;
    MediaPlayer ipuMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // Associate the components
        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);
        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);

        // Associate the Media Players:
        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this, R.raw.ipu);

        // Associate the VideoView with its URI:
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.hula;
        hulaVideoView.setVideoURI(Uri.parse(uri));
        // Create a MediaController for the VideoView
        // MediaController = controls (play/pause/forward/rewind)
        hulaVideoView.setMediaController(new MediaController(this));
    }

    // Method will handle all 3 button clicks
    public void playMedia(View v)
    {
        // Make a decision based on the id of the view
        switch (v.getId())
        {
            case R.id.ukuleleButton:
                // If it's playing, pause it
                if (ukuleleMediaPlayer.isPlaying())
                {
                    ukuleleMediaPlayer.pause();
                    // Change the text
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    ukuleleButton.setBackgroundColor(getResources().getColor(R.color.turquoise_water));
                    ukuleleButton.setTextColor(Color.WHITE);
                    // Hide other two buttons:
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                // else, play it
                else
                {
                    ukuleleMediaPlayer.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    ukuleleButton.setBackgroundColor(Color.TRANSPARENT);
                    ukuleleButton.setTextColor(getResources().getColor(R.color.turquoise_water));
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.ipuButton:
                if (ipuMediaPlayer.isPlaying())
                {
                    ipuMediaPlayer.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);
                    ipuButton.setBackgroundColor(getResources().getColor(R.color.turquoise_water));
                    ipuButton.setTextColor(Color.WHITE);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                } else
                {
                    ipuMediaPlayer.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    ipuButton.setBackgroundColor(Color.TRANSPARENT);
                    ipuButton.setTextColor(getResources().getColor(R.color.turquoise_water));
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.hulaButton:
                if (hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    hulaButton.setBackgroundColor(getResources().getColor(R.color.turquoise_water));
                    hulaButton.setTextColor(Color.WHITE);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                } else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    hulaButton.setBackgroundColor(Color.TRANSPARENT);
                    hulaButton.setTextColor(getResources().getColor(R.color.turquoise_water));
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

    // Override onStop method to release MediaPlayer
    // Prevent memory leaks

    @Override
    protected void onStop()
    {
        super.onStop();
        ukuleleMediaPlayer.release();
        ipuMediaPlayer.release();
    }
}
