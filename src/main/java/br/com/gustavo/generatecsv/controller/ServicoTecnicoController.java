package br.com.gustavo.generatecsv.controller;

import br.com.gustavo.generatecsv.service.ServicoTecnicoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api/v1/servicotecnico")
public class ServicoTecnicoController {

    private ServicoTecnicoService servicoTecnicoService;

    public ServicoTecnicoController(ServicoTecnicoService servicoTecnicoService) {
        this.servicoTecnicoService = servicoTecnicoService;
    }

    @RequestMapping(path = "/csv", method = RequestMethod.GET)
    public void generateCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"servicotecnico.csv\"");
        servicoTecnicoService.generateCSV(servletResponse.getWriter());
    }
}
