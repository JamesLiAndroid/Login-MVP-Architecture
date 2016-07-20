package com.github.mvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mvp.R;
import com.github.mvp.data.RootEntity;
import com.github.mvp.data.StoriesEntity;
import com.github.mvp.login.LoginContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;


/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class BaseFragment extends Fragment implements MainContract.View {

    @BindView(R.id.lv_news)
    ListView mListView;

    protected MainContract.Presenter mPresenter;
    protected ActionBar mActionBar;
    private ZhiHuNewsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_0, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new ZhiHuNewsAdapter(getContext());
        mListView.setAdapter(mAdapter);
        //mPresenter.getLatestNews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isAdded()) {
            mActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
            setTitle();
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setSelection(int tag) {

    }

    @Override
    public int getFragmentTag() {
        return 0;
    }

    @Override
    public void refresh(List<StoriesEntity> list) {
        mAdapter.setNewsList(list);
    }

    @Override
    public void setTitle() {
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.app_name);
        }
    }
}
