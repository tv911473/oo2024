public class Tellimus {
    String tellija;
    double tellimuseKogusumma;
    String tellitavEse;

    public Tellimus(String tellija, double tellimuseKogusumma, String tellitavEse) {
        this.tellija = tellija;
        this.tellimuseKogusumma = tellimuseKogusumma;
        this.tellitavEse = tellitavEse;
    }

    public double tellimuseSummaDollarites()  {
        return tellimuseKogusumma * 1.07;
    }

    public void tellijaNimeVahetus(String tellijaUusNimi)  {
        tellija = tellijaUusNimi;
    }
}
