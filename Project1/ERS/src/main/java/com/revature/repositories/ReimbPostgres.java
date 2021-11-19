package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimb;

import util.ConnectionUtil;

public class ReimbPostgres implements ReimbDao {

	@Override
	public List<Reimb> getAllReimb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimb getReimbById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimb addReimb(Reimb reimb) {
		Reimb resultId = null;
		String sql = "insert into Reimb(re_amount,re_author,re_type,re_description)" + "values (?,?,?,?) returning re_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, reimb.getAmount());
			ps.setInt(2, reimb.getAuthor().getId());
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				resultId = reimb;
			}
			
		}catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultId;
	}

}
