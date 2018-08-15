package com.nvquang.loadimagedemo.imageloader;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nvquang.loadimagedemo.R;

/**
 * Created by quangnv on 15/08/2018
 */

public class ImageLoaderFragment extends Fragment implements View.OnClickListener {

    private static final String URL = "https://anhdephd.com/wp-content/uploads/2017/04/hinh-nen-thien-nhien-phong-canh-dep-nhat.jpg";
    private ImageView mImage;
    private Button mButtonLoadImage;
    private Button mButtonLoadCircleImage;
    private ImageLoader mImageLoader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_view, container, false);

        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(ImageLoaderConfiguration.createDefault(getContext()));

        mImage = view.findViewById(R.id.image_view);
        mButtonLoadImage = view.findViewById(R.id.button_load_image);
        mButtonLoadCircleImage = view.findViewById(R.id.button_load_circle_image);

        mButtonLoadImage.setOnClickListener(this);
        mButtonLoadCircleImage.setOnClickListener(this);

        return view;
    }

    public static ImageLoaderFragment newInstance() {
        return new ImageLoaderFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_load_image:
                mImageLoader.loadImage(URL, new SimpleImageLoadingListener(){
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        mImage.setImageBitmap(loadedImage);
                    }
                });
                break;
            case R.id.button_load_circle_image:
                Toast.makeText(getContext(), "Not Support", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
