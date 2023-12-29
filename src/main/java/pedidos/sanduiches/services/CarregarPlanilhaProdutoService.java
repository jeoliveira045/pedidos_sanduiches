package pedidos.sanduiches.services;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pedidos.sanduiches.entities.Produto;
import pedidos.sanduiches.repositories.ProdutoRepository;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarregarPlanilhaProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void processExcelFile(MultipartFile file) throws FileNotFoundException {
        List<Produto> produtoList = new ArrayList<>();

        try(InputStream inputStream = file.getInputStream()){
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            for(Row row: sheet){
                Produto produto = new Produto();
                Random random = new Random();
                for(Cell cell: row){
                    var index = cell.getColumnIndex();
                    if (index == 1) {
                        produto.setNome(cell.getStringCellValue());
                        produto.setPrecoUnitario(BigDecimal.valueOf(random.nextDouble(30,60)));
                    }
                }
                produtoList.add(produto);
            }
            produtoRepository.saveAll(produtoList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
