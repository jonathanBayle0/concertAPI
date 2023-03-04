package comm.entities;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Objects;
@Document(collection = "t_information_inf")
public class Information {
    @Id
    private String id;

    @Field("inf_cible")
    private String infCible;
    @Field("inf_contenu")
    private String infContenu;
    @Field("inf_date")
    private String infDate;
    @Field("inf_nom")
    private String infNom;
    @Field("inf_type")
    private String infType;
    @Field("inf_type_contenu")
    private String infTypeContenu;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfCible() {
        return infCible;
    }

    public void setInfCible(String infCible) {
        this.infCible = infCible;
    }

    public String getInfContenu() {
        return infContenu;
    }

    public void setInfContenu(String infContenu) {
        this.infContenu = infContenu;
    }

    public String getInfDate() {
        return infDate;
    }

    public void setInfDate(String infDate) {
        this.infDate = infDate;
    }

    public String getInfNom() {
        return infNom;
    }

    public void setInfNom(String infNom) {
        this.infNom = infNom;
    }

    public String getInfType() {
        return infType;
    }

    public void setInfType(String infType) {
        this.infType = infType;
    }

    public String getInfTypeContenu() {
        return infTypeContenu;
    }

    public void setInfTypeContenu(String infTypeContenu) {
        this.infTypeContenu = infTypeContenu;
    }

    public Information(String id, String infCible, String infContenu, String infDate, String infNom, String infType, String infTypeContenu) {
        super();
        this.id = id;
        this.infCible = infCible;
        this.infContenu = infContenu;
        this.infDate = infDate;
        this.infNom = infNom;
        this.infType = infType;
        this.infTypeContenu = infTypeContenu;
    }

    public Information() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Information)) return false;
        Information that = (Information) o;
        return getId().equals(that.getId()) && getInfCible().equals(that.getInfCible()) && Objects.equals(getInfContenu(), that.getInfContenu()) && Objects.equals(getInfDate(), that.getInfDate()) && Objects.equals(getInfNom(), that.getInfNom()) && Objects.equals(getInfType(), that.getInfType()) && Objects.equals(getInfTypeContenu(), that.getInfTypeContenu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInfCible(), getInfContenu(), getInfDate(), getInfNom(), getInfType(), getInfTypeContenu());
    }
}
