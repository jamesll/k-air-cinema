package com.kair.cinema.db;

import java.util.ArrayList;
import java.util.List;

import com.kair.cinema.R;
import com.kair.cinema.vo.MovieGridItem;

public class MovieDao {
    public List<MovieGridItem> findMovieGridItem() {
        ArrayList list = new ArrayList<MovieGridItem>();
        list.add(new MovieGridItem("name1", R.drawable.a_0));
        list.add(new MovieGridItem("name2", R.drawable.a_1));
        list.add(new MovieGridItem("name3", R.drawable.a_2));
        list.add(new MovieGridItem("name4", R.drawable.a_3));
        list.add(new MovieGridItem("name5", R.drawable.a_4));
        list.add(new MovieGridItem("name6", R.drawable.a_5));
        list.add(new MovieGridItem("name6", R.drawable.a_6));
        list.add(new MovieGridItem("name7", R.drawable.a_7));
        list.add(new MovieGridItem("name8", R.drawable.a_0));
        list.add(new MovieGridItem("name9", R.drawable.a_0));
        list.add(new MovieGridItem("name10", R.drawable.a_0));
        list.add(new MovieGridItem("name1", R.drawable.a_0));
        list.add(new MovieGridItem("name2", R.drawable.a_1));
        list.add(new MovieGridItem("name3", R.drawable.a_2));
        list.add(new MovieGridItem("name4", R.drawable.a_3));
        list.add(new MovieGridItem("name5", R.drawable.a_4));
        list.add(new MovieGridItem("name6", R.drawable.a_5));
        list.add(new MovieGridItem("name6", R.drawable.a_6));
        list.add(new MovieGridItem("name7", R.drawable.a_7));
        list.add(new MovieGridItem("name8", R.drawable.a_0));
        list.add(new MovieGridItem("name9", R.drawable.a_0));
        list.add(new MovieGridItem("name10", R.drawable.a_0));

        return list;
    }
}
