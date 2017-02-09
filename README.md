# RotateBannerImage

**android Banner图 旋转切换方式**

![Example2](a111_clip.gif)


**使用**

`compile 'com.github.flyMountain:RotateBannerImage:v1.0'`


**操作**

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



  加载图片 （使用的是Glide）


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

最后执行 `imageLinear.startAnim();`

图片轮转效果参考[https://github.com/zhangyuChen1991/Roll3DImageView](https://github.com/zhangyuChen1991/Roll3DImageView "这里")