package model.bo;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

import model.bean.Comment;
import model.bean.HangHoa;
import model.dao.*;
public class showListCommentBO {
	
	showListCommentDAO showListCommentDAO=new showListCommentDAO();
	public  ArrayList<Comment> getListComment(String proId){
		
		return showListCommentDAO.getListComment(proId);
		}
	public long CheckDay(String proId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 	Calendar d1 = Calendar.getInstance();
	        Calendar d2 = Calendar.getInstance();
	        Date date2=Date.valueOf(java.time.LocalDate.now());
	        Date date1 = Date.valueOf(showListCommentDAO.getDateTime(proId));
	        d1.setTime(date1);
	        d2.setTime(date2);
	        long noDay = (d2.getTime().getTime() - d1.getTime().getTime());
	        return noDay/86400000;
		
	}
	public void BlockComment(String proid) {
		// TODO Auto-generated method stub
		showListCommentDAO.BlockComment(proid);
	}
	public ArrayList<HangHoa> GetDetailHangHoa(String proId){
		return showListCommentDAO.GetDetailHangHoa(proId);
	}
	}
