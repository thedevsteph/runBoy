package yass.stephanie.com.runboy.Utils

data class UserDetails(
    var weight: Float = 0F,
    var gender: Gender = Gender.MALE,
    var age: Int,
    var heartRate: Float = 80F,
    var firstName: String = "Tim",
    var lastName: String = "Shuttle"
)

enum class Gender {
    FEMALE,
    MALE
}


