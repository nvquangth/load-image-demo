package com.nvquang.loadimagedemo.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by quangnv on 15/08/2018
 */

public class PicassoFragment extends Fragment implements View.OnClickListener {

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

    public static PicassoFragment newInstance() {
        return new PicassoFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_load_image:
                Picasso.get()
                        .load(URL)
                        .into(mImage);
                break;
            case R.id.button_load_circle_image:
                Picasso.get()
                        .load(URL)
                        .transform(new CircleTransform())
                        .into(mImage);
                break;
        }
    }

    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}
