package com.github.mvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mvp.R;
import com.github.mvp.constants.TagStatic;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class OtherFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_4, container, false);
    }

    @Override
    public int getFragmentTag() {
        return TagStatic.TAG_FRAGMENT_OTHER;
    }
}
