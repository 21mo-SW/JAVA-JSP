package composite;

import lombok.Data;

@Data
public class ShrimpBurgerSet {
	private ShrimpBurger shrimpBurger;
	private Coke coke;
	private FrenchFried frenchFried;
	
	public ShrimpBurgerSet() {
		this(
			  new ShrimpBurger(),
			  new Coke(),
			  new FrenchFried()
				);
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, Coke coke, FrenchFried frenchFried) {
		this.shrimpBurger = shrimpBurger;
		this.coke = coke;
		this.frenchFried = frenchFried;
	}
}
