package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import br.gov.sp.fatec.springboot3app2025.entity.CorCorrecao;

public interface CorCorrecaoService {

    public CorCorrecao nova(CorCorrecao correcao);

    public List<CorCorrecao> buscarTodas();

    public CorCorrecao buscarPeloId(Long id);
}
