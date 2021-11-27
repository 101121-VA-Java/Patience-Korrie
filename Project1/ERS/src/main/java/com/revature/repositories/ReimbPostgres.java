package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Reimb;

import util.ConnectionUtil;

public class ReimbPostgres implements ReimbDao {
	private static Logger log = LogManager.getRootLogger();

	@Override
	public List<Reimb> getAllReimb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimb getAllReimbById(int id) {
		String sql = "select re_id,re_amount,re_submitted,re_resolved,re_description,re_resolverId,re_typeId from reimb r where r.re_authorId = ?;";
		Reimb allReimb = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();
			
		if (rs.next()) {
			int id1 = rs.getInt("re_id");
			double amount = rs.getDouble("re_amount");
			String submitted = rs.getString("re_submitted");
			String resolved = rs.getString("re_resolved");
			String description = rs.getString("re_description");
			int resolverId = rs.getInt("re_resolverId");
			int typeId = rs.getInt("re_typeId");
			
			 allReimb = new Reimb(id1,amount,submitted,resolved,description,resolverId,typeId);
			
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			}
		
		return allReimb;
	}

	@Override
	public Reimb addReimb(Reimb reimb) {
		Reimb resultId = null;
		String sql = "insert into reimb(re_amount,re_authorId,re_type,re_description)" + "values (?,?,?,?) returning re_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, reimb.getAmount());
			ps.setInt(2, reimb.getAuthor().getId());
			ps.setInt(3, reimb.getType().getId());
			ps.setString(4, reimb.getDescription());
			
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

	@Override
	public List<Reimb> getAllPendingReimb() {
		String sql = "select * from reimb r" + "join status s on r.re_statusId = s.s_id" +
				"join reimb_type rt on r.re_typeId = rt.t_id where r.re_statusId= 2 ;";
		List<Reimb> pending =new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			Statement ps = connect.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("re_id");
				double amount = rs.getDouble("re_amount");
				String submitted = rs.getString("re_submitted");
				int statusId = rs.getInt("re_statusId");
				int typeId = rs.getInt("re_typeId");
				String description = rs.getString("re_description");
				int authorId = rs.getInt("re_authorId");
				
				
				
				Reimb pendingRqt = new Reimb(id, amount, submitted,statusId,typeId,description,authorId);
				pending.add(pendingRqt);
			}
			
		}catch (SQLException |IOException e) {
			log.error("Error while trying to get lists.");
			e.printStackTrace();
		
	}
		return pending;
	}

	@Override
	public List<Reimb> viewAllResolvedReimb() {
		String sql = "select re_id,re_amount,re_submitted,re_resolved,re_description,re_resolverId,re_typeId from reimb r \r\n"
				+ "join users u on r.re_authorId = u.u_id where re_statusId = '2';"; 
		
		List<Reimb> resolvedList = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("re_id");
				double amount = rs.getDouble("re_amount");
				String submitted = rs.getString("re_submitted");
				int statusId = rs.getInt("re_resolved");
				String description = rs.getString("re_description");
				int authorId = rs.getInt("re_resolverId");
				int typeId = rs.getInt("re_typeId");
				
				Reimb reList = new Reimb(id,amount,submitted,statusId,description,authorId,typeId);
				resolvedList.add(reList);
				
				}
		
		}catch (SQLException | IOException e) {
			log.error("Error while trying to get lists.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateReimb(Reimb r) {
		String sql = "update reimb set re_status = ?, re_resolverId = ?, re_resolved = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, r.getStatus().getId());
			ps.setInt(2, r.getResolver().getId());
			ps.setString(3, r.getResolved());
			
			rowsChanged = ps.executeUpdate();
			
		}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
			}
		}
	
	

}
