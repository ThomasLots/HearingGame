package kulmedslojd.hearinggame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        setContentView(webview);
        webview.loadUrl("https://docs.google.com/document/d/1dNHZ8yTSTdrc8AcJMKUO39c5yEcobryA8RZuET8-l3o/edit?usp=sharing");
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }
}
