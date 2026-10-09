public class Aluno {
    private String nome;
    private Float[][] nota;
    private Float[] media;
    private Float mediaAnual;


    public Aluno() {}

    public Aluno(String nome, Float[][] nota, Float[] media, Float mediaAnual) {
        this.nome = nome;
        this.nota = nota;
        this.media = media;
        this.mediaAnual = mediaAnual;
    }

    public String getNome() {
        return nome;
    }
    public Float[][] getNota() {
        return nota;
    }
    public Float[] getMedia() {
        return media;
    }
    public Float getMediaAnual() {
        return mediaAnual;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNota(Float[][] nota) {
        this.nota = nota;
    }
    public void setMedia(Float[] media) {
        this.media = media;
    }
    public void setMediaAnual(Float mediaAnual) {
        this.mediaAnual = mediaAnual;
    }
}