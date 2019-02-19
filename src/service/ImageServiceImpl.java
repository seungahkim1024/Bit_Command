package service;

import java.util.List;

import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService{
	private static ImageServiceImpl instance = new ImageServiceImpl();
	public ImageServiceImpl() { dao=ImageDAOImpl.getInstance();}
	public static ImageServiceImpl getInstance() {
		return instance;
	}

	ImageDAOImpl dao;
	
	@Override
	public void addImage(ImageDTO img) {
		dao.insertImage(img);
	}

	@Override
	public List<ImageDTO> retrieveimageList() {
		
		return dao.selectimageList();
	}

	@Override
	public List<ImageDTO> retrieveImages(Proxy pxy) {
		
		return dao.selectImages(pxy);
	}

	@Override
	public ImageDTO retrieveimage(ImageDTO img) {
		// TODO Auto-generated method stub
		return dao.selectimage(img);
	}

	@Override
	public int countImage(Proxy pxy) {
		
		return dao.countImage(pxy);
	}

	@Override
	public boolean existImage(ImageDTO img) {
		
		return dao.existImage(img);
	}

	@Override
	public void modifyImage(ImageDTO img) {
		dao.updateImage(img);
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		dao.deleteImage(img);
		
	}

}
