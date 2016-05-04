package com.example.tylerbakke.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Christopher Cabreros on 03-May-16.
 */
public class ImageDetailFragment extends Fragment {
    private static final String IMAGE_DATA_EXTRA = "resId";
    private int mImageNum;
    private ImageView mImageView;

    /**
     * Instance creator that will return a fragment
     * @param imageNum - index of the image
     * @return - a new fragment
     */
    static ImageDetailFragment newInstance(int imageNum){
        final ImageDetailFragment f = new ImageDetailFragment();
        final Bundle args = new Bundle();
        args.putInt(IMAGE_DATA_EXTRA, imageNum);
        f.setArguments(args);

        return f;
    }

    //empty constructor
    public ImageDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get the image if the fragment's arguments are not null, otherwise give a number of -1
        mImageNum = getArguments() != null ? getArguments().getInt(IMAGE_DATA_EXTRA) : -1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //image_detail_fragment.xml contains just an imageView
        final View v = inflater.inflate(R.layout.clothing_image_fragment, container, false);
        mImageView = (ImageView) v.findViewById(R.id.clothing_image_view);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final int resId = ViewClothingByCatActivity.imageResIds[mImageNum];
        mImageView.setImageResource(resId); //load image into imageView
    }
}
