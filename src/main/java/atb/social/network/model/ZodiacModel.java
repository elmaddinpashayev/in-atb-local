package atb.social.network.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ZodiacModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition="TEXT", length = 1000)
    private String description;

    private String name;

    @Override
    public String toString() {
        return "ZodiacModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
