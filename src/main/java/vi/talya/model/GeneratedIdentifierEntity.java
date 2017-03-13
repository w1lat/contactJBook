package vi.talya.model;

import javax.persistence.*;

/**
 * Created by vitalii on 07.03.17.
 */
@MappedSuperclass
public class GeneratedIdentifierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
