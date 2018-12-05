package imt.ga.domain;

public class ImtGene {

    private String targetPhrase;
    private String ownPhrase;

    public ImtGene(String targetPhrase, String ownPhrase) {
        this.targetPhrase = targetPhrase;
        this.ownPhrase = ownPhrase;
    }

    public String getTargetPhrase() {
        return targetPhrase;
    }

    public String getOwnPhrase() {
        return ownPhrase;
    }

    public void setOwnPhrase(String ownPhrase) {
        this.ownPhrase = ownPhrase;
    }
}