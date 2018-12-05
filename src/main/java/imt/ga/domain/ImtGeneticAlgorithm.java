package imt.ga.domain;

import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.domain.Dna;
import com.algorithms.ai.domain.GeneticAlgorithm;
import com.algorithms.ai.domain.Population;
import com.algorithms.ai.provider.CrossOverTechniqueProvider;
import com.algorithms.ai.provider.FitnessTechniqueProvider;
import com.algorithms.ai.provider.MutationTechniqueProvider;
import com.algorithms.ai.provider.SelectionTechniqueProvider;

import java.util.ArrayList;
import java.util.List;

public class ImtGeneticAlgorithm extends GeneticAlgorithm<ImtGene> {

    private String targetPhrase;

    public ImtGeneticAlgorithm(int populationCount, double mutationRate,
                               FitnessTechniqueProvider<ImtGene> fitnessTechniqueProvider,
                               SelectionTechniqueProvider<ImtGene> selectionTechniqueProvider,
                               CrossOverTechniqueProvider<ImtGene> crossOverTechniqueProvider,
                               MutationTechniqueProvider<ImtGene> mutationTechniqueProvider,
                               String targetPhrase) {
        super(populationCount, mutationRate, fitnessTechniqueProvider, selectionTechniqueProvider, crossOverTechniqueProvider, mutationTechniqueProvider);
        this.targetPhrase = targetPhrase;
    }

    @Override
    public void initialGeneration() {
        List<Chromosome<ImtGene>> chromosomes = new ArrayList<>();
        for (int i = 0; i < populationCount; i++) {
            String phrase = ImtKeyboard.getRandomPhrase(targetPhrase.length());
            ImtGene gene = new ImtGene(targetPhrase, phrase);
            Dna<ImtGene> ch_dna = new Dna<>(gene);
            Chromosome<ImtGene> chromosome = new Chromosome<>(ch_dna);
            chromosomes.add(chromosome);
        }
        population = new Population<>(chromosomes);
    }

    @Override
    protected void drawCurrentState() {
        System.out.println(fittestChromosomeEver.getDna().getGene().getOwnPhrase());
    }

    @Override
    protected boolean shouldContinue() {
        return !fittestChromosomeEver.getDna().getGene().getOwnPhrase().equals(targetPhrase);
    }
}