package Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
public class CaseParticipator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="Поле не должно быть пустым")
    @Size(min=3,max=30,message="Поле должно содержать не менне 3х и не более 30 символов")
    private String name;
    @NotEmpty(message="Поле не должно быть пустым")
    @Size(min=3,max=30,message="Поле должно содержать не менне 3х и не более 30 символов")
    private String surname;
    @ManyToOne(optional =true, cascade =CascadeType.ALL)
    private CaseParticipantCategory caseParticipantCategory;

    @ManyToMany
    @JoinTable(name="caseparticipator_case",
            joinColumns=@JoinColumn(name = "caseparticipator_id"),
            inverseJoinColumns=@JoinColumn(name = "case_id"))
    private List<Case> cases;

    @OneToMany(mappedBy = "caseParticipator", fetch =FetchType.EAGER)
    private Collection<Testimony> testimonies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public CaseParticipantCategory getCaseParticipantCategory() {
        return caseParticipantCategory;
    }

    public void setCaseParticipantCategory(CaseParticipantCategory caseParticipantCategory) {
        this.caseParticipantCategory = caseParticipantCategory;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public Collection<Testimony> getTestimonies() {
        return testimonies;
    }

    public void setTestimonies(Collection<Testimony> testimonies) {
        this.testimonies = testimonies;
    }

    public CaseParticipator() {
    }

    public CaseParticipator(String name, String surname, CaseParticipantCategory caseParticipantCategory, List<Case> cases, Collection<Testimony> testimonies) {
        this.name = name;
        this.surname = surname;
        this.caseParticipantCategory = caseParticipantCategory;
        this.cases = cases;
        this.testimonies = testimonies;
    }
}
