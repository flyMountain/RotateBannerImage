package bocai.com.a3dimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import bocai.com.bannerimage.BannerImageLinear;

/**
 * 作者 yuanfei on 2017/2/7.
 * 邮箱 yuanfei221@126.com
 */

public class BannerActivity extends Activity {

    private BannerImageLinear imageLinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banner1_act);
        imageLinear = (BannerImageLinear) findViewById(R.id.view);

//        roll3DView = imageLinear.getRoll3DView();
//        imageLinear.setIndicatorCenter();
        //设置图片的个数
        imageLinear.setDicators(4);
        //设置滚动方向 1竖直方向  其他为水平方向
        imageLinear.setDirection(1);
        //设置是否有指示器
        imageLinear.setIsIndicator(true);
        //设置分块的数量  建议是3的倍数
        imageLinear.setPartNumber(12);
        //设置指示器的图片
        imageLinear.setIndicatorImage(R.drawable.icon_point,R.drawable.icon_point_pre);

        //第一张图片
         Glide.with(this).load("http://pic11.nipic.com/20101214/213291_155243023914_2.jpg").asBitmap().into(new SimpleTarget<Bitmap>(){

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageLinear.addBitmap(resource);
            }
        });
        //第二张张图片
        Glide.with(this).load("http://pic2.ooopic.com/12/32/19/90bOOOPIC39_1024.jpg").asBitmap().into(new SimpleTarget<Bitmap>(){

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageLinear.addBitmap(resource);
            }
        });
        Glide.with(this).load("http://img01.taopic.com/141128/240418-14112P9345826.jpg").asBitmap().into(new SimpleTarget<Bitmap>(){

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageLinear.addBitmap(resource);
            }
        });
        Glide.with(this).load("http://pic11.nipic.com/20101214/213291_155243023914_2.jpg").asBitmap().into(new SimpleTarget<Bitmap>(){

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageLinear.addBitmap(resource);
            }
        });
        Glide.with(this).load("http://img1.imgtn.bdimg.com/it/u=1926660543,3530443490&fm=214&gp=0.jpg").asBitmap().into(new SimpleTarget<Bitmap>(){

            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageLinear.addBitmap(resource);
            }
        });
        imageLinear.startAnim();
    }
}
