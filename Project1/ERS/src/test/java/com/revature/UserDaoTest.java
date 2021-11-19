package com.revature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgres;

import util.ConnectionUtil;

@ExtendWith(MockitoExtension.class)

public class UserDaoTest {

	private UserDao ud = new UserPostgres();
	
	@Test
	public void getByIdDoesNotExists() {
		assertNull(ed.getEmployeeById(25));
	}
	
	
//	private static MockedStatic<ConnectionUtil> mockedConnectionUtil;
//	private static Connection con;
//	
//	@BeforeAll
//	public static void init() {
//		mockedConnectionUtil = Mockito.mockStatic(ConnectionUtil.class);
//		mockedConnectionUtil.when(ConnectionUtil::getConnectionFromFile())
//		.then(I -> getH2Connection());
//	}
//	
//	@AfterAll
//	public static void end() {
//		
//		mockedConnectionUtil.close();
//	}
//	
//	@BeforeEach
//	public void setUp() {
//		try(Connection c = ConnectionUtil.getConnectionFromFile()){
//			RunScript.execute(c, new FileReader("setup.sql"));
//		} catch (SQLException | FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
