package dao;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageDAO {
	
	public void insertImage(ImageDTO img);
	public List<ImageDTO> selectimageList();
	public List<ImageDTO> selectImages(Proxy pxy);
	public ImageDTO selectimage(ImageDTO img);
	public String lastimageSeq();
	public int countImage(Proxy pxy);
	public boolean existImage(ImageDTO img);
	public void updateImage(ImageDTO img);
	public void deleteImage(ImageDTO img);
	
}
