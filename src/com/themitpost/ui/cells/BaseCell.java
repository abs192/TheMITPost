package com.themitpost.ui.cells;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class BaseCell extends View {

	private final class CheckForTap implements Runnable {
		public void run() {
			if (pendingCheckForLongPress == null) {
				pendingCheckForLongPress = new CheckForLongPress();
			}
			pendingCheckForLongPress.currentPressCount = ++pressCount;
			postDelayed(
					pendingCheckForLongPress,
					ViewConfiguration.getLongPressTimeout()
							- ViewConfiguration.getTapTimeout());
		}
	}

	class CheckForLongPress implements Runnable {
		public int currentPressCount;

		public void run() {
			if (checkingForLongPress && getParent() != null
					&& currentPressCount == pressCount) {
				checkingForLongPress = false;
				MotionEvent event = MotionEvent.obtain(0, 0,
						MotionEvent.ACTION_CANCEL, 0, 0, 0);
				onTouchEvent(event);
				event.recycle();
				performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
				onLongPress();
			}
		}
	}

	private boolean checkingForLongPress = false;
	private CheckForLongPress pendingCheckForLongPress = null;
	private int pressCount = 0;
	private CheckForTap pendingCheckForTap = null;

	public BaseCell(Context context) {
		super(context);
	}

	protected void setDrawableBounds(Drawable drawable, int x, int y) {
		setDrawableBounds(drawable, x, y, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());
	}

	protected void setDrawableBounds(Drawable drawable, int x, int y, int w,
			int h) {
		drawable.setBounds(x, y, x + w, y + h);
	}

	protected void startCheckLongPress() {
		if (checkingForLongPress) {
			return;
		}
		checkingForLongPress = true;
		if (pendingCheckForTap == null) {
			pendingCheckForTap = new CheckForTap();
		}
		postDelayed(pendingCheckForTap, ViewConfiguration.getTapTimeout());
	}

	protected void cancelCheckLongPress() {
		checkingForLongPress = false;
		if (pendingCheckForLongPress != null) {
			removeCallbacks(pendingCheckForLongPress);
		}
		if (pendingCheckForTap != null) {
			removeCallbacks(pendingCheckForTap);
		}
	}

	protected void onLongPress() {

	}
}
