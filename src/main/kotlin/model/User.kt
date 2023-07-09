import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val address: String,
    val birthday: LocalDate,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val devices: MutableList<Device> = mutableListOf()
)
