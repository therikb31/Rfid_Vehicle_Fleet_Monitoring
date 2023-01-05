package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import com.models.Reader;
import com.properties.Queries;
import com.utils.DBConnector;

public class ReaderDAO {
	public static Vector<Reader> getReaderActivityByDateRange(Date from_date, Date to_date) {
		Vector<Reader> readers = getReaders();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			for (Iterator<Reader> iter = readers.iterator(); iter.hasNext();) {
				Reader reader = iter.next();
				PreparedStatement ps = conn.prepareStatement(Queries.READER_RETRIEVE_ACTIVITY_COUNT_BY_DATE_RANGE);
				ps.setString(1, reader.getReader_id());
				ps.setDate(2, from_date);
				ps.setDate(3, to_date);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					reader.setActivity(rs.getInt(1));
//				System.out.println(reader.getReader_id()+":"+ rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sortReaderVector(readers);

	}
	public static Vector<Reader> sortReaderVector(Vector<Reader> arr) {
		int len = arr.size();
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(arr.elementAt(i).getActivity() < arr.elementAt(j).getActivity()) {
					Collections.swap(arr, i, j);
				}
			}
		}
		return arr;
	}
	public static Vector<Reader> getReaderActivity(Date date){
		Vector<Reader> readers = getReaders();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			for(Iterator<Reader> iter = readers.iterator();iter.hasNext();) {
				Reader reader = iter.next();
				PreparedStatement ps = conn.prepareStatement(Queries.READER_RETRIEVE_ACTIVITY_COUNT);
				ps.setString(1, reader.getReader_id());
				ps.setDate(2, date);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					reader.setActivity(rs.getInt(1));
//					System.out.println(reader.getReader_id()+":"+ rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sortReaderVector(readers);
	}
	@SuppressWarnings("finally")
	public static boolean checkReader(String reader_id) {
		boolean res = false;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.READER_RETRIEVE_BY_READER_ID);
			ps.setString(1, reader_id);
			ResultSet rs = ps.executeQuery();
			res = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return res;
		}
		
	}
	public static Reader getReaderByReaderId(String reader_id){
		Connection conn = null;
		Reader reader = new Reader();
		PreparedStatement ps;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.READER_RETRIEVE_BY_READER_ID);
			ps.setString(1, reader_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reader.setReader_id(rs.getString("reader_id"));
				reader.setAddress(rs.getString("address"));
				reader.setLat(rs.getString("lat"));
				reader.setLon(rs.getString("lon"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}
	
	public static Vector<Reader> getReaders(){
		Connection conn = null;
		Vector<Reader> readers = new Vector<Reader>();
		PreparedStatement ps;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.READER_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reader reader = new Reader();
				reader.setReader_id(rs.getString("reader_id"));
				reader.setAddress(rs.getString("address"));
				reader.setLat(rs.getString("lat"));
				reader.setLon(rs.getString("lon"));
				readers.add(reader);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return readers;
	}
	public static boolean addReader(Reader reader) {
		Connection conn = null;
		conn = DBConnector.getConnection();
		if (conn == null) {
			System.out.println("Database Error, failed to insert data into Vehicle");
			return false;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.READER_INSERT);
			ps.setString(1, reader.getReader_id());
			ps.setString(2, reader.getAddress());
			ps.setString(3, reader.getLat());
			ps.setString(4, reader.getLon());
			int rowcount = ps.executeUpdate();
			if (rowcount > 0) {
				System.out.println("Added 1 rows successfully into Reader");
				return true;

			} else {
				System.out.println("Database Error, failed to insert data into Reader");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@SuppressWarnings("unused")
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.READER_CREATE);
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		for(Iterator<Reader> iter = getReaderActivity(Date.valueOf("2022-12-24")).iterator();iter.hasNext();) {
			System.out.println(iter.next().toString());
		}
//		Reader reader = getReaderByReaderId("P9LR13");
//		System.out.println(reader.toString());
//		reader.setReader_id("rid");
//		reader.setAddress("Novotel");
//		reader.setLat("22.2");
//		reader.setLon("88.4");
//		addReader(reader);
//		createTable();
	}
	
}
