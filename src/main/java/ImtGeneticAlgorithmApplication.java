import com.algorithms.ai.exception.GeneticAlgorithmException;
import imt.ga.ImtProblem;

public class ImtGeneticAlgorithmApplication {

    public static void main(String[] args) throws GeneticAlgorithmException {
        new ImtProblem("to be or not to be that is the question", 0.9, 1000).solve();
    }
}

