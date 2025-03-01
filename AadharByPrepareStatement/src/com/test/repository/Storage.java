package com.test.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.Dao.Aadhar;

public class Storage<Gender> {

	public void createAdharRecord(Aadhar aadhar) {
		Connection connection = getConnection();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into AadharRegistration values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, aadhar.getSerialNumber());
			pstmt.setString(2, aadhar.getFirstName());
			pstmt.setString(3, aadhar.getLastName());
			pstmt.setString(4, aadhar.getFathersName());
			pstmt.setString(5, aadhar.getGender());
			pstmt.setInt(6, aadhar.getAge());
			pstmt.setLong(7, aadhar.getContactNumber());
			pstmt.setString(8, aadhar.getVillage());
			pstmt.setString(9, aadhar.getDistrict());
			pstmt.setString(10, aadhar.getState());
			pstmt.setString(11, aadhar.getCountry());
			pstmt.setString(12, aadhar.getPincode());
			pstmt.setInt(13, aadhar.getIncome());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "system");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public List<Aadhar> readAadharRecord(Aadhar aadhar) {
		Connection connection = getConnection();
		ArrayList<Aadhar> arraylist = null;
		try {
			arraylist = new ArrayList<Aadhar>();
			PreparedStatement pstmt = connection.prepareStatement("select * from  AadharRegistration");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Aadhar object = new Aadhar();
				object.setSerialNumber(rs.getInt(1));
				object.setFirstName(rs.getString(2));
				object.setLastName(rs.getString(3));
				object.setFathersName(rs.getString(4));
				object.setGender(rs.getString(5));
				object.setAge(rs.getInt(6));
				object.setContactNumber(rs.getLong(7));
				object.setVillage(rs.getString(8));
				object.setDistrict(rs.getString(9));
				object.setState(rs.getString(10));
				object.setCountry(rs.getString(11));
				object.setPincode(rs.getString(12));
				object.setIncome(rs.getInt(13));
				arraylist.add(object);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arraylist;

	}

	public String updateAadharRecord(Aadhar aadharlist) {
		Connection connection = getConnection();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("update AadharRegistration set firstName=?,lastName=?,fathersName=?,"
							+ "gender=?,age=?,contactNumber=?,village=?,District=?,State=?,country=?,pincode=?,income=? where Serialnumber =?");
			pstmt.setString(1, aadharlist.getFirstName());
			pstmt.setString(2, aadharlist.getLastName());
			pstmt.setString(3, aadharlist.getFathersName());
			pstmt.setString(4, aadharlist.getGender());
			pstmt.setInt(5, aadharlist.getAge());
			pstmt.setLong(6, aadharlist.getContactNumber());
			pstmt.setString(7, aadharlist.getVillage());
			pstmt.setString(8, aadharlist.getDistrict());
			pstmt.setString(9, aadharlist.getState());
			pstmt.setString(10, aadharlist.getCountry());
			pstmt.setString(11, aadharlist.getPincode());
			pstmt.setInt(12, aadharlist.getIncome());
			pstmt.setInt(13, aadharlist.getSerialNumber());
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "update successfully";

	}

	public Aadhar selectBySerialNumber(int sno) {
		Connection connection = getConnection();
		Aadhar aadharrecord = new Aadhar();
		try {
			PreparedStatement st = connection
					.prepareStatement("select * from AadharRegistration where serialnumber =?");
			st.setInt(1, sno);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				aadharrecord.setSerialNumber(rs.getInt(1));
				aadharrecord.setFirstName(rs.getString(2));
				aadharrecord.setLastName(rs.getString(3));
				aadharrecord.setFathersName(rs.getString(4));
				aadharrecord.setGender(rs.getString(5));
				aadharrecord.setAge(rs.getInt(6));
				aadharrecord.setContactNumber(rs.getLong(7));
				aadharrecord.setVillage(rs.getString(8));
				aadharrecord.setDistrict(rs.getString(9));
				aadharrecord.setState(rs.getString(10));
				aadharrecord.setCountry(rs.getString(11));
				aadharrecord.setPincode(rs.getString(12));
				aadharrecord.setIncome(rs.getInt(13));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aadharrecord;

	}

	public void deleteAadharRecord(int sno) {
		Connection connection = getConnection();

		try {
			PreparedStatement pstmt = connection
					.prepareStatement("delete from AadharRegistration where serialNumber =?");
			pstmt.execute("delete from AadharRegistration where serialNumber =" + sno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> maleAadharRecord(String gender) {

		Connection connection = getConnection();
		ArrayList genderList = new ArrayList();
		Aadhar genderrecord = new Aadhar();

		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from AadharRegistration where gender = ?");
			pstmt.setString(1, gender);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				genderrecord.setSerialNumber(rs.getInt(1));
				genderrecord.setFirstName(rs.getString(2));
				genderrecord.setLastName(rs.getString(3));
				genderrecord.setFathersName(rs.getString(4));
				genderrecord.setGender(rs.getString(5));
				genderrecord.setAge(rs.getInt(6));
				genderrecord.setContactNumber(rs.getLong(7));
				genderrecord.setVillage(rs.getString(8));
				genderrecord.setDistrict(rs.getString(9));
				genderrecord.setState(rs.getString(10));
				genderrecord.setCountry(rs.getString(11));
				genderrecord.setPincode(rs.getString(12));
				genderrecord.setIncome(rs.getInt(13));

				genderList.add(genderrecord);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genderList;

	}

	public ArrayList<String> fromSameDistrict(String district) {
		Connection connection = getConnection();
		ArrayList districtList = new ArrayList();
		Aadhar districtrecord = new Aadhar();

		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from AadharRegistration where district = ?");
			pstmt.setString(1, district);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				districtrecord.setSerialNumber(rs.getInt(1));
				districtrecord.setFirstName(rs.getString(2));
				districtrecord.setLastName(rs.getString(3));
				districtrecord.setFathersName(rs.getString(4));
				districtrecord.setGender(rs.getString(5));
				districtrecord.setAge(rs.getInt(6));
				districtrecord.setContactNumber(rs.getLong(7));
				districtrecord.setVillage(rs.getString(8));
				districtrecord.setDistrict(rs.getString(9));
				districtrecord.setState(rs.getString(10));
				districtrecord.setCountry(rs.getString(11));
				districtrecord.setPincode(rs.getString(12));
				districtrecord.setIncome(rs.getInt(13));

				districtList.add(districtrecord);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return districtList;
		
		
	}

	public List<String> fromSameState(String state) {
		Connection connection = getConnection();
		ArrayList stateList = new ArrayList();
		Aadhar staterecord = new Aadhar();

		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from AadharRegistration where state = ?");
			pstmt.setString(1, state);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				staterecord.setSerialNumber(rs.getInt(1));
				staterecord.setFirstName(rs.getString(2));
				staterecord.setLastName(rs.getString(3));
				staterecord.setFathersName(rs.getString(4));
				staterecord.setGender(rs.getString(5));
				staterecord.setAge(rs.getInt(6));
				staterecord.setContactNumber(rs.getLong(7));
				staterecord.setVillage(rs.getString(8));
				staterecord.setDistrict(rs.getString(9));
				staterecord.setState(rs.getString(10));
				staterecord.setCountry(rs.getString(11));
				staterecord.setPincode(rs.getString(12));
				staterecord.setIncome(rs.getInt(13));

				stateList.add(staterecord);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stateList;
		
	}

	public List<String> fromSameCountry(String country) {
		Connection connection = getConnection();
		ArrayList countryList = new ArrayList();
		Aadhar countryrecord = new Aadhar();

		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from AadharRegistration where country = ?");
			pstmt.setString(1, country);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				countryrecord.setSerialNumber(rs.getInt(1));
				countryrecord.setFirstName(rs.getString(2));
				countryrecord.setLastName(rs.getString(3));
				countryrecord.setFathersName(rs.getString(4));
				countryrecord.setGender(rs.getString(5));
				countryrecord.setAge(rs.getInt(6));
				countryrecord.setContactNumber(rs.getLong(7));
				countryrecord.setVillage(rs.getString(8));
				countryrecord.setDistrict(rs.getString(9));
				countryrecord.setState(rs.getString(10));
				countryrecord.setCountry(rs.getString(11));
				countryrecord.setPincode(rs.getString(12));
				countryrecord.setIncome(rs.getInt(13));

				countryList.add(countryrecord);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryList;
		
	}

}
