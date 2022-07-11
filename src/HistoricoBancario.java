import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoricoBancario {
    private String operacao;
    private String descricao;
    private Date created_at;
    public HistoricoBancario(String operacao, Date created_at,String descricao) {
        this.operacao = operacao;
        this.created_at = created_at;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        return "{" +
                "operacao : '" + operacao + '\'' +
                ", realizado em : " + dFormat.format(created_at) +
                ", descricao : " + descricao +
                '}';
    }
}
