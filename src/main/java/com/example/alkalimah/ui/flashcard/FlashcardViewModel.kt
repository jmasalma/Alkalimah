@HiltViewModel
class FlashcardViewModel @Inject constructor(
    private val dao: WordDao,
    private val prefs: PreferencesManager
) : ViewModel() {

    val currentLimit = prefs.advancedLevel.stateIn(viewModelScope, SharingStarted.Eagerly, 50)
    val currentIndex = prefs.currentCardIndex.stateIn(viewModelScope, SharingStarted.Eagerly, 0)

    val words = currentLimit.flatMapLatest { limit ->
        dao.getTopWords(limit)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun nextCard() {
        viewModelScope.launch {
            if (currentIndex.value < words.value.size - 1) {
                prefs.saveProgress(currentIndex.value + 1)
            }
        }
    }
}