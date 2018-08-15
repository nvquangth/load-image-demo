package com.nvquang.loadimagedemo.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

@com.bumptech.glide.annotation.GlideModule
public class GlideModule extends AppGlideModule {
   @Override
   public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
       long diskCacheSizeBytes = 1024 * 1024 * 30; // 30 MB
       builder.setDiskCache(new InternalCacheDiskCacheFactory(context, diskCacheSizeBytes));
   }
}