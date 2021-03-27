package model.bo;

import model.dao.CreateProductDAO;

public class CreateProductBO {
	
	
	CreateProductDAO createProductDAO = new CreateProductDAO();
	public void insertProduct(String maHH ,String tenHH, String dvt, String donGiaTK, String ghiChu) {
		createProductDAO.insertProduct(maHH, tenHH, dvt, donGiaTK, ghiChu);
	}
}
