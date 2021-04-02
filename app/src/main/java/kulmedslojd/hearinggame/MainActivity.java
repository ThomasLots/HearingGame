package kulmedslojd.hearinggame;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity
{
    //protected OnBackPressedListener onBackPressedListener;
    //private ConsentForm form;
    //private boolean adFree = false;
    private StartFragment mFragment;
    //public static boolean mEnable = false;


    //Gör att klasserna kan prata med varandra
   /* public interface OnBackPressedListener {
        void doBack();
    }*/
    //Göra att onClicklistener initieras vilket göra att man kan manipulera doBack()
    /*public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            //setStartFragment(new StartFragment());
            mFragment = new StartFragment();
            FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.placeholder, mFragment,"start_frag");
            mFragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed()
    {
        if (mFragment != null)
        {
            if (!mFragment.getdoNotClose())
            {
                super.onBackPressed();
            }
        }
        else
        {
            super.onBackPressed();
        }


        /*if (onBackPressedListener != null)
        {
            onBackPressedListener.doBack();
            if (onBackPressedListener != null)
            {
                onBackPressedListener = null;
            }
        }*/
    }

    public int getOrientation()
    {
        if(getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }
}
