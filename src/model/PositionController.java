package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "position_controller")
@RequestScoped
public class PositionController {

	@EJB
	private PositionEJB positionEJB;
	private Position position = new Position();
	private List<Position> list = new ArrayList<>();

	public List<Position> getPositionList() {
		list = positionEJB.findPositions();
		return list;
	}

	public String addNewPosition() {
		position = positionEJB.addNewEmployee(position);
		list = positionEJB.findPositions();
		return "position_list.xhtml";
	}

	public PositionEJB getPositionEJB() {
		return positionEJB;
	}

	public void setPositionEJB(PositionEJB positionEJB) {
		this.positionEJB = positionEJB;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Position> getList() {
		return getPositionList();
	}

	public void setList(List<Position> list) {
		this.list = list;
	}
	
	public Position getOnePosition(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Position position : getPositionList()){
            if (id.equals(position.getIdPosition())){
                return position;
            }
        }
        return null;
    }
	
}
