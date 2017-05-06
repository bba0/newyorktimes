package com.example.bba0.newyorktimes.story;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.bba0.newyorktimes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bba0 on 2017. 5. 6..
 */

public class StoryFragment extends Fragment {

    @Bind(R.id.story_webview)
    WebView mWebView;
    private String mUrl;
    private View mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(R.layout.fragment_story, container, false);
            ButterKnife.bind(this, mRoot);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    mWebView.loadUrl(url);
                    return true;
                }
            });
            mWebView.loadUrl(mUrl);
        }
        return mRoot;
    }

    public void setData(String pUrl) {
        mUrl = pUrl;
    }

    public boolean canGoBack() {
        boolean canGoBack = mWebView.canGoBack();
        if (canGoBack) {
            mWebView.goBack();
        }
        return canGoBack;
    }

}
