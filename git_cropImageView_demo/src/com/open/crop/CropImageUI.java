package com.open.crop;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class CropImageUI extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		int index = getIntent().getIntExtra("index", 1);
		if (index == 1) {
			cropImage1();
		} else if (index == 2) {
			cropImage2();
		} else if (index == 3) {
			cropImage3();
		} else if (index == 4) {
			cropImage4();
		}

	}

	private void cropImage4() {
		// TODO Auto-generated method stub
		setContentView(R.layout.fragment_cropimagehaveborder);

		Bitmap b = null;
		Bitmap border = null;
		try {

			// 原图
			b = BitmapFactory.decodeStream(getAssets().open("precrop.jpg"));

			// 边框
			border = BitmapFactory.decodeStream(getAssets().open("themex.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final CropBorder mCropImage = (CropBorder) findViewById(R.id.cropImg);
		mCropImage.setDrawable(new BitmapDrawable(b), border, 300, 206);

		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						Bitmap border2 = null;
						try {
							// 边框
							border2 = BitmapFactory.decodeStream(getAssets()
									.open("themex.png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						FileUtil.writeImage(
								mCropImage.buildConcatImage(1000, border2),
								FileUtil.SDCARD_PAHT + "/newcrop.png", 100);
						Intent mIntent = new Intent();
						mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT
								+ "/newcrop.png");
						setResult(RESULT_OK, mIntent);
						finish();
					}
				}).start();

			}

		});

	}

	private void cropImage1() {
		setContentView(R.layout.fragment_cropimage);
		final CropImageView mCropImage = (CropImageView) findViewById(R.id.cropImg);
		mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop),
				300, 300);

		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						FileUtil.writeImage(mCropImage.getCropImage(),
								FileUtil.SDCARD_PAHT + "/crop.png", 100);

						Intent mIntent = new Intent();
						mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT
								+ "/crop.png");
						setResult(RESULT_OK, mIntent);
						finish();
					}
				}).start();
			}
		});
	}

	private void cropImage2() {
		setContentView(R.layout.fragment_cropimage2);
		final CropImageView2 mCropImage = (CropImageView2) findViewById(R.id.cropImg);
		mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop),
				300, 300);
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						FileUtil.writeImage(mCropImage.getCropImage(),
								FileUtil.SDCARD_PAHT + "/crop.png", 100);
						Intent mIntent = new Intent();
						mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT
								+ "/crop.png");
						setResult(RESULT_OK, mIntent);
						finish();
					}
				}).start();
			}
		});
	}

	private void cropImage3() {
		setContentView(R.layout.fragment_cropimage3);
		final CropImageView3 mCropImage = (CropImageView3) findViewById(R.id.cropImg);
		mCropImage.setDrawable(getResources().getDrawable(R.drawable.precrop),
				300, 300);
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						FileUtil.writeImage(mCropImage.getCropImage(),
								FileUtil.SDCARD_PAHT + "/crop.png", 100);
						Intent mIntent = new Intent();
						mIntent.putExtra("cropImagePath", FileUtil.SDCARD_PAHT
								+ "/crop.png");
						setResult(RESULT_OK, mIntent);
						finish();
					}
				}).start();
			}
		});
	}

}
