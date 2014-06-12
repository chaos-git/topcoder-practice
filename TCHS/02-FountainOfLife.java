public class FountainOfLife {

	public double elixirOfDeath(int elixir, int poison, int pool) {
	
		if (elixir > poison) {
			return -1.0;
		}
		
		// Since poison/elixir should be 50/50, then 
		// pool + elixir*time = poison*time, 
		// so t = pool / (poison - elixir) 
		return (double)pool / (poison - elixir);
	}
	
}