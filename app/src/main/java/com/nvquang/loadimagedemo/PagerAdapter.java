package com.nvquang.loadimagedemo;

import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nvquang.loadimagedemo.fresco.FrescoFragment;
import com.nvquang.loadimagedemo.glide.GlideFragment;
import com.nvquang.loadimagedemo.imageloader.ImageLoaderFragment;
import com.nvquang.loadimagedemo.picasso.PicassoFragment;

/**
 * Created by quangnv on 15/08/2018
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 4;
    private static final String GLIDE_TITLE = "Glide";
    private static final String PICASSO_TITLE = "Picasso";
    private static final String IMAGE_LOADER_TITLE = "Image loader";
    private static final String FRESCO_TITLE = "Fresco";

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return GlideFragment.newInstance();
            case 1:
                return PicassoFragment.newInstance();
            case 2:
                return ImageLoaderFragment.newInstance();
            case 3:
                return FrescoFragment.newInstance();
        }
        return GlideFragment.newInstance();
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return GLIDE_TITLE;
            case 1:
                return PICASSO_TITLE;
            case 2:
                return IMAGE_LOADER_TITLE;
            case 3:
                return FRESCO_TITLE;
        }
        return GLIDE_TITLE;
    }
}
