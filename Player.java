public class Player {
    private String name;
    private int damage=10;
    private int health=100;
    public Player(String name){
        this.name=name;
    }
    public int getHealth(){
        return health;
    }
    public int getDamage(){
        return damage;
    }
    public void setHealth(int health){
        if(health<0){
        this.health=0;
        }
        else{
            this.health=health;
        }
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
}
