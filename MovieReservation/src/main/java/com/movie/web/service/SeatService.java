package com.movie.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.movie.web.entity.Seat;

public class SeatService {

	public List<Seat> getCertainAudiSeatList(String audiId) {

		List<Seat> list = new ArrayList<>();

		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "select seatId, pub from seat where audiId= ? ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, audiId);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String seatId = rs.getString("seatId");
				Boolean pub = rs.getBoolean("pub");

				Seat seat = new Seat();
				seat.setSeatId(seatId);
				seat.setPub(pub);

				list.add(seat);
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

	public int updateSeatSell(String audiId, String seatName) {
		int result = 0;
		
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = String.format("update seat set pub = 0 where audiId = '%s' and seatId in (%s)", audiId, seatName);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			Statement st = con.createStatement();

			result = st.executeUpdate(sql);

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int updateSeatPub(String audiId, String seatName) {
		int result = 0;
		
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = String.format("update seat set pub = 1 where audiId = '%s' and seatId in (%s)", audiId, seatName);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			Statement st = con.createStatement();

			result = st.executeUpdate(sql);

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
