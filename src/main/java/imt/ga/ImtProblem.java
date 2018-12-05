package imt.ga;

import com.algorithms.ai.exception.GeneticAlgorithmException;
import com.algorithms.ai.provider.CrossOverTechniqueProvider;
import com.algorithms.ai.provider.FitnessTechniqueProvider;
import com.algorithms.ai.provider.MutationTechniqueProvider;
import com.algorithms.ai.provider.SelectionTechniqueProvider;
import com.algorithms.ai.techniques.CrossOverTechnique;
import com.algorithms.ai.techniques.FitnessTechnique;
import com.algorithms.ai.techniques.SelectionTechnique;
import imt.ga.domain.ImtGene;
import imt.ga.domain.ImtGeneticAlgorithm;
import imt.ga.techniques.crossover.CrossOverTechniqueHalfWay;
import imt.ga.techniques.fitness.FitnessTechniqueForEachLetter;
import imt.ga.techniques.mutation.MutationTechniqueReplaceWithRandomLetterFromKeyboard;
import imt.ga.techniques.selection.SelectionTechniqueRouletteWheel;

import java.util.Collections;

public class ImtProblem {
    private double mutationRate;
    private int populationCount;
    private String targetPhrase;
    private FitnessTechnique<ImtGene> fitnessTechnique = FitnessTechniqueForEachLetter.getInstance();
    private SelectionTechnique<ImtGene> selectionTechnique = SelectionTechniqueRouletteWheel.getInstance();
    private CrossOverTechnique<ImtGene> crossOverTechnique = CrossOverTechniqueHalfWay.getInstance();

    public ImtProblem(String targetPhrase, double mutationRate, int populationCount) {
        this.targetPhrase = targetPhrase;
        this.mutationRate = mutationRate;
        this.populationCount = populationCount;
    }

    public void solve() throws GeneticAlgorithmException {
        FitnessTechniqueProvider<ImtGene> fitnessTechniqueProvider = new FitnessTechniqueProvider<>(Collections.singletonList(fitnessTechnique));
        SelectionTechniqueProvider<ImtGene> selectionTechniqueProvider = new SelectionTechniqueProvider<>(Collections.singletonList(selectionTechnique));
        CrossOverTechniqueProvider<ImtGene> crossOverTechniqueProvider = new CrossOverTechniqueProvider<>(Collections.singletonList(crossOverTechnique));
        MutationTechniqueProvider<ImtGene> mutationTechniqueProvider = new MutationTechniqueProvider<>(Collections.singletonList(MutationTechniqueReplaceWithRandomLetterFromKeyboard.getInstance()));

        ImtGeneticAlgorithm geneGeneticAlgorithm = new ImtGeneticAlgorithm(populationCount, mutationRate, fitnessTechniqueProvider, selectionTechniqueProvider, crossOverTechniqueProvider, mutationTechniqueProvider, targetPhrase);

        geneGeneticAlgorithm.run();
    }
}
