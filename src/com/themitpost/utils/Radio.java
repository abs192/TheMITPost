package com.themitpost.utils;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.themitpost.ApplicationLoader;

public class Radio {

	public static void fetchImage(ImageView im, String imageUrl,
			boolean featured, boolean cache) {
		// change after dummy

		InputStream ims;
		try {
			ims = ApplicationLoader.applicationContext.getAssets().open(
					"test/" + imageUrl);

			Bitmap b = BitmapFactory.decodeStream(ims);
			if (!featured)
				b = Bitmap.createScaledBitmap(b, 192, 128, true);
			if (im != null)
				im.setImageBitmap(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Get and post request handler using volley. and all image fetch using
	 * picasso
	 */
}
