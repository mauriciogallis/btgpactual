package mauricio.sahao.btgpactual.controller;

import lombok.RequiredArgsConstructor;
import mauricio.sahao.btgpactual.controller.dto.ApiResponse;
import mauricio.sahao.btgpactual.controller.dto.OrcamentoResponse;
import mauricio.sahao.btgpactual.controller.dto.PaginationResponse;
import mauricio.sahao.btgpactual.service.OrcamentoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrcamentoController {

    private final OrcamentoService orcamentoService;


    @GetMapping("/cliente/{clienteId}/orcamentos")
    public ResponseEntity<ApiResponse<OrcamentoResponse>> listarOrcamentos(@PathVariable Long clienteId,
                                                                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        var body = orcamentoService.findAll(clienteId, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(new ApiResponse<>(
                body.getContent(),
                PaginationResponse.fromPage(body)
        ));
    }


}
