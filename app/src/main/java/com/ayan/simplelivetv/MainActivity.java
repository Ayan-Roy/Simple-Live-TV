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
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.ayan.simplelivetv.adapter.TvListAdapter;
import com.ayan.simplelivetv.model.LiveTVDataModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TvListAdapter.OnItemClickListener {

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
        webView.setWebViewClient(new MyWebViewClient());

        // Load the PHP video link
        String somoyTv = "https://livetv.com.bd/tv/bangla/somoytv.php";
        webView.loadUrl(somoyTv);



        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        tvListAdapter = new TvListAdapter(tvDataModel, this);
        tvListAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(tvListAdapter);





    }



    private void setDataModel() {
        tvDataModel = new ArrayList<>();


        tvDataModel.add(new LiveTVDataModel(R.drawable.img_somoy_tv, "Somoy TV", "https://livetv.com.bd/tv/bangla/somoytv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_rtv, "Rtv", "https://livetv.com.bd/tv/bangla/rtv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_chaneli, "Chanel I", "https://livetv.com.bd/tv/bangla/channel-i.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_atn_bangla, "ATN Bangla", "https://livetv.com.bd/tv/bangla/atn-bangla.php"));


        tvDataModel.add(new LiveTVDataModel(R.drawable.img_ekushe_tv, "Ekushe Tv", "https://livetv.com.bd/tv/bangla/ekushey-tv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_chanel24, "Chanel 24", "https://livetv.com.bd/tv/bangla/channel-24.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_bangla_vision, "Bangla Vision", "https://livetv.com.bd/tv/bangla/banglavision.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_desh_tv, "Desh Tv", "https://livetv.com.bd/tv/bangla/deshtv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_jamuna_tv, "Jamuna TV", "https://livetv.com.bd/tv/bangla/jamunatv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_sa_tv, "SA TV", "https://livetv.com.bd/tv/bangla/sa-tv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_asian_tv, "Asian TV", "https://livetv.com.bd/tv/bangla/asian-tv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_gaan_bangla, "Gaan Bangla", "https://livetv.com.bd/tv/bangla/gaan-bangla.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_dbc_news, "DBC News", "https://livetv.com.bd/tv/bangla/dbc-news.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_mohona_tv, "Mohona TV", "https://livetv.com.bd/tv/bangla/mohona-tv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_my_tv, "My TV", "https://livetv.com.bd/tv/bangla/mytv.php"));
        tvDataModel.add(new LiveTVDataModel(R.drawable.img_annanda_tv, "Ananndo TV", "https://livetv.com.bd/tv/bangla/ananndotv.php"));








    }




    private void simulateClick2(WebView webView) {

        // Programmatically simulate a click after the page is loaded (you might need to adjust the delay)
        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:(function() { video.body.click(); })()");
                Log.e(TAG, "WebView Clicked" );
            }
        }, 500);
    }

    @Override
    public void onItemClick(int position) {
        String selectedTvLink = tvDataModel.get(position).getChanelLink();
        webView.loadUrl(selectedTvLink);

    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webView.loadUrl("javascript:(function() { document.querySelector('video #body').click(); })()");

        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Log.e(TAG, "onReceivedError: ");

        }

    }
}