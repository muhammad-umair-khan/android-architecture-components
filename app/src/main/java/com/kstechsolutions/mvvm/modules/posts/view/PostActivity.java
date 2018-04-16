package com.kstechsolutions.mvvm.modules.posts.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kstechsolutions.mvvm.R;
/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class PostActivity extends AppCompatActivity {
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mFragment = new PostListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mFragment, null).commit();
        } else
            mFragment = getSupportFragmentManager().getFragment(savedInstanceState, getString(R.string.arg_fragment));
    }

    @Override
    public void onBackPressed() {
        if (mFragment.getChildFragmentManager().getBackStackEntryCount() > 0)
            mFragment.getChildFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, getString(R.string.arg_fragment), mFragment);
    }
}
