package mz.ac.ucmins.Model;

public class Amostra {
    private String dataColhida;
    private String descricao;
    //something else here


    public Amostra(String dataColhida, String descricao) {
        this.dataColhida = dataColhida;
        this.descricao = descricao;
        //a medida que os atributos aumentam o construtor deve ser alterado
    }

    public String getDataColhida() {
        return dataColhida;
    }

    public void setDataColhida(String dataColhida) {
        this.dataColhida = dataColhida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
