package imt.ga.techniques.fitness;

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
    public double calculateFitness(ImtGene gene) {
        int correctCharactersCounter = 0;
        for (int i = 0; i < gene.getOwnPhrase().length(); i++) {
            if (gene.getOwnPhrase().charAt(i) == gene.getTargetPhrase().charAt(i)) {
                correctCharactersCounter++;
            }
        }
        //Increase the power for a stronger fitness function for every correct character
        return Math.pow(correctCharactersCounter, 1) / gene.getTargetPhrase().length();
    }

    @Override
    public String toString() {
        return "Using: FitnessTechniqueForEachLetter";
    }
}
