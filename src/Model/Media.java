package Model;

public class Media {
    private String categoria;
    private String immagine; //Conterrà il percorso dell'immagine
    private String data;

    @Override
    public String toString() {
        return "Media{" +
                "categoria='" + categoria + '\'' +
                ", immagine='" + immagine + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getImmagine() {
        return immagine;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Media(String categoria, String immagine, String data) {
        this.categoria = categoria;
        this.immagine = immagine;
        this.data = data;
    }
}

