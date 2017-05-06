package com.example.bba0.newyorktimes.story_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bba0.newyorktimes.R;
import com.example.bba0.newyorktimes.data.NewYorkTimesData;
import com.example.bba0.newyorktimes.view.DynamicHeightImageView;
import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bba0 on 2017. 5. 5..
 */

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.StoryListHolder> {
    ArrayList<NewYorkTimesData.NewYorkTimesResultData> mData = new ArrayList<>();
    StoryListItemClickListener mStoryListClickListener;

    public StoryListAdapter(StoryListItemClickListener storyListItemClickListener) {
        mStoryListClickListener = storyListItemClickListener;
    }

    @Override
    public StoryListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_story_list, null);
        return new StoryListHolder(itemLayoutView, mStoryListClickListener);
    }

    @Override
    public void onBindViewHolder(StoryListHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    public void setData(ArrayList<NewYorkTimesData.NewYorkTimesResultData> pData) {
        if (pData != null) {
            int p = mData.size();
            mData.addAll(pData);
            notifyItemRangeInserted(p, pData.size());
        }
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class StoryListHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.story_list_holder_sd_image)
        DynamicHeightImageView mSDImage;
        @Bind(R.id.story_list_holder_tv_portrait_title)
        TextView mTVPortraitTitle;
        @Bind(R.id.story_list_holder_tv_landscape_title)
        TextView mTVLandScapeTitle;
        @Bind(R.id.story_list_holder_ll)
        LinearLayout mLLLandscape;
        StoryListItemClickListener mStoryListItemClickListener;
        @OnClick({R.id.story_list_holder_tv_portrait_title, R.id.story_list_holder_tv_landscape_title})
        public void onClick() {
            if (mData != null && mStoryListClickListener != null) {
                mStoryListClickListener.onClick(mData);
            }
        }

        NewYorkTimesData.NewYorkTimesResultData mData;
        public StoryListHolder(View itemView, StoryListItemClickListener pStoryListClickListener) {
            super(itemView);
            mStoryListItemClickListener = pStoryListClickListener;
            ButterKnife.bind(this, itemView);
        }

        public void setData(NewYorkTimesData.NewYorkTimesResultData pData) {
            mData = pData;
            float ratio = 1;
            FrameLayout.LayoutParams flp = (FrameLayout.LayoutParams) mSDImage.getLayoutParams();
            if (mData.getImageData() != null) {
                ratio = (float)pData.getImageData().getHeight() / (float)pData.getImageData().getWidth();
                flp.height = (int) (flp.width * ratio);

                Picasso.with(itemView.getContext())
                        .load(pData.getImageData().getUrl())
                        .into(mSDImage,
                                PicassoPalette.with(pData.getImageData().getUrl(), mSDImage)
                                        .use(PicassoPalette.Profile.MUTED_LIGHT)
                                        .use(PicassoPalette.Profile.MUTED)
                                        .use(PicassoPalette.Profile.VIBRANT_DARK)
                                        .use(PicassoPalette.Profile.MUTED_DARK)
                                        .intoBackground(mLLLandscape));
            } else {
                flp.height = (int) (flp.width * ratio);
                Picasso.with(itemView.getContext())
                        .load(R.mipmap.ic_launcher)
                        .into(mSDImage);
            }

            mSDImage.setLayoutParams(flp);
            mSDImage.setRatio(ratio);

            if (pData.getImageType() == NewYorkTimesData.NewYorkTimesResultData.ImageType.PORTRAIT) {
                mLLLandscape.setVisibility(View.GONE);
                mTVPortraitTitle.setText(mData.getTitle());
                mTVPortraitTitle.setVisibility(View.VISIBLE);
            } else {
                mLLLandscape.setVisibility(View.VISIBLE);
                mTVLandScapeTitle.setText(mData.getTitle());
                mTVPortraitTitle.setVisibility(View.GONE);
            }

        }
    }

}
