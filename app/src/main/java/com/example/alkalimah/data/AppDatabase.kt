@Database(entities = [WordEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}