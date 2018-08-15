package com.nvquang.loadimagedemo.glide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.nvquang.loadimagedemo.R;
import com.nvquang.loadimagedemo.util.GlideApp;

/**
 * Created by quangnv on 15/08/2018
 */

public class GlideFragment extends Fragment implements View.OnClickListener {

    private static final String URL = "https://anhdephd.com/wp-content/uploads/2017/04/hinh-nen-thien-nhien-phong-canh-dep-nhat.jpg";
    private ImageView mImage;
    private Button mButtonLoadImage;
    private Button mButtonLoadCircleImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_view, container, false);

        mImage = view.findViewById(R.id.image_view);
        mButtonLoadImage = view.findViewById(R.id.button_load_image);
        mButtonLoadCircleImage = view.findViewById(R.id.button_load_circle_image);

        mButtonLoadImage.setOnClickListener(this);
        mButtonLoadCircleImage.setOnClickListener(this);

        return view;
    }

    public static GlideFragment newInstance() {
        return new GlideFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_load_image:
                GlideApp.with(getContext())
                        .load(URL)
                        .into(mImage);
                break;
            case R.id.button_load_circle_image:
                GlideApp.with(getContext())
                        .load(URL)
                        .circleCrop()
                        .into(mImage);
                break;
        }
    }
}
