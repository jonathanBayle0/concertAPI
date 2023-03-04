package comm.dtos;

public class GroupeDto {
    private Long groId;
    private String groNom;
    private String groDescription;

    public Long getGroId() {
        return this.groId;
    }

    public void setGroId(Long groId) {
        this.groId = groId;
    }

    public String getGroNom() {
        return this.groNom;
    }

    public void setGroNom(String groNom) {
        this.groNom = groNom;
    }

    public String getGroDescription() {
        return this.groDescription;
    }

    public void setGroDescription(String groDescription) {
        this.groDescription = groDescription;
    }
}
