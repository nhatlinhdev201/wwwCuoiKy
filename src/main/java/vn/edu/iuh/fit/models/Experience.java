package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String company;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(columnDefinition = "tinyint(4)")
    private Roles role;

    @Column()
    private String workDesc;

    @ManyToOne
    private Candidate candidate;
    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", role=" + role +
                ", workDesc='" + workDesc + '\'' +
                '}';
    }
}
