public class TocaMusica {
    
    // Este atributo guardará o áudio carregado
    private Clip clip;

    /**
     * Método para tocar uma música em loop.
     * Recebe o caminho do arquivo de áudio WAV.
     */
    public void tocarMusica(String caminhoArquivo) {
        try {
            // Cria um objeto File apontando para o arquivo de música
            File arquivo = new File(caminhoArquivo);

            // Carrega o arquivo WAV para um stream de áudio
            // AudioInputStream é uma classe do Java usada para ler arquivos de áudio
            // AudioSystem.getAudioInputStream() é o método que abre um arquivo 
            // de áudio e transforma ele em algo que o Java consegue ler
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);

            // Cria o "Clip", que é um objeto capaz de tocar áudio
            // cria um “player de áudio” dentro do Java
            // ou seja, cria o objeto responsável por tocar sons
            clip = AudioSystem.getClip();

            // Abre o áudio dentro do Clip
            // pq o clip vem vazio, sem som pra tocar
            clip.open(audioStream);

            // Configura para tocar repetidamente, infinitamente
            // dentro da classe Clip tem uma variavel chamada LOOP_CONTINUOUSLY, que
            // controla se a musica toca continuamente ou não
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Começa a tocar
            clip.start();

        } catch (Exception e) {
            // Caso dê erro para carregar o arquivo, aparece no console
            e.getMessage();
        }
    }

    /**
     * Método para parar a música.
     * Verifica se o Clip existe e se está tocando.
     */
    public void pararMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // Para a reprodução
        }
    }

    /**
     * Método principal para testar a classe.
     * Aqui a música começa a tocar e o programa fica "travado"
     * para permitir que o som continue.
     */
    public static void main(String[] args) {
        // Cria o objeto que controla a música
        TocaMusica musica = new TocaMusica();

        // Toca o arquivo theme.wav (deve estar na pasta do projeto)
        musica.tocarMusica("theme.wav");

        // Mantém o programa aberto para que a música não pare
        try {
            System.out.println("Pressione Ctrl+C para parar a música...");
            Thread.sleep(Long.MAX_VALUE); // pausa infinita
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
