package com.open.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**边框
 * @author youxiachai
 * @date   2013-8-13
 */
public class BorderDrawable extends Drawable {

	private Drawable mCropPointDrawable;

	public BorderDrawable(Context context, Bitmap bitmap) {
		super();
		init(bitmap);
	}

	public void init(Bitmap b) {
		mCropPointDrawable = new BitmapDrawable(b);
	}

	public int getCirleWidth() {
		return mCropPointDrawable.getIntrinsicWidth();
	}

	public int getCirleHeight() {
		return mCropPointDrawable.getIntrinsicHeight();
	}

	@Override
	public void draw(Canvas canvas) {

		int left = getBounds().left;
		int top = getBounds().top;
		int right = getBounds().right;
		int bottom = getBounds().bottom;

		Rect mRect = new Rect(
				left + mCropPointDrawable.getIntrinsicWidth() / 2, top
						+ mCropPointDrawable.getIntrinsicHeight() / 2, right
						- mCropPointDrawable.getIntrinsicWidth() / 2, bottom
						- mCropPointDrawable.getIntrinsicHeight() / 2);
		mCropPointDrawable.setBounds(mRect);
		mCropPointDrawable.draw(canvas);

	}

	@Override
	public void setBounds(Rect bounds) {
		super.setBounds(new Rect(bounds.left
				- mCropPointDrawable.getIntrinsicWidth() / 2, bounds.top
				- mCropPointDrawable.getIntrinsicHeight() / 2, bounds.right
				+ mCropPointDrawable.getIntrinsicWidth() / 2, bounds.bottom
				+ mCropPointDrawable.getIntrinsicHeight() / 2));
	}

	@Override
	public void setAlpha(int alpha) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColorFilter(ColorFilter cf) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}

}
