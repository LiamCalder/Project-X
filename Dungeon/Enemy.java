public class Enemy {
    private int hp;
	public boolean isDead = false;
	Player pl = new Player();

	public void takeDamage(int d) {
		hp -=d;
	}
    public void setHealth(int h) {
		hp = h;
	}
	public int getHealth() {
		return hp;
	}
	
	public void setDead(boolean d) {
		isDead = d;
	}
	public boolean getDead() {
		return isDead;
	}
}