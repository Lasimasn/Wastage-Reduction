package com.stackroute.registrationserver.seedData;

import com.stackroute.registrationserver.controller.RegistrationController;
import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.DeliveryBoys;
import com.stackroute.registrationserver.service.RabbitService;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.Locale;

@Component
public class DeliverySeedData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    RegistrationController registrationController;

    @Autowired
    private RabbitService rabbitService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        DeliveryBoys deliveryBoys=new DeliveryBoys();
        try {

            FileInputStream file = new FileInputStream(new File("./charityseed.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(2);

            System.out.println("");



            for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
                int j = 0;
                NumberFormat fmt = NumberFormat.getInstance(Locale.US);
                deliveryBoys.setName(workbook.getSheetAt(2).getRow(i).getCell(j).toString());
                deliveryBoys.setUsername(workbook.getSheetAt(2).getRow(i).getCell(j+1 ).toString());
                deliveryBoys.setPassword(workbook.getSheetAt(2).getRow(i).getCell(j+2 ).toString());
                deliveryBoys.setEmail(workbook.getSheetAt(2).getRow(i).getCell(j+3 ).toString());
                deliveryBoys.setMobile((long)(Double.parseDouble(workbook.getSheetAt(2).getRow(i).getCell(j + 4).toString())));
                deliveryBoys.setLicenseName(workbook.getSheetAt(2).getRow(i).getCell(j+5 ).toString());
                deliveryBoys.setLicenseNo(workbook.getSheetAt(2).getRow(i).getCell(j+6 ).toString());
                deliveryBoys.setRole(workbook.getSheetAt(2).getRow(i).getCell(j+7 ).toString());


                System.out.println(deliveryBoys);

                registrationController.saveDeliveryBoy(deliveryBoys);
                rabbitService.sendToDeliveryBoyUpdateMQ(deliveryBoys);

            }

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
