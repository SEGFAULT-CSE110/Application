package com.example.tylerbakke.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Christopher Cabreros on 04-May-16.
 */
public class ClothingImageFragment extends Fragment implements AdapterView.OnClickListener {

    private int mImageThumbSize;
    private int mImageThumbSpacing;
    private ImageAdapter mAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        //get image spacing
        mImageThumbSize = getResources().getDimensionPixelSize(R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(R.dimen.image_thumbnail_spacing);


        final View v = inflater.inflate(R.layout.view_clothing_by_cat, container, false);
        final GridView mGridView = (GridView) v.findViewById(R.id.gridView);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //?
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //?
            }
        });

        return v;
    }


    @Override
    public void onClick(View v) {

    }


    /**
     * THe main adapter that backs the GridView
     * Creates a fake row at the top
     */
    private class ImageAdapter extends BaseAdapter {

        private final Context mContext;
        private int mItemHeight = 0;
        private int mNumColumns = 0;
        private int mActionBarHeight = 0;
        private GridView.LayoutParams mImageViewLayoutParams;

        public ImageAdapter(Context context){
            super();
            mContext = context;

            mImageViewLayoutParams = new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            // Calculate ActionBar height
            TypedValue tv = new TypedValue();
            if (context.getTheme().resolveAttribute(
                    android.R.attr.actionBarSize, tv, true)) {
                mActionBarHeight = TypedValue.complexToDimensionPixelSize(
                        tv.data, context.getResources().getDisplayMetrics());
            }
        }

        @Override
        public int getCount() {
            //if coulmns have yet to be determined, return no items

            return 7 + 3;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //First check if this is the top row
            if (position < mNumColumns){
                if (convertView == null){
                    convertView = new View(mContext);
                }
                //Set empty view with height of ActionBar
                convertView.setLayoutParams(new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, mActionBarHeight
                ));
                return convertView;
            }

            //Now handle the main ImageView thumbnails
            ImageView imageView;
            if (convertView == null){// if it's not recycled, instantiate and initialize
                imageView = new RecyclingImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); //centers and crops the image
                imageView.setLayoutParams(mImageViewLayoutParams);
            } else{ //reuse the converted vivew
                imageView = (ImageView) convertView;
            }

            //Check the height matches our calcualted column width
            if (imageView.getLayoutParams().height != mItemHeight){
                imageView.setLayoutParams(mImageViewLayoutParams);
            }

            //Finally load the image into the imageView
            imageView.setImageBitmap(ViewClothingByCatActivity.bitmapList.get(position));
            return imageView;
        }

        public int getNumColumns() {
            return mNumColumns;
        }

        public void setNumColumns(int numColumns) {
            mNumColumns = numColumns;
        }
    }

}
