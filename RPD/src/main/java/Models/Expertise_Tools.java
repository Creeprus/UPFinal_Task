package Models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Expertise_Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min=3,max=30,message="Поле должно содержать не менее 3х и не более 30 символов")
    private String expertise_tool;
    @OneToMany(mappedBy = "expertise_tools", fetch =FetchType.EAGER)
    private Collection<Expertise> expertise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpertise_tool() {
        return expertise_tool;
    }

    public void setExpertise_tool(String expertise_tool) {
        this.expertise_tool = expertise_tool;
    }

    public Collection<Expertise> getExpertise() {
        return expertise;
    }

    public void setExpertise(Collection<Expertise> expertise) {
        this.expertise = expertise;
    }

    public Expertise_Tools() {
    }

    public Expertise_Tools(String expertise_tool, Collection<Expertise> expertise) {
        this.expertise_tool = expertise_tool;
        this.expertise = expertise;
    }
}
