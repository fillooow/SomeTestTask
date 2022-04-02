class Book(val id: String, val name: String, val author: String) {

    override fun hashCode() = id.hashCode()

    override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        if (other !is Book) return false

        /** Use [id] as unique identifier at HashSet */
        return this.id == other.id
    }
}