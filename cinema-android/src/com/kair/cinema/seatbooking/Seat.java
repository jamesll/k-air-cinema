package com.kair.cinema.seatbooking;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import com.kair.cinema.R;

public class Seat extends Button {

	private static final String SEAT_STATUS_EMPTY = "SEAT_STATUS_EMPTY";
	private static final String SEAT_STATUS_BOOKED = "SEAT_STATUS_BOOKED";

	private String status;
	private Button button;

	private Dialog emptySeatDialog;
	private Dialog bookedSeatDialog;

	private OnClickListener onClickListener;

	public Seat(final Context context) {
		super(context);
		status = SEAT_STATUS_EMPTY;
		this.setBackgroundColor(Color.GRAY);
		initialEmptySeatDialog(context);

		onClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (status.equals(SEAT_STATUS_EMPTY)) {
					emptySeatDialog.show();
				}
				else {
					initialBookedSeatDialog(context);
					bookedSeatDialog.show();
				}
			}

		};
		this.setOnClickListener(onClickListener);
	}

	private void initialEmptySeatDialog(final Context context) {
		emptySeatDialog = new Dialog(context);
		emptySeatDialog.setContentView(R.layout.empty_seat_view);
		button = (Button) emptySeatDialog.findViewById(R.id.seat_dialog_button_book);
		button.setOnClickListener(bookListener);
		button = (Button) emptySeatDialog.findViewById(R.id.seat_dialgo_button_cancel);
		button.setOnClickListener(cancelListener);
	}

	private void initialBookedSeatDialog(final Context context) {
		bookedSeatDialog = new Dialog(context);
		bookedSeatDialog.setContentView(R.layout.booked_seat_view);

	}

	private OnClickListener bookListener = new OnClickListener() {

		public void onClick(View v) {
			setStatus(SEAT_STATUS_BOOKED);
			emptySeatDialog.dismiss();
		}
	};

	private OnClickListener cancelListener = new OnClickListener() {

		public void onClick(View v) {
			emptySeatDialog.cancel();
		}
	};

	public void bookSeat() {
		status = SEAT_STATUS_BOOKED;
	}

	public String getStatus() {
		return status;
	}

	public void setAssignment(String assignment) {
		this.setText(assignment);
		this.setTextSize(12);
	}

	public void setStatus(String status) {
		this.status = status;
		if (status.equals(SEAT_STATUS_BOOKED)) {
			this.setBackgroundColor(Color.BLUE);
		}
		else {
			this.setBackgroundColor(Color.BLUE);
		}
	}

}
