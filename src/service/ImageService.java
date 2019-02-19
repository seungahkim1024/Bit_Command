package service;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageService {
	
	public void addImage(ImageDTO img);
	public List<ImageDTO> retrieveimageList();
	public List<ImageDTO> retrieveImages(Proxy pxy);
	public ImageDTO retrieveimage(ImageDTO img);
	public int countImage(Proxy pxy);
	public boolean existImage(ImageDTO img);
	public void modifyImage(ImageDTO img);
	public void deleteImage(ImageDTO img);
	
}
