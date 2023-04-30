package capital.pix.requests;

import java.math.BigDecimal;

public class TransferenciaRequest {
    private int contaDestinoId;
    private BigDecimal valor;

    public int getContaDestinoId() {
        return contaDestinoId;
    }

    public void setContaDestinoId(int contaDestinoId) {
        this.contaDestinoId = contaDestinoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
