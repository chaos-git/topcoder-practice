public class KidsWordGame {

	public int getCheater(String[] first, String[] second, String[] third) {
		String[][] plays = { first, second, third };
		
		String lastChange = "";
		for (int turn = 0; turn < first.length + second.length + third.length; turn++) {
			int player = turn % 3;
			String change = plays[player][turn / 3];
			
			if (change.indexOf(lastChange) == -1 || (turn != 0 && change.length() != lastChange.length() + 1)) {
				return (turn - 1) % 3 + 1;
			}
			
			lastChange = change;
		}
		
		return -1;
	}

}