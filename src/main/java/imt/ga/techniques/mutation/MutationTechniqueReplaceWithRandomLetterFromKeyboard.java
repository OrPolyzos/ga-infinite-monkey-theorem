package imt.ga.techniques.mutation;

import com.algorithms.ai.domain.Dna;
import com.algorithms.ai.techniques.MutationTechnique;
import imt.ga.domain.ImtGene;
import imt.ga.domain.ImtKeyboard;

import java.util.Random;

public class MutationTechniqueReplaceWithRandomLetterFromKeyboard implements MutationTechnique<ImtGene> {

    private static MutationTechniqueReplaceWithRandomLetterFromKeyboard mutationTechniqueReplaceWithRandomLetterFromKeyboard;

    private MutationTechniqueReplaceWithRandomLetterFromKeyboard() {
    }

    public static synchronized MutationTechniqueReplaceWithRandomLetterFromKeyboard getInstance() {
        if (mutationTechniqueReplaceWithRandomLetterFromKeyboard == null) {
            mutationTechniqueReplaceWithRandomLetterFromKeyboard = new MutationTechniqueReplaceWithRandomLetterFromKeyboard();
        }
        return mutationTechniqueReplaceWithRandomLetterFromKeyboard;
    }

    @Override
    public void mutate(Dna<ImtGene> dnaToMutate) {
        String currentPhrase = dnaToMutate.getGene().getOwnPhrase();
        StringBuilder mutatedPhraseBuilder = new StringBuilder(currentPhrase);
        int chosenPosition = new Random().nextInt(currentPhrase.length());
        mutatedPhraseBuilder.setCharAt(chosenPosition, ImtKeyboard.getRandomCharacterFromKeyboard());
        dnaToMutate.getGene().setOwnPhrase(mutatedPhraseBuilder.toString());
    }

    @Override
    public String toString() {
        return "Using: MutationTechniqueReplaceWithRandomLetterFromKeyboard";
    }
}
