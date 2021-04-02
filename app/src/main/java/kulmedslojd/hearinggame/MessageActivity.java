package kulmedslojd.hearinggame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MessageActivity extends Activity {


    public static final String MESSAGE = "message";
    public static final String TITLE = "title";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_message);
        initTitleTextView();
        initMessageTextView();
        initButton();
    }
    public void showInterstitial2()
    {
        this.finish();
        Intent intent = new Intent("show_interstitial");
        sendBroadcast(intent);

        /*Intent intent = new Intent(MessageActivity.this, GameActivity.class);
        startActivity(intent);*/
    }
    private void initButton()
    {
        Button mButton;
        mButton = findViewById(R.id.buttonMessage);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showInterstitial2();
                MessageActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            }
        });
    }
    public void initTitleTextView()
    {
        String mTitle;
        mTitle = getIntent().getStringExtra(TITLE);
        TextView mTextViewTitle;
        mTextViewTitle = findViewById(R.id.titleText);
        mTextViewTitle.setText(mTitle);
    }
    private void initMessageTextView()
    {
        String mMessage;
        mMessage = getIntent().getStringExtra(MESSAGE);
        TextView mTextViewMessage;
        mTextViewMessage = findViewById(R.id.messageText);
        mTextViewMessage.setText(mMessage);
    }
    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();
        //showInterstitial2();
    }

}