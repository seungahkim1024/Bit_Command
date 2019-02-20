package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ImageDTO;
import enums.ImageSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAOImpl instance = new ImageDAOImpl();
	
	private ImageDAOImpl() {}
	public static ImageDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertImage(ImageDTO img) {
		System.out.println("인서트 이미지진입!");
		try {
			String sql = ImageSQL.IMG_ADD.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getOwner());
			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"입력성공":"입력실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ImageDTO> selectimageList() {
		ArrayList<ImageDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ImageDTO> selectImages(Proxy pxy) {
		ArrayList<ImageDTO> list = new ArrayList<>();
		try {
			String sql = "";
			DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ImageDTO selectimage(ImageDTO img) {
		ImageDTO image = new ImageDTO();
		try {
			String sql = ImageSQL.SELECT_ONE_IMG.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, img.getImgSeq());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				image.setImgSeq(rs.getString("IMG_SEQ"));
				image.setImgName(rs.getString("IMG_NAME"));
				image.setImgExtention(rs.getString("IMGEXTENTION"));
				image.setOwner(rs.getString("OWNER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

	@Override
	public int countImage(Proxy pxy) {
		int img = 0;
		try {
			String sql = "";
			DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public void updateImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean existImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String lastimageSeq() {
		String seq = "";
		try {
			String sql = ImageSQL.IMG_LAST_SEQ.toString();
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				seq = rs.getString("IMG_SEQ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seq;
	}

}
