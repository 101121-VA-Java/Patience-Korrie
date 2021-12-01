package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
		List<Reimb> reimb = new ArrayList<>();
		
		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			String sql = "select * from reimb;";
			
			Statement ps = c.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				
				int id = rs.getInt("re_id");
				int authorId = rs.getInt("re_authorId");
				double amount = rs.getDouble("re_amount");
				String submitted = rs.getString("re_submitted");
				String resolved = rs.getString("re_resolved");
				String description = rs.getString("re_description");
				int resolverId = rs.getInt("re_resolverId");
				int statusId = rs.getInt("re_statusId");
				int typeId = rs.getInt("re_typeId");
				
				Reimb r = new Reimb(id,authorId,amount,submitted,resolved,description,resolverId,statusId,typeId);
				reimb.add(r);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	
	@Override
	public Reimb addReimb(Reimb reimb) {
		Reimb resultId = null;
		String sql = "insert into reimb(re_amount,re_typeId,re_description,re_submitted,re_statusId,re_authorId)" + "values (?,?,?,?,?,?) returning re_id;";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, reimb.getAmount());
			ps.setInt(2, reimb.getType());
			ps.setString(3, reimb.getDescription());
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.setInt(5, reimb.getStatus());
			ps.setInt(6, reimb.getAuthor());
			
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
		String sql = "update reimb set re_status = ?, re_resolverId = ?, re_resolved = ?  Where u_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, r.getStatus());
			ps.setInt(2, r.getResolver().getId());
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setInt(5, r.getId());
			
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

	@Override
	public Reimb getReimbById(int id) {
		String sql = "select re_amount,re_submitted,re_resolved,re_description,re_resolverId,re_typeId from reimb r where r.re_Id = ?;";
		Reimb allReimb1 = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id); 

			ResultSet rs = ps.executeQuery();
			
		if (rs.next()) {
			int authorId = rs.getInt("re_authorId");
			double amount = rs.getDouble("re_amount");
			String submitted = rs.getString("re_submitted");
			String resolved = rs.getString("re_resolved");
			String description = rs.getString("re_description");
			int resolverId = rs.getInt("re_resolverId");
			int typeId = rs.getInt("re_typeId");
			
			 allReimb1 = new Reimb(authorId,amount,submitted,resolved,description,resolverId,typeId);
			
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			}
		
		return allReimb1;
	}


	@Override
	public List<Reimb> getReimbsById(int id) {
		String sql = "select re_id,re_amount,re_submitted,re_resolved,re_description,re_resolverId,re_typeId from reimb r where r.re_authorId = ?;";
		List<Reimb> allReimbs = new ArrayList<>();
		
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
			
			 Reimb allReimb = new Reimb(id1,amount,submitted,resolved,description,resolverId,typeId);
			 
			 allReimbs.add(allReimb);
			
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			}
		
		return allReimbs;
	}


	
	

}
