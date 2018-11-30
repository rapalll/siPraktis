package com.grack.rapalll.sipraktis;


import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class SimbelmawaWebView extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    SwipeRefreshLayout swipeRefreshLayout;
    WebView  wv_simbelmawa;
    WebSettings webSettings;

    String URL = "https://simbelmawa.ristekdikti.go.id/login.aspx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simbelmawa_web_view);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        wv_simbelmawa = (WebView) findViewById(R.id.web_view);

        swipeRefreshLayout.setOnRefreshListener(this);

        webSettings = wv_simbelmawa.getSettings();
        webSettings.setJavaScriptEnabled(true); // Untuk mengaktifkan javascript
        webSettings.getUseWideViewPort();

        wv_simbelmawa.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // Menampilkan loading ketika webview proses load halaman
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        wv_simbelmawa.setWebViewClient(new WebViewClient(){
            // Ketika webview error atau selesai load page loading akan dismiss

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        wv_simbelmawa.loadUrl(URL);

    }

    @Override
    public void onRefresh() {
        // Untuk refresh webview dengan swipe
        wv_simbelmawa.reload();
    }

    @Override
    public void onBackPressed() {
        // Jika Webview bisa di back maka backward page sebelumnya
        if (wv_simbelmawa.canGoBack()) {
            wv_simbelmawa.goBack();
        } else {
            finish();
            System.exit(0);
        }
    }
}

////        bar  = (ProgressBar) findViewById(R.id.progressBar);
////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////        getSupportActionBar().setDisplayShowHomeEnabled(true);
////
//////        getSupportActionBar().setDisplayShowHomeEnabled(true);
//////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
//        wv_simbelmawa = (WebView) findViewById(R.id.simbelmawa);
//
//
//        swipeRefreshLayout.setOnRefreshListener(this);
//
//        webSettings = wv_simbelmawa.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setUseWideViewPort(true);
//
//
//        wv_simbelmawa.getSettings().setLoadsImagesAutomatically(true);
////        wv_simbelmawa.getSettings().setJavaScriptEnabled(true);
//        wv_simbelmawa.getSettings().setDomStorageEnabled(true);
//
//        wv_simbelmawa.getSettings().setSupportZoom(true);
////        webView.setWebViewClient(new myWebclient());
//        wv_simbelmawa.getSettings().setBuiltInZoomControls(true);
//        wv_simbelmawa.getSettings().setDisplayZoomControls(false);
//
//        wv_simbelmawa.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        wv_simbelmawa.setWebViewClient(new myWebclient());
//        wv_simbelmawa.loadUrl("https://simbelmawa.ristekdikti.go.id/login.aspx");
//    }
//
//    public class myWebclient extends WebViewClient{
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            super.onPageFinished(view, url);
//            bar.setVisibility(View.GONE);
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return super.shouldOverrideUrlLoading(view, url);
//        }
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if((keyCode==KeyEvent.KEYCODE_BACK) && wv_simbelmawa.canGoBack()){
//            wv_simbelmawa.goBack();
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
//}
