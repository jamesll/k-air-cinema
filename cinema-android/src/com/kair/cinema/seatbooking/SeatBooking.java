package com.kair.cinema.seatbooking;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.kair.cinema.R;

public class SeatBooking extends Activity {

	private static final int MINIMUM_VIEW_HEIGHT = 1000;
	private static final int MINIMUM_VIEW_WIDTH = 1000;
	private static final int VERTICAL_GRID_NUMBER = 10;
	private static final int HORIZONTAL_RID_NUMBER = 10;
	private static final int MINIMUM_VIEW_SIZE = 1000;
	private static final int GRID_NUMBER = 10;
	private static final String SEAT_FILE_PATH = "E:/android/Eclipse/workspace/cinema/external-files/seat.txt";

	private int layoutWidth;
	private int layoutHeight;
	private int layoutSize;
	private int gridSize;
	private int cellSize;
	private Reader reader;

	private ScrollView scrollView;
	private AbsoluteLayout absoluteLayout;

	private DisplayMetrics displayMetrics; // view display pixel metrics

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seat_booking);
		scrollView = (ScrollView) findViewById(R.id.scrollView_vertical);

		initialView();

		// set text for testing
		TextView textView = (TextView) findViewById(R.id.TestView_0);
		CharSequence text = "width:" + displayMetrics.widthPixels + "  height:"
				+ displayMetrics.heightPixels;
		textView.setText(text);

	}

	private void initialView() {
		File file = new File(SEAT_FILE_PATH);
		reader = new InputStreamReader(getResources().openRawResource(R.raw.seat));
		int tempchar;
		int x = 0;
		int y = 0;
		int status = 0;

		// get view display pixel metrics
		displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

		// layout is a square with the maximum size
		if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
			layoutSize = displayMetrics.widthPixels;
		}
		else {
			layoutSize = displayMetrics.heightPixels;
		}
		if (layoutSize < MINIMUM_VIEW_SIZE) {
			layoutSize = MINIMUM_VIEW_SIZE;
		}

		// calculate grid size
		gridSize = layoutSize / GRID_NUMBER;
		cellSize = (gridSize / 3) * 2;

		absoluteLayout = (AbsoluteLayout) findViewById(R.id.absoluteLayout_0);
		absoluteLayout.setMinimumHeight(layoutSize);
		absoluteLayout.setMinimumWidth(layoutSize);

		try {
			while ((tempchar = reader.read()) != -1) {
				x = Character.getNumericValue(tempchar);
				if ((tempchar = reader.read()) != -1) {
					y = Character.getNumericValue(tempchar);
				}
				if ((tempchar = reader.read()) != -1) {
					status = Character.getNumericValue(tempchar);
				}

				Seat seat = new Seat(absoluteLayout.getContext());
				LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT);
				seat.setLayoutParams(layoutParams);

				seat.setX(gridSize + gridSize * x);
				seat.setY(gridSize + gridSize * y);
				seat.getLayoutParams().height = cellSize;
				seat.getLayoutParams().width = cellSize;
				absoluteLayout.addView(seat);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
