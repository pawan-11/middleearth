package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Action.Attack;
import model.Action.Move;
import model.Action.Rotate;
import strategy.ActionController;

abstract public class Living {

	protected PropertyChangeSupport ps = new PropertyChangeSupport(this);
	protected double health;
	protected double[] pos = new double[] {0,0,0};
	protected double angle = 90;
	protected double moveSpeed = 10, rotateSpeed = 5;
	
	protected double actualSize, apparentSize;
	
	protected ActionController actionController; 

	public Living(double health) {
		this.health = health;
	}
	
	abstract public void getReadyFor(Game game);
	
	
	public void executeActions(World world) {
		List<Action> actions = new ArrayList<Action>();
		double[] nextPos = actionController.getMove();
		double nextAngle = actionController.getRotate();
		Attack nextAttack = actionController.getAttack();

		Move nextMove = new Move(pos, nextPos);
		Rotate nextRotate = new Rotate(angle, nextAngle);
		
		actions.add(nextMove);
		actions.add(nextRotate);
		actions.add(nextAttack);

		for (Action action: actions) {
			action.execute(world, this);
		}
	}
	
	public void addPropertyListener(PropertyChangeListener pcs) {
		ps.addPropertyChangeListener(pcs);
	}
	
	public void addPropertyListener(String name, PropertyChangeListener pcs) {
		ps.addPropertyChangeListener(name, pcs);
	}
	
	public void setAngle(double angle) {	
		double oldAngle = this.angle;
		this.angle = angle;
		ps.firePropertyChange("angle", oldAngle, angle);
	}
	
	public double rotate(double r_delta) {
		return angle+r_delta*rotateSpeed;
	}
	
	public void move(double[] nextPos) {	
		move(nextPos[0], nextPos[1], nextPos[2]);
	}
	
	public void move(double x, double y, double z) {	
		double[] oldPos = this.pos.clone();
		pos[0] = x; pos[1] = y; pos[2] = z;
		//System.out.println("moved from ,"+Arrays.toString(oldPos)+" to "+Arrays.toString(pos));
		ps.firePropertyChange("position", oldPos, this.pos);
	}
	
	public double[] translate(double x_delta, double y_delta, double z_delta) {
		return new double[] {pos[0]+x_delta*moveSpeed, pos[1]+y_delta*moveSpeed, pos[2]+z_delta*moveSpeed};
	}
}
