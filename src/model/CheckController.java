package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "check_controller")
@RequestScoped
public class CheckController {

	@EJB
	private CheckEJB checkEJB;
	private Check check = new Check();
	private List<Check> checkList = new ArrayList<>();

	public List<Check> getCheckList() {
		checkList = checkEJB.findChecks();
		return checkList;
	}

	public String viewCheck() {
		return "check_list.xhtml";
	}

	public String addNewCheck() {
		check = checkEJB.addNewCheck(check);
		checkList = checkEJB.findChecks();
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

	public void setCheckList(List<Check> checkList) {
		this.checkList = checkList;
	}
}
