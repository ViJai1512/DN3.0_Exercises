import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is required")
    @Size(min = 2, message = "Title must be at least 2 characters")
    private String title;

    @NotNull(message = "Author is required")
    @Size(min = 2, message = "Author must be at least 2 characters")
    private String author;

    @Min(value = 1, message = "Price must be at least 1")
    private double price;

    @NotNull(message = "ISBN is required")
    private String isbn;

    @Version  // for optimistic locking
    private Long version;
}
