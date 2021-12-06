package com.movie.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.movie.web.entity.Payment;
import com.movie.web.entity.PaymentView;
import com.movie.web.entity.Seat;

public class PaymentService {
	
	public List<PaymentView> getUserPayListAll(String sessionId) {
		List<PaymentView> list = new ArrayList<>();

		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "select * from payment_view where memberId = ?;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, sessionId);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String payId = rs.getString("payId");
				String movieId = rs.getString("movieId");
				String method = rs.getString("method");
				int totalPrice = rs.getInt("totalPrice");
				Date payDay = rs.getDate("payDay");
				String memberId = rs.getString("memberId");
				String audiId = rs.getString("audiId");
				String seatName = rs.getString("seatName");
				String screenDay = rs.getString("screenDay");
				String name = rs.getString("name");
				
				PaymentView paymentView = new PaymentView(payId, 
						movieId, 
						method, 
						totalPrice, 
						payDay,
						memberId,
						audiId,
						seatName,
						screenDay,
						name);

				list.add(paymentView);
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
	

	public int insertPayment(Payment payment) {
		int result = 0;
		
		SeatService service = new SeatService();
		int secondResult = 0;
		secondResult = service.updateSeatSell(payment.getAudiId(), payment.getSeatName());
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "insert into payment(movieId, method, totalPrice, memberId, audiId, seatName, screenDay) "
				+ "values (?, ?, ?, ?, ?, ?, ?) ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, payment.getMovieId());
			st.setString(2, payment.getMethod());
			st.setInt(3, payment.getTotalPrice());
			st.setString(4, payment.getMemberId());
			st.setString(5, payment.getAudiId());
			st.setString(6, payment.getSeatName());
			st.setString(7, payment.getScreenDay());
			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (secondResult <= 0 && result <= 0)
			result = 0;
		else
			result = 1;
		
		return result;
	}


	public int deleteReservation(String payId, String audiId, String seatName) {
		int result = 0;
		
		SeatService service = new SeatService();
		int secondResult = 0;
		secondResult = service.updateSeatPub(audiId, seatName);
		String url = "jdbc:mysql://127.0.0.1:3306/theater_db";
		String sql = "delete from payment where payId = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "hoseok", "!dlghtjr4948");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, payId);
			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (secondResult <= 0 && result <= 0)
			result = 0;
		else
			result = 1;
		
		return result;
	}

}
