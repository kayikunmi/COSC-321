
/** a place to store the axiom and rules for an L-System plant *
 */
public class APlant extends Ri{
 
	protected String axiom;
	protected String[] rules;
	
	
	public void setAxiom(String axiom) {
		this.axiom = axiom;
	}


	public void setRules(String[] rules) {
		this.rules = rules;
	}

	public String getAxiom() {
		return axiom;
	}


	public String[] getRules() {
		return rules;
	}

/** should return -1 unless the Plant grammar is using different probabilities for different rules - see AProbPlant
 * 
 */
	
	public double getProb(String rule) {
		return -1;
	}


	
	
	

	

}
