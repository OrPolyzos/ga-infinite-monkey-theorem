package imt.ga.techniques.selection;

import com.algorithms.ai.domain.Chromosome;
import com.algorithms.ai.techniques.SelectionTechnique;
import imt.ga.domain.ImtGene;

import java.util.List;

public class SelectionTechniquePopulationElitism implements SelectionTechnique<ImtGene> {

    private static SelectionTechniquePopulationElitism selectionTechniquePopulationElitism;

    private SelectionTechniquePopulationElitism() {
    }

    public static synchronized SelectionTechniquePopulationElitism getInstance() {
        if (selectionTechniquePopulationElitism == null) {
            selectionTechniquePopulationElitism = new SelectionTechniquePopulationElitism();
        }
        return selectionTechniquePopulationElitism;
    }

    @Override
    public Chromosome<ImtGene> select(List<Chromosome<ImtGene>> population, Chromosome<ImtGene> fittestChromosomeEver, Chromosome<ImtGene> fittestChromosome) {
        return fittestChromosome;
    }

    @Override
    public String toString() {
        return "Using: SelectionTechniquePopulationElitism";
    }
}
