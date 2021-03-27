package model.bo;

import java.util.ArrayList;

import model.bean.Accounts;
import model.dao.ShowListAccountDAO;




public class ShowListAccountBO {
	ShowListAccountDAO showListAccountDAO=new ShowListAccountDAO();
	public ArrayList<Accounts> getdsAccount(){
		
		return showListAccountDAO.getdsAccount();
	}
}
