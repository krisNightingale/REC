package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named(value = "check_controller")
@RequestScoped
public class CheckController {

	@EJB
	private CheckEJB checkEJB;
	private Check check = new Check();
	private List<Check> list = new ArrayList<>();
	
	@EJB
	private MenuEJB menuEJB;	
	private List<SelectItem> selectList = new ArrayList<>();
	
	public List<SelectItem> getSelectList() {
		List<SelectItem> newList = new ArrayList<>();
		
		for(Menu menu : menuEJB.findMenuItems()) {
			newList.add(new SelectItem(menu, menu.getName()));
		}	
        return newList;
    }

	public List<Check> getCheckList() {
		list = null;
		list = checkEJB.findChecks();
		return list;
	}

	public String viewCheck() {
		return "check_list.xhtml";
	}

	public String addNewCheck() {
		check.setTime(new Timestamp(System.currentTimeMillis()));
		check = checkEJB.addNewCheck(check);
		list = checkEJB.findChecks();
		return "check_list.xhtml";
	}

	public CheckEJB getCheckEJB() {
		return checkEJB;
	}

	public void setCheckEJB(CheckEJB checkEJB) {
		this.checkEJB = checkEJB;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public List<Check> getList() {
		return getCheckList();
	}

	public void setList(List<Check> list) {
		this.list = list;
	}

}
