import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.exception.GeneticAlgorithmException;
import imt.ga.domain.ImtGene;
import imt.ga.domain.ImtGeneticAlgorithm;
import imt.ga.domain.ImtKeyboard;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImtGeneticAlgorithmApplication {

    private static final String TARGET_PHRASE = "to be or not to be that is the question";
    private static final int POPULATION_COUNT = 1000;
    private static final double MUTATION_RATE = 0.9;

    public static void main(String[] args) throws GeneticAlgorithmException {
        ImtGeneticAlgorithmApplication imtGeneticAlgorithmApplication = new ImtGeneticAlgorithmApplication();

        ImtGeneticAlgorithm geneGeneticAlgorithm =
                new ImtGeneticAlgorithm(MUTATION_RATE,
                        imtGeneticAlgorithmApplication::generateInitialGeneration,
                        imtGeneticAlgorithmApplication::calculateFitnessPerCorrectCharacter,
                        imtGeneticAlgorithmApplication::selectPopulationFittestChromosome,
                        imtGeneticAlgorithmApplication::pickCharactersAlternately,
                        imtGeneticAlgorithmApplication::replaceCharacterAtRandomIndex,
                        TARGET_PHRASE);
        geneGeneticAlgorithm.run();
    }

    private List<Chromosome<ImtGene>> generateInitialGeneration() {
        return IntStream.range(0, POPULATION_COUNT)
                .boxed()
                .map(i -> new Chromosome<>(new ImtGene(TARGET_PHRASE, ImtKeyboard.getRandomPhrase(TARGET_PHRASE.length()))))
                .collect(Collectors.toList());
    }

    private double calculateFitnessPerCorrectCharacter(Chromosome<ImtGene> chromosomeToCalculateFitness) {
        int correctCharactersCounter = 0;
        String currentPhrase = chromosomeToCalculateFitness.getGene().getOwnPhrase();
        for (int i = 0; i < currentPhrase.length(); i++) {
            if (currentPhrase.charAt(i) == TARGET_PHRASE.charAt(i)) {
                correctCharactersCounter++;
            }
        }
        //Increase the power for a stronger fitness function for every correct character
        return Math.pow(correctCharactersCounter, 1) / TARGET_PHRASE.length();
    }

    private Chromosome<ImtGene> selectPopulationFittestChromosome(List<Chromosome<ImtGene>> population, Chromosome<ImtGene> fittestChromosomeEver, Chromosome<ImtGene> fittestChromosome) {
        return fittestChromosome;
    }

    private void replaceCharacterAtRandomIndex(Chromosome<ImtGene> chromosomeToMutate, double mutationRate) {
        if (new Random().nextDouble() < mutationRate) {
            String currentPhrase = chromosomeToMutate.getGene().getOwnPhrase();
            StringBuilder mutatedPhraseBuilder = new StringBuilder(currentPhrase);
            int chosenPosition = new Random().nextInt(currentPhrase.length());
            mutatedPhraseBuilder.setCharAt(chosenPosition, ImtKeyboard.getRandomCharacterFromKeyboard());
            chromosomeToMutate.getGene().setOwnPhrase(mutatedPhraseBuilder.toString());
        }
    }

    private Chromosome<ImtGene> pickCharactersAlternately(Chromosome<ImtGene> firstParent, Chromosome<ImtGene> secondParent) {
        StringBuilder newPhraseBuilder = new StringBuilder();
        String firstParentPhrase = firstParent.getGene().getOwnPhrase();
        String secondParentPhrase = secondParent.getGene().getOwnPhrase();
        for (int i = 0; i < firstParentPhrase.length(); i++) {
            if (i % 2 == 0) {
                newPhraseBuilder.append(firstParentPhrase.charAt(i));
            } else {
                newPhraseBuilder.append(secondParentPhrase.charAt(i));
            }
        }
        return new Chromosome<>(new ImtGene(TARGET_PHRASE, newPhraseBuilder.toString()));
    }
}

