package Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Testimony {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="Поле не должно быть пустым")
    @Size(min=10,max=300,message="Поле должно содержать не менeе 10 и не более 300 символов")
    private String testimony;

    @NotEmpty(message="Поле не должно быть пустым")
    @Size(min=10,max=30,message="Поле должно содержать не менeе 10 и не более 150 символов")
    private String date_of_testimony;
    @ManyToOne(optional =true, cascade =CascadeType.ALL)
    private CaseParticipator caseParticipator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestimony() {
        return testimony;
    }

    public void setTestimony(String testimony) {
        this.testimony = testimony;
    }

    public String getDate_of_testimony() {
        return date_of_testimony;
    }

    public void setDate_of_testimony(String date_of_testimony) {
        this.date_of_testimony = date_of_testimony;
    }

    public CaseParticipator getCaseParticipator() {
        return caseParticipator;
    }

    public void setCaseParticipator(CaseParticipator caseParticipator) {
        this.caseParticipator = caseParticipator;
    }

    public Testimony() {
    }

    public Testimony(String testimony, String date_of_testimony, CaseParticipator caseParticipator) {
        this.testimony = testimony;
        this.date_of_testimony = date_of_testimony;
        this.caseParticipator = caseParticipator;
    }
}
