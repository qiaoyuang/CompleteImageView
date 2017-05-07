package com.w10group.completeimageview;

import android.app.Activity;

import java.io.File;

/**
 * Created by qiaoyuang on 2017/4/26.
 * 下载图片的抽象接口
 */

public interface ImageDownloader {
    File downLoad(String url, Activity activity);
}