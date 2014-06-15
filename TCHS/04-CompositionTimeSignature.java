import java.util.*;

public class CompositionTimeSignature {
    final String NOTES = "SEQHW";
    final int[] SIGNATURES = { 16, 12, 8, 6 }; /* this is 3/8,2/4,3/4,4/4 converted to 16ths */

    public String getTimeSignature(String duration) {

        int totalDuration = sumNotes(duration);
        int minimalDiffSignatureIndex = -1; //index of the signature with the minimum count of notes starting/ending in different measures
        int minimalDiff = -1; //keep track of the count

        for (int i = 0; i < SIGNATURES.length; i++) { //find signatures where duration matches signature (rule 1)
            if (totalDuration % SIGNATURES[i] == 0) {
                int counter = 0, current = 0, startEndInDiffMeasure = 0;
                for (int n = 0; n < duration.length(); n++) { //count notes that start in one measure, but finish in another (rule 2)
                    current = getNoteValue(duration.charAt(n));

                    if ((counter / SIGNATURES[i] + 1) * SIGNATURES[i] < counter + current) {
                        startEndInDiffMeasure++;
                    }

                    counter += current;
                }

                if (minimalDiff < 0 || startEndInDiffMeasure <= minimalDiff) { //check that it's the minimal amount
                    minimalDiffSignatureIndex = i;
                    minimalDiff = startEndInDiffMeasure;
                }
            }
        }

        if (minimalDiffSignatureIndex < 0) {
            return "?/?";
        }

        return SIGNATURES[minimalDiffSignatureIndex] % 4 == 0
            ? "" + (SIGNATURES[minimalDiffSignatureIndex] / 4) + "/4"
            : "" + (SIGNATURES[minimalDiffSignatureIndex] / 2) + "/8";
    }


    private int sumNotes(String duration) { //returns how many 16ths
        int totalDuration = 0;
        for (int i = 0; i < duration.length(); i++) {
            totalDuration += getNoteValue(duration.charAt(i));
        }

        return totalDuration;
    }

    private int getNoteValue(char note) {
        return (int)Math.pow(2, NOTES.indexOf(note));
    }

}