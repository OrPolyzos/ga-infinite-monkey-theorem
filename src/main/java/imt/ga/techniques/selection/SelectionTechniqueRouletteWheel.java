package imt.ga.techniques.selection;

import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.domain.Population;
import com.algorithms.ai.techniques.SelectionTechnique;
import imt.ga.domain.ImtGene;

public class SelectionTechniqueRouletteWheel implements SelectionTechnique<ImtGene> {

    private static SelectionTechniqueRouletteWheel selectionTechniqueRouletteWheel;

    private SelectionTechniqueRouletteWheel() {
    }

    public static synchronized SelectionTechniqueRouletteWheel getInstance() {
        if (selectionTechniqueRouletteWheel == null) {
            selectionTechniqueRouletteWheel = new SelectionTechniqueRouletteWheel();
        }
        return selectionTechniqueRouletteWheel;
    }

    @Override
    public Chromosome<ImtGene> select(Population<ImtGene> population) {
        return population.getFittestChromosome();
    }

    @Override
    public String toString() {
        return "Using: SelectionTechniqueRouletteWheel";
    }
}
