package com.ayan.simplelivetv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.ayan.simplelivetv.adapter.TvListAdapter;
import com.ayan.simplelivetv.model.LiveTVDataModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private WebView webView;
    private RecyclerView recyclerView;
    private boolean isClicked = false;
    private TvListAdapter tvListAdapter;

    private List<LiveTVDataModel> tvDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDataModel();

        webView = findViewById(R.id.web_view);
        recyclerView = findViewById(R.id.recyclerview);

        // Enable JavaScript (if required)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a WebViewClient to handle navigation within the WebView
        webView.setWebViewClient(new WebViewClient());

        // Load the PHP video link
        String videoUrl = "https://livetv.com.bd/tv/bangla/rtv.php";
        String somoyTv = "https://livetv.com.bd/tv/bangla/somoytv.php";
        webView.loadUrl(somoyTv);



        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        tvListAdapter = new TvListAdapter(tvDataModel, this);
        recyclerView.setAdapter(tvListAdapter);


        simulateClick(webView);


    }

    private void setDataModel() {
        tvDataModel = new ArrayList<>();


        tvDataModel.add(new LiveTVDataModel(R.drawable.img_somoy_tv, "Somoy TV", "https://livetv.com.bd/tv/bangla/somoytv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_rtv, "Rtv", "https://livetv.com.bd/tv/bangla/somoytv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_chaneli, "Chanel I", "https://livetv.com.bd/tv/bangla/somoytv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_atn_bangla, "ATN Bangla", "https://livetv.com.bd/tv/bangla/somoytv.php"));
    }

    // Function to simulate a click on a WebView
    private void simulateClick(WebView webView) {

        // Programmatically simulate a click after the page is loaded (you might need to adjust the delay)
        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:(function() { video.body.click(); })()");
            }
        }, 100); // Delay in milliseconds, adjust as needed

    }

}