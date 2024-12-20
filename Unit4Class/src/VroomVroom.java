
public class VroomVroom {
	private double locX, locY, speed, mpg, gas;
	private int dir = 0;
	public VroomVroom() {
		locX = Math.random()*100-50;
		locY = Math.random()*100-50;
		speed = Math.random()*30+40;
		gas = 20;
		mpg = Math.random()*10+20;
	}
	public String toString() {
		String output =  "";
		output += "Im located at approximately " +  Math.ceil(locX) + ", " +  Math.ceil(locY) + "\n";
		output += "Facing " + dir + "\n";
		output += "My tank is: " + gas + " burning at " + Math.ceil(mpg);
		return output;
	}
	public void move(int distance) {
		switch(dir){
			case 90:
				locX += distance;
			case 180:
				locY -= distance;
			case 270:
				locX -= distance;
			case 0, 360:	
				locY += distance;
		}
	}
	public void move(int x, int y) {
		locX = x;
		locY = y;
	}
	public void turnRight() {
		dir =(dir + 90)%360;
	}
	public void turnLeft() {
		dir = (dir - 90)%360;
		if (dir < 0)
			dir = 270;
	}
	public String distanceFromHome() {
		String distanceFromHome = "You are " +
		Math.sqrt((Math.pow(locX , 2) + Math.pow(locY , 2))) +
		" units from home";
		return distanceFromHome;
	}
}
