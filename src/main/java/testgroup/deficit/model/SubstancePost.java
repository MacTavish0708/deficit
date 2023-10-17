package testgroup.deficit.model;


public class SubstancePost {
    int typeAction;
    String inputSubstance;
    int selectSubstance;

    public int getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(int typeAction) {
        this.typeAction = typeAction;
    }

    public String getInputSubstance() {
        return inputSubstance;
    }

    public void setInputSubstance(String inputSubstance) {
        this.inputSubstance = inputSubstance;
    }

    public int getSelectSubstance() {
        return selectSubstance;
    }

    public void setSelectSubstance(int selectSubstance) {
        this.selectSubstance = selectSubstance;
    }

    @Override
    public String toString() {
        return "SubstancePost{" +
                "typeAction=" + typeAction +
                ", inputSubstance='" + inputSubstance + '\'' +
                ", selectSubstance=" + selectSubstance +
                '}';
    }

}
