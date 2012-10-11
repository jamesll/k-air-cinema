package com.kair.cinema.db;

import java.util.ArrayList;
import java.util.List;
import com.kair.cinema.R;
import com.kair.cinema.vo.MovieGridItem;

public class MovieDao {

	public List<MovieGridItem> findMovieGridItem() {
		ArrayList list = new ArrayList<MovieGridItem>();
		// list.add(new MovieGridItem("Double Xposeure",
		// R.drawable.double_xposeure_small));
		list.add(new MovieGridItem("End of Watch", R.drawable.end_of_watch_small));
		list.add(new MovieGridItem("Finding Nemo", R.drawable.finding_nemo_small));
		list.add(new MovieGridItem("Frankenweenie", R.drawable.frankenweenie_small));
		list.add(new MovieGridItem("Looper", R.drawable.looper_small));
		list.add(new MovieGridItem("Pitch Perfect", R.drawable.pitch_perfect_small));
		list.add(new MovieGridItem("Taken 2", R.drawable.taken2_small));
		list.add(new MovieGridItem("Arbitrage", R.drawable.arbitrage));
		list.add(new MovieGridItem("Avengers", R.drawable.avengers));
		list.add(new MovieGridItem("Hit and Run", R.drawable.hit_run));
		list.add(new MovieGridItem("Lawless", R.drawable.lawless));
		list.add(new MovieGridItem("John Carter", R.drawable.john_carter));
		list.add(new MovieGridItem("Journey", R.drawable.journey2));
		list.add(new MovieGridItem("Resident Evil", R.drawable.resident_evil));

		return list;
	}
}
