package ca.pjones.studyguide;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewNotesActivity extends Activity {
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView wb = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Bundle b = getIntent().getExtras();
        String page = b.getString("page");
        System.out.println("Getting: " + page);
        wb.loadUrl("file:///android_asset/www/" + page + ".htm");
    }

}
