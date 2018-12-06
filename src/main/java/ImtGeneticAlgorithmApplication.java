import com.algorithms.ai.exception.GeneticAlgorithmException;
import imt.ga.ImtProblem;

public class ImtGeneticAlgorithmApplication {

    private static final String PHRASE = "to be or not to be that is the question";

    public static void main(String[] args) throws GeneticAlgorithmException {
        new ImtProblem(PHRASE, 0.9, 1000).solve();
    }
}

