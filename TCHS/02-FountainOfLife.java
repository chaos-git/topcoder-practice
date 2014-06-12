public class FountainOfLife {

	public double elixirOfDeath(int elixir, int poison, int pool) {
	
		if (elixir > poison) {
			return -1.0;
		}
		
		return (double)pool / (poison - elixir);
	}
	
}