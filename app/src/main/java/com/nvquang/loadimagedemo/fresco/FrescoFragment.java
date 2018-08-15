package com.nvquang.loadimagedemo.fresco;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nvquang.loadimagedemo.R;

/**
 * Created by quangnv on 15/08/2018
 */

public class FrescoFragment extends Fragment implements View.OnClickListener {

    private static final String URL = "https://anhdephd.com/wp-content/uploads/2017/04/hinh-nen-thien-nhien-phong-canh-dep-nhat.jpg";
    private SimpleDraweeView mSimpleDraweeView;
    private Button mButtonLoadImage;
    private Button mButtonLoadCircleImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Fresco.initialize(getContext());
        View view = inflater.inflate(R.layout.fragment_fresco, container, false);
        mButtonLoadImage = view.findViewById(R.id.button_load_image);
        mButtonLoadCircleImage = view.findViewById(R.id.button_load_circle_image);
        mSimpleDraweeView = view.findViewById(R.id.simple_drawee_view);

        mButtonLoadImage.setOnClickListener(this);
        mButtonLoadCircleImage.setOnClickListener(this);

        return view;
    }

    public static FrescoFragment newInstance() {
        return new FrescoFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_load_image:
                mSimpleDraweeView.setImageURI(URL);
                break;
            case R.id.button_load_circle_image:
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setRoundAsCircle(true);
                mSimpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
                break;
        }
    }
}
