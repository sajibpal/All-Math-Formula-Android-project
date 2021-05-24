package com.spal.sajibpal.mathformula;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by sajib pal on 1/5/2020.
 */

class CustomAdapter extends PagerAdapter {

    int[] images1;
    Context context1;
    LayoutInflater inflater;
    PhotoViewAttacher attacher;

    public CustomAdapter(Context context, int[] image) {

        this.context1=context;
        this.images1=image;
    }

    @Override
    public int getCount() {

        return images1.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View ok = inflater.inflate(R.layout.imagepage, container, false);
        ImageView ima =(ImageView)ok.findViewById(R.id.imag);
        ima.setImageResource(images1[position]);
        attacher=new PhotoViewAttacher(ima);
        container.addView(ok);
        return ok;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);
    }

}
