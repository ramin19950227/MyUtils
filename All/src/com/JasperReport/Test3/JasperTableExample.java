package com.JasperReport.Test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author javaQuery
 * @date 24nd November, 2015
 * @Github: https://github.com/javaquery/Examples
 * @Link: http://www.javaquery.com/2015/11/how-to-fill-jasper-table-using.html
 * @YOuTube: https://www.youtube.com/watch?v=AfC6MlWrXqY&t=4s
 */
public class JasperTableExample {

    public static void main(String[] args) {

        /* List to hold Items */
        ArrayList<ProductWrapperForReport> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Product p = new Product();
            p.setId(i);
            p.setName("Product " + i);
            p.setBarCode("barCode " + i);
            p.setPurchasePrice(1.25 + i);
            p.setNote("qeyd");
            p.setQty(i * i);
            dataList.add(new ProductWrapperForReport(p));
        }

        String title = "SaleSoft - Satish Proqrami";
        String qaimeNo = "123525845";
        Double totalPrice = 25.66;
        String tarix = "27.02.1995";
        String jasterFileAddress = "src/com/JasperReport/Test3/template_Table.jasper";
        String customerName = "Ramin Ismayilov";

        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap();

        parameters.put("title", title);
        parameters.put("qaimeNo", qaimeNo);
        parameters.put("totalPrice", totalPrice);
        parameters.put("tarix", tarix);
        parameters.put("jasterFileAddress", jasterFileAddress);
        parameters.put("customerName", customerName);

        showJasperView(dataList, parameters);
    }

    public static void showJasperView(ArrayList<ProductWrapperForReport> dataList, Map<String, Object> parameters) {
        try {

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(dataList);

            parameters.put("ItemDataSource", itemsJRBean);


            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport(parameters.get("jasterFileAddress").toString(), parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            //OutputStream outputStream = new FileOutputStream(new File("JasperTableExample.pdf"));
            /* Write content to PDF file */
            //JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);

            System.out.println("File Generated");
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
