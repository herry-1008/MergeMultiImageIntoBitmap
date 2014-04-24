package com.example.mergemultiimageintobitmap;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView iv = (ImageView) findViewById(R.id.iv);

		Resources res = getResources();
		int appIconSize = res.getDimensionPixelSize(R.dimen.app_icon_size);
		int iconSpan = res.getDimensionPixelSize(R.dimen.icon_span);
		int width = 4 * iconSpan + 3 * appIconSize;
		int height = 4 * iconSpan + 3 * appIconSize;
		initRects(width, height, appIconSize, iconSpan);
		Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Bitmap b = null;
		for (int i = 0; i < mIds.length; i++) {
			b = BitmapFactory.decodeResource(res, mIds[i]);
			canvas.drawBitmap(b, null, mRects[i], null);
		}
		iv.setImageBitmap(bitmap);
	}

	private static void initRects(int width, int height, int appIconSize,
			int iconSpan) {
		// row 0
		mRects[0].left = iconSpan;
		mRects[0].top = iconSpan;
		mRects[0].right = mRects[0].left + appIconSize;
		mRects[0].bottom = mRects[0].top + appIconSize;

		mRects[1].left = mRects[0].right + iconSpan;
		mRects[1].top = iconSpan;
		mRects[1].right = mRects[1].left + appIconSize;
		mRects[1].bottom = mRects[1].top + appIconSize;

		mRects[2].left = mRects[1].right + iconSpan;
		mRects[2].top = iconSpan;
		mRects[2].right = mRects[2].left + appIconSize;
		mRects[2].bottom = mRects[2].top + appIconSize;

		// row 1
		mRects[3].left = iconSpan;
		mRects[3].top = mRects[0].bottom + iconSpan;
		mRects[3].right = mRects[3].left + appIconSize;
		mRects[3].bottom = mRects[3].top + appIconSize;

		mRects[4].left = mRects[3].right + iconSpan;
		mRects[4].top = mRects[3].top;
		mRects[4].right = mRects[4].left + appIconSize;
		mRects[4].bottom = mRects[4].top + appIconSize;

		mRects[5].left = mRects[4].right + iconSpan;
		mRects[5].top = mRects[4].top;
		mRects[5].right = mRects[5].left + appIconSize;
		mRects[5].bottom = mRects[5].top + appIconSize;

		// row 2
		mRects[6].left = iconSpan;
		mRects[6].top = mRects[3].bottom + iconSpan;
		mRects[6].right = mRects[6].left + appIconSize;
		mRects[6].bottom = mRects[6].top + appIconSize;

		mRects[7].left = mRects[6].right + iconSpan;
		mRects[7].top = mRects[6].top;
		mRects[7].right = mRects[7].left + appIconSize;
		mRects[7].bottom = mRects[7].top + appIconSize;

		mRects[8].left = mRects[7].right + iconSpan;
		mRects[8].top = mRects[7].top;
		mRects[8].right = mRects[8].left + appIconSize;
		mRects[8].bottom = mRects[8].top + appIconSize;
	}

	private static final int[] mIds = new int[] { R.drawable.test1,
			R.drawable.test2, R.drawable.test3, R.drawable.test4,
			R.drawable.test5, R.drawable.test6, R.drawable.test7,
			R.drawable.test8, R.drawable.test9 };
	private static Rect[] mRects = new Rect[] { new Rect(), new Rect(),
			new Rect(), new Rect(), new Rect(), new Rect(), new Rect(),
			new Rect(), new Rect() };

}
