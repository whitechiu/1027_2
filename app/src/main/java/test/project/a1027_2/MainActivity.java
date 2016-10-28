package test.project.a1027_2;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.VmPolicy policy = new StrictMode.VmPolicy.Builder()
                .detectFileUriExposure()
                .build();
        StrictMode.setVmPolicy(policy);

        wv = (WebView) findViewById(R.id.webView);
        wv.setWebChromeClient(new WebChromeClient());
        wv.getSettings().setJavaScriptEnabled(true);
        //wv.loadUrl("https://tw.mobi.yahoo.com");
        wv.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (wv.getUrl().contains("index.html"))
        {
            super.onBackPressed();
        }
        else
        {
            wv.goBack();
        }

    }
}
