package id.codepanda.viewstemplateaet2019;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AuthorActivity extends AppCompatActivity {

    WebView mWebview;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        toolbar();
        binding();
        webView();
    }

    private void toolbar(){
        getSupportActionBar().setSubtitle("Author");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void binding(){
        mWebview = findViewById(R.id.web_view);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void webView(){
        mWebview.getSettings().setLoadsImagesAutomatically(true);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.getSettings().setDomStorageEnabled(true);

        mWebview.getSettings().setSupportZoom(true);
        mWebview.getSettings().setBuiltInZoomControls(true);
        mWebview.getSettings().setDisplayZoomControls(true);

        mWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        progressBar = ProgressDialog.show(this, "", "Loading...");
        mWebview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {
                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(AuthorActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });


        mWebview.loadUrl("https://github.com/vitorizkiimanda");
    }
}
