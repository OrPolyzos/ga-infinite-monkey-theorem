package imt.ga.techniques.crossover;

import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.techniques.CrossOverTechnique;
import imt.ga.domain.ImtGene;

public class CrossOverTechniqueHalfWay implements CrossOverTechnique<ImtGene> {

    private static CrossOverTechniqueHalfWay crossOverTechniqueHalfWay;

    private CrossOverTechniqueHalfWay() {
    }

    public static synchronized CrossOverTechniqueHalfWay getInstance() {
        if (crossOverTechniqueHalfWay == null) {
            crossOverTechniqueHalfWay = new CrossOverTechniqueHalfWay();
        }
        return crossOverTechniqueHalfWay;
    }

    @Override
    public Chromosome<ImtGene> crossOver(Chromosome<ImtGene> firstParent, Chromosome<ImtGene> secondParent) {
        StringBuilder newPhraseBuilder = new StringBuilder();
        String targetPhrase = firstParent.getGene().getTargetPhrase();
        String firstParentPhrase = firstParent.getGene().getOwnPhrase();
        String secondParentPhrase = secondParent.getGene().getOwnPhrase();
        for (int i = 0; i < firstParentPhrase.length(); i++) {
            if (i % 2 == 0) {
                newPhraseBuilder.append(firstParentPhrase.charAt(i));
            } else {
                newPhraseBuilder.append(secondParentPhrase.charAt(i));
            }
        }
        return new Chromosome<>(new ImtGene(targetPhrase, newPhraseBuilder.toString()));
    }

    @Override
    public String toString() {
        return "Using: CrossOverTechniqueHalfWay";
    }
}
