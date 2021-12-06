package com.movie.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.movie.web.entity.Movie;
import com.movie.web.entity.MovieListView;

public class MovieService {

	public List<Movie> getMovieList() {

		List<Movie> list = new ArrayList<>();

		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "select * from movie";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String movieId = rs.getString("movieId");
				String name = rs.getString("name");
				String genre = rs.getString("genre");
				String content = rs.getString("content");
				Date openDay = rs.getDate("openDay");
				String files = rs.getString("files");

				Movie movie = new Movie(movieId, name, genre, content, openDay, files);
				list.add(movie);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<MovieListView> getMovieViewList() {
		List<MovieListView> list = new ArrayList<>();

		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "select * from movie_list_view";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String movieId = rs.getString("movieId");
				String name = rs.getString("name");
				String genre = rs.getString("genre");
				String content = rs.getString("content");
				Date openDay = rs.getDate("openDay");
				String files = rs.getString("files");
				String scheduleId = rs.getString("scheduleId");
				Date screenDay = rs.getDate("screenDay");
				String audiId = rs.getString("audiId");
				int totalSeat = rs.getInt("totalSeat");
				
				MovieListView movieView = new MovieListView(movieId,
						name,
						genre,
						content,
						openDay,
						files,
						scheduleId,
						screenDay,
						audiId,
						totalSeat);
						
				list.add(movieView);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
