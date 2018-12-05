package imt.ga.techniques.fitness;

import com.algorithms.ai.domain.Dna;
import com.algorithms.ai.techniques.FitnessTechnique;
import imt.ga.domain.ImtGene;

public class FitnessTechniqueForEachLetter implements FitnessTechnique<ImtGene> {

    private static FitnessTechniqueForEachLetter fitnessTechniqueWithSickJoints;

    private FitnessTechniqueForEachLetter() {
    }

    public static synchronized FitnessTechniqueForEachLetter getInstance() {
        if (fitnessTechniqueWithSickJoints == null) {
            fitnessTechniqueWithSickJoints = new FitnessTechniqueForEachLetter();
        }
        return fitnessTechniqueWithSickJoints;
    }

    @Override
    public double calculateFitness(Dna<ImtGene> dna) {
        int correctCharactersCounter = 0;
        for (int i = 0; i < dna.getGene().getOwnPhrase().length(); i++) {
            if (dna.getGene().getOwnPhrase().charAt(i) == dna.getGene().getTargetPhrase().charAt(i)) {
                correctCharactersCounter++;
            }
        }
        return Math.pow(correctCharactersCounter, 15) / dna.getGene().getTargetPhrase().length();
    }

    @Override
    public String toString() {
        return "Using: FitnessTechniqueForEachLetter";
    }
}
