package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app2025.entity.Anotacao;
import br.gov.sp.fatec.springboot3app2025.entity.CorCorrecao;
import br.gov.sp.fatec.springboot3app2025.repository.CorCorrecaoRepository;
import br.gov.sp.fatec.springboot3app2025.repository.AnotacaoRepository;

@Service
public class CorCorrecaoServiceImpl implements CorCorrecaoService {

    private CorCorrecaoRepository corRepo;
    private AnotacaoRepository anotRepo;

    public CorCorrecaoServiceImpl(CorCorrecaoRepository corRepo, AnotacaoRepository anotRepo) {
        this.corRepo = corRepo;
        this.anotRepo = anotRepo;
    }

    @Override
    @Transactional
    public CorCorrecao nova(CorCorrecao correcao) {
        if (correcao == null ||
            correcao.getFeedback() == null || correcao.getFeedback().isBlank() ||
            correcao.getNota() == null ||
            correcao.getData() == null ||
            correcao.getAnotacao() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltam informações!");
        }

        correcao.setId(null); // garante que será criado um novo registro

        // validar anotação existente
        Anotacao anotacao = buscarAnotacaoPorId(correcao.getAnotacao().getId());
        correcao.setAnotacao(anotacao);

        return corRepo.save(correcao);
    }

    private Anotacao buscarAnotacaoPorId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Código de anotação nulo!");
        }
        return anotRepo.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Anotação não existe!");
        });
    }

    @Override
    public List<CorCorrecao> buscarTodas() {
        return corRepo.findAll();
    }

    @Override
    public CorCorrecao buscarPeloId(Long id) {
        Optional<CorCorrecao> corOp = corRepo.findById(id);
        if (corOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Correção não existe!");
        }
        return corOp.get();
    }
}
