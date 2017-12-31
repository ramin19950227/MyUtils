package com.JasperReport.Test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
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
        try {

            /* List to hold Items */
            List<Item> listItems = new ArrayList<>();

            /* Create Items */
            Item iPhone = new Item();
            iPhone.setName("asdfasdfads");
            iPhone.setPrice(3456787654.00);
            iPhone.setBarCode("bc");

            Item iPad = new Item();
            iPad.setName("asfdasdfadfo");
            iPad.setPrice(34345.00);
            iPhone.setBarCode("bc2");


            /* Add Items to List */
            listItems.add(iPhone);
            listItems.add(iPad);

            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap();
            parameters.put("ItemDataSource", itemsJRBean);
            parameters.put("title", "SaleSoft - Satish Proqrami");
            parameters.put("qaimeNo", "4025550552555552");
            parameters.put("totalPrice", 25.66);


            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport("src/com/JasperReport/Test3/template_Table.jasper", parameters, new JREmptyDataSource());

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
