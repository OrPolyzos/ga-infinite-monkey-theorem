package imt.ga.domain;

import com.algorithms.ai.domain.GeneticAlgorithm;
import com.algorithms.ai.provider.CrossOverTechniqueProvider;
import com.algorithms.ai.provider.FitnessTechniqueProvider;
import com.algorithms.ai.provider.InitialGenerationProvider;
import com.algorithms.ai.provider.MutationTechniqueProvider;
import com.algorithms.ai.provider.SelectionTechniqueProvider;

public class ImtGeneticAlgorithm extends GeneticAlgorithm<ImtGene> {

    private String targetPhrase;

    public ImtGeneticAlgorithm(double mutationRate,
                               InitialGenerationProvider<ImtGene> initialGenerationProvider,
                               FitnessTechniqueProvider<ImtGene> fitnessTechniqueProvider,
                               SelectionTechniqueProvider<ImtGene> selectionTechniqueProvider,
                               CrossOverTechniqueProvider<ImtGene> crossOverTechniqueProvider,
                               MutationTechniqueProvider<ImtGene> mutationTechniqueProvider,
                               String targetPhrase) {
        super(mutationRate, initialGenerationProvider, fitnessTechniqueProvider, selectionTechniqueProvider, crossOverTechniqueProvider, mutationTechniqueProvider);
        this.targetPhrase = targetPhrase;
    }

    @Override
    protected void drawCurrentState() {
        System.out.println(String.format("Current phrase: '%s' with Fitness: %s", fittestChromosomeEver.getGene().getOwnPhrase(), fittestChromosomeEver.getFitness()));
    }

    @Override
    protected boolean shouldContinue() {
        return !fittestChromosomeEver.getGene().getOwnPhrase().equals(targetPhrase);
    }
}