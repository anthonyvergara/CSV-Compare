import java.util.Date;

public class Pessoa {

    String nome, nome_mae, cpf;
    Date data_nascimento;

    public Pessoa(String nome, String nome_mae, String cpf, Date data_nascimento){

        this.nome = nome;
        this.nome_mae = nome_mae;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        //result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((nome_mae == null) ? 0 : nome_mae.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (other.hashCode() != this.hashCode()){
            return false;
        }


        return true;
    }

}
