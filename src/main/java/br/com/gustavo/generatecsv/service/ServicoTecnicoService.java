package br.com.gustavo.generatecsv.service;

import br.com.gustavo.generatecsv.entity.ServicoTecnico;
import br.com.gustavo.generatecsv.repository.ServicoTecnicoRepository;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static org.jboss.logging.Logger.getLogger;

@Service
public class ServicoTecnicoService {

    private static final Logger LOGGER = getLogger(ServicoTecnicoService.class);

    private final ServicoTecnicoRepository servicoTecnicoRepository;

    @Autowired
    public ServicoTecnicoService(ServicoTecnicoRepository servicoTecnicoRepository) {
        this.servicoTecnicoRepository = servicoTecnicoRepository;
    }

    public void generateCSV(Writer writer) {
        List<ServicoTecnico> result = servicoTecnicoRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (ServicoTecnico st : result) {
                csvPrinter.printRecord(
                        st.getId(),
                        st.getNome(),
                        st.getDescricaoDetalhada(),
                        st.isAtivo());
            }
        } catch (IOException e) {
            LOGGER.error("Error on generate CSV file ", e);
        }
    }
}
