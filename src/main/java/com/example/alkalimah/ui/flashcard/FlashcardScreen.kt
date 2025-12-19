@Composable
fun FlashcardScreen(viewModel: FlashcardViewModel, audioPlayer: AudioPlayer) {
    val words by viewModel.words.collectAsState()
    val index by viewModel.currentIndex.collectAsState()

    if (words.isNotEmpty() && index < words.size) {
        val word = words[index]
        
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Card(modifier = Modifier.weight(1f).fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(word.uthmani ?: "", fontSize = 40.sp) // Arabic Text
                    Text(word.transliteration ?: "", fontStyle = FontStyle.Italic)
                    Text(word.translation ?: "", fontSize = 24.sp)
                    
                    IconButton(onClick = { audioPlayer.playAudio(word.audio_blob) }) {
                        Icon(Icons.Default.PlayArrow, "Play")
                    }
                }
            }
            
            Button(onClick = { viewModel.nextCard() }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Default.ArrowForward, null)
                Text("Next")
            }
        }
    }
}