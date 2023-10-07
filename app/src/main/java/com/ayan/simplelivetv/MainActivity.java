package com.ayan.simplelivetv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;




public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private String liveTvEndpoint = "https://livetv.com.bd/tv/bangla/somoytv.php";
    private String TAG = "MainActivity";
    VideoView videoView;
    WebView webView;
    String[] str_permission = {"android.permission.INTERNET"};
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.web_view);

        // Enable JavaScript (if required)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a WebViewClient to handle navigation within the WebView
        webView.setWebViewClient(new WebViewClient());
        // Set WebChromeClient for handling JavaScript dialogs, like alert(), etc.
       // webView.setWebChromeClient(new WebChromeClient());

        // Load the PHP video link
        String videoUrl = "https://livetv.com.bd/tv/bangla/rtv.php";
        String somoyTv = "https://livetv.com.bd/tv/bangla/somoytv.php";
        webView.loadUrl(somoyTv);

        // Programmatically simulate a click after the page is loaded (you might need to adjust the delay)

        if(!isClicked){
            webView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    simulateClick(webView);
                }
            }, 100); // Delay in milliseconds, adjust as needed
            isClicked = true;
        }



    }

    // Function to simulate a click on a WebView
    private void simulateClick(WebView webView) {
        webView.loadUrl("javascript:(function() { video.body.click(); })()");
    }

    @Override
    public void onBackPressed() {
        // Handle back button press to navigate within the WebView history
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}