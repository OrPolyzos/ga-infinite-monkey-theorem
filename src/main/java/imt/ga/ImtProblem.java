package imt.ga;

import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.exception.GeneticAlgorithmException;
import com.algorithms.ai.provider.CrossOverTechniqueProvider;
import com.algorithms.ai.provider.FitnessTechniqueProvider;
import com.algorithms.ai.provider.MutationTechniqueProvider;
import com.algorithms.ai.provider.SelectionTechniqueProvider;
import imt.ga.domain.ImtGene;
import imt.ga.domain.ImtGeneticAlgorithm;
import imt.ga.domain.ImtKeyboard;
import imt.ga.techniques.crossover.CrossOverTechniqueHalfWay;
import imt.ga.techniques.fitness.FitnessTechniqueForEachLetter;
import imt.ga.techniques.mutation.MutationTechniqueReplaceWithRandomLetterFromKeyboard;
import imt.ga.techniques.selection.SelectionTechniquePopulationElitism;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImtProblem {
    private double mutationRate;
    private int populationCount;
    private String targetPhrase;

    public ImtProblem(String targetPhrase, double mutationRate, int populationCount) {
        this.targetPhrase = targetPhrase;
        this.mutationRate = mutationRate;
        this.populationCount = populationCount;
    }

    public void solve() throws GeneticAlgorithmException {
        FitnessTechniqueProvider<ImtGene> fitnessTechniqueProvider = new FitnessTechniqueProvider<>(Collections.singletonList(FitnessTechniqueForEachLetter.getInstance()));
        SelectionTechniqueProvider<ImtGene> selectionTechniqueProvider = new SelectionTechniqueProvider<>(Collections.singletonList(SelectionTechniquePopulationElitism.getInstance()));
        CrossOverTechniqueProvider<ImtGene> crossOverTechniqueProvider = new CrossOverTechniqueProvider<>(Collections.singletonList(CrossOverTechniqueHalfWay.getInstance()));
        MutationTechniqueProvider<ImtGene> mutationTechniqueProvider = new MutationTechniqueProvider<>(Collections.singletonList(MutationTechniqueReplaceWithRandomLetterFromKeyboard.getInstance()));

        List<Chromosome<ImtGene>> chromosomes =
                IntStream.range(0, populationCount)
                        .boxed()
                        .map(i -> new Chromosome<>(new ImtGene(targetPhrase, ImtKeyboard.getRandomPhrase(targetPhrase.length()))))
                        .collect(Collectors.toList());

        ImtGeneticAlgorithm geneGeneticAlgorithm = new ImtGeneticAlgorithm(mutationRate, chromosomes, fitnessTechniqueProvider, selectionTechniqueProvider, crossOverTechniqueProvider, mutationTechniqueProvider, targetPhrase);

        geneGeneticAlgorithm.run();
    }
}
