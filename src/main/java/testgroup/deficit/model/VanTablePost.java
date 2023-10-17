package testgroup.deficit.model;

public class VanTablePost {
    String typeList;
    String substance;
    String year;
    String month;
    String dateFrom;
    String dateTo;
    int maxRowInPage;

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public int getMaxRowInPage() {
        return maxRowInPage;
    }

    public void setMaxRowInPage(int maxRowInPage) {
        this.maxRowInPage = maxRowInPage;
    }

    @Override
    public String toString() {
        return "VanTablePost{" +
                "typeList='" + typeList + '\'' +
                ", substance='" + substance + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", maxRowInPage=" + maxRowInPage +
                '}';
    }

    public void setAll(String[] arrForTypeQuery, int maxRow){
        setSubstance(arrForTypeQuery[0]);
        setTypeList(arrForTypeQuery[1]);
        setYear(arrForTypeQuery[2]);
        setMonth(arrForTypeQuery[3]);
        setDateFrom(arrForTypeQuery[4]);
        setDateTo(arrForTypeQuery[5]);
        setMaxRowInPage(maxRow);
    }

}
