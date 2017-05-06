package com.example.bba0.newyorktimes.story_list;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bba0.newyorktimes.R;
import com.example.bba0.newyorktimes.data.NewYorkTimesData;
import com.example.bba0.newyorktimes.story.StoryActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * Created by bba0 on 2017. 5. 5..
 */

public class StoryListFragment extends Fragment implements StoryListContract.View{

    String TAG = "lol";

    @Bind(R.id.story_list_recycler)
    RecyclerView mRecycler;

    StoryListContract.Presenter mPresenter;
    View mRoot;
    StoryListAdapter mAdapter;
    StaggeredGridLayoutManager mManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_story_list, container, false);
            ButterKnife.bind(this, mRoot);
            mPresenter.getStoryList();
            mAdapter = new StoryListAdapter(new StoryListItemClickListener() {
                @Override
                public void onClick(NewYorkTimesData.NewYorkTimesResultData pData) {
                    Intent intent = new Intent(getActivity(), StoryActivity.class);
                    intent.putExtra("url", pData.getShort_url());
                    getActivity().startActivity(intent);
                }
            });
            mManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            mRecycler.setLayoutManager(mManager);
            mRecycler.setAdapter(mAdapter);
            mRecycler.addItemDecoration(new StoryListDecoration());
            mRecycler.setHasFixedSize(true);
            mRecycler.setItemViewCacheSize(20);
            mRecycler.setDrawingCacheEnabled(true);
            mRecycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        }
        return mRoot;
    }

    @Override
    public void setPresenter(StoryListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setStoryList(NewYorkTimesData pData) {
        mAdapter.setData(pData.getResults());
    }

    @Override
    public void toast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
