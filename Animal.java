import java.util.Random;


public class Animal {
	//Current Stat Fields
	protected int health;
	protected int str;
	protected int def;
	protected int agil;
	protected int intel;


	
	//Base Stat Fields
	final private int rhealth;
	final private int rstr;
	final private int rdef;
	final private int ragil;
	final private int rintel;
	
	//Identidy
	private String name;
	private String species;
	final public String[] abilList = {"Normal Strike", "Ferocious Strike", "Increase Safety", "Recuperate"};
	final private int lvl;
	final private int exp;
	final private int deathCount;
	final private int killCount;
	final private int killStreak;

	
	public Animal(String name, String species, int health, int str, int def, int agil, int intel){
		this.name = name;
		this.species = species;
		this.health = health;
		this.str = str;
		this.def = def;
		this.agil = agil;
		this.intel = intel;
		rhealth = health;
		rstr = str;
		rdef = def;
		ragil = agil;
		rintel = intel;
		
		this.lvl = 1;
		this.exp = 0;
		this.deathCount = 0;
		this.killCount = 0;
		this.killStreak = 0;
	}
	
	//Base moves
	
	//Accessors
	
	//Randomizer, Chance to hit

	protected int rdzr(){
		Random rand = new Random();
		return rand.nextInt(10);	
	}
	
	protected int rdzr(int x){
		Random rand = new Random();
		return rand.nextInt(x);	
	}
	
	protected boolean cth(Animal targ){
		Random rand = new Random();
		if (rand.nextInt(10)*targ.agil > 100)
			return false;
		return true;	
	}
	
	protected boolean cth(Animal targ, int hitMod){
		Random rand = new Random();
		if (rand.nextInt(10)*targ.agil > 100 - hitMod)
			return false;
		return true;	
	}
	//Blocking
	protected int absorb(int dmgIn){
		Random rand = new Random();
		

	}
	
	//All kinds of crits
	protected int crit(int atkDmg){
		Random rand = new Random();
		if(rand.nextInt(100) < this.intel){
			return atkDmg * 2;
		}return atkDmg;
	}
	
	protected int crit(int atkDmg, double critDmgMult){
		Random rand = new Random();
		if(rand.nextInt(100) < this.intel){
			return (int) (atkDmg * critDmgMult);
		}return atkDmg;
	}
	
	protected int crit(int atkDmg, int critChanceAdd){
		Random rand = new Random();
		if(rand.nextInt(100) < this.intel + critChanceAdd){
			return atkDmg * 2;
		}return atkDmg;
	}
	
	protected int crit(int atkDmg, int critChanceAdd, double critDmgMult){
		Random rand = new Random();
		if(rand.nextInt(100) < this.intel + critChanceAdd){
			return (int) (atkDmg * critDmgMult);
		}return atkDmg;
	}
	
}
