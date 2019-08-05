public class Enemy {
    int hp;
	public boolean isDead = false;
	Player pl = new Player();

    public void setHealth(int h) {
		hp = h;
	}
	
	public int getHealth() {
		return hp;
	}
}