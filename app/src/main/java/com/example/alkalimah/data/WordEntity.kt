@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey val id: Int,
    val location: String?,
    val uthmani: String?,
    val simple: String?,
    val translation: String?,
    val transliteration: String?,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) val audio_blob: ByteArray?
)

// Data class for the aggregated frequency view
data class WordWithFrequency(
    val simple: String,
    val uthmani: String?,
    val translation: String?,
    val transliteration: String?,
    val audio_blob: ByteArray?,
    val locations: Int
)